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
import com.ipartek.formacion.sdm.modelos.Servicio;

@Path("/servicios")
@Produces("application/json")
@Consumes("application/json")
public class ServiciosREST {
	private static final Logger LOGGER = Logger.getLogger(ServiciosREST.class.getCanonicalName());

	@GET
	public Iterable<Servicio> obtenerTodos(){
		LOGGER.info("ObtenerTodos");
		
		return Globales.daoServicio.obtenerTodos();
	}
	
	@GET
	@Path("/{idservicios: \\d+}")
	public Servicio obtenerPorId(@PathParam("idservicios") Integer idservicios) {
		LOGGER.info("ObtenerPorId");
		
		Servicio servicio = Globales.daoServicio.obtenerPorId(idservicios);
		if (servicio==null) {
			LOGGER.warning("No se ha encontrado el servicio(" + idservicios + ")");
			throw new WebApplicationException("No se ha encontrado el servicio(" + idservicios + ")", Status.NOT_FOUND);
		}
		return servicio;
	}
	
	@POST
	public Response agregar(Servicio servicio) {
		LOGGER.info("Agregar");
		Globales.daoServicio.agregar(servicio);
		return Response.status(Status.CREATED).entity(servicio).build();
	}
	
	@PUT
	@Path("/{idservicios: \\d+}")
	public Servicio modificar(@PathParam("idservicios") Integer idservicios, Servicio servicio) {
		LOGGER.info("Modificar");
		
		if (!idservicios.equals(servicio.getIdservicios())) {
			LOGGER.warning("No coinciden los ids");
			throw new WebApplicationException("No coinciden los ids", Status.BAD_REQUEST);
		}
		
		boolean existe=false;
		Iterable<Servicio> serviciosTodos = Globales.daoServicio.obtenerTodos();
		for(Servicio servicioX: serviciosTodos) {
			if(servicioX.getIdservicios()==servicio.getIdservicios()) {
				existe=true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado el servicio("+ idservicios + ")");
			throw new WebApplicationException("No se ha encontrado el servicio("+ idservicios + ")", Status.NOT_FOUND);
		}
		
		Globales.daoServicio.modificar(servicio);
		return servicio;
	}

	@DELETE
	@Path("/{idservicios: \\d+}")
	public String borrar(@PathParam("idservicios") Integer idservicios) {
		LOGGER.info("Borrar");
		
		Servicio servicio = Globales.daoServicio.obtenerPorId(idservicios);
		if (servicio==null) {
			LOGGER.warning("No se ha encontrado el servicio("+ idservicios + ")");
			throw new WebApplicationException("No se ha encontrado el servicio("+ idservicios + ")", Status.NOT_FOUND);
		}
		Globales.daoServicio.borrar(idservicios);
		return "{}";
	}
	
}
