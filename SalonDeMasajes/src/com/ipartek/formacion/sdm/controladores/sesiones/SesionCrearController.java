package com.ipartek.formacion.sdm.controladores.sesiones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.Mensaje;
import com.ipartek.formacion.sdm.modelos.Sesion;

@WebServlet("/admin/sesion/agregar")
public class SesionCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_SESION_JSP = "/WEB-INF/vistas/admin/sesion.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String id = request.getParameter("id");
		String clientes_idclientes = request.getParameter("clientes_idclientes");
		String trabajadores_idtrabajadores = request.getParameter("trabajadores_idtrabajadores");
		String servicios_idservicios= request.getParameter("servicios_idservicios");
		String fecha = request.getParameter("fecha");
		String resena = request.getParameter("resena");
		String calificacion = request.getParameter("calificacion");
		

		Sesion sesion = new Sesion(id,clientes_idclientes, trabajadores_idtrabajadores,servicios_idservicios,fecha, resena, calificacion);

		Mensaje mensaje;

		request.setAttribute("primeravez", false);

		if (sesion.isCorrecto()) {
			//Dao<Servicio> dao =ServicioTreeMap.getInstancia();

			Globales.daoSesion.agregar(sesion);

			mensaje = new Mensaje("Sesion agregada correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/sesiones");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("sesion", sesion);
			//mensaje = new Mensaje(cliente.toString(), Mensaje.Nivel.ERROR);

			mensaje = new Mensaje("La sesion no se ha podido agregar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_SESION_JSP).forward(request, response);
		}

	}

}
