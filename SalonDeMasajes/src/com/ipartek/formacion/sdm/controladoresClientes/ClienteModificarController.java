package com.ipartek.formacion.sdm.controladoresClientes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.Cliente;
import com.ipartek.formacion.sdm.modelos.Mensaje;

@WebServlet("/admin/cliente/modificar")
public class ClienteModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ADMIN_CLIENTE_JSP = "/WEB-INF/vistas/admin/cliente.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		String idclientes = request.getParameter("idclientes");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		
		Cliente cliente = new Cliente(Integer.parseInt(idclientes), nombre, apellidos, dni);

		Mensaje mensaje;

		request.setAttribute("primeravez", false);

		if (cliente.isCorrecto()) {
			Globales.daoCliente.modificar(cliente);

			mensaje = new Mensaje("Cliente modificado correctamente", Mensaje.Nivel.INFORMATIVO);

			request.getSession().setAttribute("mensaje", mensaje);

			response.sendRedirect(request.getContextPath() + "/admin/clientes");
		} else {
			request.setAttribute("op", op);
			request.setAttribute("cliente", cliente);

			mensaje = new Mensaje("El cliente no se ha podido modificar. Revisa los errores.", Mensaje.Nivel.ERROR);

			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher(ADMIN_CLIENTE_JSP).forward(request, response);
		}
	}

}
