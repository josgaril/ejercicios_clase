package com.ipartek.formacion.sdm.controladoresTrabajadores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;

@WebServlet("/indexTrabajadores")
public class IndexTrabajadoresController extends HttpServlet {
	private static final String INDEX_TRABAJADORES = "/WEB-INF/vistas/indexTrabajadores.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("trabajadores", Globales.daoTrabajador.obtenerTodos());
		request.getRequestDispatcher(INDEX_TRABAJADORES).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
