package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.modelos.Tractor;
import mvc.repositorios.Dao;
import mvc.repositorios.TractorTreeMap;

@WebServlet("/admin/tractor")
public class AdminTractorController extends HttpServlet {
	private static final String TRACTOR_JSP = "/WEB-INF/vistas/admin/tractor.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		if (id != null) {
			Tractor tractor = TractorTreeMap.getInstancia().obtenerPorId(Long.parseLong(id));
			request.setAttribute("tractor", tractor);
		}

		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		Dao<Tractor> dao = TractorTreeMap.getInstancia();
		if ("borrar".equals(op)) {
			dao.borrar(Long.parseLong(id));
			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");
			response.sendRedirect(request.getContextPath() + "/admin/indextractor");
		} else {
			request.getRequestDispatcher(TRACTOR_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// NECESARIO EN TODAS LAS RECEPCIONES DE DATOS DE FORMULARIO
		// SI QUEREMOS QUE SE GUARDEN CORRECTAMENTE LOS CARACTERES
		// Ññá...
		request.setCharacterEncoding("UTF-8");

		Dao<Tractor> dao = TractorTreeMap.getInstancia();

		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String precio = request.getParameter("precio");
		String url = request.getParameter("url");
		String imagen = request.getParameter("imagen");


		Tractor tractor = null;

		switch (op) {
		case "agregar":
			tractor = new Tractor(marca, modelo, precio, url, imagen);
			if (tractor.isCorrecto()) {
				dao.agregar(tractor);
			}

			break;
		case "modificar":
			tractor = new Tractor(Long.parseLong(id), marca, modelo, precio, url, imagen);
			if (tractor.isCorrecto()) {
				dao.modificar(tractor);
			}

			break;
		default:
			throw new RuntimeException("Operación no reconocida");
		}

		// response.getWriter().println(tractor);

		// request.getRequestDispatcher("/admin/index").forward(request, response);

		if (tractor.isCorrecto()) {

			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");
			// A diferencia del requestDispatcher, el response.sendRedirect lo que hace
			// es pedir al navegador que cargue la URL que le enviamos
			// SE PIERDEN TODAS LAS VARIABLES DE REQUEST
			response.sendRedirect(request.getContextPath() + "/admin/indextractor");
		} else {
			request.setAttribute("alertatexto", "Hay un error en el formulario. Revise los datos.");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("primeravez", false);
			request.setAttribute("op", op);
			request.setAttribute("tractor", tractor);
			request.getRequestDispatcher(TRACTOR_JSP).forward(request, response);
		}
	}

}
