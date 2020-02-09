package sdm.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.modelos.Cliente;
import sdm.modelos.Mensaje;

@WebServlet("/admin/cliente/agregar")
public class ClienteCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_CLIENTE_JSP = "/WEB-INF/vistas/admin/cliente.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String idclientes = request.getParameter("idclientes");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		

		//Cliente cliente = null;
		Cliente cliente = new Cliente(nombre, apellidos, dni);

		//Cliente cliente = new Cliente(Long.parseLong(idclientes), nombre, apellidos, dni);

		Mensaje mensaje;

		request.setAttribute("primeravez", false);

		if (cliente.isCorrecto()) {
			//Dao<Servicio> dao =ServicioTreeMap.getInstancia();

			Globales.daoc.agregar(cliente);

			mensaje = new Mensaje("Servicio agregado correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/listado");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("cliente", cliente);
			mensaje = new Mensaje(cliente.toString(), Mensaje.Nivel.INFORMATIVO);

			//mensaje = new Mensaje("El cliente no se ha podido agregar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_CLIENTE_JSP).forward(request, response);
		}

	}

}
