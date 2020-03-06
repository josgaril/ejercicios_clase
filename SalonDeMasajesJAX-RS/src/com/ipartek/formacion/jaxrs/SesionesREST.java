package com.ipartek.formacion.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.SesionO;

@Path("/sesionesO")
@Produces("application/json")
@Consumes("application/json")
public class SesionesREST {

	@GET
	public Iterable<SesionO> obtenerTodos() {
		return Globales.daoSesionO.obtenerTodos();
	}

	@GET
	@Path("/{id}")
	public SesionO obtenerPorId(@PathParam("id") Integer id) {
		return Globales.daoSesionO.obtenerPorId(id);
	}

	@POST
	public SesionO agregar(SesionO sesionO) {
		return Globales.daoSesionO.agregar(sesionO);
		/*
		 * try { return Globales.daoSesionO.agregar(sesionO); } catch (Exception e) {
		 * throw new WebApplicationException("Error al agregar sesion",
		 * Status.BAD_REQUEST); }
		 */
	}

	@PUT
	@Path("/{id}")
	public SesionO modificar(@PathParam("id") Integer id, SesionO sesionO) {
		if (id != sesionO.getId()) {
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
			throw new WebApplicationException("No existe el id", Status.NOT_FOUND);
		}
		return Globales.daoSesionO.modificar(sesionO);

	}

	@DELETE
	@Path("/{id}")
	public String borrar(@PathParam("id") Integer id) {
		Globales.daoSesionO.borrar(id);
		return ("Sesion-eliminada");
	}

}

/*
 * Iterable<SesionO> sesionesTodas = Globales.daoSesionO.obtenerTodos(); boolean
 * coincide = false; for (SesionO sesiones : sesionesTodas) { if
 * (sesionO.getId().equals(sesiones.getId())) { coincide = true; } } if
 * (!coincide) { throw new WebApplicationException("No existe el id",
 * Status.NOT_FOUND); } return Globales.daoSesionO.modificar(sesionO);
 */