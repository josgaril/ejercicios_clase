package com.ipartek.formacion.jaxrs;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.SesionO;

@Path("/sesionesO")
@Produces("application/json")
@Consumes("application/json")
public class SesionesREST {
	private static final Logger LOGGER = Logger.getLogger(SesionesREST.class.getCanonicalName());

	@GET
	public Iterable<SesionO> obtenerTodos() {
		LOGGER.info("ObtenerTodos");

		return Globales.daoSesionO.obtenerTodos();
	}

	@GET
	@Path("/{id: \\d+}")
	public SesionO obtenerPorId(@PathParam("id") Integer id) {
		LOGGER.info("ObtenerPorId");

		SesionO sesion = Globales.daoSesionO.obtenerPorId(id);
		if (sesion == null) {
			LOGGER.warning("No se ha encontrado la sesion(" + id + ")");
			throw new WebApplicationException("No se ha encontrado la sesion(" + id + ")", Status.NOT_FOUND);
		}

		return sesion;
	}

	@POST
	public Response agregar(SesionO sesionO) {
		LOGGER.info("Agregar");

		Globales.daoSesionO.agregar(sesionO);
		return Response.status(Status.CREATED).entity(sesionO).build();

		/*
		 * try { return Globales.daoSesionO.agregar(sesionO); } catch (Exception e) {
		 * throw new WebApplicationException("Error al agregar sesion",
		 * Status.BAD_REQUEST); }
		 */
	}

	@PUT
	@Path("/{id: \\d+}")
	public SesionO modificar(@PathParam("id") Integer id, SesionO sesionO) {
		LOGGER.info("Modificar");

		if (!id.equals(sesionO.getId())) {
			LOGGER.warning("No concuerdan los id");
			throw new WebApplicationException("No concuerdan los id", Status.BAD_REQUEST);
		}

		Iterable<SesionO> sesionesTodas = Globales.daoSesionO.obtenerTodos();
		boolean existe = false;
		for (SesionO sesiones : sesionesTodas) {
			if (sesionO.getId().equals(sesiones.getId())) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado la sesion(" + id + ")");
			throw new WebApplicationException("No se ha encontrado la sesion(" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoSesionO.modificar(sesionO);
		return sesionO;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String borrar(@PathParam("id") Integer id) {
		LOGGER.info("Borrar");
		
		SesionO sesion = Globales.daoSesionO.obtenerPorId(id);
		if(sesion == null) {
			LOGGER.warning("No se ha encontrado la sesion(" + id + ") para borarr");
			throw new WebApplicationException("No se ha encontrado la sesion(" + id + ") para borarr", Status.NOT_FOUND);
		}
		Globales.daoSesionO.borrar(id);		
		return "{}";
	}

}

/*
 * Iterable<SesionO> sesionesTodas = Globales.daoSesionO.obtenerTodos(); boolean
 * coincide = false; for (SesionO sesiones : sesionesTodas) { if
 * (sesionO.getId().equals(sesiones.getId())) { coincide = true; } } if
 * (!coincide) { throw new WebApplicationException("No existe el id",
 * Status.NOT_FOUND); } return Globales.daoSesionO.modificar(sesionO);
 */