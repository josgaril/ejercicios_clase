package com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.resenas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.Globales;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Mensaje;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Resena;

@WebServlet("/admin/resena/modificar")
public class ResenaModificarController extends HttpServlet {
	private static final String FORMULARIO_RESENAS = "/WEB-INF/vistas/admin/resena.jsp";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		String codigo = request.getParameter("codigo");
		String alumno_codigo = request.getParameter("alumno");
		String curso_codigo = request.getParameter("curso");
		String comentario = request.getParameter("comentario");

		Resena resena = new Resena(codigo, alumno_codigo, curso_codigo, comentario);

		request.setAttribute("primeravez", false);
		Mensaje mensaje;
		if (resena.isCorrecto()) {
			Globales.daoResena.modificar(resena);
			
			mensaje= new Mensaje("Reseña modificada correctemente", Mensaje.Nivel.INFORMATIVO);
			
			request.getSession().setAttribute("mensaje", mensaje);
			
			response.sendRedirect(request.getContextPath() + "/admin/resenas");
		}else {
			request.setAttribute("op", op);
			request.setAttribute("resena", resena);
			request.setAttribute("alumnos", Globales.daoAlumno.obtenerTodos());
			request.setAttribute("cursos", Globales.daoCurso.obtenerTodosRealizados());
			
			mensaje = new Mensaje("La reseña no se ha podido modificar. Revisa los errores", Mensaje.Nivel.ERROR);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(FORMULARIO_RESENAS).forward(request, response);
		}
	}

}
