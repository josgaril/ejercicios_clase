package com.ipartek.formacion.model.dao;

import java.sql.SQLException;

import com.ipartek.formacion.model.Persona;

public interface IPERSONADAO extends IDAO<Persona>{

	/**
	 * Contratar un curso paraa una persona
	 * @param idPersona Id de la persona que contrata el curso
	 * @param idCurso Id del curso que se contrata
	 * @return 
	 * @throws Exception Si no se encuentra el id de la persona o del curso
	 * @throws SQLException Si ya tiene contratado el curso
	 */
	boolean contratarCurso (int idPersona, int idCurso) throws Exception, SQLException;
	
	/**
	 * Eliminar curso contratado
	 * @param idPersona Id de la persona a la que se elimina el curso
	 * @param idCurso Id del curso que se elimina
	 * @return
	 * @throws Exception Si no se encuentra el id de la persona o del curso
	 */
	boolean eliminarCursoContratado (int idPersona, int idCurso) throws Exception;
}
