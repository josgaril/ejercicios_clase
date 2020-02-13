package sdm.repositorios;

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

import sdm.modelos.Sesion;
import sdm.modelos.SesionO;

public class SesionesO implements Dao<SesionO> {
	//Bloque de consultas de prueba
	private static final String SQL_SELECT_CLIENTES = "SELECT nombre, apellidos FROM clientes";
	private static final String SQL_SELECT_TRABAJADORES = "SELECT nombre, apellidos FROM trabjadores";
	private static final String SQL_SELECT_SERVICIOS = "SELECT nombre, precio FROM servicios";
	private static final String SQL_SELECT_JOIN = "SELECT sesion.id, CONCAT(c.idclientes, \"-\", c.nombre, \" \", c.apellidos) as cliente , CONCAT(t.nombre, \" \", t.apellidos) as trabajador, s.idservicios as servicio, sesion.fecha as fecha, sesion.resena as resena, sesion.calificacion as calificacion\r\n" + 
			"FROM sesiones sesion\r\n" + 
			"INNER JOIN clientes c ON sesion.clientes_idclientes=c.idclientes\r\n" + 
			"INNER JOIN trabajadores t ON sesion.trabajadores_idtrabajadores=t.idtrabajadores\r\n" + 
			"INNER JOIN servicios s ON sesion.servicios_idservicios=s.idservicios\r\n";
	private static final String SQL_SELECT_JOIN_SEPARADO = 
			"SELECT sesion.id, c.idclientes, c.nombre as Nombre_Cliente, c.apellidos as Apellidos_cliente, t.idtrabajadores, t.nombre as Nombre_trabajador, t.apellidos as Apellidos_trabajador, s.nombre as Nombre_servicio, sesion.fecha as fecha, sesion.resena as resena, sesion.calificacion as calificacion\r\n" + 
			"FROM sesiones sesion\r\n" + 
			"INNER JOIN clientes c ON sesion.clientes_idclientes=c.idclientes\r\n" + 
			"INNER JOIN trabajadores t ON sesion.trabajadores_idtrabajadores=t.idtrabajadores\r\n" + 
			"INNER JOIN servicios s ON sesion.servicios_idservicios=s.idservicios";
	private static final String SQL_INSERT_OBJETOS="INSERT INTO sesiones (id, clientes, trabajadores, servicios,fecha, resena, calificacion) VALUES (?,?,?,?,?,?,?)";
	//Fin bloque de consultas de prueba
	
	private static final String SQL_SELECT = "SELECT * FROM sesiones";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM sesiones WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO sesiones (clientes_idclientes, trabajadores_idtrabajadores, servicios_idservicios, fecha, resena,calificacion) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE sesiones set clientes_idclientes=?, trabajadores_idtrabajadores=?, servicios_idservicios=?, fecha=?, resena=?, calificacion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM sesiones WHERE id=?";

	private static String url, usuario, password;

	private static SesionesO instancia;

	// SINGLETON

	private SesionesO(String url, String usuario, String password) {
		SesionesO.url = url;
		SesionesO.usuario = usuario;
		SesionesO.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL");
		}
	}

	public static SesionesO getInstancia(String pathConfiguracion) {

		try {
			if (instancia == null) {
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));
				instancia = new SesionesO(configuracion.getProperty("mysql.url"),
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
	public Iterable<SesionO> obtenerTodos() {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_JOIN)) {
				ArrayList<SesionO> sesionesO = new ArrayList<>();
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						//Crear ArrayList aqui si usamos Statement en vez de PreparedStatement
						//usamos el constructor genear, con tipos integer, string y fechas...
						sesionesO.add(new SesionO(rs.getString("id"), rs.getString("cliente"), rs.getString("trabajador"),rs.getString("servicio"), rs.getString("fecha"), rs.getString("resena"), rs.getString("calificacion")));
						/* PARA CONSULTA SQL_SELECT_JOIN
						 * sesiones.add(new Sesion(rs.getString("sesion.id"), rs.getString("cliente"),
						 * rs.getString("trabajador"), rs.getString("servicio"), rs.getString("fecha"),
						 * rs.getString("resena"), rs.getString("calificacion")));
						 */
						
						  /*ASI ESTÁ CON LOS NORMALES
						   * sesionesO.add(new SesionO(rs.getInt("id"), rs.getInt("clientes_idclientes"),
						  rs.getInt("trabajadores_idtrabajadores"), rs.getInt("servicios_idservicios"),
						  rs.getDate("fecha"), rs.getString("resena"), rs.getString("calificacion")));*/
						 
					}
					return sesionesO;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todas las sesiones", e);
		}
	}

	@Override
	public SesionO obtenerPorId(Integer id) {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID)) {
				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return  new SesionO(rs.getString("id"), rs.getString("cliente"), rs.getString("trabajador"),rs.getString("servicio"), rs.getString("fecha"), rs.getString("resena"), rs.getString("calificacion"));
						
						/*ASI ESTA CON LOS NORMALES
						 * return new SesionO(rs.getInt("id"), rs.getInt("clientes_idclientes"), rs.getInt("trabajadores_idtrabajadores"), rs.getInt("servicios_idservicios"),
								rs.getDate("fecha"), rs.getString("resena"), rs.getString("calificacion"));*/
					} else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obetner la sesion id: " + id, e);
		}
	}

	@Override
	public void agregar(SesionO sesionO) {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
				ps.setint(1, sesionO.getClienteO());
				ps.setInt(2, sesionO.getTrabajadorO());
				ps.setInt(3, sesionO.getServicioO());
				ps.setDate(4, new java.sql.Date(sesionO.getFecha().getTime()));
				ps.setString(5, sesionO.getResena());
				ps.setString(6, sesionO.getCalificacion());
				
				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al agregar la sesión", e);
		}

	}

	@Override
	public void modificar(SesionO sesionO) {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
				ps.setInt(1, sesionO.getClienteO());
				ps.setInt(2, sesionO.getTrabajadorO());
				ps.setInt(3, sesionO.getServicioO());
				ps.setDate(4, new java.sql.Date(sesionO.getFecha().getTime()));
				ps.setString(5, sesionO.getResena());
				ps.setString(6, sesionO.getCalificacion());
				ps.setInt(7, sesionO.getId());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al modificar la sesión", e);
		}
	}

	@Override
	public void borrar(Integer id) {
		try (Connection con = getConnexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
				ps.setInt(1, id);

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de un delete");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al borrar la sesion id:" + id, e);
		}

	}

}
