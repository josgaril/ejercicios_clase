package com.ipartek.formacion.jaxrs;

import java.util.TreeMap;

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

import com.ipartek.formacion.sdm.modelos.Cliente;

@Path("/clientes")
@Produces("application/json")
@Consumes("application/json")
public class ClientesREST {
	private static TreeMap<Integer, Cliente> clientes = new TreeMap<>();
	
	static {
		clientes.put(1, new Cliente(1,"Josete", "AAA","71225362P"));
		clientes.put(2, new Cliente(2, "Alberto", "Ranieri Pelaez", "71225659F"));
	}
	
	@GET
	public Iterable<Cliente> getAll() {
		return clientes.values();
	}
	
	@GET
	@Path("/{id}")
	public Cliente getById(@PathParam("id") Integer idclientes) {
		return clientes.get(idclientes);
	}
	
	@POST
	public Cliente insert(Cliente cliente) {
		Integer id = clientes.size() == 0 ? 1 : clientes.lastKey() + 1;
		cliente.setIdclientes(id);
		
		clientes.put(id, cliente);
		
		return cliente;
	}
	
	@PUT
	@Path("/{id}")
	public Cliente update(@PathParam("id") Integer id, Cliente cliente) {
		if(id != cliente.getIdclientes()) {
			throw new WebApplicationException("No concuerdan los id", Status.BAD_REQUEST);
		}

		if(!clientes.containsKey(id)) {
			throw new WebApplicationException("No se ha encontrado el id a modificar", Status.NOT_FOUND);
		}
		
		clientes.put(id, cliente);
		
		return cliente;
	}
	
	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") Integer id) {
		clientes.remove(id);
		
		return "{}";
	}
}
