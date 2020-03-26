package com.ipartek.formacion.mf0966_3ejerciciocasa.modelos;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Curso {

	private Integer codigo;
	private String nombre;
	private String identificador;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Europe/Madrid")
	private Date fInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Europe/Madrid")
	private Date fFin;
	private Integer nHoras;
	private String temario;
	private Boolean activo;
	private Cliente cliente;
	private BigDecimal precio;
	private Profesor profesor;

	public Curso(Integer codigo, String nombre, String identificador, Date fInicio, Date fFin, Integer nHoras,
			String temario, Boolean activo, Cliente cliente, BigDecimal precio, Profesor profesor) {
		setCodigo(codigo);
		setNombre(nombre);
		setIdentificador(identificador);
		setfInicio(fInicio);
		setfFin(fFin);
		setnHoras(nHoras);
		setTemario(temario);
		setActivo(activo);
		setCliente(cliente);
		setPrecio(precio);
		setProfesor(profesor);
	}

	public Curso(String nombre, String identificador, Date fInicio, Date fFin, Integer nHoras, String temario,
			Boolean activo, Cliente cliente, BigDecimal precio, Profesor profesor) {
		this(null, nombre, identificador, fInicio, fFin, nHoras, temario, activo, cliente, precio, profesor);
	}

	public Curso(Integer codigo,String nombre, String identificador, Integer nHoras, Profesor profesor) {
		this(codigo, nombre, identificador,null,null, nHoras,null,null,null,null, profesor);
	}
	
	//constructor para obtener solo el codigo del curso
	public Curso(Integer codigo) {
		this(codigo, null, null,null,null, null,null,null,null,null, null);
	}
	
	//Constructor vacío
	public Curso() {
		//TODO Prueba, dejado consructor vacio en vez de: this(null, null, null, null, null, null, null, null, null, null, null);
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public Integer getnHoras() {
		return nHoras;
	}

	public void setnHoras(Integer nHoras) {
		this.nHoras = nHoras;
	}

	public String getTemario() {
		return temario;
	}

	public void setTemario(String temario) {
		this.temario = temario;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fFin == null) ? 0 : fFin.hashCode());
		result = prime * result + ((fInicio == null) ? 0 : fInicio.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((nHoras == null) ? 0 : nHoras.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((temario == null) ? 0 : temario.hashCode());
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
		Curso other = (Curso) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fFin == null) {
			if (other.fFin != null)
				return false;
		} else if (!fFin.equals(other.fFin))
			return false;
		if (fInicio == null) {
			if (other.fInicio != null)
				return false;
		} else if (!fInicio.equals(other.fInicio))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (nHoras == null) {
			if (other.nHoras != null)
				return false;
		} else if (!nHoras.equals(other.nHoras))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (temario == null) {
			if (other.temario != null)
				return false;
		} else if (!temario.equals(other.temario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", identificador=" + identificador + ", fInicio="
				+ fInicio + ", fFin=" + fFin + ", nHoras=" + nHoras + ", temario=" + temario + ", activo=" + activo
				+ ", cliente=" + cliente + ", precio=" + precio + ", profesor=" + profesor + "]";
	}

}
