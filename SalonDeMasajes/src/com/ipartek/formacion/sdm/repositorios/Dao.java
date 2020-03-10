package com.ipartek.formacion.sdm.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Integer id);

	Integer agregar(T objeto); //Integer para que devuelva el id generado

	T modificar(T objeto);

	void borrar(Integer id);
}
