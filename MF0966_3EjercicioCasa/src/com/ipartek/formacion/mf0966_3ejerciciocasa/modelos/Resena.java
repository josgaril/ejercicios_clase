package com.ipartek.formacion.mf0966_3ejerciciocasa.modelos;

public class Resena {

	private Integer codigo;
	private Alumno alumno;
	private Curso curso;
	private String comentario;

	private boolean correcto = true;
	private String errorCodigo, errorAlumno, errorCurso, errorComentario;

	public Resena(Integer codigo, Alumno alumno, Curso curso, String comentario) {
		setCodigo(codigo);
		setAlumno(alumno);
		setCurso(curso);
		setComentario(comentario);
	}

	// Constructor String
	public Resena(String codigo, String alumno, String curso, String comentario) {
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

	// Constructor vacío
	public Resena() {
		// TODO Prueba a dejarlo vacio en vez de: this(null, null, null, null);
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

	private void setCodigo(String codigo) {
		if (codigo == null || codigo.trim().length() == 0) {
			this.codigo = null;
			return;
		}

		try {
			this.codigo = Integer.parseInt(codigo);
		} catch (NumberFormatException e) {
			setErrorCodigo("No era un número");
		}
	}

	private void setAlumno(String alumno) {
		if (alumno == null || alumno.trim().length() == 0) {
			setErrorAlumno("Debes elegir un alumno");
		} else {
			try {
				setAlumno(new Alumno(Integer.parseInt(alumno)));
			} catch (NumberFormatException e) {
				setErrorAlumno("El codigo del tabajador debe ser numérico");
			}
		}
	}

	private void setCurso(String curso) {
		if (curso == null || curso.trim().length() == 0) {
			setErrorCurso("Debes elegir un curso");
		} else {
			try {
				setCurso(new Curso(Integer.parseInt(curso)));
			} catch (NumberFormatException e) {
				setErrorCurso("El codigo del curso debe ser numérico");
			}
		}
	}

	public void setComentario(String comentario) {
		if (comentario == null || comentario.trim().length() < 1 || comentario.trim().length() > 1000) {
			setErrorComentario("El comentario debe tener como máximo 1000 caracteres");
		}
		this.comentario = comentario;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorCodigo() {
		return errorCodigo;
	}

	public void setErrorCodigo(String errorCodigo) {
		setCorrecto(false);
		this.errorCodigo = errorCodigo;
	}

	public String getErrorAlumno() {
		return errorAlumno;
	}

	public void setErrorAlumno(String errorAlumno) {
		setCorrecto(false);
		this.errorAlumno = errorAlumno;
	}

	public String getErrorCurso() {
		return errorCurso;
	}

	public void setErrorCurso(String errorCurso) {
		setCorrecto(false);
		this.errorCurso = errorCurso;
	}

	public String getErrorComentario() {
		return errorComentario;
	}

	public void setErrorComentario(String errorComentario) {
		setCorrecto(false);
		this.errorComentario = errorComentario;
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
