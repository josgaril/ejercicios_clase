package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.repositorios.CocheTreeMap;

@WebServlet("/admin/borrarcoche")
public class AdminBorrarCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		CocheTreeMap.getInstancia().borrar(Long.parseLong(id));
		
		response.sendRedirect(request.getContextPath() + "/admin/indexcoche");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
