package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.repositorios.QuadTreeMap;
	
// La ruta /admin/index se puede crear ya que podemos inventarnos cualquier ruta
// http://localhost:8080/EjemploMVC/admin/index
// NO hay ninguna carpeta admin
@WebServlet("/admin/indexquad")
public class AdminIndexQuadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("quads", QuadTreeMap.getInstancia().obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/indexquad.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
