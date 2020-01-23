package mvc.modelos;

public class Libro {

	private static final String REGEX_NOMBRE = "[\\d\\p{L} .]+";

	private Long id;
	private String nombre;
	private Double precio;
	private Integer descuento;
	private String autor;
	private String imagen;

	private boolean correcto = true;
	private String errorNombre, errorPrecio, errorDescuento, errorAutor, errorImagen;

	public Libro(Long id, String nombre, Double precio, Integer descuento, String autor, String imagen) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
		setAutor(autor);
		setImagen(imagen);
	}

	public Libro(String nombre, Double precio, Integer descuento, String autor, String imagen) {
		this(null, nombre, precio, descuento, autor, imagen);
	}


	public Libro(Long id, String nombre, Double precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}

	public Libro() {

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
		if (nombre == null || nombre.trim().length() < 2 || nombre.trim().length() > 150) {
			setErrorNombre("Se necesitan como mínimo 2 letras y máximo 150");
		}
		if (!nombre.matches(REGEX_NOMBRE)) {
			setErrorNombre("Solo se admiten caracteres de letras, números y espacios");
		}
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		if (precio == null || precio <= 0) {
			setErrorPrecio("El número debe ser mayor que 0");
		}
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		if (descuento == null || descuento < 0 || descuento > 100) {
			setErrorDescuento("El descuento tiene que ser entre 0 y 100");
		}
		this.descuento = descuento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if ("".equals(autor)) {
			autor = "anónimo"; }
		 
		this.autor = autor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		if ("".equals(imagen)) {
			imagen = "https://image.freepik.com/vector-gratis/libro-abierto-blanco_1308-22968.jpg";
			}
		
		this.imagen = imagen;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		correcto = false;
		this.errorNombre = errorNombre;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		correcto = false;
		this.errorPrecio = errorPrecio;
	}

	public String getErrorDescuento() {
		return errorDescuento;
	}

	public void setErrorDescuento(String errorDescuento) {
		correcto = false;
		this.errorDescuento = errorDescuento;
	}

	public String getErrorAutor() {
		return errorAutor;
	}

	public void setErrorAutor(String errorAutor) {
		correcto = false;
		this.errorAutor = errorAutor;
	}

	/*
	 * public String getErrorImagen() { return errorImagen; }
	 * 
	 * public void setErrorImagen(String errorImagen) { correcto = false;
	 * this.errorImagen = errorImagen; }
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + (correcto ? 1231 : 1237);
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + ((errorAutor == null) ? 0 : errorAutor.hashCode());
		result = prime * result + ((errorDescuento == null) ? 0 : errorDescuento.hashCode());
		result = prime * result + ((errorImagen == null) ? 0 : errorImagen.hashCode());
		result = prime * result + ((errorNombre == null) ? 0 : errorNombre.hashCode());
		result = prime * result + ((errorPrecio == null) ? 0 : errorPrecio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (correcto != other.correcto)
			return false;
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
			return false;
		if (errorAutor == null) {
			if (other.errorAutor != null)
				return false;
		} else if (!errorAutor.equals(other.errorAutor))
			return false;
		if (errorDescuento == null) {
			if (other.errorDescuento != null)
				return false;
		} else if (!errorDescuento.equals(other.errorDescuento))
			return false;
		if (errorImagen == null) {
			if (other.errorImagen != null)
				return false;
		} else if (!errorImagen.equals(other.errorImagen))
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
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
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
		return true;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", imagen=" + imagen + ", correcto=" + correcto + ", errorNombre=" + errorNombre
				+ ", errorPrecio=" + errorPrecio + ", errorDescuento=" + errorDescuento + ", errorAutor=" + errorAutor
				+ ", errorImagen=" + errorImagen + "]";
	}

}
