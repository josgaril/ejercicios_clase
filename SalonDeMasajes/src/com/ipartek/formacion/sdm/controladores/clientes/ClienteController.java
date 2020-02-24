package com.ipartek.formacion.sdm.controladores.clientes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;

@WebServlet("/admin/cliente")
public class ClienteController extends HttpServlet {
	private static final String ADMIN_CLIENTE_JSP = "/WEB-INF/vistas/admin/cliente.jsp";
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String idclientes = request.getParameter("idclientes");
		
		if(idclientes != null && idclientes.trim().length() > 0) {
			
			request.setAttribute("cliente", Globales.daoCliente.obtenerPorId(Integer.parseInt(idclientes)));
		}
		
		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		request.getRequestDispatcher(ADMIN_CLIENTE_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
