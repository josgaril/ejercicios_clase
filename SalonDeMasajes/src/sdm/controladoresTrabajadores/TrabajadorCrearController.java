package sdm.controladoresTrabajadores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.controladores.Globales;
import sdm.modelos.Mensaje;
import sdm.modelos.Trabajador;

@WebServlet("/admin/trabajador/agregar")
public class TrabajadorCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_TRABAJADOR_JSP = "/WEB-INF/vistas/admin/trabajador.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String id = request.getParameter("idtrabajadores");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");


		//Trabajador trabajador = new Trabajador(11, nombre, apellidos, dni);
		//Trabajador trabajador = new Trabajador(Integer.parseInt(id), nombre, apellidos, dni);
		Trabajador trabajador=new Trabajador(nombre, apellidos, dni);
		//Trabajador trabajador = new Trabajador(id,nombre, apellidos, dni);
		Mensaje mensaje;

		request.setAttribute("primeravez", false);
		
		if (trabajador.isCorrecto()) {

	
			Globales.daoT.agregar(trabajador);

			mensaje = new Mensaje("Trabajador agregado correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/trabajadores");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("trabajador", trabajador);
			//mensaje = new Mensaje(trabajador.toString(), Mensaje.Nivel.ERROR);
			mensaje = new Mensaje("El trabajador no se ha podido agregar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_TRABAJADOR_JSP).forward(request, response);
		}

	}

}