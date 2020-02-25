package com.ipartek.formacion.sdm.controladores.servicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.Mensaje;
import com.ipartek.formacion.sdm.modelos.Servicio;

@WebServlet("/admin/servicio/agregar")
public class ServicioCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_SERVICIO_JSP = "/WEB-INF/vistas/admin/servicio.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String idservicios = request.getParameter("idservicios");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");

		Servicio servicio = new Servicio(idservicios, nombre, precio);

		Mensaje mensaje;

		request.setAttribute("primeravez", false);

		if (servicio.isCorrecto()) {
			Globales.daoServicio.agregar(servicio);

			mensaje = new Mensaje("Servicio agregado correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/servicios");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("servicio", servicio);

			mensaje = new Mensaje("El servicio no se ha podido agregar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_SERVICIO_JSP).forward(request, response);
		}

	}

}
