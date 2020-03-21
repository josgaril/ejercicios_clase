package com.ipartek.formacion.mf0966_3ejerciciocasa.modelos;

public class Resena {

	private Integer codigo;
	private Alumno alumno;
	private Curso curso;
	private String comentario;

	public Resena(Integer codigo, Alumno alumno, Curso curso, String comentario) {
		setCodigo(codigo);
		setAlumno(alumno);
		setCurso(curso);
		setComentario(comentario);
	}

	public Resena(Alumno alumno, Curso curso, String comentario) {
		this(null, alumno, curso, comentario);
	}

	public Resena(Alumno alumno, String comentario) {
		this(alumno, null, comentario);
	}

	public Resena() {
		this(null, null, null, null);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
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
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resena [codigo=" + codigo + ", alumno=" + alumno + ", comentario=" + comentario + "]";
	}

}
