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

@WebServlet("/admin/sesion/modificar")
public class SesionModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_SESION_JSP = "/WEB-INF/vistas/admin/sesion.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String id = request.getParameter("id");
		String idcliente = request.getParameter("cliente");
		String idtrabajador = request.getParameter("trabajador");
		String idservicio= request.getParameter("servicio");
		String fecha = request.getParameter("fecha");
		String resena = request.getParameter("resena");
		String calificacion = request.getParameter("calificacion");

		Sesion sesion = new Sesion(id,idcliente, idtrabajador,idservicio,fecha, resena, calificacion);

		Mensaje mensaje;

		request.setAttribute("primeravez", false);

		Iterable<Sesion> sesionesTodas = Globales.daoSesion.obtenerTodos();
		Sesion sesionExistente = Globales.daoSesion.obtenerPorId(Integer.parseInt(id));
		for (Sesion sesionX: sesionesTodas) {
			if (sesion.getFecha().equals(sesionX.getFecha()) && !sesion.getFecha().equals(sesionExistente.getFecha())){
				sesion.setErrorFecha("Ya hay otra sesión a esa hora.");
				sesion.setCorrecto(false);
			}
		}
		if (sesion.isCorrecto()) {
			Globales.daoSesion.modificar(sesion);

			mensaje = new Mensaje("Sesion modificada correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/sesiones");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("sesion", sesion);
			request.setAttribute("clientes", Globales.daoCliente.obtenerTodos());
			request.setAttribute("trabajadores", Globales.daoTrabajador.obtenerTodos());
			request.setAttribute("servicios", Globales.daoServicio.obtenerTodos());
			//mensaje = new Mensaje(sesion.toString(), Mensaje.Nivel.INFORMATIVO);
			mensaje = new Mensaje("La sesión no se ha podido modificar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_SESION_JSP).forward(request, response);
		}
	}

}
