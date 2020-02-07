package sdm.repositorios;

import java.util.TreeMap;

import sdm.modelos.Trabajador;

public class TrabajadorTreeMap implements Dao<Trabajador>{
	private TreeMap<Integer, Trabajador> trabajadores = new TreeMap<>();

	//SINGLETON
	private static final TrabajadorTreeMap INSTANCIA = new TrabajadorTreeMap();
	
	private TrabajadorTreeMap() {
		agregar(new Trabajador("Jose Angel", "Garcia Illera", "71284315R"));
		agregar(new Trabajador("Alberto", "Garcia Illera", "71284314T"));
		agregar(new Trabajador("Rodrigo", "Mendez Martinez", "75289635G"));
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
	public Trabajador obtenerPorId(Integer id) {
		return trabajadores.get(id);
	}

	@Override
	public void agregar(Trabajador trabajador) {
		Integer id = (int) (trabajadores.size() == 0L ? 1L : trabajadores.lastKey() + 1L);
		trabajador.setId(id);
		trabajadores.put(id, trabajador);
		
	}

	@Override
	public void modificar(Trabajador trabajador) {
		trabajadores.put(trabajador.getId(), trabajador);
		
	}

	@Override
	public void borrar(Integer id) {
		if (!trabajadores.containsKey(id)) {
			throw new AccesoDatosException("No se ha encontrado el libro a borrar");
		}

		trabajadores.remove(id);
	}

	

	
	
}
