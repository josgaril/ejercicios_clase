package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		// Comprobamos que el usuario es "administrador" y su contraseña "123456"
		// Si no es correcto, el usuario debe volver a meter usuario y contraseña
		if("administrador".equals(usuario) && "123456".equals(password)) {
			request.getSession().setAttribute("nombre", usuario);
			response.sendRedirect("admin/index");
		} else {
			request.setAttribute("alertatexto", "El login no es correcto. Introduzca nombre y contraseña correctamente");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("nombre", usuario);
			
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
	}
	
}
