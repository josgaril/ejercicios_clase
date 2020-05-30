package com.ipartek.formacion.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<P> {

	/**
	 * Obtener todos los pojos
	 * @return Devuelve todos los pojos
	 */
	List<P> getAll();
	
	/**
	 * Busca un pojo por su id
	 * @param id Se pasa el id del pojo como parámetro
	 * @return Devuelve el pojo
	 * @throws Exception si no encuentra pojo
	 */
	P getById(int id) throws Exception;

	/**
	 * Crea un nuevo Pojo 
	 * @param pojo Se pasa como parámetro el Pojo
	 * @return Devuelve el Pojo con el id actualizado
	 * @throws Exception Si no cumple las validaciones
	 * @throws SQLException Si existe alguna constraint, por ejemplo UNIQUE_INDEX
	 */
	P insert (P pojo) throws Exception, SQLException;
	
	/**
	 * Modifica un Pojo
	 * @param pojo Se pasa como parámetro el pojo
	 * @return Devuelve el Pojo modificado
	 * @throws Exception Si no cumple las validaciones o no encuentra el pojo
	 * @throws SQLException Si existe alguna constraint
	 */
	P update (P pojo) throws Exception, SQLException;

	/**
	 * Elimina un pojo
	 * @param id Se pasa el id del pojo como parámetro
	 * @return Devuelve el pojo eliminado
	 * @throws Exception Si no encuentra el pojo
	 */
	P delete (int id) throws Exception;
	
}
