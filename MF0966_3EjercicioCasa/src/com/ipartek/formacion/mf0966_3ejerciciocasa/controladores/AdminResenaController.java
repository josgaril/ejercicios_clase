package com.ipartek.formacion.mf0966_3ejerciciocasa.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/resenas")
public class AdminResenaController extends HttpServlet {
	private static final String ADMIN_RESENAS_TABLA = "/WEB-INF/vistas/admin/tablaResenas.jsp";
	
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("resenas", Globales.daoResena.obtenerTodos());
		request.getRequestDispatcher(ADMIN_RESENAS_TABLA).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
