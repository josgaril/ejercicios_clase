package sdm.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.modelos.Mensaje;
import sdm.modelos.Trabajador;

@WebServlet("/admin/trabajador/modificar")
public class TrabjadorModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_LIBRO_JSP = "/WEB-INF/vistas/admin/trabajador.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");


		Trabajador trabajador = new Trabajador(Integer.parseInt(id), nombre, apellidos, dni);


		Mensaje mensaje;

		request.setAttribute("primeravez", false);

		if (trabajador.isCorrecto()) {
			
			Globales.dao.modificar(trabajador);

			mensaje = new Mensaje("Libro modificado correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/listado");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("libro", trabajador);

			mensaje = new Mensaje("El libro no se ha podido modificar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_LIBRO_JSP).forward(request, response);
		}
	}

}
