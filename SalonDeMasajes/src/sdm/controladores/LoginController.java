package sdm.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdm.modelos.Mensaje;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		if("administrador".equals(usuario) && "123456".equals(password)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("/admin/index").forward(request, response);
		} else {
			request.setAttribute("usuario", usuario);
			request.setAttribute("mensaje", new Mensaje("Login incorrecto", Mensaje.Nivel.ERROR));
			
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
	}

}
