package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.repositorios.LibroTreeMap;

@WebServlet("/admin/borrar")
public class AdminBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		//Borramos el libro deseado según su id
		LibroTreeMap.getInstancia().borrar(Long.parseLong(id));
		
		//Redirigimos al administrador al la página de inicio de la zona Administrador
		response.sendRedirect(request.getContextPath() + "/admin/index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
