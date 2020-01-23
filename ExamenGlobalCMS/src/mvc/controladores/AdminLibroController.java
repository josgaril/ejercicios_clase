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

@WebServlet("/admin/libro")
public class AdminLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String op = request.getParameter("op");

		if (id != null) {
			Libro libro = LibroTreeMap.getInstancia().obtenerPorId(Long.parseLong(id));
			request.setAttribute("libro", libro);
		}

		request.setAttribute("op", op);
		request.setAttribute("primeravez", true);
		request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Dao<Libro> dao = LibroTreeMap.getInstancia();

		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");
		String autor = request.getParameter("autor");
		String imagen = request.getParameter("imagen");
		
		Libro libro = null;

		switch (op) {
		case "agregar":
			libro = new Libro(nombre, Double.parseDouble(precio), Integer.parseInt(descuento), autor, imagen);
			if (libro.isCorrecto()) {
				dao.agregar(libro);
			}

			break;
		case "modificar":
			libro = new Libro(Long.parseLong(id), nombre, Double.parseDouble(precio), Integer.parseInt(descuento), autor, imagen);
			if (libro.isCorrecto()) {
				dao.modificar(libro);
			}

			break;
		default:
			throw new RuntimeException("Operación no reconocida");
		}

		if (libro.isCorrecto()) {

			HttpSession session = request.getSession();
			session.setAttribute("alertatexto", "La operación " + op + " se ha realizado correctamente");
			session.setAttribute("alertanivel", "success");
			response.sendRedirect(request.getContextPath() + "/admin/index");
		} else {
			request.setAttribute("alertatexto", "Error en el formulario. Revise los datos para continuar.");
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("primeravez", false);
			request.setAttribute("op", op);
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
		}
	}

}
