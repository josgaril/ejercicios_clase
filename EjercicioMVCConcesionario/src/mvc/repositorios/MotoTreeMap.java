package mvc.repositorios;

import java.util.TreeMap;

import mvc.modelos.Moto;

public class MotoTreeMap implements Dao<Moto> {
	private TreeMap<Long, Moto> motos = new TreeMap<>();

	// SINGLETON
	private final static MotoTreeMap INSTANCIA = new MotoTreeMap();

	private MotoTreeMap() {
		agregar(new Moto("Kawasaki", "Ninja 650", "8900",
				"https://www.kawasaki.es/es/products/Supersport/2020/Ninja_650/overview?Uid=0860WlFfWlwMXFhdDlBYXF0NDApYXAtfXg5aCllZXQ5cClA"));
		agregar(new Moto("Yamaha", "YZF-R1", "10200",
				"https://www.yamaha-motor.eu/es/es/products/motocicletas/supersport/yzf-r1/"));
	}

	public static MotoTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Moto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moto obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregar(Moto moto) {
		// Comprobamos si la colección está vacía y en ese caso ponemos el id a 1
		// En caso contrario ponemos el id al último id + 1
		Long id = motos.size() == 0 ? 1L : motos.lastKey() + 1;
		moto.setId(id);
		motos.put(id, moto);
	}

	@Override
	public void modificar(Moto moto) {
		motos.put(moto.getId(), moto);

	}

	@Override
	public void borrar(Long id) {
		motos.remove(id);

	}

}
