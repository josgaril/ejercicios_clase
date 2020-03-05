package com.ipartek.formacion.sdm.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Integer id);

	void agregar(T objeto);

	void modificar(T objeto);

	void borrar(Integer id);
}
