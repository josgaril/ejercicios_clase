package com.ipartek.formacion.sdm.repositorios;

import java.util.TreeMap;

import com.ipartek.formacion.sdm.modelos.Cliente;

public class ClienteTreeMap implements Dao<Cliente> {


	private TreeMap<Integer, Cliente> clientes = new TreeMap<>();

	// SINGLETON
	private static final ClienteTreeMap INSTANCIA = new ClienteTreeMap();

	private ClienteTreeMap() {
		agregar(new Cliente(null, "Alberto", "Ranieri Pelaez", "71225659F"));
		agregar(new Cliente(null, "Leticia", "Fernandez Cuesta", "78859989R"));
		agregar(new Cliente(null, "Salvador", "Dali Marina", "75566565Y"));
	}

	public static ClienteTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return clientes.values();
	}

	@Override
	public Cliente obtenerPorId(Integer idclientes) {
		return clientes.get(idclientes);
	}

	@Override
	public Cliente agregar(Cliente cliente) {
		Integer idclientes = clientes.size() == 0 ? 1 : clientes.lastKey() + 1;
		cliente.setIdclientes(idclientes);
		return clientes.put(idclientes, cliente);
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		return clientes.put(cliente.getIdclientes(), cliente);
	}

	@Override
	public void borrar(Integer idclientes) {
		if (!clientes.containsKey(idclientes)) {
			throw new AccesoDatosException("No se ha encontrado el cliente a borrar");
		}
		clientes.remove(idclientes);

	}

}
