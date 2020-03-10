package com.ipartek.formacion.hibernate_salon_de_masajes;

public class Trabajador {

	private static final String REGEX_NOMBRE = "[\\p{L} ]+";
	private static final String REGEX_APELLIDOS = "[\\p{L} ']+";
	private static final String REGEX_DNI = "[XYZ\\d]\\d{7}[A-Z]";

	private Integer idtrabajadores;
	private String nombre;
	private String apellidos;
	private String dni;

	private boolean correcto = true;
	private String errorIdtrabajadores, errorNombre, errorApellidos, errorDni;

	public Trabajador(Integer idtrabajadores, String nombre, String apellidos, String dni) {
		setIdtrabajadores(idtrabajadores);
		setNombre(nombre);
		setApellidos(apellidos);
		setDni(dni);
	}

	public Trabajador(String nombre, String apellidos, String dni) {
		this(null, nombre, apellidos, dni);
	}

	public Trabajador() {
	}

	public Integer getIdtrabajadores() {
		return idtrabajadores;
	}

	public void setIdtrabajadores(Integer idtrabajadores) {
		this.idtrabajadores = idtrabajadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 1 || nombre.trim().length() > 45) {
			setErrorNombre("El nombre tiene que tener entre 1 y 45 caracteres");
		}

		if (nombre != null && !nombre.matches(REGEX_NOMBRE)) {
			setErrorNombre("Solo se admiten caracteres de letras y espacios");
		}

		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (apellidos == null || apellidos.trim().length() < 1 || apellidos.trim().length() > 90) {
			setErrorApellidos("Los apellidos tienen que tener entre 1 y 90 caracteres");
		}

		if (apellidos != null && !apellidos.matches(REGEX_APELLIDOS)) {
			setErrorApellidos("Solo se admiten caracteres de letras, espacios y apóstrofe");
		}

		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni == null || dni.trim().length() != 9) {
			setErrorDni("El DNI tiene que tener 9 caracteres");
		}

		
		  if (dni !=null && !dni.matches(REGEX_DNI)) {
		  setErrorDni("El formato de DNI no es correcto"); }
		 

		this.dni = dni;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorIdtrabajadores() {
		return errorIdtrabajadores;
	}

	public void setErrorIdtrabajadores(String errorIdtrabajadores) {
		setCorrecto(false);
		this.errorIdtrabajadores = errorIdtrabajadores;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		setCorrecto(false);
		this.errorNombre = errorNombre;
	}

	public String getErrorApellidos() {
		return errorApellidos;
	}

	public void setErrorApellidos(String errorApellidos) {
		setCorrecto(false);
		this.errorApellidos = errorApellidos;
	}

	public String getErrorDni() {
		return errorDni;
	}

	public void setErrorDni(String errorDni) {
		setCorrecto(false);
		this.errorDni = errorDni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((idtrabajadores == null) ? 0 : idtrabajadores.hashCode());
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
		Trabajador other = (Trabajador) obj;
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
		if (idtrabajadores == null) {
			if (other.idtrabajadores != null)
				return false;
		} else if (!idtrabajadores.equals(other.idtrabajadores))
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
		return "Trabajador [idtrabajadores=" + idtrabajadores + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dni=" + dni + "]";
	}

}