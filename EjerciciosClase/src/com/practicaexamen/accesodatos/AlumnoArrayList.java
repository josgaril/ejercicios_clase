package com.practicaexamen.accesodatos;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.practicaexamen.entidades.AlumnoExamen;

public class AlumnoArrayList implements Dao<AlumnoExamen> {

	private ArrayList<AlumnoExamen> alumnos = new ArrayList<>();

	private static Long ultimoId = 0L;

	// Singleton
	private static final AlumnoArrayList INSTANCIA = new AlumnoArrayList();

	private AlumnoArrayList() {
		agregar(new AlumnoExamen(null, "Javier", "Lete García", "12345678Z",
				new GregorianCalendar(1980, 5 - 1, 5).getTime()));
		agregar(new AlumnoExamen(null, "Pepe", "Pérez García", "84908444B",
				new GregorianCalendar(1982, 1 - 1, 10).getTime()));
	}

	public static AlumnoArrayList getInstancia() {
		return INSTANCIA;
	}
	// Fin singleton

	@Override
	public Iterable<AlumnoExamen> obtenerTodos() {
		return alumnos;
	}

	public Integer obtenerIndicePorId(long id) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getId() == id) {
				return i;
			}
		}

		return null;
	}

	@Override
	public AlumnoExamen obtenerPorId(Long id) {
		Integer i = obtenerIndicePorId(id);

		if (i == null) {
			return null;
		}

		return alumnos.get(i);

	}

	@Override
	public AlumnoExamen agregar(AlumnoExamen alumno) {
		if (alumno == null) {
			throw new AccesoDatosException("No se aceptan alumnos nulos");
		}

		Long id = ++ultimoId;

		if (alumno.getId() == null) {
			alumno.setId(id);
		} else {
			throw new AccesoDatosException("No debes pasar un ID");
		}

		alumnos.add(alumno);

		return alumno;
	}

	@Override
	public AlumnoExamen modificar(AlumnoExamen alumno) {
		Integer i = obtenerIndicePorId(alumno.getId());

		if (i == null) {
			throw new AccesoDatosException("No se ha encontrado ese ID");
		}

		return alumnos.set((int) i, alumno);
	}

	@Override
	public void borrar(Long id) {
		Integer i = obtenerIndicePorId(id);

		if (i == null) {
			throw new AccesoDatosException("No se ha encontrado ese ID");
		}
		alumnos.remove((int) i);

	}

}
