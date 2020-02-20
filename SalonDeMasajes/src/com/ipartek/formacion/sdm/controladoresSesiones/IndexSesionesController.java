package com.ipartek.formacion.sdm.controladoresSesiones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;

@WebServlet("/indexSesiones")
public class IndexSesionesController extends HttpServlet {
	private static final String INDEX_SESIONES = "/WEB-INF/vistas/indexSesiones.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("sesiones", Globales.daoSesion.obtenerTodos());
		request.setAttribute("clientes", Globales.daoCliente.obtenerTodos());

		request.getRequestDispatcher(INDEX_SESIONES).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
