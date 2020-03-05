package com.ipartek.formacion.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.Servicio;

@Path("/servicios")
@Produces("application/json")
@Consumes("application/json")
public class ServiciosREST {

	@GET
	public Iterable<Servicio> obtenerTodos(){
		return Globales.daoServicio.obtenerTodos();
		
	}
	
	@GET
	@Path("/{idservicios}")
	public Servicio obtenerPorId(@PathParam("idservicios") Integer idservicios) {
		return Globales.daoServicio.obtenerPorId(idservicios);
	}
	
	@POST
	public Servicio agregar(Servicio servicio) {
		return Globales.daoServicio.agregar(servicio);
	}
	
	@PUT
	@Path("/idservicios")
	public Servicio modificar(@PathParam("idservicios") Integer idservicios, Servicio servicio) {
		return Globales.daoServicio.modificar(servicio);
	}

	@DELETE
	@Path("/idservicios")
	public void borrar(@PathParam("idservicios") Integer idservicios) {
		Globales.daoServicio.borrar(idservicios);
	}
	
}
