package com.ipartek.formacion.sdm.controladoresSesiones2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.Mensaje;
import com.ipartek.formacion.sdm.modelos.SesionO;

@WebServlet("/admin/sesionO/agregar")
public class SesionCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_SESION_JSP = "/WEB-INF/vistas/admin/sesionO.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String id = request.getParameter("id");
		String idCliente = request.getParameter("cliente");
		String idTrabajador = request.getParameter("trabajador");
		String idServicio= request.getParameter("servicio");
		String fecha = request.getParameter("fecha");
		String resena = request.getParameter("resena");
		String calificacion = request.getParameter("calificacion");
		

		SesionO sesionO = new SesionO(id,idCliente, idTrabajador,idServicio,fecha, resena, calificacion);

		Mensaje mensaje;

		request.setAttribute("primeravez", false);

		if (sesionO.isCorrecto()) {
			//Dao<Servicio> dao =ServicioTreeMap.getInstancia();

			Globales.daoSesionO.agregar(sesionO);

			mensaje = new Mensaje("Sesion agregada correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/sesionesO");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("sesionO", sesionO);
			request.setAttribute("clientes", Globales.daoCliente.obtenerTodos());
			request.setAttribute("trabajadores", Globales.daoTrabajador.obtenerTodos());
			request.setAttribute("servicios", Globales.daoServicio.obtenerTodos());
			
			//mensaje = new Mensaje(cliente.toString(), Mensaje.Nivel.ERROR);

			mensaje = new Mensaje("La sesion no se ha podido agregar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_SESION_JSP).forward(request, response);
		}

	}

}
