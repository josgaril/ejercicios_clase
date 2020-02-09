package sdm.repositorios;

import java.util.TreeMap;

import sdm.modelos.Trabajador;

public class TrabajadorTreeMap implements Dao<Trabajador>{
	private TreeMap<Long, Trabajador> trabajadores = new TreeMap<>();

	//SINGLETON
	private static final TrabajadorTreeMap INSTANCIA = new TrabajadorTreeMap();
	
	private TrabajadorTreeMap() {
		agregar(new Trabajador(null, "jose", "asd", "71284545F"));
		agregar(new Trabajador(null, "Jose Roberto", "Paroli Jilguero", "78523652L"));
		agregar(new Trabajador(null,"Jose Angel", "Garcia Illera", "71284315R"));
		agregar(new Trabajador(null,"Alberto", "Garcia Illera", "71284314T"));
		agregar(new Trabajador(null,"Rodrigo", "Mendez Martinez", "75289635G"));
		agregar(new Trabajador(null,"Ramon", "Del Hoyo Perez", "71456248F"));

	}
	
	public static TrabajadorTreeMap getInstancia() {
		return INSTANCIA;
	}
	//FIN SINGLETON
	
	@Override
	public Iterable<Trabajador> obtenerTodos() {
		return trabajadores.values();
	}

	@Override
	public Trabajador obtenerPorId(Long id) {
		return trabajadores.get(id);
	}

	@Override
	public void agregar(Trabajador trabajador) {
		//Integer id =(trabajadores.size() == 0 ? 1 : trabajadores.lastKey() + 1);
		Long id = trabajadores.size() == 0L ? 1L : trabajadores.lastKey() + 1L;
		trabajador.setId(id);
		trabajadores.put(id, trabajador);
	}

	@Override
	public void modificar(Trabajador trabajador) {
		trabajadores.put(trabajador.getId(), trabajador);
	}

	@Override
	public void borrar(Long id) {
		if (!trabajadores.containsKey(id)) {
			throw new AccesoDatosException("No se ha encontrado el libro a borrar");
		}
		trabajadores.remove(id);
	}
}
