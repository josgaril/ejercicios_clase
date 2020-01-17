package mvc.repositorios;

import java.util.TreeMap;

import mvc.modelos.Coche;

public class CocheTreeMap implements Dao<Coche> {
	private TreeMap<Long, Coche> coches = new TreeMap<>();

	// SINGLETON
	private final static CocheTreeMap INSTANCIA = new CocheTreeMap();
	
	private CocheTreeMap() {
		agregar(new Coche("Renault", "Clio Sport", "19500",
				"https://www.kawasaki.es/es/products/Supersport/2020/Ninja_650/overview?Uid=0860WlFfWlwMXFhdDlBYXF0NDApYXAtfXg5aCllZXQ5cClA"));
		agregar(new Coche("Seat", "Leon FR", "23000",
				"https://www.yamaha-motor.eu/es/es/products/motocicletas/supersport/yzf-r1/"));
	}
	
	public static CocheTreeMap getInstancia() { return INSTANCIA; }
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
		//throw new UnsupportedOperationException("NO ESTÁ IMPLEMENTADO");
		coches.put(coche.getId(), coche);
	}

	@Override
	public void borrar(Long id) {
		coches.remove(id);
	}
}
