package mvc.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tractor {
	private Long id;
	private String marca;
	private String modelo;
	private String precio;
	private String url;
	private String imagen;
	private String fecha;
	
	private boolean correcto = true;
	private String errorMarca, errorModelo, errorPrecio, errorUrl, errorImagen,errorFecha;

	public Tractor(Long id, String marca, String modelo, String precio, String url,String imagen, String fecha) {
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setPrecio(precio);
		setUrl(url);
		setImagen(imagen);
		setFecha(fecha);
	}

	public Tractor() {
		
	}
	
	public Tractor( String marca, String modelo, String precio, String url,String imagen, String fecha) {
		this(null,marca,modelo,precio,url,imagen,fecha);
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
	     Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("yyyy-m-d hh:mm:ss");  
         fecha = dateFormat.format(date);  
		
		this.fecha = fecha;
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

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}
	
	
	public String getErrorImagen() {
		return errorImagen;
	}

	public void setErrorImagen(String errorImagen) {
		this.errorImagen = errorImagen;
	}

	public String getErrorFecha() {
		return errorFecha;
	}

	public void setErrorFecha(String errorFecha) {
		this.errorFecha = errorFecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correcto ? 1231 : 1237);
		result = prime * result + ((errorFecha == null) ? 0 : errorFecha.hashCode());
		result = prime * result + ((errorImagen == null) ? 0 : errorImagen.hashCode());
		result = prime * result + ((errorMarca == null) ? 0 : errorMarca.hashCode());
		result = prime * result + ((errorModelo == null) ? 0 : errorModelo.hashCode());
		result = prime * result + ((errorPrecio == null) ? 0 : errorPrecio.hashCode());
		result = prime * result + ((errorUrl == null) ? 0 : errorUrl.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Tractor other = (Tractor) obj;
		if (correcto != other.correcto)
			return false;
		if (errorFecha == null) {
			if (other.errorFecha != null)
				return false;
		} else if (!errorFecha.equals(other.errorFecha))
			return false;
		if (errorImagen == null) {
			if (other.errorImagen != null)
				return false;
		} else if (!errorImagen.equals(other.errorImagen))
			return false;
		if (errorMarca == null) {
			if (other.errorMarca != null)
				return false;
		} else if (!errorMarca.equals(other.errorMarca))
			return false;
		if (errorModelo == null) {
			if (other.errorModelo != null)
				return false;
		} else if (!errorModelo.equals(other.errorModelo))
			return false;
		if (errorPrecio == null) {
			if (other.errorPrecio != null)
				return false;
		} else if (!errorPrecio.equals(other.errorPrecio))
			return false;
		if (errorUrl == null) {
			if (other.errorUrl != null)
				return false;
		} else if (!errorUrl.equals(other.errorUrl))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
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
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tractor [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", url=" + url
				+ ", imagen=" + imagen + ", fecha=" + fecha + ", correcto=" + correcto + ", errorMarca=" + errorMarca
				+ ", errorModelo=" + errorModelo + ", errorPrecio=" + errorPrecio + ", errorUrl=" + errorUrl
				+ ", errorImagen=" + errorImagen + ", errorFecha=" + errorFecha + "]";
	}


	
	
}	