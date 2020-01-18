package mvc.repositorios;

import java.util.TreeMap;

import mvc.modelos.Coche;

public class CocheTreeMap implements Dao<Coche> {
	private TreeMap<Long, Coche> coches = new TreeMap<>();

	// SINGLETON
	private static final CocheTreeMap INSTANCIA = new CocheTreeMap();

	private CocheTreeMap() {
		agregar(new Coche("Renaut", "Clio Sport", "26850 €",
				"https://www.diariomotor.com/2016/05/21/renault-clio-rs-250-cv-2016/"));
		agregar(new Coche("Seat", "Leon FR", "23200 €",
				"https://www.motor.es/seat/leon/fr"));
	}

	public static CocheTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Coche> obtenerTodos() {
		return coches.values();
	}

	@Override
	public Coche obtenerPorId(Long id) {
		return coches.get(id);
	}

	@Override
	public void agregar(Coche coche) {
		// Comprobamos si la colección está vacía y en ese caso ponemos el id a 1
		// En caso contrario ponemos el id al último id + 1
		Long id = coches.size() == 0 ? 1L : coches.lastKey() + 1;
		coche.setId(id);
		coches.put(id, coche);

	}

	@Override
	public void modificar(Coche coche) {
		// throw new UnsupportedOperationException("NO ESTÁ IMPLEMENTADO");
		coches.put(coche.getId(), coche);

	}

	@Override
	public void borrar(Long id) {
		coches.remove(id);
	}

}
