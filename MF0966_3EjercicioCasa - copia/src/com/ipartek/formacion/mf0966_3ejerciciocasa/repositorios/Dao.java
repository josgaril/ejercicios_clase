package com.ipartek.formacion.mf0966_3ejerciciocasa.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorCodigo(Integer codigo);

	T agregar(T objeto);

	T modificar(T objeto);

	void borrar(Integer codigo);

}
