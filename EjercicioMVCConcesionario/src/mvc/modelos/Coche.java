package mvc.modelos;

public class Coche {
	private Long id;
	private String marca;
	private String modelo;
	private String precio;
	private String url;
	
	private boolean correcto = true;
	private String errorMarca, errorModelo, errorPrecio, errorURL;

	public Coche(Long id, String marca, String modelo, String precio, String url) {
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setPrecio(precio);
		setUrl(url);
	}

	public Coche() {
		
	}
	
	public Coche( String marca, String modelo, String precio, String url) {
		this(null,marca,modelo,precio,url);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca == null || marca.trim().length() < 2) {
			setErrorMarca("Se necesitan como mínimo 2 caracteres");
		}
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo == null || modelo.trim().length() < 3) {
			setErrorModelo("Se necesitan como mínimo 3 caracteres");
		}
		this.modelo = modelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		if(precio == null || precio.trim().length() < 2) {
			setErrorPrecio("Se necesitan como mínimo 3 caracteres");
		}
		this.precio = precio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorMarca() {
		return errorMarca;
	}

	public void setErrorMarca(String errorMarca) {
		correcto = false;
		this.errorMarca = errorMarca;
	}

	public String getErrorModelo() {
		return errorModelo;
	}

	public void setErrorModelo(String errorModelo) {
		correcto = false;
		this.errorModelo = errorModelo;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		correcto = false;
		this.errorPrecio = errorPrecio;
	}

	public String getErrorURL() {
		return errorURL;
	}

	public void setErrorURL(String errorURL) {
		correcto = false;
		this.errorURL = errorURL;
	}

	@Override
	public String toString() {
		return "Moto [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", url=" + url
				+ ", correcto=" + correcto + ", errorMarca=" + errorMarca + ", errorModelo=" + errorModelo
				+ ", errorPrecio=" + errorPrecio + ", errorURL=" + errorURL + "]";
	}
	
	
}	