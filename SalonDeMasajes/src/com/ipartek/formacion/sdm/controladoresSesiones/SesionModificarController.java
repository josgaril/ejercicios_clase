package com.ipartek.formacion.sdm.controladoresSesiones;

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

		if (sesion.isCorrecto()) {
			Globales.daoSesion.modificar(sesion);

			mensaje = new Mensaje("Sesion modificada correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/sesiones");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("sesion", sesion);

			mensaje = new Mensaje("La sesión no se ha podido modificar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_SESION_JSP).forward(request, response);
		}
	}

}
