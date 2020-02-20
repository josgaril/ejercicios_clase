package com.ipartek.formacion.sdm.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SesionBuena {

	private Integer id;
	private Integer clientes_idclientes;
	private Integer trabajadores_idtrabajadores;
	private Integer servicios_idservicios;
	private Date fecha;
	private String resena;
	private String calificacion;

	private boolean correcto = true;
	private String errorId, errorClientes_idclientes, errorTrabajadores_idtrabajadores, errorServicios_idservicios,
			errorFecha, errorResena, errorCalificacion;

	public SesionBuena(Integer id, Integer clientes_idclientes, Integer trabajadores_idtrabajadores,
			Integer servicios_idservicios, Date fecha, String resena, String calificacion) {
		setId(id);
		setClientes_idclientes(clientes_idclientes);
		setTrabajadores_idtrabajadores(trabajadores_idtrabajadores);
		setServicios_idservicios(servicios_idservicios);
		setFecha(fecha);
		setResena(resena);
		setCalificacion(calificacion);
	}

	// Constructor de tipos String
	public SesionBuena(String id, String clientes_idclientes, String trabajadores_idtrabajadores,
			String servicios_idservicios, String fecha, String resena, String calificacion) {
		setId(id);
		setClientes_idclientes(clientes_idclientes);
		setTrabajadores_idtrabajadores(trabajadores_idtrabajadores);
		setServicios_idservicios(servicios_idservicios);
		setFecha(fecha);
		setResena(resena);
		setCalificacion(calificacion);
	}

	

	// esto ES PRUEBA
	/*
	 * public Sesion() { clientes_idclientes = new Cliente();
	 * trabajadores_idtrabajadores = new Trabajador(); servicios_idservicios= new
	 * Servicio(); }
	 * 
	 * private String datosSesiones() { int idcliente =
	 * clientes_idclientes.getIdclientes(); int idtrabajador =
	 * trabajadores_idtrabajadores.getIdtrabajadores(); int idservicio =
	 * servicios_idservicios.getIdservicios(); String datosSesiones= "idcliente" +
	 * idcliente + ", idtrabajador " + idtrabajador + ", idservicio" + idservicio;
	 * return datosSesiones; }
	 */

	// hacer en el set cliente un new cliente;.....
	// fin prueba

	public SesionBuena(Integer clientes_idclientes, Integer trabajadores_idtrabajadores, Integer servicios_idservicios,
			Date fecha) {
		this(null, clientes_idclientes, trabajadores_idtrabajadores, servicios_idservicios, fecha, null, null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientes_idclientes() {
		return clientes_idclientes;
		/*
		 * Cliente clientes_idclientes = new Cliente(); return
		 * clientes_idclientes.getIdclientes();
		 */
	}

	public void setClientes_idclientes(Integer clientes_idclientes) {
		if (clientes_idclientes == null) {
			setErrorClientes_idclientes("El id del cliente no puede ser null");
		}
		this.clientes_idclientes = clientes_idclientes;

		/*
		 * if (clientes_idclientes==null) {
		 * setErrorClientes_idclientes("El id del cliente no puede ser null"); } Cliente
		 * IDCLIENTE = new Cliente(); this.clientes_idclientes =
		 * IDCLIENTE.getIdclientes();
		 */

	}

	public Integer getTrabajadores_idtrabajadores() {
		return trabajadores_idtrabajadores;

		/*
		 * Trabajador trabajadores_idtrabajadores = new Trabajador(); return
		 * trabajadores_idtrabajadores.getIdtrabajadores();
		 */
	}

	public void setTrabajadores_idtrabajadores(Integer trabajadores_idtrabajadores) {
		if (trabajadores_idtrabajadores == null) {
			setErrorTrabajadores_idtrabajadores("El id del trabajador no puede ser null");
		}
		this.trabajadores_idtrabajadores = trabajadores_idtrabajadores;

		/*
		 * if (trabajadores_idtrabajadores == null) {
		 * setErrorTrabajadores_idtrabajadores("El id del trabajador no puede ser null"
		 * ); } Trabajador IDTRABAJADOR= new Trabajador();
		 * this.trabajadores_idtrabajadores= IDTRABAJADOR.getIdtrabajadores();
		 */
	}

	public Integer getServicios_idservicios() {
		return servicios_idservicios;

		/*
		 * Servicio servicios_idservicios = new Servicio(); return
		 * servicios_idservicios.getIdservicios();
		 */
	}

	public void setServicios_idservicios(Integer servicios_idservicios) {
		if (servicios_idservicios == null) {
			setErrorServicios_idservicios("El id del servicio no puede ser null");
		}
		this.servicios_idservicios = servicios_idservicios;

		/*
		 * if (servicios_idservicios == null) {
		 * setErrorServicios_idservicios("El id del servicio no puede ser null"); }
		 * Servicio IDSERVICIO= new Servicio(); this.servicios_idservicios=
		 * IDSERVICIO.getIdservicios();
		 */
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		if (fecha != null && fecha.after(new Date())) {
			setErrorFecha("No puedes usar una fecha futura para la fecha del servicio");
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
		if (calificacion.trim().length() > 15) {
			setErrorCalificacion("La calificación debe tener como máximo 15 caracteres");
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
	
	private void setClientes_idclientes(String clientes_idclientes) {
		if (clientes_idclientes == null || clientes_idclientes.trim().length() == 0) {
			setErrorClientes_idclientes("El id del cliente es obligatorio");
			this.clientes_idclientes = null;
			return;
		}

		try {
			this.clientes_idclientes = Integer.parseInt(clientes_idclientes);
		} catch (NumberFormatException e) {
			setErrorClientes_idclientes("IdCliente introducido no es un número");
		}
	}

	private void setTrabajadores_idtrabajadores(String trabajadores_idtrabajadores) {
		if (trabajadores_idtrabajadores == null || trabajadores_idtrabajadores.trim().length() == 0) {
			setErrorTrabajadores_idtrabajadores("El id del trabajador es obligatorio");
			this.trabajadores_idtrabajadores = null;
			return;
		}

		try {
			this.trabajadores_idtrabajadores = Integer.parseInt(trabajadores_idtrabajadores);
		} catch (NumberFormatException e) {
			setErrorTrabajadores_idtrabajadores("IdTrabajador introducido no es un número");
		}
	}

	private void setServicios_idservicios(String servicios_idservicios) {
		if (servicios_idservicios == null || servicios_idservicios.trim().length() == 0) {
			setErrorServicios_idservicios("El id del servicio es obligatorio");
			this.servicios_idservicios = null;
			return;
		}

		try {
			this.servicios_idservicios = Integer.parseInt(servicios_idservicios);
		} catch (NumberFormatException e) {
			setErrorServicios_idservicios("IdServicio introducido no es un número");
		}
	}

	private void setFecha(String fecha) {	
		if (fecha == null || fecha.trim().length()==0) {
			setErrorFecha("La fecha es obligatoria");
			this.fecha = null;
			return;
		}
		
		SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");			
		try {
			Date fecha1 = formatoFecha.parse(fecha);
			this.fecha= fecha1;
		} catch (ParseException e) {
			setErrorFecha("Error al convertir fecha");
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

	public String getErrorClientes_idclientes() {
		return errorClientes_idclientes;
	}

	public void setErrorClientes_idclientes(String errorClientes_idclientes) {
		setCorrecto(false);
		this.errorClientes_idclientes = errorClientes_idclientes;
	}

	public String getErrorTrabajadores_idtrabajadores() {
		return errorTrabajadores_idtrabajadores;
	}

	public void setErrorTrabajadores_idtrabajadores(String errorTrabajadores_idtrabajadores) {
		setCorrecto(false);
		this.errorTrabajadores_idtrabajadores = errorTrabajadores_idtrabajadores;
	}

	public String getErrorServicios_idservicios() {
		return errorServicios_idservicios;
	}

	public void setErrorServicios_idservicios(String errorServicios_idservicios) {
		setCorrecto(false);
		this.errorServicios_idservicios = errorServicios_idservicios;
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
		result = prime * result + ((clientes_idclientes == null) ? 0 : clientes_idclientes.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resena == null) ? 0 : resena.hashCode());
		result = prime * result + ((servicios_idservicios == null) ? 0 : servicios_idservicios.hashCode());
		result = prime * result + ((trabajadores_idtrabajadores == null) ? 0 : trabajadores_idtrabajadores.hashCode());
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
		SesionBuena other = (SesionBuena) obj;
		if (calificacion == null) {
			if (other.calificacion != null)
				return false;
		} else if (!calificacion.equals(other.calificacion))
			return false;
		if (clientes_idclientes == null) {
			if (other.clientes_idclientes != null)
				return false;
		} else if (!clientes_idclientes.equals(other.clientes_idclientes))
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
		if (servicios_idservicios == null) {
			if (other.servicios_idservicios != null)
				return false;
		} else if (!servicios_idservicios.equals(other.servicios_idservicios))
			return false;
		if (trabajadores_idtrabajadores == null) {
			if (other.trabajadores_idtrabajadores != null)
				return false;
		} else if (!trabajadores_idtrabajadores.equals(other.trabajadores_idtrabajadores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sesion [id=" + id + ", clientes_idclientes=" + clientes_idclientes + ", trabajadores_idtrabajadores="
				+ trabajadores_idtrabajadores + ", servicios_idservicios=" + servicios_idservicios + ", fecha=" + fecha
				+ ", resena=" + resena + ", calificacion=" + calificacion + "]";
	}

}
