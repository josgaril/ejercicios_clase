package com.ipartek.formacion.mf0966_3ejerciciocasa.repositorios;

import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Resena;

public interface ResenaDao extends Dao<Resena>{
	Iterable<Resena> obtenerTodasPorCodigoCurso(Integer codigo);
}
