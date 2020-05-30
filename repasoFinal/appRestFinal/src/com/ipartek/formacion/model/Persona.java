package com.ipartek.formacion.model;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Persona {

	private int id;
	
	@Size(min=2, max=250, message = "El nombre debe tener entre 3 y 250 caracteres")
	private String nombre;
	
	@Size(min=2, max=250, message = "Los apellidos deben tener entre 3 y 250 caracteres")
	private String apellidos;
	
	@Size(min=9, max=9, message = "El dni debe terner 9 caracteres")
	private String dni;
	
	@NotNull
	private String avatar;
	
	@Pattern(regexp = "^[h|m]{1}$", message ="El sexo debe ser h(hombre) o m(mujer")
	private String sexo;
	
	private ArrayList<Curso> cursos;
	
	@NotNull
	private int rol;
	
	public Persona(int id, String nombre, String apellidos, String dni, String avatar, String sexo, int rol ) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.avatar = avatar;
		this.sexo = sexo;
		this.rol = rol;
	}
	
	public Persona() {
		super();
		this.id = 0;
		this.nombre = "Sin-Nombre";
		this.apellidos = "Sin-Apellidos";
		this.dni = "00000000O";
		this.avatar = "avatar7.png";
		this.sexo = "h";
		this.cursos = new ArrayList<Curso>();
		this.rol = 1;
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
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", avatar="
				+ avatar + ", sexo=" + sexo + ", rol=" + rol + "]";
	}
	
	
	

}
