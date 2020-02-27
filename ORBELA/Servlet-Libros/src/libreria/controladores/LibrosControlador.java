package libreria.controladores;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libreria.accesoDatos.Dao;
import libreria.accesoDatos.LibrosArrayList;
import libreria.entidades.Libro;

@WebServlet("/libros")
public class LibrosControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pedimos un objeto de acceso a datos para tener el repositorio de alumnos
		Dao<Libro> dao = LibrosArrayList.getInstancia();

		// Recoger el posible ID
		String id = request.getParameter("id");
		// Recoger la posible op
		String op = request.getParameter("op");

		if (op != null) {
			// Según la operación, saltamos a la vista que corresponde con los datos
			// asociados
			switch (op) {
			case "modificar":
				Libro libro= dao.obtenerPorId(Long.parseLong(id));
				request.setAttribute("libro", libro);				
			case "agregar":
				request.getRequestDispatcher("libro.jsp").forward(request, response);
				// Es MUY recomendable hacer un return después de un forward
				return;
			case "borrar":
				dao.borrar(Long.parseLong(id));
				break;
			}
		}
		
		// Pedimos al dao (Data Access Object, objeto de acceso a datos) que nos de
		// todos los alumnos que contiene
		// Lo almacenamos en un atributo de request para que la JSP pueda recibirlos con
		// el nombre "alumnos"
		// Se relacionará con ${alumnos} en la JSP
		request.setAttribute("libros", dao.obtenerTodos());
		// Reenviamos (forward) la petición a la JSP de alumnos.jsp
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
