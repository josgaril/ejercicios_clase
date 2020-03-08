package com.ipartek.formacion.sdm.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.sdm.modelos.Sesion;

public class SesionesMySQL implements Dao<Sesion> {

	private static final String SQL_GET_ALL = "SELECT * FROM sesiones";
	private static final String SQL_GET_BY_ID = "SELECT * FROM sesiones WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO sesiones (clientes_idclientes, trabajadores_idtrabajadores, servicios_idservicios, fecha, resena,calificacion) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE sesiones set clientes_idclientes=?, trabajadores_idtrabajadores=?, servicios_idservicios=?, fecha=?, resena=?, calificacion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM sesiones WHERE id=?";

	private static String url, usuario, password;

	private static SesionesMySQL instancia;

	// SINGLETON

	private SesionesMySQL(String url, String usuario, String password) {
		SesionesMySQL.url = url;
		SesionesMySQL.usuario = usuario;
		SesionesMySQL.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL");
		}
	}

	public static SesionesMySQL getInstancia(String pathConfiguracion) {

		try {
			if (instancia == null) {
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));
				instancia = new SesionesMySQL(configuracion.getProperty("mysql.url"),
						configuracion.getProperty("mysql.usuario"), configuracion.getProperty("mysql.password"));
			}
			return instancia;

		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el fichero de configuración", e);
		} catch (IOException e) {
			throw new AccesoDatosException("Fallo de lectura/escritura al fichero", e);
		}

	}
	// FIN SINGLETON

	private Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Error al conectar con la base de datos", e);
		}
	}

	@Override
	public Iterable<Sesion> obtenerTodos() {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)) {
				ArrayList<Sesion> sesiones = new ArrayList<>();
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						sesiones.add(new Sesion(rs.getInt("id"), rs.getInt("clientes_idclientes"),
								rs.getInt("trabajadores_idtrabajadores"), rs.getInt("servicios_idservicios"),
								rs.getTimestamp("fecha"), rs.getString("resena"), rs.getString("calificacion")));

					}
					return sesiones;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al obtener los registros de sesiones", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todas las sesiones", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todas las sesiones", e);
		}
	}

	@Override
	public Sesion obtenerPorId(Integer id) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID)) {
				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return new Sesion(rs.getInt("id"), rs.getInt("clientes_idclientes"),
								rs.getInt("trabajadores_idtrabajadores"), rs.getInt("servicios_idservicios"),
								rs.getTimestamp("fecha"), rs.getString("resena"), rs.getString("calificacion"));
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al obtener los registros de sesiones", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener sesion id: " + id, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener la sesion id: " + id, e);
		}
	}

	@Override
	public void agregar(Sesion sesion) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
				ps.setInt(1, sesion.getClientes_idclientes());
				ps.setInt(2, sesion.getTrabajadores_idtrabajadores());
				ps.setInt(3, sesion.getServicios_idservicios());
				ps.setTimestamp(4, new Timestamp(sesion.getFecha().getTime()));
				ps.setString(5, sesion.getResena());
				ps.setString(6, sesion.getCalificacion());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Agregar sesión", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para agregar sesión", e);
		}

	}

	@Override
	public void modificar(Sesion sesion) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
				ps.setInt(1, sesion.getClientes_idclientes());
				ps.setInt(2, sesion.getTrabajadores_idtrabajadores());
				ps.setInt(3, sesion.getServicios_idservicios());
				ps.setTimestamp(4, new Timestamp(sesion.getFecha().getTime()));
				ps.setString(5, sesion.getResena());
				ps.setString(6, sesion.getCalificacion());
				ps.setInt(7, sesion.getId());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Modificar sesión", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para modificar la sesión", e);
		}
	}

	@Override
	public void borrar(Integer id) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
				ps.setInt(1, id);

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de un delete");
				}
			}catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Borrar sesion id:" + id, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para borrar la sesion id:" + id, e);
		}
	}

}
