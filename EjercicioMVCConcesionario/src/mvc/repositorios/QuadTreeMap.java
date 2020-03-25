package mvc.repositorios;

import java.util.TreeMap;

import mvc.modelos.Quad;

public class QuadTreeMap implements Dao<Quad> {
	private TreeMap<Long, Quad> quads = new TreeMap<>();

	// SINGLETON
	private final static QuadTreeMap INSTANCIA = new QuadTreeMap();

	private QuadTreeMap() {
		agregar(new Quad("Honda", "TRX 350", "8.400",
				"https://www.arpem.com/motos/modelos/honda/modelos-05/honda-trx-350-fe-fourtrax.html"));
		agregar(new Quad("Yamaha", "Raptor 660", "8999",
				"https://www.quadestonline.com/blog/2013/10/08/especial-raptor-660/"));

		agregar(new Quad("Suzuki", "LTZ 400", "8.580",
				"https://alexquad.wordpress.com/2007/10/11/nuevo-suzuki-ltz-400-edicion-especial/"));
	}

	public static QuadTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Quad> obtenerTodos() {
		return quads.values();
	}

	@Override
	public Quad obtenerPorId(Long id) {
		return quads.get(id);
	}

	@Override
	public void agregar(Quad quad) {
		// Comprobamos si la colección está vacía y en ese caso ponemos el id a 1
		// En caso contrario ponemos el id al último id + 1
		Long id = quads.size() == 0 ? 1L : quads.lastKey() + 1;
		quad.setId(id);
		quads.put(id, quad);
	}

	@Override
	public void modificar(Quad quad) {
		quads.put(quad.getId(), quad);

	}

	@Override
	public void borrar(Long id) {
		quads.remove(id);

	}

}
