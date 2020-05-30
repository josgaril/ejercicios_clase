package com.ipartek.formacion.model;

import javax.validation.constraints.Size;

public class Rol {

	private int id;
	
	@Size(min=3, max=200, message="El nombre del rol debe tener entre 3 y 200 caracteres")
	private String nombre;

	public Rol(int id,String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Rol() {
	
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}

	
	
}
