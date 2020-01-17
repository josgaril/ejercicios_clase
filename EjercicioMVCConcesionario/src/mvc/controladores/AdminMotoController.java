package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.modelos.Moto;
import mvc.repositorios.Dao;
import mvc.repositorios.MotoTreeMap;

@WebServlet("/admin/moto")
public class AdminMotoController extends HttpServlet {
	private static final String MOTO_JSP = "/WEB-INF/vistas/admin/moto.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		if (id != null) {
			Moto moto = MotoTreeMap.getInstancia().obtenerPorId(Long.parseLong(id));
			request.setAttribute("moto", moto);
		}

		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		request.getRequestDispatcher(MOTO_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// NECESARIO EN TODAS LAS RECEPCIONES DE DATOS DE FORMULARIO
		// SI QUEREMOS QUE SE GUARDEN CORRECTAMENTE LOS CARACTERES
		// Ññá...
		request.setCharacterEncoding("UTF-8");
		
		Dao<Moto> dao = MotoTreeMap.getInstancia();

		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String precio = request.getParameter("precio");
		String url = request.getParameter("url");

		Moto moto = null;

		switch (op) {
		case "agregar":
			moto = new Moto(marca, modelo, precio, url);
			if (moto.isCorrecto()) {
				dao.agregar(moto);
			}

			break;
		case "modificar":
			moto = new Moto(Long.parseLong(id), marca, modelo, precio, url);
			if (moto.isCorrecto()) {
				dao.modificar(moto);
			}

			break;
		default:
			throw new RuntimeException("Operación no reconocida");
		}

		// response.getWriter().println(moto);

		// request.getRequestDispatcher("/admin/index").forward(request, response);

		if (moto.isCorrecto()) {

			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");
			// A diferencia del requestDispatcher, el response.sendRedirect lo que hace
			// es pedir al navegador que cargue la URL que le enviamos
			// SE PIERDEN TODAS LAS VARIABLES DE REQUEST
			response.sendRedirect(request.getContextPath() + "/admin/index");
		} else {
			request.setAttribute("alertatexto", "Hay un error en el formulario. Revise los datos.");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("primeravez", false);
			request.setAttribute("op", op);
			request.setAttribute("moto", moto);
			request.getRequestDispatcher(MOTO_JSP).forward(request, response);
		}
	}

}
