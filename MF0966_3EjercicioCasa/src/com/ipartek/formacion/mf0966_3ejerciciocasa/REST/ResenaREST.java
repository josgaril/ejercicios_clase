package com.ipartek.formacion.mf0966_3ejerciciocasa.REST;

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

import com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.Globales;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Resena;

@Path("resenas")
@Produces("application/json")
@Consumes("application/json")
public class ResenaREST {

	private static final Logger LOGGER = Logger.getLogger(ResenaREST.class.getCanonicalName());

	@Context
	private ServletContext context;

	@GET
	public Iterable<Resena> obtenerTodos() {
		LOGGER.info("Obtener todos");
		LOGGER.info(context.toString());

		return Globales.daoResena.obtenerTodos();
	}

	@GET
	@Path("/{codigo: \\d+}")
	public Resena obtenerPorCodigo(@PathParam("codigo") Integer codigo) {
		LOGGER.info("Obtener por codigo");

		Resena resena = Globales.daoResena.obtenerPorCodigo(codigo);
		if (resena == null) {
			LOGGER.warning("No se ha encontrado la reseña(" + codigo + ")");
			throw new WebApplicationException("No se ha encontrado la reseña(" + codigo + ")", Status.NOT_FOUND);
		}
		return resena;
	}

	@POST
	public Response agregar(Resena resena) {
		LOGGER.info("Agregar");

		Globales.daoResena.agregar(resena);
		return Response.status(Status.CREATED).entity(resena).build();
	}

	@PUT
	@Path("/{codigo: \\d+}")
	public Resena modificar(@PathParam("codigo") Integer codigo, Resena resena) {
		LOGGER.info("Modificar");

		if (!codigo.equals(resena.getCodigo())) {
			LOGGER.warning("No coinciden los codigos");
			throw new WebApplicationException("No coinciden los codigos", Status.BAD_REQUEST);
		}

		boolean existe = false;
		Iterable<Resena> resenasTodas = Globales.daoResena.obtenerTodos();
		for (Resena resenaX : resenasTodas) {
			if (resenaX.getCodigo() == resena.getCodigo()) {
				existe = true;
			}
		}

		if (!existe) {
			LOGGER.warning("No se ha encontrado la resena(" + codigo + ")");
			throw new WebApplicationException("No se ha encontrado la resena(" + codigo + ")", Status.NOT_FOUND);
		}
		
		Globales.daoResena.modificar(resena);
		return resena;
	}

	@DELETE
	@Path("/{codigo: \\d+}")
	public String borrar(@PathParam("codigo") Integer codigo) {
		LOGGER.info("Borrar");
		
		Resena resena = Globales.daoResena.obtenerPorCodigo(codigo);
		if (resena==null) {
			LOGGER.warning("No se ha encontrado la reseña(" + codigo + ")");
			throw new WebApplicationException("No se ha encontrado la reseña(" + codigo + ")", Status.NOT_FOUND);
		}
		Globales.daoResena.borrar(codigo);
		return "Borrada";
	}
	
}
