package com.ipartek.formacion.sdm.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.sdm.jaxrs.Servicio;

 class ServiciosMySQL implements Dao<Servicio> {
		private static final String SQL_GET_ALL= "SELECT * FROM servicios";
		private static final String SQL_GET_BY_ID = "SELECT * FROM servicios WHERE idservicios=?";

		private static final String SQL_INSERT = "INSERT INTO servicios (nombre, precio) VALUES (?,?)";
		private static final String SQL_UPDATE = "UPDATE servicios set nombre=?,precio=? WHERE idservicios=?";
		private static final String SQL_DELETE = "DELETE FROM servicios WHERE idservicios=?";

	private static String url, usuario, password;
	// SINGLETON

	private static ServiciosMySQL instancia;

	private ServiciosMySQL(String url, String usuario, String password) {
		ServiciosMySQL.url = url;
		ServiciosMySQL.usuario = usuario;
		ServiciosMySQL.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL");
		}
	}

	public static ServiciosMySQL getInstancia(String pathConfiguracion) {
		try {
			if (instancia == null) {
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				instancia = new ServiciosMySQL(configuracion.getProperty("mysql.url"),
						configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
			}

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
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos");
		}
	}

	@Override
	public Iterable<Servicio> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Servicio> servicios = new ArrayList<>();

					while (rs.next()) {
						servicios.add(new Servicio(rs.getInt("idservicios"), rs.getString("nombre"),
								rs.getBigDecimal("precio")));
					}
					return servicios;
				}catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a a los registros de servicios", e);
				}
			}catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los servicios", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los servicios", e);
		}
	}

	@Override
	public Servicio obtenerPorId(Integer idservicios) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID)) {
				ps.setInt(1, idservicios);

				try (ResultSet rs = ps.executeQuery()) {

					if (rs.next()) {
						return new Servicio(rs.getInt("idservicios"), rs.getString("nombre"),
								rs.getBigDecimal("precio"));
					} else {
						return null;
					}
				}catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de servicios", e);
				}
			}catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener servicio con id: " + idservicios, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el servicio id: " + idservicios, e);
		}
	}

	@Override
	public Servicio agregar(Servicio servicio) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con
					.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS)) {
				ps.setString(1, servicio.getNombre());
				ps.setBigDecimal(2, servicio.getPrecio());

				int numeroRegistrosModificados = ps.executeUpdate();
			
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
				
				Integer idGenerado=null;
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if(generatedKeys.next()) {
					 idGenerado= generatedKeys.getInt(1);
				}
				servicio.setIdservicios(idGenerado);
				return servicio;
				
			}catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Agregar servicio", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para agregar servicio", e);
		}
	}

	@Override
	public Servicio modificar(Servicio servicio) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con
					.prepareStatement(SQL_UPDATE)) {
				ps.setString(1, servicio.getNombre());
				ps.setBigDecimal(2, servicio.getPrecio());
				ps.setInt(3, servicio.getIdservicios());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una update");
				}
				return servicio;
			}catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Modificar servicio", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para modificar el servicio", e);
		}

	}

	@Override
	public void borrar(Integer idservicios) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
				ps.setInt(1, idservicios);

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una delete");
				}
			}catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Borrar servicio con id: " + idservicios, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para borrar el servicio con id: " + idservicios, e);
		}
	}

}
