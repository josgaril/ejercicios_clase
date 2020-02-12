package sdm.controladoresSesiones2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.controladores.Globales;

@WebServlet("/admin/sesionO")
public class SesionController extends HttpServlet {
	private static final String ADMIN_SESION_JSP = "/WEB-INF/vistas/admin/sesionO.jsp";
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id= request.getParameter("id");
		
		if(id != null && id.trim().length() > 0) {
			
			request.setAttribute("sesionO", Globales.daoSesionO.obtenerPorId(Integer.parseInt(id)));
			
		}
		
		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		request.getRequestDispatcher(ADMIN_SESION_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
