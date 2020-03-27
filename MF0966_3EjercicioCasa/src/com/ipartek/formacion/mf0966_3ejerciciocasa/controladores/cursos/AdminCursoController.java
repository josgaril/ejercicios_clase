package com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.cursos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.Globales;

@WebServlet("/cursos")
public class AdminCursoController extends HttpServlet {
	private static final String ADMIN_CURSOS_TABLA = "/WEB-INF/vistas/tablaCursos.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cursos", Globales.daoCurso.obtenerTodos());
		request.getRequestDispatcher(ADMIN_CURSOS_TABLA).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
