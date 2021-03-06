package com.ipartek.formacion.hibernate_salon_de_masajes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")

public class Cliente {

	private static final String REGEX_NOMBRE = "[\\p{L} ]+";
	private static final String REGEX_APELLIDOS = "[\\p{L} ']+";
	private static final String REGEX_DNI = "[XYZ\\d]\\d{7}[A-Z]";

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idclientes;
	@Size(min = 1, max = 45, message = "El nombre tiene que tener entre 1 y 45 caracteres")
	@Column(length = 90)
	private String nombre;
	@Size(min = 1, max = 90, message = "Los apellidos tienen que tener entre 1 y 90 caracteres")
	@Column(length = 90)
	private String apellidos;
	@Size(min = 9, max = 9, message = "El DNI necesita 9 caracteres")
	@Column(length = 9)
	private String dni;

	private boolean correcto = true;
	private String errorId, errorNombre, errorApellidos, errorDni;

	public Cliente(Integer idclientes, String nombre, String apellidos, String dni) {
		setIdclientes(idclientes);
		setNombre(nombre);
		setApellidos(apellidos);
		setDni(dni);
	}

	/*
	 * public Cliente(String idclientes, String nombre, String apellidos, String
	 * dni) { setIdclientes(idclientes); setNombre(nombre); setApellidos(apellidos);
	 * setDni(dni); }
	 */

	public Cliente(String nombre, String apellidos, String dni) {
		this(null, nombre, apellidos, dni);
	}

	public Cliente(String nombre) {
		this(null, nombre, null, null);
	}

	public Cliente(Integer idclientes, String nombre) {
		this(idclientes, nombre, null, null);
	}

	public Cliente() {
	}

	public Integer getIdclientes() {
		return idclientes;
	}

	public void setIdclientes(Integer idclientes) {
		this.idclientes = idclientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 1 || nombre.trim().length() > 45) {
			setErrorNombre("El nombre tiene que tener entre 1 y 45 caracteres");
		}

		
		  if (nombre !=null && !nombre.matches(REGEX_NOMBRE)) {
		  setErrorNombre("Solo se admiten caracteres de letras y espacios"); }
		 
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (apellidos == null || apellidos.trim().length() < 1 || apellidos.trim().length() > 90) {
			setErrorApellidos("Los apellidos tienen que tener entre 1 y 90 caracteres");
		}

		
		  if (apellidos !=null && !apellidos.matches(REGEX_APELLIDOS)) {
		  setErrorApellidos("Solo se admiten caracteres de letras, espacios y apóstrofe"
		  ); }
		 

		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni == null || dni.trim().length() != 9) {
			setErrorDni("El dni tiene que estar formado por 9 caracteres");
		}

		
		  if (dni !=null && !dni.matches(REGEX_DNI)) { setErrorDni("Formato de DNI incorrecto"); }
		 

		this.dni = dni;
	}


	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		setCorrecto(false);
		this.errorId = errorId;
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
		result = prime * result + ((idclientes == null) ? 0 : idclientes.hashCode());
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
		Cliente other = (Cliente) obj;
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
		if (idclientes == null) {
			if (other.idclientes != null)
				return false;
		} else if (!idclientes.equals(other.idclientes))
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
		return "Cliente [idclientes=" + idclientes + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ "]";
	}

}
