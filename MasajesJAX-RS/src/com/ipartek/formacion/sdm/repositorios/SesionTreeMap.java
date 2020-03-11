package com.ipartek.formacion.sdm.repositorios;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.TreeMap;

import com.ipartek.formacion.sdm.jaxrs.Cliente;
import com.ipartek.formacion.sdm.jaxrs.Servicio;
import com.ipartek.formacion.sdm.jaxrs.Sesion;
import com.ipartek.formacion.sdm.jaxrs.Trabajador;

class SesionTreeMap implements Dao<Sesion> {

	private TreeMap<Integer, Sesion> sesiones = new TreeMap<>();

	// SINGLETON
	private static final SesionTreeMap INSTANCIA = new SesionTreeMap();

	public SesionTreeMap() {

		agregar(new Sesion(1, new Cliente(1, "Leticia", "Gonzalez Ruiz", "71545258P"),
				new Trabajador(1, "Manuel", "Martinez Gombarri", "85514521B"),
				new Servicio(1, "Masaje de caderas", new BigDecimal("38.458")),
				new GregorianCalendar(2019, 11, 15).getTime(), "mu bien", "mal"));
		agregar(new Sesion(2, new Cliente(1, "jose", "garcia", "71284315G"),
				new Trabajador(2, "Fran", "Xisco", "71345622G"),
				new Servicio(2, "Masaje a 4 manos", new BigDecimal("48.154")),
				new GregorianCalendar(2020, 10, 02).getTime(), "Me ha gustado mucho", "Notable"));
		agregar(new Sesion(3, new Cliente(3, "Alberto", "Perez Alonso", "71284555O"),
				new Trabajador(3, "Marcos", "Minguez Soleil", "71829335B"),
				new Servicio(3, "Masaje de pies ", new BigDecimal("50.025")),
				new GregorianCalendar(2018, 05, 05).getTime(), "No me ha gustado Nada", "Insuficiente"));
	}

	public static SesionTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Sesion> obtenerTodos() {
		return sesiones.values();
	}

	@Override
	public Sesion obtenerPorId(Integer id) {
		return sesiones.get(id);
	}

	@Override
	public Sesion agregar(Sesion sesion) {
		Integer id = sesiones.size() == 0 ? 1 : sesiones.lastKey() + 1;
		sesion.setId(id);
		sesiones.put(id, sesion);
		return null;
	}

	@Override
	public Sesion modificar(Sesion sesion) {
		sesiones.put(sesion.getId(), sesion);
		return sesion;
	}

	@Override
	public void borrar(Integer id) {
		if (sesiones.containsKey(id)) {
			throw new AccesoDatosException("No se ha encontrado el servicio para borrar");
		}

	}

}
