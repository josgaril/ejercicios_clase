package com.practicaexamen.accesodatos;

public interface Dao <T>{
	public Iterable<T> obtenertodos();
	public T obtenerPorId(long id);
	public T agregar(T t);
	public T modificar (T t);
	public void borrar (Long Id);


}
