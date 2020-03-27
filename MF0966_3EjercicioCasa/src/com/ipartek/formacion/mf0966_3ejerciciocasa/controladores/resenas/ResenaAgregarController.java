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

@WebServlet("/admin/resena/agregar")
public class ResenaAgregarController extends HttpServlet {

	private static final String FORMULARIO_RESEÑA = "/WEB-INF/vistas/admin/formularioResena.jsp";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");
		String codigo = request.getParameter("codigo");
		String codigoAlumno = request.getParameter("alumno");
		String codigoCurso = request.getParameter("curso");
		String comentario = request.getParameter("comentario");
		String url = request.getParameter("url");
		String codCurso = request.getParameter("codigo");
		Resena resena = new Resena(codigo, codigoAlumno, codigoCurso, comentario);

		request.setAttribute("primeravez", false);
		 Mensaje mensaje;
		
		if (resena.isCorrecto()) {
			Globales.daoResena.agregar(resena);
			mensaje = new Mensaje("Reseña agregada correctamente", Mensaje.Nivel.INFORMATIVO);
			
			request.getSession().setAttribute("mensaje", mensaje);
			// TODO si es el administrador va a la tabla de reseñas, si no va a la pagina
			// del curso.por ahora va a la de reseñas
			response.sendRedirect(request.getContextPath() + "/admin/resenas");
		}else {
			
			request.setAttribute("op", op);
			request.setAttribute("resena", resena);
			request.setAttribute("codCurso", codCurso);
			request.setAttribute("alumnos", Globales.daoAlumno.obtenerTodos());
			request.setAttribute("cursos", Globales.daoCurso.obtenerTodosRealizados());
		
			mensaje=new Mensaje("La reseña no se ha podido agregar. Revisa los errores", Mensaje.Nivel.ERROR);
			
			request.setAttribute("mensaje", mensaje);
			
			request.getRequestDispatcher(FORMULARIO_RESEÑA).forward(request, response);
			
		}
	}

}
