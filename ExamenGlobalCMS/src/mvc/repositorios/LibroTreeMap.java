package mvc.repositorios;

import java.util.TreeMap;

import mvc.modelos.Libro;

public class LibroTreeMap implements Dao<Libro> {
	private TreeMap<Long, Libro> libros = new TreeMap<>();

	// SINGLETON
	private final static LibroTreeMap INSTANCIA = new LibroTreeMap();

	private LibroTreeMap() {
		agregar(new Libro("Los Futbolisimos. El misterio del jugador número 13", 11.35, 5, "ROBERTO SANTIAGO", "https://imagenes.literaturasm.com/ecat_Imagenes/Original/181980_226121.jpg"));
		agregar(new Libro("Los Futbolisimos. El misterio del oberlisco mágico", 13.25, 10, "ROBERTO SANTIAGO", "https://imagessl6.casadellibro.com/a/l/t0/16/9788467594416.jpg"));
		agregar(new Libro("Los Futbolisimos. El misterio del día de los inocentes", 12.72, 20, "ROBERTO SANTIAGO", "https://www.diegomarin.com/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/9/7/9788467561357.jpg"));

	}

	public static LibroTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return libros.get(id);
	}

	@Override
	public void agregar(Libro libro) {
		// Si la colección está vacía ponemos el id a 1
		// Sino ponemos el id al último id + 1
		Long id = libros.size() == 0 ? 1L : libros.lastKey() + 1;
		libro.setId(id);
		libros.put(id, libro);
	}

	@Override
	public void modificar(Libro libro) {
		libros.put(libro.getId(), libro);
	}

	@Override
	public void borrar(Long id) {
		//TODO TENGO QUE CONTROLAR QUE EXISTA O NO EL LIBRO
		libros.remove(id);
	}
}
