package sdm.repositorios;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.TreeMap;

import sdm.modelos.Cliente;
import sdm.modelos.Servicio;
import sdm.modelos.Sesion;
import sdm.modelos.Trabajador;

public class SesionTreeMap implements Dao<Sesion> {

	private TreeMap<Integer, Sesion> sesiones = new TreeMap<>();

	// SINGLETON
	private static final SesionTreeMap INSTANCIA = new SesionTreeMap();

	public SesionTreeMap() {
		agregar(new Sesion(null, new Cliente(1, "jose", "garcia", "71284315G"),
				new Trabajador(1, "Fran", "Xisco", "71345622G"),
				new Servicio(2, "Masaje a 4 manos", new BigDecimal("48.154")),
				new GregorianCalendar(2020, 10, 02).getTime(), "Me ha gustado mucho", "Notable"));
		agregar(new Sesion(null, new Cliente(2, "Alberto", "Perez", "72224315G"),
				new Trabajador(2, "Roberto", "perex", "71284222G"),
				new Servicio(2, "Masaje de pies", new BigDecimal("60,456")),
				new GregorianCalendar(2020, 10, 02).getTime(), "Me ha gustado ", "Muy bien"));
		agregar(new Sesion(null, new Cliente(3, "jose", "garcia", "71255515G"),
				new Trabajador(2, "Roberto", "perex", "71284222G"),
				new Servicio(2, "Masaje cadera", new BigDecimal("48.154")),
				new GregorianCalendar(2020, 10, 02).getTime(), "Lo mejor", "Excelente"));

	}

	public static SesionTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Sesion> obtenerTodos() {
		return sesiones.values();
	}

	@Override
	public Sesion obtenerPorId(Integer id) {
		return sesiones.get(id);
	}

	@Override
	public void agregar(Sesion sesion) {
		Integer id = sesiones.size() == 0 ? 1 : sesiones.lastKey() + 1;
		sesion.setId(id);
		sesiones.put(id, sesion);
	}

	@Override
	public void modificar(Sesion sesion) {
		sesiones.put(sesion.getId(),sesion);

	}

	@Override
	public void borrar(Integer id) {
		if (sesiones.containsKey(id)) {
			throw new AccesoDatosException("No se ha encontrado el servicio para borrar");
		}

	}

}
