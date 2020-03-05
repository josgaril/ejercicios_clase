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
import com.ipartek.formacion.sdm.modelos.Trabajador;

@Path("/trabajadores")
@Produces("application/json")
@Consumes("application/json")
public class TrabajadoresREST {

	@GET
	public Iterable<Trabajador> obtenerTodos(){
		return Globales.daoTrabajador.obtenerTodos();
	}
	
	@GET
	@Path("/{idtrabajadores}")
	public Trabajador obtenerPorId(@PathParam("idtrabajadores") Integer idtrabajadores) {
		return Globales.daoTrabajador.obtenerPorId(idtrabajadores);		
	}
	
	@POST
	public void agregar(Trabajador trabajador){
		 Globales.daoTrabajador.agregar(trabajador); 
	}
	
	
	  @PUT
	  @Path("/{idtrabajadores}")
	  public void modificar(@PathParam("idtrabajadores") Integer idtrabajadores, Trabajador trabajador ) {
		  Globales.daoTrabajador.modificar(trabajador);
	  }
	  
	  @DELETE
	  @Path("/{idtrabajadores}")
	  public void borrar(@PathParam("idtrabajadores") Integer idtrabajadores) {
		  Globales.daoTrabajador.borrar(idtrabajadores);
	  }
	 
}
