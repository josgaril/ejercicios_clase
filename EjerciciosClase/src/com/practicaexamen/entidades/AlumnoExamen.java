package com.practicaexamen.entidades;

import java.util.Date;

import com.practicaexamen.utilidades.Biblioteca;

public class AlumnoExamen {

	private static final String REGEX_NOMBRE = "[\\p{L} ]+ ";
	private static final String REGEX_APELLIDOS = "[\\p{L} ']+";
	private static final String REGEX_DNI = "[XYZ\\d]\\d{7}[A-Z]";

	private Long id;
	private String nombre;
	private String apellidos;
	private String dni;
	private Date fechaNacimiento;

	public AlumnoExamen(Long id, String nombre, String apellidos, String dni, Date fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setDni(dni);
		setFechaNacimiento(fechaNacimiento);
	}

	public AlumnoExamen() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id < 0) {
			throw new EntidadesException("No se admiten id's negativos");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * solo se admiten nombres
	 * 
	 * @param nombre el nombre que se quiere guardar
	 * @throws EntidadesException Si el nombre no son letras o espacios
	 */
	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() == 0) {
			throw new EntidadesException("No se admiten valores nulos para el nombre");
		}
		if (!nombre.matches(REGEX_NOMBRE)) {
			throw new EntidadesException("Solo se admiten caracteres de letras y espacios");
		}
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (apellidos == null || apellidos.trim().length() == 0) {
			this.apellidos = null;
		}
		if (!apellidos.matches(REGEX_APELLIDOS)) {
			throw new EntidadesException("Solo se admiten caracteres de letras, espacios y/o apostrofes");
		}
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (!dni.matches(REGEX_DNI)) {
			throw new EntidadesException("Formato de dni mal introducido");
		}
		if (!Biblioteca.dniEsValido(dni)) {
			throw new EntidadesException("El dni introducido no es valido");
		}
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		if (fechaNacimiento != null && fechaNacimiento.after(new Date())) {
			throw new EntidadesException("No puedes ser una fecha posterior a la actual");
		}
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		AlumnoExamen other = (AlumnoExamen) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlumnoExamen [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
