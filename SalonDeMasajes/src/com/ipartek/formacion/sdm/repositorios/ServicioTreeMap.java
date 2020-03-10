package com.ipartek.formacion.sdm.repositorios;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.sdm.modelos.Servicio;

class ServicioTreeMap implements Dao<Servicio> {

	private TreeMap<Integer, Servicio> servicios = new TreeMap<>();

	// SINGLETON
	private static final ServicioTreeMap INSTANCIA = new ServicioTreeMap();

	private ServicioTreeMap() {
		agregar(new Servicio(null, "Masaje facial", new BigDecimal("48.15")));
		agregar(new Servicio(null, "Drenaje linfatico", new BigDecimal("35.48")));
		agregar(new Servicio(null, "Cobertura de algas", new BigDecimal("60.50")));
	}

	public static ServicioTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Servicio> obtenerTodos() {
		return servicios.values();

	}

	@Override
	public Servicio obtenerPorId(Integer idservicios) {
		return servicios.get(idservicios);
	}

	@Override
	public Integer agregar(Servicio servicio) {
		Integer idservicios = servicios.size() == 0 ? 1 : servicios.lastKey() + 1;
		servicio.setIdservicios(idservicios);
		servicios.put(idservicios, servicio);
		return null;
	}

	@Override
	public Servicio modificar(Servicio servicio) {
		servicios.put(servicio.getIdservicios(), servicio);
		return servicio;
	}

	@Override
	public void borrar(Integer idservicios) {
		if (!servicios.containsKey(idservicios)) {
			throw new AccesoDatosException("No se ha encontrado el libro a borrar");
		}
		servicios.remove(idservicios);

	}

}
