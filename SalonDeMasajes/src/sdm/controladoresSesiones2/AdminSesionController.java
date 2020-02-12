package sdm.controladoresSesiones2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.controladores.Globales;

@WebServlet("/admin/sesionesO")
public class AdminSesionController extends HttpServlet {
	private static final String ADMIN_TABLA_JSP = "/WEB-INF/vistas/admin/tablaSesionesO.jsp";
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sesionesO", Globales.daoSesionO.obtenerTodos());
		request.getRequestDispatcher(ADMIN_TABLA_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
