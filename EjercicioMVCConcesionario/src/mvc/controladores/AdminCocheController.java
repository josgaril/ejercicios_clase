package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.modelos.Coche;
import mvc.repositorios.CocheTreeMap;
import mvc.repositorios.Dao;

@WebServlet("/admin/coche")
public class AdminCocheController extends HttpServlet {
	private static final String COCHE_JSP = "/WEB-INF/vistas/admin/coche.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		if (id != null) {
			Coche coche = CocheTreeMap.getInstancia().obtenerPorId(Long.parseLong(id));
			request.setAttribute("coche", coche);
		}

		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		Dao<Coche> dao = CocheTreeMap.getInstancia();
		if ("borrar".equals(op)) {
			dao.borrar(Long.parseLong(id));
			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");
			response.sendRedirect(request.getContextPath() + "/admin/indexcoche");
		} else {
			request.getRequestDispatcher(COCHE_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// NECESARIO EN TODAS LAS RECEPCIONES DE DATOS DE FORMULARIO
		// SI QUEREMOS QUE SE GUARDEN CORRECTAMENTE LOS CARACTERES
		// Ññá...
		request.setCharacterEncoding("UTF-8");

		Dao<Coche> dao = CocheTreeMap.getInstancia();

		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String precio = request.getParameter("precio");
		String url = request.getParameter("url");

		Coche coche = null;

		switch (op) {
		case "agregar":
			coche = new Coche(marca, modelo, precio, url);
			if (coche.isCorrecto()) {
				dao.agregar(coche);
			}

			break;
		case "modificar":
			coche = new Coche(Long.parseLong(id), marca, modelo, precio, url);
			if (coche.isCorrecto()) {
				dao.modificar(coche);
			}

			break;
		default:
			throw new RuntimeException("Operación no reconocida");
		}

		if (coche.isCorrecto()) {

			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");

			response.sendRedirect(request.getContextPath() + "/admin/indexcoche");
		} else {
			request.setAttribute("alertatexto", "Hay un error en el formulario. Revise los datos.");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("primeravez", false);
			request.setAttribute("op", op);
			request.setAttribute("coche", coche);
			request.getRequestDispatcher(COCHE_JSP).forward(request, response);
		}
	}

}
