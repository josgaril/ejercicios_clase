package libreria.accesoDatos;

import java.util.ArrayList;

import libreria.entidades.Libro;

public class LibrosArrayList implements Dao<Libro> {

	private ArrayList<Libro> libros = new ArrayList<>();
	private static Long ultimoId = 0L;

	// Creamos Singleton
	private static final LibrosArrayList INSTANCIA = new LibrosArrayList();

	// Indicamos estos valores para poder hacer pruebas y ver que todo funciona bien
	// desde el principio
	private LibrosArrayList() {
		agregar(new Libro(null, "PruebaLibroUno", "1234567890", 100, "Digital"));
		agregar(new Libro(null, "Prueba Libro Dos", "0123456789", 65, "Papel"));
	}

	public static LibrosArrayList getInstancia() {
		return INSTANCIA;
	}

	// FIn Singleton

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros;
	}

	private Integer obtenerIndicePorId(Long id) {
		// Creamos este método manualmente para obtener el índice con el id introducido
		// por el usuario.
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	@Override
	public Libro obtenerPorId(Long id) {
		Integer i = obtenerIndicePorId(id);

		if (i == null) {
			return null;
		}

		return libros.get(i);

	}

	@Override
	public Libro agregar(Libro libro) {
		if (libro == null) {
			throw new AccesoDatosException("No se aceptan libros nulos");
		}

		Long id = ++ultimoId;

		if (libro.getId() == null) {
			libro.setId(id);
		} else {
			throw new AccesoDatosException("No debes pasar un ID");
		}

		libros.add(libro);

		return libro;
	}

	@Override
	public Libro modificar(Libro libro) {
		Integer i = obtenerIndicePorId(libro.getId());

		if (i == null) {
			throw new AccesoDatosException("No se ha encontrado un libro con ese ID ");
		}

		return libros.set((int) i, libro);
	}

	@Override
	public void borrar(Long id) {
		Integer i = obtenerIndicePorId(id);

		if (i == null) {
			throw new AccesoDatosException("No se ha encontrado un libro con ese ID");
		}

		libros.remove((int) i);

	}

}
