package com.ipartek.formacion.uff2215Examen.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.uff2215Examen.modelos.Autor;
import com.ipartek.formacion.uff2215Examen.modelos.Libro;

public class LibroMySQL implements Dao<Libro> {

	private static final String SQL_SELECT_ALL = "SELECT *\r\n"
			+ "FROM libros l \r\n" + "INNER JOIN autores a ON a.id=l.autores_id";
	private static final String SQL_GET_BY_ID = 
			"SELECT *\r\n" + 
			"FROM libros l \r\n" + 
			"INNER JOIN autores a ON a.id=l.autores_id WHERE l.id=?";
	private static final String SELECT_BY_TITULO = 
			"SELECT *\r\n" + 
			"FROM libros l \r\n" + 
			"INNER JOIN autores a ON a.id=l.autores_id\r\n" + 
			"WHERE l.titulo LIKE ?";
	private static String url, usuario, password;
	
	// SINGLETON

	// Creamos la variable 'instancia'
	private static LibroMySQL instancia;

	// Constructor privado de LibroMySQL
	private LibroMySQL(String url, String usuario, String password) {
		LibroMySQL.url = url;
		LibroMySQL.usuario = usuario;
		LibroMySQL.password = password;

	}

	// Inicializamos la instancia
	public static LibroMySQL getInstancia(String pathConfiguracion) {
		try {
			// si no existe la instancia..
			if (instancia == null) {
				// obtenemos los datos del archivo de configuración
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				// ..la creamos con el constructor de LibroMySQL
				instancia = new LibroMySQL(configuracion.getProperty("mysql.url"),
						configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
			}
			// devolvemos la instancia
			return instancia;
		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("Fichero de configuración no encontrado", e);
		} catch (IOException e) {
			throw new AccesoDatosException("Fallo de lectura/escritura al fichero", e);
		}
	}
	// FIN SINGLETON

	private Connection getConexion() {
		try {
			new com.mysql.cj.jdbc.Driver();
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos");
		}
	}

	@Override
	public Iterable<Libro> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (CallableStatement sp = (CallableStatement) con.prepareCall(SQL_SELECT_ALL)) {
				try (ResultSet rs = sp.executeQuery()) {
					ArrayList<Libro> libros = new ArrayList<>();

					Libro libro = null;
					Autor autor;

					while (rs.next()) {
						autor = new Autor(rs.getInt("autores_id"), rs.getString("a.nombre"),
								rs.getString("a.apellidos"));
						libros.add(new Libro(rs.getInt("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor));
						libros.add(libro);
					}
					return libros;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de libros", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los libros", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los libros", e);
		}
	}

	@Override
	public Libro obtenerPorId(Integer id) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID)) {
				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {

					Libro libro = null;
					Autor autor;
					
					if (rs.next()) {
						autor = new Autor(rs.getInt("autores_id"), rs.getString("a.nombre"),
								rs.getString("a.apellidos"));

						libro = new Libro(rs.getInt("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

						return libro;
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de librosas");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener libro con id: " + id, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el libro id: " + id, e);
		}
	}

	@Override
	public Libro obtenerPorTitulo(String titulo) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SELECT_BY_TITULO)) {
				ps.setString(1, titulo);

				try (ResultSet rs = ps.executeQuery()) {

					Libro libro = null;
					Autor autor;
					
					if (rs.next()) {
						autor = new Autor(rs.getInt("autores_id"), rs.getString("a.nombre"),
								rs.getString("a.apellidos"));

						libro = new Libro(rs.getInt("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

						return libro;
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de libros ");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener libro con titulo: " + titulo, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el libro titulo: " + titulo, e);
		}
	}
	
	
		@Override
	public Libro agregar(Libro objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
		// return null;
	}

	@Override
	public Libro modificar(Libro objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
		// return null;
	}

	@Override
	public void borrar(Integer id) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");

	}


}
