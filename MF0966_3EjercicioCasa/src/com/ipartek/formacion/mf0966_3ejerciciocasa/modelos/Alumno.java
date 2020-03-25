package com.ipartek.formacion.mf0966_3ejerciciocasa.modelos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Alumno {

	private Integer codigo;
	private String nombre;
	private String apellidos;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Madrid")
	private Date fNacimiento;
	private String direccion;
	private String poblacion;
	private Integer codigopostal;
	private Integer telefono;
	private String email;
	private String dni;
	private Integer nHermanos;
	private Boolean activo = true;

	public Alumno(Integer codigo, String nombre, String apellidos, Date fNacimiento, String direccion, String poblacion,
			Integer codigopostal, Integer telefono, String email, String dni, Integer nHermanos, Boolean activo) {
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setfNacimiento(fNacimiento);
		setDireccion(direccion);
		setPoblacion(poblacion);
		setCodigopostal(codigopostal);
		setTelefono(telefono);
		setEmail(email);
		setDni(dni);
		setnHermanos(nHermanos);
		setActivo(activo);
	}

	public Alumno(String nombre, String apellidos, Date fNacimiento, String direccion, String poblacion,
			Integer codigopostal, Integer telefono, String email, String dni, Integer nHermanos, Boolean activo) {
		this(null, nombre, apellidos, fNacimiento, direccion, poblacion, codigopostal, telefono, email, dni, nHermanos,
				activo);
	}

	/*
	 * public Alumno() { this(codigo, nombre, apellidos, null, null, null, null,
	 * telefono, email, dni, null, null); }
	 */

	public Alumno(String nombre, String apellidos) {
		this(null, nombre, apellidos, null, null, null, null, null, null, null, null, null);
	}

	public Alumno() {
		this(null, null, null, null, null, null, null, null, null, null, null, null);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public Integer getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(Integer codigopostal) {
		this.codigopostal = codigopostal;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getnHermanos() {
		return nHermanos;
	}

	public void setnHermanos(Integer nHermanos) {
		this.nHermanos = nHermanos;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((codigopostal == null) ? 0 : codigopostal.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fNacimiento == null) ? 0 : fNacimiento.hashCode());
		result = prime * result + ((nHermanos == null) ? 0 : nHermanos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Alumno other = (Alumno) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigopostal == null) {
			if (other.codigopostal != null)
				return false;
		} else if (!codigopostal.equals(other.codigopostal))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fNacimiento == null) {
			if (other.fNacimiento != null)
				return false;
		} else if (!fNacimiento.equals(other.fNacimiento))
			return false;
		if (nHermanos == null) {
			if (other.nHermanos != null)
				return false;
		} else if (!nHermanos.equals(other.nHermanos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNacimiento="
				+ fNacimiento + ", direccion=" + direccion + ", poblacion=" + poblacion + ", codigopostal="
				+ codigopostal + ", telefono=" + telefono + ", email=" + email + ", dni=" + dni + ", nHermanos="
				+ nHermanos + ", activo=" + activo + "]";
	}

}
