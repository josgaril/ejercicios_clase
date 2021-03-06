package com.ipartek.formacion.sdm.repositorios;

import java.util.TreeMap;

import com.ipartek.formacion.sdm.jaxrs.Trabajador;

public class TrabajadorTreeMap implements Dao<Trabajador> {
	private TreeMap<Integer, Trabajador> trabajadores = new TreeMap<>();

	// SINGLETON
	private static final TrabajadorTreeMap INSTANCIA = new TrabajadorTreeMap();

	private TrabajadorTreeMap() {
		agregar(new Trabajador(null, "Josele", "Belez Marina", "87452165M"));
		agregar(new Trabajador(null, "Miguel Angel", "Martinez Diez", "78789876T"));
		agregar(new Trabajador(null, "Marta", "Renes Zulua", "76267655G"));
	}

	public static TrabajadorTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Trabajador> obtenerTodos() {
		return trabajadores.values();
	}

	@Override
	public Trabajador obtenerPorId(Integer idtrabajadores) {
		return trabajadores.get(idtrabajadores);
	}

	@Override
	public Trabajador agregar(Trabajador trabajador) {
		Integer idtrabajadores= trabajadores.size()==0? 1: trabajadores.lastKey() +1;
		trabajador.setIdtrabajadores(idtrabajadores);
		trabajadores.put(idtrabajadores, trabajador);
		return null;
	}

	@Override
	public Trabajador modificar(Trabajador trabajador) {
		trabajadores.put(trabajador.getIdtrabajadores(), trabajador);
		return trabajador;
	}

	@Override
	public void borrar(Integer idtrabajadores) {
		if (!trabajadores.containsKey(idtrabajadores)) {
			throw new AccesoDatosException("No se ha encontrado el trabajador a borrar");
		}
		trabajadores.remove(idtrabajadores);
	}
}
