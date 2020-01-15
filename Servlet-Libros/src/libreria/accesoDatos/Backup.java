package libreria.accesoDatos;

public interface Backup<T> {
	public void guardar(Iterable<T> datos);
	public Iterable<T> recuperar();
}
