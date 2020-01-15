package libreria.controladores;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libreria.accesoDatos.Dao;
import libreria.accesoDatos.LibrosArrayList;
import libreria.entidades.Libro;

@WebServlet("/libro")
public class LibroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String isbn = request.getParameter("isbn");
		String paginas = request.getParameter("paginas");
		String formato = request.getParameter("formato");
		
		if (id==null | titulo==null | isbn==null | paginas==null | formato==null){
			throw new RuntimeException("Falta algún parámetro para la petición");
		}
		
		Libro libro = null;
		
		
		try {
			libro = new Libro(
					id == "" ? null : Long.parseLong(id), 
					titulo, 
					isbn, 
					paginas == "" ? null : Integer.parseInt(paginas), 
					formato
			);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dao<Libro> dao = LibrosArrayList.getInstancia();
		
		if(libro.getId() == null) {
			// AGREGAR
			dao.agregar(libro);
		} else {
			// MODIFICAR
			dao.modificar(libro);
		}
		
		request.getRequestDispatcher("libros").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
