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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.sdm.jaxrs.Cliente;
import com.ipartek.formacion.sdm.jaxrs.Servicio;
import com.ipartek.formacion.sdm.jaxrs.Sesion;
import com.ipartek.formacion.sdm.jaxrs.Trabajador;

public class SesionesMySQL implements Dao<Sesion> {

	private static final String SQL_GET_ALL = "SELECT *\r\n" + "FROM sesiones sesion\r\n"
			+ "INNER JOIN clientes c ON sesion.clientes_idclientes=c.idclientes\r\n"
			+ "INNER JOIN trabajadores t ON sesion.trabajadores_idtrabajadores=t.idtrabajadores\r\n"
			+ "INNER JOIN servicios s ON sesion.servicios_idservicios=s.idservicios\r\n" + "ORDER BY sesion.id";

	private static final String SQL_GET_BY_ID = "	SELECT *\r\n" + "			FROM sesiones sesion\r\n"
			+ "			INNER JOIN clientes c ON sesion.clientes_idclientes=c.idclientes\r\n"
			+ "			INNER JOIN trabajadores t ON sesion.trabajadores_idtrabajadores=t.idtrabajadores\r\n"
			+ "			INNER JOIN servicios s ON sesion.servicios_idservicios=s.idservicios\r\n"
			+ "            WHERE sesion.id = ?\r\n" + "            ORDER BY sesion.id;";
	// "SELECT * FROM sesiones WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO sesiones (clientes_idclientes, trabajadores_idtrabajadores, servicios_idservicios, fecha, resena,calificacion) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE sesiones set clientes_idclientes=?, trabajadores_idtrabajadores=?, servicios_idservicios=?, fecha=?, resena=?, calificacion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM sesiones WHERE id=?";

	private static String url, usuario, password;

	// SINGLETON
	private static SesionesMySQL instancia;

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

	private Connection getConnexion() throws SQLException {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Error al conectar con la base de datos", e);
		}
	}

	@Override
	public Iterable<Sesion> obtenerTodos() {
		try (Connection con = getConnexion()) {
			try (Statement s = con.createStatement()) {
				try (ResultSet rs = s.executeQuery(SQL_GET_ALL)) {
					ArrayList<Sesion> sesiones = new ArrayList<>();
					Cliente cliente;
					Trabajador trabajador;
					Servicio servicio;
					Sesion sesion;

					while (rs.next()) {
						// Crear ArrayList aqui si usamos Statement en vez de PreparedStatement
						// usamos el constructor general, con tipos integer, string y fechas...

						cliente = new Cliente(rs.getInt("clientes_idclientes"), rs.getString("c.nombre"),
								rs.getString("c.apellidos"), rs.getString("c.dni"));
						trabajador = new Trabajador(rs.getInt("trabajadores_idtrabajadores"), rs.getString("t.nombre"),
								rs.getString("t.apellidos"), rs.getString("t.dni"));
						servicio = new Servicio(rs.getInt("servicios_idservicios"), rs.getString("s.nombre"),
								rs.getBigDecimal("s.precio"));
						sesion = (new Sesion(rs.getInt("id"), cliente, trabajador, servicio, rs.getTimestamp("fecha"),
								rs.getString("resena"), rs.getString("calificacion")));

						sesiones.add(sesion);
					}
					return sesiones;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de sesiones", e);
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
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID)) {
				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {
					Cliente cliente;
					Trabajador trabajador;
					Servicio servicio;
					Sesion sesion = null;

					if (rs.next()) {
						cliente = new Cliente(rs.getInt("clientes_idclientes"), rs.getString("c.nombre"),
								rs.getString("c.apellidos"), rs.getString("c.dni"));
						trabajador = new Trabajador(rs.getInt("trabajadores_idtrabajadores"), rs.getString("t.nombre"),
								rs.getString("t.apellidos"), rs.getString("t.dni"));
						servicio = new Servicio(rs.getInt("servicios_idservicios"), rs.getString("s.nombre"),
								rs.getBigDecimal("s.precio"));
						sesion = new Sesion(rs.getInt("id"), cliente, trabajador, servicio, rs.getTimestamp("fecha"),
								rs.getString("resena"), rs.getString("calificacion"));

						return sesion;
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de sesiones ");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener sesion con id: " + id, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener la sesion id: " + id, e);
		}
	}

	@Override
	public Sesion agregar(Sesion sesion) {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS)) {
				ps.setInt(1, sesion.getCliente().getIdclientes());
				ps.setInt(2, sesion.getTrabajador().getIdtrabajadores());
				ps.setInt(3, sesion.getServicio().getIdservicios());
				ps.setTimestamp(4, new Timestamp(sesion.getFecha().getTime()));
				ps.setString(5, sesion.getResena());
				ps.setString(6, sesion.getCalificacion());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
				Integer idGenerado=null;
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if(generatedKeys.next()) {
					 idGenerado= generatedKeys.getInt(1);
				}
				sesion.setId(idGenerado);
				return sesion;
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Agregar sesión", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para agregar la sesión", e);
		}

	}

	@Override
	public Sesion modificar(Sesion sesion) {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
				ps.setInt(1, sesion.getCliente().getIdclientes());
				ps.setInt(2, sesion.getTrabajador().getIdtrabajadores());
				ps.setInt(3, sesion.getServicio().getIdservicios());
				ps.setTimestamp(4, new Timestamp(sesion.getFecha().getTime()));
				ps.setString(5, sesion.getResena());
				ps.setString(6, sesion.getCalificacion());
				ps.setInt(7, sesion.getId());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
				return sesion;
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Modificar sesión", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para modificar la sesión", e);
		}
	}

	@Override
	public void borrar(Integer id) {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {

				ps.setInt(1, id);

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Número de registros modificados: " + numeroRegistrosModificados);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error al crear la sentencia Borrar sesion con id: " + id, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para borrar la sesión con id: " + id, e);
		}
	}

}
