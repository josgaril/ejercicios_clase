package com.ipartek.formacion.uff2215Examen.REST;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.uff2215Examen.controladores.Globales;
import com.ipartek.formacion.uff2215Examen.modelos.Libro;

@Path("/libros")
@Produces("application/json")
@Consumes("application/json")
public class LibroREST {

	private static final Logger LOGGER = Logger.getLogger(LibroREST.class.getCanonicalName());

	@Context
	private ServletContext context;

	@GET
	public Iterable<Libro> obtenerTodos() {
		LOGGER.info("ObtenerTodos");
		LOGGER.info(context.toString());

		return Globales.daoLibro.obtenerTodos();
	}

	@GET
	@Path("/{id: \\d+}")
	public Libro obtenerPorId(@PathParam("id") Integer id) {
		LOGGER.info("ObtenerPorID(" + id + ")");

		Libro libro = Globales.daoLibro.obtenerPorId(id);
		if (libro == null) {
			LOGGER.warning("No se ha encontrado el libro (" + id + ")");
			throw new WebApplicationException("No se ha encontrado el libro", Status.NOT_FOUND);
		}

		return libro;
	}

	@GET
	@Path("/{titulo}")
	public Libro obtenerPorTitulo(@PathParam("titulo") String titulo) {
		LOGGER.info("ObtenerPorTitulo(" + titulo + ")");

		Libro libro = Globales.daoLibro.obtenerPorTitulo(titulo);
		if (libro == null) {
			LOGGER.warning("No se ha encontrado el libro: (" + titulo + ")");
			throw new WebApplicationException("No se ha encontrado el libro", Status.NOT_FOUND);
		}

		return libro;
	}

	@POST
	public Libro insertar(Libro libro) {
		LOGGER.info("Insertar");
		Globales.daoLibro.agregar(libro);
		return libro;
	}

	@PUT
	@Path("/{id: \\d+}")
	public Libro modificar(@PathParam("id") Integer id, Libro libro) {
		LOGGER.info("Modificar");

		if (!libro.getId().equals(id)) {
			LOGGER.warning("No coinciden los ids");
			throw new WebApplicationException("No coinciden los ids", Status.BAD_REQUEST);
		}

		boolean existe = false;
		Iterable<Libro> librosTodos = Globales.daoLibro.obtenerTodos();
		for (Libro librosX : librosTodos) {
			if (librosX.getId() == libro.getId()) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado el libro(" + id + ")");
			throw new WebApplicationException("No se ha encontrado el libro (" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoLibro.modificar(libro);
		return libro;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String borrar(@PathParam("id") Integer id) {
		LOGGER.info("Borrar");

		Libro libro = Globales.daoLibro.obtenerPorId(id);
		if (libro == null) {
			LOGGER.warning("No se ha encontrado el libro (" + id + ")");
			throw new WebApplicationException("No se ha encontrado el libro (" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoLibro.borrar(id);
		return "{}";
	}

}
