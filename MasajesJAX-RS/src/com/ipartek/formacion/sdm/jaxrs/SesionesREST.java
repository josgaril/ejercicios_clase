package com.ipartek.formacion.sdm.jaxrs;

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

@Path("/sesiones")
@Produces("application/json")
@Consumes("application/json")
public class SesionesREST {
	private static final Logger LOGGER = Logger.getLogger(SesionesREST.class.getCanonicalName());

	@Context
	private ServletContext context;

	@GET
	public Iterable<Sesion> obtenerTodos() {
		LOGGER.info("ObtenerTodos");
		LOGGER.info(context.toString());

		return Globales.daoSesion.obtenerTodos();
	}

	@GET
	@Path("/{id: \\d+}")
	public Sesion obtenerPorId(@PathParam("id") Integer id) {
		LOGGER.info("ObtenerPorId");

		Sesion sesion = Globales.daoSesion.obtenerPorId(id);
		if (sesion == null) {
			LOGGER.warning("No se ha encontrado la sesion(" + id + ")");
			throw new WebApplicationException("No se ha encontrado la sesion(" + id + ")", Status.NOT_FOUND);
		}

		return sesion;
	}

	@POST
	public Sesion agregar(Sesion sesion) {
		LOGGER.info("Agregar");

		if (sesion.isCorrecto()) {
			Globales.daoSesion.agregar(sesion);
			return sesion;
		} else {
			LOGGER.warning("Los datos de la sesion no son correctos");
			throw new WebApplicationException("Los datos de la sesion no son correctos", Status.BAD_REQUEST);
		}
		/*
		 * try { return Globales.daoSesion.agregar(sesion); } catch (Exception e) {
		 * throw new WebApplicationException("Error al agregar sesion",
		 * Status.BAD_REQUEST); }
		 */
	}

	@PUT
	@Path("/{id: \\d+}")
	public Sesion modificar(@PathParam("id") Integer id, Sesion sesion) {
		LOGGER.info("Modificar");

		if (!id.equals(sesion.getId())) {
			LOGGER.warning("No concuerdan los id");
			throw new WebApplicationException("No concuerdan los id", Status.BAD_REQUEST);
		}

		Iterable<Sesion> sesionesTodas = Globales.daoSesion.obtenerTodos();
		boolean existe = false;
		for (Sesion sesiones : sesionesTodas) {
			if (sesion.getId().equals(sesiones.getId())) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado la sesion(" + id + ")");
			throw new WebApplicationException("No se ha encontrado la sesion(" + id + ")", Status.NOT_FOUND);
		}

		if (sesion.isCorrecto()) {
			Globales.daoSesion.modificar(sesion);
			return sesion;
		}
		return sesion;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String borrar(@PathParam("id") Integer id) {
		LOGGER.info("Borrar");

		Sesion sesion = Globales.daoSesion.obtenerPorId(id);
		if (sesion == null) {
			LOGGER.warning("No se ha encontrado la sesion(" + id + ") para borarr");
			throw new WebApplicationException("No se ha encontrado la sesion(" + id + ") para borarr",
					Status.NOT_FOUND);
		}
		Globales.daoSesion.borrar(id);
		return "{}";
	}

}

/*
 * Iterable<Sesion> sesionesTodas = Globales.daoSesion.obtenerTodos(); boolean
 * coincide = false; for (Sesion sesiones : sesionesTodas) { if
 * (sesion.getId().equals(sesiones.getId())) { coincide = true; } } if
 * (!coincide) { throw new WebApplicationException("No existe el id",
 * Status.NOT_FOUND); } return Globales.daoSesion.modificar(sesion);
 */