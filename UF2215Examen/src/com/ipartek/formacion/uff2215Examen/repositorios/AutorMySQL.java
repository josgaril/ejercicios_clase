package com.ipartek.formacion.uff2215Examen.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.uff2215Examen.jaxrs.Autor;

public class AutorMySQL implements Dao<Autor>{

	private static final String SQL_SELECT_ALL = "SELECT * FROM autores";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM autores WHERE id=?";
	private static String url, usuario, password;
	// SINGLETON

	// Creamos la variable 'instancia'
	private static AutorMySQL instancia;

	// Constructor privado de AutorMySQL
	private AutorMySQL(String url, String usuario, String password) {
		AutorMySQL.url = url;
		AutorMySQL.usuario = usuario;
		AutorMySQL.password = password;

	}

	// Inicializamos la instancia
	public static AutorMySQL getInstancia(String pathConfiguracion) {
		try {
			// si no existe la instancia..
			if (instancia == null) {
				// obtenemos los datos del archivo de configuración
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				// ..la creamos con el constructor de AutorMySQL
				instancia = new AutorMySQL(configuracion.getProperty("mysql.url"),
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
	public Iterable<Autor> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (CallableStatement sp = (CallableStatement) con.prepareCall(SQL_SELECT_ALL)) {
				try (ResultSet rs = sp.executeQuery()) {
					ArrayList<Autor> autores = new ArrayList<>();

					while (rs.next()) {
						autores.add(new Autor(rs.getInt("id"), rs.getString("nombre"),
								rs.getString("apellidos")));
					}
					return autores;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de autores", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los autores", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los autores", e);
		}
	}

	@Override
	public Autor obtenerPorId(Integer id) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_SELECT_BY_ID)) {
				cs.setInt(1, id);

				try (ResultSet rs = cs.executeQuery()) {

					if (rs.next()) {
						return new Autor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"));
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de autores", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener autor con id: " + id, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el eutor con id: " + id, e);
		}
	}

	@Override
	public Autor agregar(Autor objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");

	}

	@Override
	public Autor modificar(Autor objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");

	}

	@Override
	public void borrar(Integer id) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
		
	}

	@Override
	public Autor obtenerPorTitulo(String titulo) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
		//return null;
	}

	

}
