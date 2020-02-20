package com.ipartek.formacion.sdm.controladoresClientes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;

@WebServlet("/indexClientes")
public class IndexClientesController extends HttpServlet {
	private static final String INDEX_CLIENTES = "/WEB-INF/vistas/indexClientes.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("clientes", Globales.daoCliente.obtenerTodos());
		request.getRequestDispatcher(INDEX_CLIENTES).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
