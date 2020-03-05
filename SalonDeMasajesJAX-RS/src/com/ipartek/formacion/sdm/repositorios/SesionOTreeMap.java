package com.ipartek.formacion.sdm.repositorios;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.TreeMap;

import com.ipartek.formacion.sdm.modelos.Cliente;
import com.ipartek.formacion.sdm.modelos.Servicio;
import com.ipartek.formacion.sdm.modelos.SesionO;
import com.ipartek.formacion.sdm.modelos.Trabajador;

class SesionOTreeMap implements Dao<SesionO> {

	private TreeMap<Integer, SesionO> sesionesO = new TreeMap<>();

	// SINGLETON
	private static final SesionOTreeMap INSTANCIA = new SesionOTreeMap();

	public SesionOTreeMap() {

		agregar(new SesionO(1, new Cliente(1, "Leticia", "Gonzalez Ruiz", "71545258P"),
				new Trabajador(1, "Manuel", "Martinez Gombarri", "85514521B"),
				new Servicio(1, "Masaje de caderas", new BigDecimal("38.458")),
				new GregorianCalendar(2019,11,15).getTime(), "mu bien", "mal"));
		agregar(new SesionO(2, new Cliente(1, "jose", "garcia", "71284315G"),
				new Trabajador(2, "Fran", "Xisco", "71345622G"),
				new Servicio(2, "Masaje a 4 manos", new BigDecimal("48.154")),
				new GregorianCalendar(2020, 10, 02).getTime(), "Me ha gustado mucho", "Notable"));
		agregar(new SesionO(3, new Cliente(3, "Alberto", "Perez Alonso", "71284555O"),
				new Trabajador(3, "Marcos", "Minguez Soleil", "71829335B"),
				new Servicio(3, "Masaje de pies ", new BigDecimal("50.025")),
				new GregorianCalendar(2018, 05, 05).getTime(), "No me ha gustado Nada", "Insuficiente"));
	}

	public static SesionOTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<SesionO> obtenerTodos() {
		return sesionesO.values();
	}

	@Override
	public SesionO obtenerPorId(Integer id) {
		return sesionesO.get(id);
	}

	@Override
	public void agregar(SesionO sesionO) {
		Integer id = sesionesO.size() == 0 ? 1 : sesionesO.lastKey() + 1;
		sesionO.setId(id);
		sesionesO.put(id, sesionO);
	}

	@Override
	public void modificar(SesionO sesionO) {
		sesionesO.put(sesionO.getId(), sesionO);

	}

	@Override
	public void borrar(Integer id) {
		if (sesionesO.containsKey(id)) {
			throw new AccesoDatosException("No se ha encontrado el servicio para borrar");
		}

	}

}
