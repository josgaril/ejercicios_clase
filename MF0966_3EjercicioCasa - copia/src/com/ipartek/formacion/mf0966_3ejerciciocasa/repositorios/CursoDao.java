package com.ipartek.formacion.mf0966_3ejerciciocasa.repositorios;

import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Curso;

public interface CursoDao extends Dao<Curso>{
	Iterable<Curso> obtenerTodosRealizados();
}
