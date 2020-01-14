package libreria.Presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import libreria.Utilidades.Biblioteca;
import libreria.accesoDatos.AccesoDatosException;
import libreria.accesoDatos.Dao;
import libreria.accesoDatos.LibrosArrayList;
import libreria.entidades.EntidadesException;
import libreria.entidades.Libro;

public class ProgramaPrincipal {

	private static final Dao<Libro> dao = LibrosArrayList.getInstancia();

	private static final int OPCION_SALIR = 0;
	private static final int OPCION_LISTADO = 1;

	private static final int OPCION_AGREGAR = 2;

	private static final int OPCION_BORRAR = 3;

	private static final int OPCION_MODIFICAR = 4;

	private static final int OPCION_GUARDAR_CSV = 5;

	public static void main(String[] args) {

		try {
			int opcion = 0;

			do {
				mostrarOciones();
				opcion = pedirOpcion();
				System.out.println();
				procesadoOpcion(opcion);
			} while (opcion != OPCION_SALIR); // Mostramos el men� mientras la opci�n sea diferente de 0.
			saludoFinal();

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());

			e.printStackTrace(); // TODO Dejar bien puesto la gestion de errores
			return;
		}

	}

	private static void mostrarOciones() {
		System.out.println("\n\tMENU");
		System.out.println("-----------------");
		System.out.println(OPCION_LISTADO + ". Listado");
		System.out.println(OPCION_AGREGAR + ". A�adir");
		System.out.println(OPCION_BORRAR + ". Borrar");
		System.out.println(OPCION_MODIFICAR + ". Modificar");
		System.out.println(OPCION_GUARDAR_CSV + ". Guardar");
		System.out.println(OPCION_SALIR + ". Salir");
	}

	private static int pedirOpcion() {
		return Biblioteca.leerEntero("Elija una opci�n: ");

	}

	private static void procesadoOpcion(int opcion) throws IOException {
		switch (opcion) {
		case OPCION_SALIR:
			System.out.println("SALIR");
			break;
		case OPCION_LISTADO:
			System.out.println("LISTADO");
			listadoLibros();
			break;
		case OPCION_AGREGAR:
			System.out.println("A�ADIR");
			agregarLibro();
			break;
		case OPCION_BORRAR:
			System.out.println("BORRAR");
			borrarLibro();
			break;
		case OPCION_MODIFICAR:
			System.out.println("MODIFICAR");
			modificarLibro();
			break;
		case OPCION_GUARDAR_CSV:
			System.out.println("GUARDAR");
			guardarCSV();
		default:
			System.out.println("OPCION NO IMPLEMENTADA");
		}
	}

	private static void listadoLibros() {
		mostrarCabeceraListado();
		for (Libro libro : dao.obtenerTodos()) {
			mostrarLibroFila(libro);
		}
	}
	private static void mostrarLibroFila(Libro libro) {
		System.out.print(libro.getId());
		System.out.print('\t');
		System.out.print(libro.getIsbn());
		System.out.print('\t');
		System.out.print(libro.getPaginas());
		System.out.print("\t\t\t");
		System.out.print(libro.getFormato());
		System.out.print("\t");
		System.out.print(libro.getTitulo());
		System.out.print("\t\t");
		System.out.println();
	}

	private static void mostrarCabeceraListado() {
		System.out.print("ID");
		System.out.print('\t');
		System.out.print("ISBN");
		System.out.print("\t\t");
		System.out.print("NUMERO DE PAGINAS");
		System.out.print('\t');
		System.out.print("FORMATO");
		System.out.print('\t');
		System.out.print("TITULO");
		System.out.print("\t\t\t");
		System.out.println();
	}
	private static void agregarLibro() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena;
		char respuesta;
		Libro libro = pedirDatosLibro();
		System.out.println("Los datos del nuevo libro que desea agregar son:");
		System.out.println("Titulo: " + libro.getTitulo());
		System.out.println("ISBN: " + libro.getIsbn());
		System.out.println("N�mero de p�ginas: " + libro.getPaginas());
		System.out.println("Formato: " + libro.getFormato());
		System.out.print("�Desea agregar el nuevo libro?(S/N): ");
		cadena = br.readLine();
		respuesta = cadena.charAt(0);
		if (respuesta == 'S' || respuesta == 's') {
			dao.agregar(libro);
			System.out.println("Se ha agregado el nuevo libro.");
		} else {
			System.out.println("No se ha agregado el nuevo libro");
		}
	}

	private static Libro pedirDatosLibro() {
		Libro libro = new Libro();

		final int TITULO = 0;
		final int ISBN = 1;
		final int PAGINAS = 2;
		final int FORMATO = 3;

		int campo = 0;

		while (campo <= FORMATO) {
			try {
				switch (campo) {
				case TITULO:
					libro.setTitulo(Biblioteca.leerLinea("T�tulo: "));
					break;
				case ISBN:
					libro.setIsbn(Biblioteca.leerLinea("ISBN: "));
					break;
				case PAGINAS:
					libro.setPaginas(Biblioteca.leerEntero("N�mero de p�ginas: "));
					break;
				case FORMATO:
					libro.setFormato(Biblioteca.leerLinea("Formato: "));
					break;
				default:
					throw new PresentacionException("CAMPO DE LIBRO NO DEFINIDO");
				}
				campo++;
			} catch (EntidadesException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		return libro;
	}

	private static void borrarLibro() {
		listadoLibros();

		Long id = (long) Biblioteca.leerEntero("Introduzca el ID del libro que quiere borrar: ");

		try {
			dao.borrar(id);

			System.out.println("El libro ha sido borrado");
		} catch (AccesoDatosException e) {
			System.out.println("ERROR al borrar libro: " + e.getMessage());
		}
	}

	private static void modificarLibro() {
		listadoLibros();
		Long id = (long) Biblioteca.leerEntero("Introduzca el ID del libro que desea modificar: ");

		if (dao.obtenerPorId(id) == null) {
			System.out.println("ERROR: No se ha encontrado el alumno a modificar");
			return;
		}

		Libro libro = pedirDatosLibro();

		libro.setId(id);

		try {
			dao.modificar(libro);
			System.out.println("El libro ha sido modificado");
		} catch (AccesoDatosException e) {
			System.out.println("ERROR: al modificar libro " + e.getMessage());
		}
	}

	private static void guardarCSV() {
		// TODO Implementar metodo guardarCSV

	}

	private static void saludoFinal() {
		System.out.println("Gracias por utilizar nuestro programa.");
	}

}
