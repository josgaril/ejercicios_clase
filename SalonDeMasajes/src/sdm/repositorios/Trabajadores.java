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

import sdm.modelos.Trabajador;

public class Trabajadores implements DaoTrabajador<Trabajador> {
	private static final String SQL_SELECT = "SELECT * FROM trabajadores";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM trabajadores WHERE idtrabajadores=?";
	
	private static final String SQL_INSERT = "INSERT INTO trabajadores (nombre, apellidos, dni) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE trabajadores set nombre=?, apellidos=?, dni=? WHERE idtrabajadores=?";
	private static final String SQL_DELETE = "DELETE FROM trabajadores WHERE idtrabajadores=?";

	private static String url, usuario, password;

	// SINGLETON
	private static Trabajadores instancia;

	private Trabajadores(String url, String usuario, String password) {
		Trabajadores.url = url;
		Trabajadores.usuario = usuario;
		Trabajadores.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL");
		}
	}

	public static Trabajadores getInstancia(String pathConfiguracion) {
		try {
			if (instancia == null) {
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				instancia = new Trabajadores(configuracion.getProperty("mysql.url"),
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

	private Connection getConnection() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos", e);

		}
	}

	@Override
	public Iterable<Trabajador> obtenerTodos() {

		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Trabajador> trabajadores = new ArrayList<>();

					while (rs.next()) {
						trabajadores.add(new Trabajador(rs.getInt("idtrabajadores"), rs.getString("nombre"),
								rs.getString("apellidos"), rs.getString("dni")));
					}
					return trabajadores;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los trabajadores", e);
		}
	}

	@Override
	public Trabajador obtenerPorId(Integer idtrabajadores) {

		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID)) {
				ps.setInt(1, idtrabajadores);
				try (ResultSet rs = ps.executeQuery()) {

					if (rs.next()) {
						return new Trabajador(rs.getInt("idtrabajadores"), rs.getString("nombre"),
								rs.getString("apellidos"), rs.getString("dni"));
					} else {
						return null;
					}
				}
			}
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el trabajador: " + idtrabajadores, e);
		}
	}

	@Override
	public void agregar(Trabajador trabajador) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con
					.prepareStatement(SQL_INSERT)) {
				ps.setString(1, trabajador.getNombre());
				ps.setString(2, trabajador.getApellidos());
				ps.setString(3, trabajador.getDni());

				int numeroRegistrosModificados = ps.executeUpdate();
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de una insert");
				}
			}
		} catch (Exception e) {
			throw new AccesoDatosException("Error al agregar el trabajador", e);
		}
	}

	@Override
	public void modificar(Trabajador trabajador) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con
					.prepareStatement(SQL_UPDATE)) {
				ps.setString(1, trabajador.getNombre());
				ps.setString(2, trabajador.getApellidos());
				ps.setString(3, trabajador.getDni());
				ps.setInt(4, trabajador.getIdtrabajadores());

				int numeroRegistrosModificados = ps.executeUpdate();
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de un update");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al modificar el trabajador");
		}
	}

	@Override
	public void borrar(Integer idtrabajadores) {
		try (Connection con = getConnection()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
				ps.setInt(1, idtrabajadores);

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una delete");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al borrar el trabajador", e);
		}
	}
}
