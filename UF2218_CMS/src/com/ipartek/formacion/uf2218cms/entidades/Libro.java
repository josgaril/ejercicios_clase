package com.ipartek.formacion.uf2218cms.entidades;


public class Libro {
	
	private static final String REGEX_NOMBRE = "[\\p{L}\\d ]+";
	private Long id;
	private String nombre;
	private Double precio;
	private Integer descuento;
	
	private boolean valido = true;
	private String errorNombre, errorPrecio, errorDescuento;

	public Libro() {}

	public Libro(Long id, String nombre, Double precio, Integer descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}
	
	public Libro(String nombre, Double precio, Integer descuento) {
		this(null, nombre, precio, descuento);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() > 150 || nombre.trim().length() < 2) {
			setErrorNombre("El titulo del libro debe estar entre 2 y 150 caracteres");
		}
		
		if(!nombre.matches(REGEX_NOMBRE) ) {
			setErrorNombre("Sólo se admiten caracteres de letras, número y espacios");
		}
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		
		if(precio == null || precio <=0) {
			setErrorPrecio("El precio debe ser mayor que 0");
		}else {
			Double precioRound = this.round(precio, 2);
			this.precio =precioRound;
		}
		
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		if(descuento<101 && descuento>=0) {
			this.descuento = descuento;
		}else {
			setErrorDescuento("El descuento debe estar entre 0 y 100");
		}
		
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		setValido(false);
		this.errorNombre = errorNombre;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		setValido(false);
		this.errorPrecio = errorPrecio;
	}

	public String getErrorDescuento() {
		return errorDescuento;
	}

	public void setErrorDescuento(String errorDescuento) {
		setValido(false);
		this.errorDescuento = errorDescuento;
	}
	
	private double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + ((errorDescuento == null) ? 0 : errorDescuento.hashCode());
		result = prime * result + ((errorNombre == null) ? 0 : errorNombre.hashCode());
		result = prime * result + ((errorPrecio == null) ? 0 : errorPrecio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + (valido ? 1231 : 1237);
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
		Libro other = (Libro) obj;
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
			return false;
		if (errorDescuento == null) {
			if (other.errorDescuento != null)
				return false;
		} else if (!errorDescuento.equals(other.errorDescuento))
			return false;
		if (errorNombre == null) {
			if (other.errorNombre != null)
				return false;
		} else if (!errorNombre.equals(other.errorNombre))
			return false;
		if (errorPrecio == null) {
			if (other.errorPrecio != null)
				return false;
		} else if (!errorPrecio.equals(other.errorPrecio))
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
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (valido != other.valido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", valido=" + valido + ", errorNombre=" + errorNombre + ", errorPrecio=" + errorPrecio
				+ ", errorDescuento=" + errorDescuento + "]";
	}

	

}
