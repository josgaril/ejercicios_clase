package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.repositorios.QuadTreeMap;

@WebServlet("/admin/borrarquad")
public class AdminBorrarQuad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		QuadTreeMap.getInstancia().borrar(Long.parseLong(id));
		HttpSession session = request.getSession();
		session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
		session.setAttribute("alertanivel", "success");
		response.sendRedirect(request.getContextPath() + "/admin/indexquad");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
