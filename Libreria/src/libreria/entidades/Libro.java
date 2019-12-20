package libreria.entidades;

import java.io.Serializable;

import libreria.Utilidades.Biblioteca;

public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	// TODO implementar posibilidad de que el titulo tambien puedan ser numeros
	private static final String REGEX_TITULO = "[\\p{L} ']+"; // "{\\d{0-9]\\p{L} }+}";
	private static final String REGEX_ISBN = "\\d{10}";

	private static final String REGEX_FORMATO = "[\\p{L}]+";

	private Long id;
	private String titulo;
	private String isbn;
	private int paginas;
	private String formato;

	public Libro(Long id, String titulo, String isbn, int paginas, String formato) {
		setId(id);
		setTitulo(titulo);
		setIsbn(isbn);
		setPaginas(paginas);
		setFormato(formato);
	}

	public Libro(Long id, String titulo, String isbn, int paginas, boolean formato) {

	}

	public Libro() { // creamos el constructor vacío

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id < 0) {
			throw new EntidadesException("No están permitidos id's negativos");
		}

		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == null || titulo.trim().length() <= 3 || titulo.trim().length() >= 150) {
			throw new EntidadesException("El título debe tener entre 3 y 150 caracteres");
		}
		if (!titulo.matches(REGEX_TITULO)) {
			throw new EntidadesException("El título sólo debe tener caracteres de letras, espacios y/o apóstrofes");
		}
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn == null || isbn.trim().length() == 0) {
			throw new EntidadesException("El ISBN no puede estar vacío");
		}
		if (!isbn.matches(REGEX_ISBN)) {
			throw new EntidadesException("El ISBN tiene que estar formado por 10 números");
		}
		this.isbn = isbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		if (paginas < 1) {
			throw new EntidadesException("El número de páginas mínimo de un libro es 1");
		}
		this.paginas = paginas;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {

		if (formato == null || formato.trim().length()==0) {
			throw new EntidadesException("El formato no puede ser nulo");
		}
		if (!formato.matches(REGEX_FORMATO)) {
			throw new EntidadesException("El formato solo pueden ser caracteres");			
		}
		if(!Biblioteca.formatoValido(formato)) {
			throw new EntidadesException("El formato solo puede ser Digital o Papel");
		}
		this.formato = formato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + paginas;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Libro other = (Libro) obj;
		if (formato == null) {
			if (other.formato != null)
				return false;
		} else if (!formato.equals(other.formato))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (paginas != other.paginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas + ", formato="
				+ formato + "]";
	}

}
