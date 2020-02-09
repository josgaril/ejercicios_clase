package sdm.repositorios;

public interface DaoTrabajador<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Integer idtrabajadores);

	void agregar(T objeto);

	void modificar(T objeto);

	void borrar(Integer idtrabajadores);
}
