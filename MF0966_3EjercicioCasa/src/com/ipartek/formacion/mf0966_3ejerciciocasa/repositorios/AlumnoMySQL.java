package com.ipartek.formacion.mf0966_3ejerciciocasa.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Alumno;

public class AlumnoMySQL implements Dao<Alumno> {

	private static final String SQL_GET_ALL = 
			"SELECT * " + 
			"FROM alumno " + 
			"WHERE activo = true\r\n" + 
			"ORDER BY codigo";

	private static final String SQL_GET_BY_CODIGO = 
			"SELECT * \r\n" + 
			"FROM alumno \r\n" + 
			"WHERE codigo=?\r\n"+ 
			"ORDER BY codigo";

	private static String url, usuario, password;

	// SINGLETON

	private static AlumnoMySQL instancia;

	public AlumnoMySQL(String url, String usuario, String password) {
		AlumnoMySQL.url = url;
		AlumnoMySQL.usuario = usuario;
		AlumnoMySQL.password = password;
	}

	public static AlumnoMySQL getInstancia(String pathConfiguracion) {

		try {
			if (instancia == null) {
				
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				instancia = new AlumnoMySQL(configuracion.getProperty("mysql.url"),
						configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
			}
			return instancia;

		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("Fichero de configuración no encontrado", e);
		} catch (IOException e) {
			throw new AccesoDatosException("Fallo de lectura/escritura en el fichero", e);
		}
	}

	// FIN SINGLETON

	private Connection getConexion() {
		try {
			new com.mysql.cj.jdbc.Driver();
			return DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos", e);
		}
	}

	@Override
	public Iterable<Alumno> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)) {
				try (ResultSet rs = ps.executeQuery()) {

					ArrayList<Alumno> alumnos = new ArrayList<>();
					Alumno alumno;
					while (rs.next()) {
						alumno = new Alumno(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("apellidos"),
								rs.getTimestamp("fNacimiento"), rs.getString("direccion"), rs.getString("poblacion"),
								rs.getInt("codigopostal"), rs.getInt("telefono"), rs.getString("email"),
								rs.getString("dni"), rs.getInt("nHermanos"), rs.getBoolean("activo"));
						alumnos.add(alumno);
					}
					return alumnos;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al obtener registros de alumnos", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los alumnos", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos alumnos", e);
		}
	}

	@Override
	public Alumno obtenerPorCodigo(Integer codigo) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_CODIGO)) {
				ps.setInt(1, codigo);
				
				try (ResultSet rs = ps.executeQuery()) {
					Alumno alumno;
					if (rs.next()) {
						alumno = new Alumno(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("apellidos"),
								rs.getTimestamp("fNacimiento"), rs.getString("direccion"), rs.getString("poblacion"),
								rs.getInt("codigopostal"), rs.getInt("telefono"), rs.getString("email"),
								rs.getString("dni"), rs.getInt("nHermanos"), rs.getBoolean("activo"));
						return alumno;
					}else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al obtener registros de alumnos", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los alumnos", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos alumnos", e);
		}
	}

	@Override
	public Alumno agregar(Alumno objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public Alumno modificar(Alumno objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public void borrar(Integer codigo) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

}
