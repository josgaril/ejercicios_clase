package com.ipartek.formacion.uff2215Examen.jaxrs;

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

@Path("/autores")
@Produces("application/json")
@Consumes("application/json")
public class AutorREST {

	private static final Logger LOGGER = Logger.getLogger(AutorREST.class.getCanonicalName());

	@Context
	private ServletContext context;

	@GET
	public Iterable<Autor> obtenerTodos() {
		LOGGER.info("ObtenerTodos");
		LOGGER.info(context.toString());

		return Globales.daoAutor.obtenerTodos();
	}

	@GET
	@Path("/{id: \\d+}")
	public Autor obtenerPorId(@PathParam("id") Integer id) {
		LOGGER.info("ObtenerPorID(" + id + ")");

		Autor autor = Globales.daoAutor.obtenerPorId(id);
		if (autor == null) {
			LOGGER.warning("No se ha encontrado el autor (" + id + ")");
			throw new WebApplicationException("No se ha encontrado el autor", Status.NOT_FOUND);
		}

		return autor;
	}

	@POST
	public Autor insertar(Autor autor) {
		LOGGER.info("Insertar");
		Globales.daoAutor.agregar(autor);
		return autor;
	}

	@PUT
	@Path("/{id: \\d+}")
	public Autor modificar(@PathParam("id") Integer id, Autor autor) {
		LOGGER.info("Modificar");

		if (!autor.getId().equals(id)) {
			LOGGER.warning("No coinciden los ids");
			throw new WebApplicationException("No coinciden los ids", Status.BAD_REQUEST);
		}

		boolean existe = false;
		Iterable<Autor> autoresTodos = Globales.daoAutor.obtenerTodos();
		for (Autor autorX : autoresTodos) {
			if (autorX.getId() == autor.getId()) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado el autor(" + id + ")");
			throw new WebApplicationException("No se ha encontrado el autor (" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoAutor.modificar(autor);
		return autor;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String borrar(@PathParam("id") Integer id) {
		LOGGER.info("Borrar");

		Autor autor = Globales.daoAutor.obtenerPorId(id);
		if (autor == null) {
			LOGGER.warning("No se ha encontrado el cliente (" + id + ")");
			throw new WebApplicationException("No se ha encontrado el cliente (" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoAutor.borrar(id);
		return "{}";
	}

}
