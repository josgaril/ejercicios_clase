package sdm.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import sdm.modelos.Sesion;

public class Sesiones implements Dao<Sesion> {
	private static final String SQL_SELECT = "SELECT * FROM sesiones";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM sesiones WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO sesiones (clientes_idclientes, trabajadores_idtrabajadores, servicios_idservicios, fecha, resena,calificacion) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE FROM sesiones SET id=?, clientes_idclientes=?, trabajadores_idtrabajadores=?, servicios_idservicios=?, fecha=?, resena=?, calificacion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM sesiones WHERE id=?";

	private static String url, usuario, password;

	private static Sesiones instancia;

	// SINGLETON

	private Sesiones(String url, String usuario, String password) {
		Sesiones.url = url;
		Sesiones.usuario = usuario;
		Sesiones.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL");
		}
	}

	public static Sesiones getInstancia(String pathConfiguracion) {

		try {
			if (instancia == null) {
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));
				instancia = new Sesiones(configuracion.getProperty("mysql.url"),
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
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
				ArrayList<Sesion> sesiones = new ArrayList<>();
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						sesiones.add(new Sesion(rs.getInt("id"), rs.getClass(), rs.getClass(), rs.getClass(),
								rs.getDate("fecha")), rs.getString("resena"), rs.getString("calificacion"));
					}
					return sesiones;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todas las sesiones", e);
		}
	}

	@Override
	public Sesion obtenerPorId(Integer id) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID)) {
				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return new Sesion(id, clientes_idclientes, trabajadores_idtrabajadores, servicios_idservicios,
								fecha, resena, calificacion);
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
	public void agregar(Sesion sesion) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
				ps.setTipoClaseCliente(1, clientes.idclientes .getClientes_idclientes());
				ps.setInt(1, "SELECT id FROM sesiones where id=1");
				ps.setTipoClaseTrabajador(2, sesion.getTrabajadores_idtrabajadores());
				ps.setTipoClaseServicio(3, sesion.getServicios_idservicios());
				ps.setDate(4, (Date) sesion.getFecha());
				ps.setString(5, sesion.getResena());
				ps.setString(6, sesion.getCalificacion());
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al agregar la sesión", e);
		}

	}

	@Override
	public void modificar(Sesion sesion) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
				ps.setTipoClaseCliente(1, sesion.getClientes_idclientes());
				ps.setTipoClaseTrabajador(2, sesion.getTrabajadores_idtrabajadores());
				ps.setTipoClaseServicio(3, sesion.getServicios_idservicios());
				ps.setDate(4, (Date) sesion.getFecha());
				ps.setString(5, sesion.getResena());
				ps.setString(6, sesion.getCalificacion());
				ps.setInt(7, sesion.getId());

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
		try (Connection con = getConnection()) {
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
