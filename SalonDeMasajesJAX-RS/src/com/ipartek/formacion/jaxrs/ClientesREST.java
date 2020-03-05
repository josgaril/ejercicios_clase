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
import com.ipartek.formacion.sdm.modelos.Cliente;

@Path("/clientes")
@Produces("application/json")
@Consumes("application/json")
public class ClientesREST {
	
	@GET
	public Iterable<Cliente> obtenerTodos(){
		return Globales.daoCliente.obtenerTodos();
	}
	
	@GET
	@Path("/{idclientes}")
	public Cliente obtenerPorId(@PathParam("idclientes") Integer idclientes) {
		return Globales.daoCliente.obtenerPorId(idclientes);
	}
	
	@POST
	public Cliente insertar(Cliente cliente) {
		return Globales.daoCliente.agregar(cliente);
	}
	
	@PUT
	@Path("/{idclientes}")
	public Cliente modificar(@PathParam("idclientes") Integer idclientes, Cliente cliente){
		return Globales.daoCliente.modificar(cliente);
	}
	
	@DELETE
	@Path("/{idclientes}")
	public String borrar(@PathParam("idclientes") Integer idclientes) {
		Globales.daoCliente.borrar(idclientes);
		return ("Cliente-eliminado");
	}
	
}
