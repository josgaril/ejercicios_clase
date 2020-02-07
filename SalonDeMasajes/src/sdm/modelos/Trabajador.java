package sdm.modelos;

public class Trabajador {

	private Integer id;
	private String nombre;
	private String apellidos;
	private String dni;

	private boolean correcto;
	private String errorId,errorNombre, errorApellidos, errorDni;

	public Trabajador(Integer id, String nombre, String apellidos, String dni) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setDni(dni);
	}

	/*
	 * public Trabajador(String id, String nombre, String apellidos, String dni) {
	 * setId(id); setNombre(nombre); setApellidos(apellidos); setDni(dni);
	 * }
	 */
	
	public Trabajador(String nombre, String apellidos, String dni) {
		this(null, nombre, apellidos, dni);
	}

	public Trabajador() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre==null || nombre.trim().length()<1 || nombre.trim().length()>45) {
			setErrorNombre("El nombre tiene que tener entre 1 y 45 caracteres");
		}
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (apellidos==null || apellidos.trim().length()<1 || apellidos.trim().length()>90) {
			setErrorApellidos("Los apellidos tiene que tener una longitud entre 1 y 90");
		}this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni==null|| dni.trim().length()!=9) {
			setErrorDni("El dni tiene que tener una longitud de 9 caracteres");
		}	
			this.dni = dni;
		
	}

	/*
	 * private void setId(String id) { if (id == null || id.trim().length() == 0) {
	 * this.id = null; return; }
	 * 
	 * try { this.id = Long.parseLong(id); } catch (NumberFormatException e) {
	 * setErrorId("No era un número"); } }
	 */
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

	public String getErrorApellidos() {
		return errorApellidos;
	}

	public void setErrorApellidos(String errorApellidos) {
		setCorrecto(false);
		this.errorApellidos = errorApellidos;
	}

	public String getErrorDni() {
		return errorDni;
	}

	public void setErrorDni(String errorDni) {
		setCorrecto(false);
		this.errorDni = errorDni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Trabajador other = (Trabajador) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
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
		return true;
	}

	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + "]";
	}



}
