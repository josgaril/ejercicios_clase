package com.ipartek.formacion.MF0966_3Examen.modelos;

import java.util.Date;

public class Alumno1 extends Persona1 {

	private String apellidos;
	private Date fNacimiento;
	private String dni;
	private int nHermanos;
	private boolean activo = true;

	public Alumno1(Integer codigo, String nombre, String apellidos, Date fNacimiento, String direccion, String poblacion,
			int codigopostal, int telefono, String email, String dni, int nHermanos, boolean activo) {
		super(codigo, nombre, direccion, poblacion, codigopostal, email, telefono);
		setApellidos(apellidos);
		setfNacimiento(fNacimiento);
		setDni(dni);
		setnHermanos(nHermanos);
		setActivo(activo);
	}

	public Alumno1(Persona1 p, String apellidos, Date fNacimiento, String dni, int nHermanos, boolean activo) {
		this(null, p.getNombre(), apellidos, fNacimiento, p.getDireccion(), p.getPoblacion(), p.getCodigopostal(),
				p.getTelefono(), p.getEmail(), dni, nHermanos, activo);
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getnHermanos() {
		return nHermanos;
	}

	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (activo ? 1231 : 1237);
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fNacimiento == null) ? 0 : fNacimiento.hashCode());
		result = prime * result + nHermanos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno1 other = (Alumno1) obj;
		if (activo != other.activo)
			return false;
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
		if (fNacimiento == null) {
			if (other.fNacimiento != null)
				return false;
		} else if (!fNacimiento.equals(other.fNacimiento))
			return false;
		if (nHermanos != other.nHermanos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [apellidos=" + apellidos + ", fNacimiento=" + fNacimiento + ", dni=" + dni + ", nHermanos="
				+ nHermanos + ", activo=" + activo + ", toString() = " + super.toString() + "]";
	}

}
