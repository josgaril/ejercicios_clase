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
import com.ipartek.formacion.sdm.modelos.Trabajador;

@Path("/trabajadores")
@Produces("application/json")
@Consumes("application/json")
public class TrabajadoresREST {
	private static final Logger LOGGER = Logger.getLogger(TrabajadoresREST.class.getCanonicalName());

	@GET
	public Iterable<Trabajador> obtenerTodos() {
		LOGGER.info("getAll");

		return Globales.daoTrabajador.obtenerTodos();
	}

	@GET
	@Path("/{idtrabajadores: \\d+}") // comprueba que el id sea numerico
	public Trabajador obtenerPorId(@PathParam("idtrabajadores") Integer idtrabajadores) {
		LOGGER.info("getByID(" + idtrabajadores + ")");
		
		Trabajador trabajador = Globales.daoTrabajador.obtenerPorId(idtrabajadores);
		if (trabajador == null) {
			LOGGER.warning("No se ha encontrado el trabajador(" + idtrabajadores + ")");
			throw new WebApplicationException("No se ha encontrado el trabajador", Status.NOT_FOUND);
		}
		return trabajador;
	}

	@POST
	public Response agregar(Trabajador trabajador) {
		LOGGER.info("Insert");
		Globales.daoTrabajador.agregar(trabajador);
		
		return Response.status(Status.CREATED).entity(trabajador).build();
	}

	@PUT
	@Path("/{idtrabajadores: \\d+}")
	public Trabajador modificar(@PathParam("idtrabajadores") Integer idtrabajadores, Trabajador trabajador) {
		LOGGER.info("Update");

		if (!idtrabajadores.equals(trabajador.getIdtrabajadores())) {
			LOGGER.warning("No coinciden los ids");
			throw new WebApplicationException("No coinciden los ids", Status.BAD_REQUEST);
		}
		
		boolean existe = false;
		Iterable<Trabajador> trabajadoresTodos = Globales.daoTrabajador.obtenerTodos();
		for (Trabajador trabajadorX : trabajadoresTodos) {
			if (trabajadorX.getIdtrabajadores() == trabajador.getIdtrabajadores()) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado el trabajador("+ idtrabajadores + ")");
			throw new WebApplicationException("No se ha encontrado el trabajador ("+idtrabajadores + ")", Status.NOT_FOUND);
		}
		Globales.daoTrabajador.modificar(trabajador);
		return trabajador;
	}

	@DELETE
	@Path("/{idtrabajadores: \\d+}")
	public String borrar(@PathParam("idtrabajadores") Integer idtrabajadores) {
		LOGGER.info("delete");
		Trabajador trabajador = Globales.daoTrabajador.obtenerPorId(idtrabajadores);
		if (trabajador == null) {
			LOGGER.warning("No se ha encontrado el trabajador a borrar");
			throw new WebApplicationException("No se ha encontrado el trabajador a borrar", Status.NOT_FOUND);
		}
		Globales.daoTrabajador.borrar(idtrabajadores);
		return "{}";
	}

}
