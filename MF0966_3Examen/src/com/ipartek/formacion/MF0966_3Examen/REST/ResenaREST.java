package com.ipartek.formacion.MF0966_3Examen.REST;

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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.MF0966_3Examen.controladores.Globales;
import com.ipartek.formacion.MF0966_3Examen.modelos.Resena;

@Path("/resenas")
@Produces("application/json")
@Consumes("application/json")
public class ResenaREST {

	private static final Logger LOGGER = Logger.getLogger(ResenaREST.class.getCanonicalName());

	@Context
	private ServletContext context;

	@GET
	public Iterable<Resena> obtenerTodos() {
		LOGGER.info("ObtenerTodos");
		LOGGER.info(context.toString());

		return Globales.daoResena.obtenerTodos();
	}

	@GET
	@Path("/{id: \\d+}")
	public Resena obtenerPorId(@PathParam("id") Integer id) {
		LOGGER.info("ObtenerPorID(" + id + ")");

		Resena resena= Globales.daoResena.obtenerPorId(id);
		if (resena == null) {
			LOGGER.warning("No se ha encontrado la resena (" + id + ")");
			throw new WebApplicationException("No se ha encontrado las resena(" + id + ")", Status.NOT_FOUND);
		}

		return resena;
	}

	@POST
	public Response insertar(Resena resena) {
		LOGGER.info("Insertar");
		Globales.daoResena.agregar(resena);
		return Response.status(Status.CREATED).entity(resena).build();
	}

	@PUT
	@Path("/{id: \\d+}")
	public Resena modificar(@PathParam("id") Integer id, Resena resena) {
		LOGGER.info("Modificar");

		if (!resena.getId().equals(id)) {
			LOGGER.warning("No coinciden los ids");
			throw new WebApplicationException("No coinciden los ids", Status.BAD_REQUEST);
		}

		boolean existe = false;
		Iterable<Resena> resenasTodas = Globales.daoResena.obtenerTodos();
		for (Resena resenaX : resenasTodas) {
			if (resenaX.getId() == resena.getId()) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado la resena(" + id + ")");
			throw new WebApplicationException("No se ha encontrado la resena(" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoResena.modificar(resena);
		return resena;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String borrar(@PathParam("id") Integer id) {
		LOGGER.info("Borrar");

		Resena resena = Globales.daoResena.obtenerPorId(id);
		if (resena == null) {
			LOGGER.warning("No se ha encontrado la resena(" + id + ")");
			throw new WebApplicationException("No se ha encontrado la resena(" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoResena.borrar(id);
		return "{}";
	}

}
