package sdm.modelos;

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

	//CONSTRUCTORES
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

	//Constructor de String
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
		this(id, clienteO,trabajadorO,servicioO,fecha, null, null);
	}
	//FIN CONSTRUCTORES
	
	
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
		if (clienteO == null) {
			setErrorClienteO("El cliente no puede ser null");
		}
		this.clienteO = clienteO;
	}

	public Trabajador getTrabajadorO() {
		return trabajadorO;
	}

	public void setTrabajadorO(Trabajador trabajadorO) {
		if (trabajadorO == null) {
			setErrorTrabajadorO("El trabajador no puede ser null");
		}
		this.trabajadorO = trabajadorO;
	}

	public Servicio getServicioO() {
		return servicioO;
	}

	public void setServicioO(Servicio servicioO) {
		if (servicioO == null) {
			setErrorServicioO("El servicio no puede ser null");
		}
		this.servicioO = servicioO;
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

	private void setClienteO(String clienteO) {
		if (clienteO == null|| clienteO.trim().length() == 0) {
			setErrorClienteO("El cliente es obligatorio");
			this.clienteO=null;
		}
			
			Cliente objetoCliente = new Cliente();
			this.clienteO= objetoCliente;
		//TODO Comprobar bien
	}

	private void setTrabajadorO(String trabajadorO) {
		if (trabajadorO == null) {
			setErrorTrabajadorO("El trabajador es obligatorio");
			this.trabajadorO=null;
		}
		
		try {
			this.trabajadorO= new Trabajador();
		} catch (Exception e) {
			setErrorTrabajadorO("El dato pasado no es de trabajador");
		}
		//TODO Comprobar bien
	}

	private void setServicioO(String servicioO) {
		if (servicioO == null|| servicioO.trim().length() == 0) {
			setErrorServicioO("El servicio es obligatorio");
			this.servicioO=null;
		}
		
			Servicio objetoServicio = new Servicio();
			this.servicioO= objetoServicio;
		//TODO Comprobar bien

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
		setCorrecto(false);
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
