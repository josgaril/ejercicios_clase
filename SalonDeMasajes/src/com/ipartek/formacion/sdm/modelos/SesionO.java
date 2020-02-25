package com.ipartek.formacion.sdm.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SesionO {

	private Integer id;
	private Cliente clienteO;
	private Trabajador trabajadorO;
	private Servicio servicioO;
	private Date fecha;
	private String resena;
	private String calificacion;

	private boolean correcto = true;
	private String errorId, errorClienteO, errorTrabajadorO, errorServicioO, errorFecha, errorResena, errorCalificacion;

	// CONSTRUCTORES
	public SesionO(Integer id, Cliente clienteO, Trabajador trabajadorO, Servicio servicioO, Date fecha, String resena,
			String calificacion) {
		setId(id);
		setClienteO(clienteO);
		setTrabajadorO(trabajadorO);
		setServicioO(servicioO);
		setFecha(fecha);
		setResena(resena);
		setCalificacion(calificacion);
	}

	// Constructor de String
	public SesionO(String id, String clienteO, String trabajadorO, String servicioO, String fecha, String resena,
			String calificacion) {
		setId(id);
		setClienteO(clienteO);
		setTrabajadorO(trabajadorO);
		setServicioO(servicioO);
		setFecha(fecha);
		setResena(resena);
		setCalificacion(calificacion);
	}

	public SesionO() {
	}

	public SesionO(Integer id, Cliente clienteO, Trabajador trabajadorO, Servicio servicioO, Date fecha) {
		this(id, clienteO, trabajadorO, servicioO, fecha, null, null);
	}
	// FIN CONSTRUCTORES

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getClienteO() {
		return clienteO;
	}

	public void setClienteO(Cliente clienteO) {
		this.clienteO = clienteO;
	}

	public Trabajador getTrabajadorO() {
		return trabajadorO;
	}

	public void setTrabajadorO(Trabajador trabajadorO) {
		this.trabajadorO = trabajadorO;
	}

	public Servicio getServicioO() {
		return servicioO;
	}

	public void setServicioO(Servicio servicioO) {
		this.servicioO = servicioO;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		if (fecha != null && fecha.after(new Date())) {
			setErrorFecha("No puedes usar una fecha futura para la fecha de la sesión");
		}
		this.fecha = fecha;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		if (resena.trim().length() > 1000) {
			setErrorResena("La reseña debe tener como máximo 1000 caracteres");
		}
		this.resena = resena;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		if (calificacion == null) {
			setErrorCalificacion("Calificación incorrecta");
		} else {
			switch (calificacion) {
			case "":
			case "No recomendable":
			case "Aceptable":
			case "Para repetir":
				break;
			default:
				setErrorCalificacion("Calificación incorrecta");
			}
		}

		this.calificacion = calificacion;

	}

	private void setId(String id) {
		if (id == null || id.trim().length() == 0) {
			this.id = null;
			return;
		}

		try {
			this.id = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			setErrorId("No era un número");
		}
	}

	private void setClienteO(String clienteO) {
		if (clienteO == null || clienteO.trim().length() == 0) {
			setErrorClienteO("Debes seleccionar un cliente");
		} else {
			try {
				setClienteO(new Cliente(Integer.parseInt(clienteO), null, null, null));
			} catch (NumberFormatException e) {
				setErrorClienteO("El id del cliente debe ser numérico");
			}
		}
	}

	private void setTrabajadorO(String trabajadorO) {
		if (trabajadorO == null || trabajadorO.trim().length() == 0) {
			setErrorTrabajadorO("Debes seleccionar un trabajador");
		} else {
			try {
				setTrabajadorO(new Trabajador(Integer.parseInt(trabajadorO), null, null, null));
			} catch (NumberFormatException e) {
				setErrorTrabajadorO("El id del trabajador debe ser numérico");
			}
		}

	}

	private void setServicioO(String servicioO) {
		if (servicioO == null || servicioO.trim().length() == 0) {
			setErrorServicioO("Debes elegir un servicio");
		} else
			try {
				setServicioO(new Servicio(Integer.parseInt(servicioO), null, null));
			} catch (NumberFormatException e) {
				setErrorServicioO("El id del servicio debe ser numérico");
			}
	}

	private void setFecha(String fecha) {
		try {
			setFecha(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(fecha));
		} catch (ParseException e) {
			setErrorFecha("El formato de la fecha es incorrecto");
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

	public String getErrorClienteO() {
		return errorClienteO;
	}

	public void setErrorClienteO(String errorClienteO) {
		setCorrecto(false);
		this.errorClienteO = errorClienteO;
	}

	public String getErrorTrabajadorO() {
		return errorTrabajadorO;
	}

	public void setErrorTrabajadorO(String errorTrabajadorO) {
		setCorrecto(false);
		this.errorTrabajadorO = errorTrabajadorO;
	}

	public String getErrorServicioO() {
		return errorServicioO;
	}

	public void setErrorServicioO(String errorServicioO) {
		setCorrecto(false);
		this.errorServicioO = errorServicioO;
	}

	public String getErrorFecha() {
		return errorFecha;
	}

	public void setErrorFecha(String errorFecha) {
		setCorrecto(false);
		this.errorFecha = errorFecha;
	}

	public String getErrorResena() {
		return errorResena;
	}

	public void setErrorResena(String errorResena) {
		setCorrecto(false);
		this.errorResena = errorResena;
	}

	public String getErrorCalificacion() {
		return errorCalificacion;
	}

	public void setErrorCalificacion(String errorCalificacion) {
		setCorrecto(false);
		this.errorCalificacion = errorCalificacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calificacion == null) ? 0 : calificacion.hashCode());
		result = prime * result + ((clienteO == null) ? 0 : clienteO.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resena == null) ? 0 : resena.hashCode());
		result = prime * result + ((servicioO == null) ? 0 : servicioO.hashCode());
		result = prime * result + ((trabajadorO == null) ? 0 : trabajadorO.hashCode());
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
		SesionO other = (SesionO) obj;
		if (calificacion == null) {
			if (other.calificacion != null)
				return false;
		} else if (!calificacion.equals(other.calificacion))
			return false;
		if (clienteO == null) {
			if (other.clienteO != null)
				return false;
		} else if (!clienteO.equals(other.clienteO))
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
		if (resena == null) {
			if (other.resena != null)
				return false;
		} else if (!resena.equals(other.resena))
			return false;
		if (servicioO == null) {
			if (other.servicioO != null)
				return false;
		} else if (!servicioO.equals(other.servicioO))
			return false;
		if (trabajadorO == null) {
			if (other.trabajadorO != null)
				return false;
		} else if (!trabajadorO.equals(other.trabajadorO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SesionO [id=" + id + ", clienteO=" + clienteO + ", trabajadorO=" + trabajadorO + ", servicioO="
				+ servicioO + ", fecha=" + fecha + ", resena=" + resena + ", calificacion=" + calificacion + "]";
	}

}
