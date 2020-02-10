package sdm.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/indexcopia")
public class IndexCopiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("clientes", Globales.daoCliente.obtenerTodos());
		request.setAttribute("servicios", Globales.daoServicio.obtenerTodos());
		request.setAttribute("trabajadores", Globales.daoTrabajador.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/indexTrabajadores.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
