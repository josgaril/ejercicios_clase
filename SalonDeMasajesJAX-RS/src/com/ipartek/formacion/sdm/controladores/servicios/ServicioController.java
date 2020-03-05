package com.ipartek.formacion.sdm.controladores.servicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;

@WebServlet("/admin/servicio")
public class ServicioController extends HttpServlet {
	private static final String ADMIN_SERVICIO_JSP = "/WEB-INF/vistas/admin/servicio.jsp";
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String idservicios = request.getParameter("idservicios");
		
		if(idservicios != null && idservicios.trim().length() > 0) {
			
			request.setAttribute("servicio", Globales.daoServicio.obtenerPorId(Integer.parseInt(idservicios)));
		}
		
		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		request.getRequestDispatcher(ADMIN_SERVICIO_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
