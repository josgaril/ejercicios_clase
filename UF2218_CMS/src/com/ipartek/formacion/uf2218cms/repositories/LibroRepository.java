package com.ipartek.formacion.uf2218cms.repositories;

import java.util.TreeMap;

import com.ipartek.formacion.uf2218cms.entidades.Libro;


public class LibroRepository implements Dao<Libro> {
	private TreeMap<Long, Libro> libros = new TreeMap<>();

	// SINGLETON
	private final static LibroRepository INSTANCIA = new LibroRepository();

	private LibroRepository() {}

	public static LibroRepository getInstancia() {
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
		Long id = libros.size() == 0 ? 1L :  libros.lastKey()+1;
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
