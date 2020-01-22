package mvc.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.modelos.Libro;
import mvc.repositorios.Dao;
import mvc.repositorios.LibroTreeMap;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op == null) {
			op = "";
		}

		switch (op) {
		case "agregar":
			request.setAttribute("primeravez", true);
			request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("libros", LibroTreeMap.getInstancia().obtenerTodos());
			request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// NECESARIO EN TODAS LAS RECEPCIONES DE DATOS DE FORMULARIO
		// SI QUEREMOS QUE SE GUARDEN CORRECTAMENTE LOS CARACTERES
		// Ññá...
		request.setCharacterEncoding("UTF-8");

		Dao<Libro> dao = LibroTreeMap.getInstancia();

		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");

		Libro libro = null;

		libro = new Libro(nombre, Double.parseDouble(precio), Integer.parseInt(descuento));
		if (libro.isCorrecto()) {
			dao.agregar(libro);
			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación Agregar se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");
			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			request.setAttribute("alertatexto", "Hay un error en el formulario. Revise los datos.");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("primeravez", false);
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
		}
	}

}
