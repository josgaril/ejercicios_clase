package sdm.controladoresServicios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.controladores.Globales;

@WebServlet("/indexServicios")
public class IndexServiciosController extends HttpServlet {
	private static final String INDEX_SERVICIOS = "/WEB-INF/vistas/indexServicios.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("servicios", Globales.daos.obtenerTodos());
		request.getRequestDispatcher(INDEX_SERVICIOS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
