package mvc.repositorios;

import java.util.TreeMap;

import mvc.modelos.Tractor;

public class TractorTreeMap implements Dao<Tractor> {
	private TreeMap<Long, Tractor> tractors = new TreeMap<>();

	// SINGLETON
	private final static TractorTreeMap INSTANCIA = new TractorTreeMap();

	private TractorTreeMap() {
		agregar(new Tractor("John Deere", "7720", "22.550.000"
				+ "",
				"https://www.arpem.com/motos/modelos/honda/modelos-05/honda-trx-350-fe-fourtrax.html","JD7720"));
		agregar(new Tractor("Massey Fergusson", "8150", "17.665.256",
				"https://www.quadestonline.com/blog/2013/10/08/especial-raptor-660/","MF8150"));

		agregar(new Tractor("New Holland", "T7-190", "21.198.625",
				"https://alexquad.wordpress.com/2007/10/11/nuevo-suzuki-ltz-400-edicion-especial/","NHT7-190"));
	}

	public static TractorTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Tractor> obtenerTodos() {
		return tractors.values();
	}

	@Override
	public Tractor obtenerPorId(Long id) {
		return tractors.get(id);
	}

	@Override
	public void agregar(Tractor tractor) {
		// Comprobamos si la colección está vacía y en ese caso ponemos el id a 1
		// En caso contrario ponemos el id al último id + 1
		Long id = tractors.size() == 0 ? 1L : tractors.lastKey() + 1;
		tractor.setId(id);
		tractors.put(id, tractor);
	}

	@Override
	public void modificar(Tractor tractor) {
		tractors.put(tractor.getId(), tractor);

	}

	@Override
	public void borrar(Long id) {
		tractors.remove(id);

	}

}
