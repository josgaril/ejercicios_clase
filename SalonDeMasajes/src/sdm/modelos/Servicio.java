package sdm.modelos;

import java.math.BigDecimal;

public class Servicio {

	private Integer idservicios;
	private String nombre;
	private BigDecimal precio;

	private boolean correcto=true;
	private String errorId, errorNombre, errorPrecio;

	public Servicio(String idservicios, String nombre, String precio) {
		setIdservicios(idservicios);
		setNombre(nombre);
		setPrecio(precio);
	}

	public Servicio(Integer idservicios, String nombre, BigDecimal precio) {
		setIdservicios(idservicios);
		setNombre(nombre);
		setPrecio(precio);
	}

	public Servicio(String nombre, BigDecimal precio) {
		this(null, nombre, precio);
	}

	public Servicio() {
	}

	public Integer getIdservicios() {
		return idservicios;
	}

	public void setIdservicios(Integer idservicios) {
		this.idservicios = idservicios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 1 || nombre.trim().length() > 45) {
			setErrorNombre("El nombre tiene que tener entre 1 y 45 catacteres");
		}
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if (precio.compareTo(BigDecimal.ZERO) <= 0) {
			setErrorPrecio("El precio debe ser mayor que cero");
		}
		this.precio = precio;
	}

	private void setIdservicios(String idservicios) {
		if (idservicios == null || idservicios.trim().length() == 0) {
			this.idservicios = null;
			return;
		}

		try {
			this.idservicios = Integer.parseInt(idservicios);
		} catch (NumberFormatException e) {
			setErrorId("No era un número");
		}
	}

	private void setPrecio(String precio) {
		if (precio == null) {
			setErrorPrecio("El precio es obligatorio");
			this.precio = null;
			return;
		}

		try {
			setPrecio(new BigDecimal(precio.replace(",", ".")));

			if (!precio.matches("\\d+[,\\.]\\d{3}")) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			setErrorPrecio("El precio debe tener tres decimales y al menos un entero y debe ser positivo");
		}
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

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		setCorrecto(false);
		this.errorPrecio = errorPrecio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idservicios == null) ? 0 : idservicios.hashCode());
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
		Servicio other = (Servicio) obj;
		if (idservicios == null) {
			if (other.idservicios != null)
				return false;
		} else if (!idservicios.equals(other.idservicios))
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
		return "Servicios [id=" + idservicios + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
