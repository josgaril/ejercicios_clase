package com.ipartek.formacion.sdm.repositorios;

import java.util.GregorianCalendar;
import java.util.TreeMap;

import com.ipartek.formacion.sdm.modelos.Sesion;

public class SesionTreeMap implements Dao<Sesion> {

	private TreeMap<Integer, Sesion> sesiones = new TreeMap<>();

	// SINGLETON
	private static final SesionTreeMap INSTANCIA = new SesionTreeMap();

	public SesionTreeMap() {
	
		agregar(new Sesion(null, 1, 1, 1, new GregorianCalendar(2020, 11, 02).getTime(), "Me ha gustado mucho",
				"Notable"));
		agregar(new Sesion(null, 2, 2, 3, new GregorianCalendar(2019, 5, 05).getTime(), "No me ha gustado nada",
				"Lamentable"));
		agregar(new Sesion(null, 3, 2, 3, new GregorianCalendar(2020, 6, 01).getTime(), "Ni fu ni nfa", "Pasable"));
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
		return sesion;
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
