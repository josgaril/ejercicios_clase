package com.ipartek.formacion.MF0966_3Examen.modelos;

public class Resena {

	private Integer id;
	private String resena;
	private Curso curso;
	private Alumno alumno;

	public Resena(Integer id, String resena, Curso curso, Alumno alumno) {
		setId(id);
		setResena(resena);
		setCurso(curso);
		setAlumno(alumno);
	}

	public Resena(String resena, Curso curso, Alumno alumno) {
		this(null, resena, curso, alumno);
	}
	
	public Resena() {
		this(null,null,null,null);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resena == null) ? 0 : resena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resena other = (Resena) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (resena == null) {
			if (other.resena != null)
				return false;
		} else if (!resena.equals(other.resena))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resena [id=" + id + ", resena=" + resena + ", curso=" + curso + "]";
	}

}
