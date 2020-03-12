package com.ipartek.formacion.MF0966_3Examen.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Integer id);
	
	T agregar(T objeto);

	T modificar(T objeto);

	void borrar(Integer id);
}
