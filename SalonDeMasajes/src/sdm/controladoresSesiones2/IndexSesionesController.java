package sdm.controladoresSesiones2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.controladores.Globales;

@WebServlet("/indexSesionesO")
public class IndexSesionesController extends HttpServlet {
	private static final String INDEX_SESIONES = "/WEB-INF/vistas/indexSesionesO.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("sesionesO", Globales.daoSesionO.obtenerTodos());
		request.setAttribute("clientes", Globales.daoCliente.obtenerTodos());

		request.getRequestDispatcher(INDEX_SESIONES).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
