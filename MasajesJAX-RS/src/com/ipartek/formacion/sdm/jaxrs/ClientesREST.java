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

@Path("/clientes")
@Produces("application/json")
@Consumes("application/json")
public class ClientesREST {

	private static final Logger LOGGER = Logger.getLogger(ClientesREST.class.getCanonicalName());

	@Context
	private ServletContext context;
	
	@GET
	public Iterable<Cliente> obtenerTodos() {
		LOGGER.info("ObtenerTodos");
		LOGGER.info(context.toString());

		return Globales.daoCliente.obtenerTodos();
	}

	@GET
	@Path("/{idclientes: \\d+}")
	public Cliente obtenerPorId(@PathParam("idclientes") Integer idclientes) {
		LOGGER.info("ObtenerPorID(" + idclientes + ")");

		Cliente cliente = Globales.daoCliente.obtenerPorId(idclientes);
		if (cliente == null) {
			LOGGER.warning("No se ha encontrado el cliente (" + idclientes + ")");
			throw new WebApplicationException("No se ha encontrado el cliente", Status.NOT_FOUND);
		}

		return cliente;
	}

	@POST
	public Cliente insertar(Cliente cliente) {
		LOGGER.info("Insertar");
		if (cliente.isCorrecto()) {
			Globales.daoCliente.agregar(cliente);
			return cliente;
		}else {
			LOGGER.warning("Los datos del cliente no son correctos");
			throw new WebApplicationException("Los datos del cliente no son correctos", Status.BAD_REQUEST);
		}
	}

	@PUT
	@Path("/{idclientes: \\d+}")
	public Cliente modificar(@PathParam("idclientes") Integer idclientes, Cliente cliente) {
		LOGGER.info("Modificar");

		if (!cliente.getIdclientes().equals(idclientes)) {
			LOGGER.warning("No coinciden los ids");
			throw new WebApplicationException("No coinciden los ids", Status.BAD_REQUEST);
		}

		boolean existe = false;
		Iterable<Cliente> clientesTodos = Globales.daoCliente.obtenerTodos();
		for (Cliente clienteX : clientesTodos) {
			if (clienteX.getIdclientes() == cliente.getIdclientes()) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado el cliente(" + idclientes + ")");
			throw new WebApplicationException("No se ha encontrado el cliente (" + idclientes + ")", Status.NOT_FOUND);
		}
		if (cliente.isCorrecto()) {
			Globales.daoCliente.modificar(cliente);
			return cliente;
		}else {
			LOGGER.warning("Los datos del cliente no son correctos");
			throw new WebApplicationException("Los datos del cliente no son correctos", Status.BAD_REQUEST);
			//return cliente; TODO ARREGLAR 
			//se devueve el cliente con los errores. No lo dejo porque 
			//me devuelve codigo 200 como si se hubiese agregado  
			
		}
	}

	@DELETE
	@Path("/{idclientes: \\d+}")
	public String borrar(@PathParam("idclientes") Integer idclientes) {
		LOGGER.info("Borrar");

		Cliente cliente = Globales.daoCliente.obtenerPorId(idclientes);
		if (cliente == null) {
			LOGGER.warning("No se ha encontrado el cliente (" + idclientes + ")");
			throw new WebApplicationException("No se ha encontrado el cliente (" + idclientes + ")", Status.NOT_FOUND);
		}
		Globales.daoCliente.borrar(idclientes);
		return "{}";
	}

}
