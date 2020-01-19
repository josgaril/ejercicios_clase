package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.modelos.Quad;
import mvc.repositorios.Dao;
import mvc.repositorios.QuadTreeMap;

@WebServlet("/admin/quad")
public class AdminQuadController extends HttpServlet {
	private static final String QUAD_JSP = "/WEB-INF/vistas/admin/quad.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		if (id != null) {
			Quad quad = QuadTreeMap.getInstancia().obtenerPorId(Long.parseLong(id));
			request.setAttribute("quad", quad);
		}

		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		request.getRequestDispatcher(QUAD_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// NECESARIO EN TODAS LAS RECEPCIONES DE DATOS DE FORMULARIO
		// SI QUEREMOS QUE SE GUARDEN CORRECTAMENTE LOS CARACTERES
		// Ññá...
		request.setCharacterEncoding("UTF-8");
		
		Dao<Quad> dao = QuadTreeMap.getInstancia();

		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String precio = request.getParameter("precio");
		String url = request.getParameter("url");

		Quad quad = null;

		switch (op) {
		case "agregar":
			quad = new Quad(marca, modelo, precio, url);
			if (quad.isCorrecto()) {
				dao.agregar(quad);
			}

			break;
		case "modificar":
			quad = new Quad(Long.parseLong(id), marca, modelo, precio, url);
			if (quad.isCorrecto()) {
				dao.modificar(quad);
			}

			break;
		default:
			throw new RuntimeException("Operación no reconocida");
		}

		// response.getWriter().println(quad);

		// request.getRequestDispatcher("/admin/index").forward(request, response);

		if (quad.isCorrecto()) {

			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");
			// A diferencia del requestDispatcher, el response.sendRedirect lo que hace
			// es pedir al navegador que cargue la URL que le enviamos
			// SE PIERDEN TODAS LAS VARIABLES DE REQUEST
			response.sendRedirect(request.getContextPath() + "/admin/indexquad");
		} else {
			request.setAttribute("alertatexto", "Hay un error en el formulario. Revise los datos.");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("primeravez", false);
			request.setAttribute("op", op);
			request.setAttribute("moto", quad);
			request.getRequestDispatcher(QUAD_JSP).forward(request, response);
		}
	}

}
