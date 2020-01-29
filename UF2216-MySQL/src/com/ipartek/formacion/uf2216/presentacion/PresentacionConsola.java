package com.ipartek.formacion.uf2216.presentacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PresentacionConsola {

	/*
	 * private final static TreeMap<Long, Libro> libros = new TreeMap<>(); private
	 * final static Scanner scanner = new Scanner(System.in); private static long
	 * ultimoId = 1L;
	 */
	private static final String usuario = "root";
	private static final String password = "admin";
	private static final String URL = "jdbc:mysql://localhost:3306/uf2213?serverTimezone=UTC";//Cadena de conexión de MySQL
	private static final int OPCION_LISTADO = 1;
	private static final int OPCION_OBTENERPORID = 2;
	private static final int OPCION_AGREGAR = 3;
	private static final int OPCION_MODIFICAR = 4;
	private static final int OPCION_ELIMINAR = 5;
	private static final int OPCION_SALIR = 0;

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		int opcion = 0;
		do {
			mostrarMenu();
			opcion = pedirOpcion();
			System.out.println();
			procesarOpcion(opcion);
		} while (opcion != OPCION_SALIR);
		saludoFinal();

	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println(OPCION_LISTADO + " - Listar libros");
		System.out.println(OPCION_OBTENERPORID + " - Obtener libro por ID");
		System.out.println(OPCION_AGREGAR + " - Agregar libro");
		System.out.println(OPCION_MODIFICAR + " - Modificar libro");
		System.out.println(OPCION_ELIMINAR + " - Eliminar libro");
		System.out.println(OPCION_SALIR + " - Salir");
	}

	private static int pedirOpcion() {
		return Biblioteca.leerEntero("Elija una opción del menú: ");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case OPCION_LISTADO:
			System.out.println("LISTADO");
			listado();
			break;
		case OPCION_OBTENERPORID:
			System.out.println("OBTENER POR ID");
			getbyid();
			break;
		case OPCION_AGREGAR:
			System.out.println("AGREGAR");
			insert();
			break;
		case OPCION_MODIFICAR:
			System.out.println("MODIFICAR");
			update();
			break;
		case OPCION_ELIMINAR:
			System.out.println("ELIMINAR");
			delete();
			break;
		case OPCION_SALIR:
			System.out.println("SALIR");
			break;
		default:
			System.out.println("No ha introducido una opción correcta del menú");
		}
	}

	private static void listado() {
		try {
			System.out.println("Conectando para Listar todos los libros");
			Connection con = DriverManager.getConnection(URL, usuario, password);
			System.out.println("Conectado");
			System.out.println("LISTADO");
			String sql = "SELECT * FROM libros";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 System.out.println(rs.getLong("id") + "\t" + rs.getString("titulo") + "\t" + rs.getString("isbn") + "\t"
						+ rs.getInt("numeroPaginas") + "\t" + rs.getString("formato"));
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido realizar el listado de libros", e);
		}
	}

	private static void getbyid() {
		try {
			System.out.println("Conectando para obtener por ID");
			Connection con = DriverManager.getConnection(URL, usuario, password);
			System.out.println("Conectado");
			System.out.println("OBTENER POR ID");
			Long id = 1L;
			String sql = "SELECT * FROM libros WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println((rs.getString("titulo") + "\t" + rs.getString("isbn") + "\t"
						+ rs.getString("numeroPaginas") + "\t" + rs.getString("formato")));
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el libro pod id", e);
		}
		// TODO ACABAR METODO GETBYID CON TRY/CATH
	}

	private static void insert() {

		System.out.println("Conectando para agregar");
		try  {
			Connection con = DriverManager.getConnection(URL, usuario, password);
			System.out.println("Conectado");
			System.out.println("Agregar libro");
			String titulo = "Los del alla";
			String isbn = "1234561230";
			String numeroPaginas = "35";
			String formato = "digital";
			System.out.println("Agregar libro1");

			String sql = "INSERT INTO libros (titulo, isbn, numeroPaginas,formato) VALUES(?,?,?,?,?)";
			System.out.println("Agregar libro2");

			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Agregar libro21");
			ps.setString(1, titulo);
			ps.setString(2, isbn);
			ps.setString(3, numeroPaginas);
			ps.setString(4, formato);
			System.out.println("Agregar libro22");
			int numeroRegistrosModificados = ps.executeUpdate();
			System.out.println("Agregar libro3");

			if (numeroRegistrosModificados == 1) {
				System.out.println("Insertado correctamente");
			} else {
				System.err.println("No se ha insertado correctamente");
				System.err.println(numeroRegistrosModificados);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el libro");
		}
		
	}
	
	private static void update() {
		System.out.println("Conectando para actualizar el libro");

		try (Connection con = DriverManager.getConnection(URL, usuario, password)){
			System.out.println("Conectado");
			Long idAModificar = 1L;
			String titulo= "La roca 2";
			String isbn="9638527410";
			String numeroPaginas="2000";
			String formato="papel";
			String sql = "UPDATE libros SET titulo=?, isbn=?, numeroPaginas=?, formato =? WHERE id=?";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, titulo);
			ps.setString(2, isbn);
			ps.setString(3, numeroPaginas);
			ps.setString(4, formato);
			ps.setLong(5, idAModificar);
			int numeroRegistrosmodificados=ps.executeUpdate();
			if (numeroRegistrosmodificados==1) {
				System.out.println("Modificado correctamente");
			}else{
				System.out.println("No modificado correctamente");
			}
		} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido modificar el libro ");
		}

	}

	private static void delete() {
		System.out.println("Conectando para eliminar libro");

		try (Connection con = DriverManager.getConnection(URL, usuario, password)) {
			System.out.println("Conectado");
			Long id = 1L;
			String sql = "DELETE FROM libros WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			int numeroRegistrosModificados = ps.executeUpdate();
			if (numeroRegistrosModificados == 1) {
				System.out.println("Se ha eliminado correctamente el libro");
			} else {
				System.err.println("No se ha eliminado correctamente");
				System.err.println(numeroRegistrosModificados);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido eliminar el libro");
		}
	}

	private static void saludoFinal() {
		System.out.println("Saliendo. Gracias por utilizar la apliación.");
	}
}
/*
 * boolean esNuevoRegistro;
 *
 *
 * do {
 * 
 * System.out.println("Conectando");
 * 
 * Connection con = DriverManager.getConnection(URL, usuario, password);
 * 
 * System.out.println("Conectado");
 * 
 * System.out.println("LISTADO DE LIBROS");
 * 
 * String sql = "SELECT * FROM libros";
 * 
 * Statement s = con.createStatement();
 * 
 * ResultSet rs = s.executeQuery(sql);
 * 
 * while (rs.next()) { System.out.println(rs.getString("titulo") + "\t" +
 * rs.getString("isbn") + "\t" + rs.getInt("numeroPaginas") + "\t" +
 * rs.getString("formato")); }
 * 
 * System.out.println("AGREGAR LIBROS");
 * 
 * String titulo = "La montaña"; String isbn = "1234567890"; String
 * numeroPaginas = "111"; String formato = "digital";
 * 
 * sql =
 * "INSERT INTO libros (titulo, isbn, numeroPaginas,formato) VALUES (?,?,?,?) ";
 * PreparedStatement ps = con.prepareStatement(sql);
 * 
 * ps.setString(1, titulo); ps.setString(2, isbn); ps.setString(3,
 * numeroPaginas); ps.setString(4, formato);
 * 
 * int numeroRegistrosModificados = ps.executeUpdate();
 * 
 * if (numeroRegistrosModificados == 1) {
 * System.out.println("Insertado correctamente"); } else {
 * System.err.println("No se ha insertado correctamente");
 * System.err.println(numeroRegistrosModificados); }
 * 
 * System.out.println("MODIFICAR LIBRO"); Long idAModificar = 3L; titulo =
 * "El sendero"; isbn = "0987654321"; numeroPaginas = "66"; formato = "papel";
 * 
 * sql =
 * "UPDATE usuarios SET titulo = ?, isbn = ?, numeroPaginas = ?, formato = ? WHERE id = ?"
 * ;
 * 
 * ps = con.prepareStatement(sql);
 * 
 * ps.setString(1, titulo); ps.setString(2, isbn); ps.setString(3,
 * numeroPaginas); ps.setString(4, formato); ps.setLong(5, idAModificar);
 * 
 * numeroRegistrosModificados = ps.executeUpdate();
 * 
 * if (numeroRegistrosModificados == 1) {
 * System.out.println("Libro modificado correctamente"); } else {
 * System.err.println("No se ha modificado correctamente");
 * System.err.println(numeroRegistrosModificados); }
 * 
 * 
 * System.out.println("ELIMINAR LIBRO"); Long id = 2L; sql =
 * "DELETE FROM libros WHERE id = ?";
 * 
 * ps = con.prepareStatement(sql);
 * 
 * ps.setLong(1, id); numeroRegistrosModificados = ps.executeUpdate();
 * 
 * if(numeroRegistrosModificados == 1) {
 * System.out.println("El libro se ha borrado correctamente"); } else {
 * System.err.println("No se ha borrado correctamente");
 * System.err.println(numeroRegistrosModificados); }
 * 
 * 
 * ps.close(); rs.close(); s.close(); con.close();
 * 
 * listadoLibros();
 * 
 * Libro libro = pedirLibro();
 * 
 * mostrarLibro(libro);
 * 
 * guardarLibro(libro);
 * 
 * 
 * // Preguntar si el usuario quiere introducir un nuevo registro
 * System.out.print("�Desea introducir un nuevo registro? (S/n) ");
 * esNuevoRegistro = !scanner.nextLine().equalsIgnoreCase("n");
 * }while(esNuevoRegistro);
 * 
 * System.out.
 * println("Saliendo de la aplicaci�n. Gracias por usar esta aplicaci�n");
 * 
 * scanner.close(); }
 * 
 * private static Libro pedirLibro() {
 * 
 * // Pedir datos de libro String titulo, isbn; int numeroPaginas = -1; boolean
 * formato = false;
 * 
 * titulo = pedirTitulo(); isbn = pedirIsbn(); numeroPaginas =
 * pedirNumeroPaginas(numeroPaginas); formato = pedirFormato(formato);
 * 
 * // Creaci�n de libro en base a los datos introducidos Libro libro = new
 * Libro(ultimoId, titulo, isbn, numeroPaginas, formato);
 * 
 * return libro; }
 * 
 * private static void guardarLibro(Libro libro) {
 * System.out.print("�Quieres guardar este libro? (S/n) ");
 * 
 * // Si me dicen que s�, guardo el libro if
 * (!scanner.nextLine().equalsIgnoreCase("n")) { // A�adir el libro a la
 * colecci�n de libros libros.put(ultimoId++, libro); } }
 * 
 * private static void listadoLibros() {
 * System.out.println("LISTADO DE LIBROS");
 * 
 * System.out.println("Id\tISBN\t\tN�mero de p�ginas\tFormato\tT�tulo"); for
 * (Libro libroExtraido : libros.values()) {
 * System.out.println(libroExtraido.getId() + "\t" + libroExtraido.getIsbn() +
 * "\t" + libroExtraido.getNumeroPaginas() + "\t\t" + (libroExtraido.isFormato()
 * ? "Digital" : "Papel") + "\t" + libroExtraido.getTitulo()); } }
 * 
 * private static void mostrarLibro(Libro libro) { System.out.println("Id: " +
 * libro.getId() + "\nT�tulo: " + libro.getTitulo() + "\nISBN: " +
 * libro.getIsbn() + "\nN�mero de p�ginas: " + libro.getNumeroPaginas() +
 * "\nFormato: " + (libro.isFormato() ? "Digital" : "Papel")); }
 * 
 * private static boolean pedirFormato(boolean formato) { boolean
 * esFormatoCorrecto; String stringFormato; do { // Introducci�n de formato
 * System.out.print("Formato (digital o papel): "); stringFormato =
 * scanner.nextLine().trim();
 * 
 * if (stringFormato.equalsIgnoreCase("digital") ||
 * stringFormato.equalsIgnoreCase("papel")) { esFormatoCorrecto = true; formato
 * = stringFormato.equalsIgnoreCase("digital"); } else { esFormatoCorrecto =
 * false; System.out.println("El formato debe ser digital o papel"); } } while
 * (!esFormatoCorrecto); return formato; }
 * 
 * private static int pedirNumeroPaginas(int numeroPaginas) { boolean
 * esNumeroPaginasCorrecto; do { // Introducci�n de n�mero de p�ginas
 * System.out.print("N�mero de p�ginas: ");
 * 
 * try { numeroPaginas = scanner.nextInt();
 * 
 * if (numeroPaginas >= 1) { esNumeroPaginasCorrecto = true; } else {
 * esNumeroPaginasCorrecto = false;
 * System.out.println("El n�mero de p�ginas debe ser m�nimo 1"); } } catch
 * (Exception e) {
 * System.out.println("Debes introducir un n�mero (s�lo d�gitos)");
 * esNumeroPaginasCorrecto = false; } finally { // Consumir el enter si ha ido
 * bien, o el texto si ha habido una excepci�n scanner.nextLine(); } } while
 * (!esNumeroPaginasCorrecto); return numeroPaginas; }
 * 
 * private static String pedirIsbn() { boolean esIsbnCorrecto; String isbn; do {
 * // Introducci�n de ISBN System.out.print("ISBN: "); isbn =
 * scanner.nextLine();
 * 
 * if (isbn.matches("\\d{10}")) { esIsbnCorrecto = true; } else { esIsbnCorrecto
 * = false; System.out.println("El ISBN debe ser un n�mero de longitud 10"); } }
 * while (!esIsbnCorrecto); return isbn; }
 * 
 * private static String pedirTitulo() { boolean esTituloCorrecto; String
 * titulo; do { // Introducci�n de t�tulo System.out.print("T�tulo: "); titulo =
 * scanner.nextLine().trim();
 * 
 * // Validaci�n del t�tulo if (titulo.length() > 3 && titulo.length() <= 150) {
 * esTituloCorrecto = true;
 * 
 * } else { esTituloCorrecto = false; System.out.
 * println("El t�tulo debe tener un tama�o m�nimo de 3 letras y m�ximo de 150");
 * } } while (!esTituloCorrecto); return titulo; }
 * 
 * }
 */
