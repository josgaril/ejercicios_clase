package com.ipartek.formacion.uf2216.presentacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PresentacionConsola {

	/*
	 * private final static TreeMap<Long, Libro> libros = new TreeMap<>(); private
	 * final static Scanner scanner = new Scanner(System.in); private static long
	 * ultimoId = 1L;
	 */
	private static final String usuario = "root";
	private static final String password = "admin";
	private static final String URL = "jdbc:mysql://localhost:3306/uf2213?serverTimezone=UTC";// Cadena de conexión de
																								// MySQL
	private static final int OPCION_LISTADO = 1;
	private static final int OPCION_OBTENERPORID = 2;
	private static final int OPCION_AGREGAR = 3;
	private static final int OPCION_MODIFICAR = 4;
	private static final int OPCION_ELIMINAR = 5;
	private static final int OPCION_SALIR = 0;

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

	private static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, usuario, password);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la coneción a la base de datos", e);
		}
	}

	private static void listado() {
		System.out.println("Conectando para Listar todos los libros");
		try (Connection con = getConnection()) {
			System.out.println("Conectado");
			System.out.println("LISTADO");
			String sql = "SELECT * FROM libros";
			try (Statement s = con.createStatement()) {
				try (ResultSet rs = s.executeQuery(sql)) {
					while (rs.next()) {
						System.out
								.println(rs.getLong("id") + "\t" + rs.getString("titulo") + "\t" + rs.getString("isbn")
										+ "\t" + rs.getInt("numeroPaginas") + "\t" + rs.getBoolean("formato"));
					}
				}
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido realizar el listado de libros", e);
		}
	}

	private static void getbyid() {
		System.out.println("Conectando para obtener por ID");
		try (Connection con = getConnection();) {
			System.out.println("Conectado");
			System.out.println("OBTENER POR ID");
			Long id = 14L;
			String sql = "SELECT * FROM libros WHERE id = ?";
			try (PreparedStatement ps = con.prepareStatement(sql)) {

				ps.setLong(1, id);
				try (ResultSet rs = ps.executeQuery()) {

					if (rs.next()) {
						System.out
								.println(rs.getLong("id") + "\t" + rs.getString("titulo") + "\t" + rs.getString("isbn")
										+ "\t" + rs.getInt("numeroPaginas") + "\t" + rs.getBoolean("formato"));
					} else {
						System.out.println("No encontrado");
					}
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el libro pod id", e);
		}
	}

	private static void insert() {

		System.out.println("Conectando para agregar");
		try (Connection con = getConnection()) {

			System.out.println("Conectado");
			System.out.println("Agregar libro");
			String titulo = "yiiieso";
			String isbn = "1111111111";
			Integer numeroPaginas = 11;
			Boolean formato = false;

			String sql = "INSERT INTO libros (titulo, isbn, numeroPaginas,formato) VALUES(?,?,?,?)";

			try (PreparedStatement ps = con.prepareStatement(sql)) {

				ps.setString(1, titulo);
				ps.setString(2, isbn);
				ps.setInt(3, numeroPaginas);
				ps.setBoolean(4, formato);
				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados == 1) {
					System.out.println("Insertado correctamente");
				} else {
					System.err.println("No se ha insertado correctamente");
					System.err.println(numeroRegistrosModificados);
				}
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("Error al insertar el libro", e);
		}

	}

	private static void update() {
		System.out.println("Conectando para actualizar el libro");

		try (Connection con = getConnection()) {
			System.out.println("Conectado");
			Long idAModificar = 7L;
			String titulo = "cambiado";
			String isbn = "0000000000";
			Integer numeroPaginas = 223;
			Boolean formato = false;
			String sql = "UPDATE libros SET titulo=?, isbn=?, numeroPaginas=?, formato =? WHERE id=?";

			try (PreparedStatement ps = con.prepareStatement(sql)) {

				ps.setString(1, titulo);
				ps.setString(2, isbn);
				ps.setInt(3, numeroPaginas);
				ps.setBoolean(4, formato);
				ps.setLong(5, idAModificar);
				int numeroRegistrosmodificados = ps.executeUpdate();
				if (numeroRegistrosmodificados == 1) {
					System.out.println("Modificado correctamente");
				} else {
					System.out.println("No modificado correctamente");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el libro ", e);
		}

	}

	private static void delete() {
		System.out.println("Conectando para eliminar libro");

		try (Connection con = getConnection()) {
			System.out.println("Conectado");
			Long id = 8L;
			String sql = "DELETE FROM libros WHERE id = ?";
			try (PreparedStatement ps = con.prepareStatement(sql)) {

				ps.setLong(1, id);
				int numeroRegistrosModificados = ps.executeUpdate();
				if (numeroRegistrosModificados == 1) {
					System.out.println("Se ha eliminado correctamente el libro");
				} else {
					System.err.println("No se ha eliminado correctamente");
					System.err.println(numeroRegistrosModificados);
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido eliminar el libro", e);
		}
	}

	private static void saludoFinal() {
		System.out.println("Saliendo. Gracias por utilizar la aplicación.");
	}
}