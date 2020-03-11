package com.ipartek.formacion.uff2215Examen.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Integer id);
	
	T obtenerPorTitulo(String titulo);

	T agregar(T objeto);

	T modificar(T objeto);

	void borrar(Integer id);
}
