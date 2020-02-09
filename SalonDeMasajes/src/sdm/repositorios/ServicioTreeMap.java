package sdm.repositorios;

import java.math.BigDecimal;
import java.util.TreeMap;

import sdm.modelos.Servicio;

 class ServicioTreeMap implements Dao<Servicio> {

	private TreeMap<Long, Servicio> servicios = new TreeMap<>();

	// SINGLETON
	private static final ServicioTreeMap INSTANCIA = new ServicioTreeMap();

	private ServicioTreeMap() {
		agregar(new Servicio(null, "Masaje facial", new BigDecimal("48.15")));
		agregar(new Servicio(null, "Drenaje linfatico", new BigDecimal("35.48")));
		agregar(new Servicio(null, "Cobertura de algas", new BigDecimal("60.50")));
	}

	public static ServicioTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Servicio> obtenerTodos() {
		return servicios.values();
		 
	}

	@Override
	public Servicio obtenerPorId(Long id) {
		return servicios.get(id);
	}

	@Override
	public void agregar(Servicio servicio) {
				Long id = servicios.size() == 0L ? 1L : servicios.lastKey() + 1L;
				servicio.setId(id);
				servicios.put(id, servicio);
	}

	@Override
	public void modificar(Servicio servicio) {
		servicios.put(servicio.getId(), servicio);
	}

	@Override
	public void borrar(Long id) {
		if (!servicios.containsKey(id)) {
			throw new AccesoDatosException("No se ha encontrado el libro a borrar");
		}
		servicios.remove(id);

	}

}
