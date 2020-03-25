package com.ipartek.formacion.mf0966_3ejerciciocasa.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/curso/detalle")
public class AdminCursoDetalle extends HttpServlet {
	private static final String TABLA_CURSO_DETALLE = "/WEB-INF/vistas/admin/tablaCursoDetalle.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String codigo = request.getParameter("codigo");
		
		request.setAttribute("curso", Globales.daoCurso.obtenerPorCodigo(Integer.parseInt(codigo)));
		request.setAttribute("resena", Globales.daoResena.obtenerTodasPorCodigoCurso(Integer.parseInt(codigo)));
		request.getRequestDispatcher(TABLA_CURSO_DETALLE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
