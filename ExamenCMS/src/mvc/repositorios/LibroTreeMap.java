package mvc.repositorios;

import java.util.TreeMap;

import mvc.modelos.Libro;

public class LibroTreeMap implements Dao<Libro> {
	private TreeMap<Long, Libro> libros = new TreeMap<>();
	private final static LibroTreeMap INSTANCIA = new LibroTreeMap();

	// SINGLETON
	
	/* 
	 * private LibroTreeMap() { agregar(new Libro("La cueva", 12.00, 50));
	 * agregar(new Libro("La montaña", 15.25, 20)); agregar(new
	 * Libro("El silencio de los corderos", 10.52, 32)); }
	 */

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
		libros.remove(id);
	}
}
