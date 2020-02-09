package sdm.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/listado")
public class AdminListadoController extends HttpServlet {
	private static final String ADMIN_LISTADO_JSP = "/WEB-INF/vistas/admin/listadoTrabajadores.jsp";
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("clientes", Globales.daoc.obtenerTodos());
		request.setAttribute("servicios", Globales.daos.obtenerTodos());
		request.setAttribute("trabajadores", Globales.daoT.obtenerTodos());
		request.getRequestDispatcher(ADMIN_LISTADO_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
