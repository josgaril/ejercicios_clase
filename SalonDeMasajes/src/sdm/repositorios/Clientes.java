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

import sdm.modelos.Cliente;

public class Clientes implements Dao<Cliente> {
	private static final String SQL_GET_ALL = "SELECT * FROM clientes";
	private static final String SQL_GET_BY_ID = "SELECT * FROM clientes WHERE idclientes=?";

	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, dni) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE clientes set nombre=?,apellidos=?,dni=? WHERE idclientes=?";
	private static final String SQL_DELETE = "DELETE FROM clientes WHERE idclientes=?";


	
	private static String url, usuario, password;
	// SINGLETON

	private static Clientes instancia;

	private Clientes(String url, String usuario, String password) {
		Clientes.url = url;
		Clientes.usuario = usuario;
		Clientes.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL");
		}
	}

	public static Clientes getInstancia(String pathConfiguracion) {
		try {
			if (instancia == null) {
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				instancia = new Clientes(configuracion.getProperty("mysql.url"),
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
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Cliente> clientes = new ArrayList<>();

					while (rs.next()) {
						clientes.add(new Cliente(rs.getInt("idclientes"), rs.getString("nombre"),
								rs.getString("apellidos"), rs.getString("dni")));
					}
					return clientes;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener todos los trabajadores", e);
		}
	}

	@Override
	public Cliente obtenerPorId(Integer idclientes) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_ID)) {
				ps.setInt(1, idclientes);

				try (ResultSet rs = ps.executeQuery()) {

					if (rs.next()) {
						return new Cliente(rs.getInt("idclientes"), rs.getString("nombre"), rs.getString("apellidos"),
								rs.getString("dni"));
					} else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener el cliente id: " + idclientes, e);
		}
	}

	@Override
	public void agregar(Cliente cliente) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con
					.prepareStatement(SQL_INSERT)) {
				ps.setString(1, cliente.getNombre());
				ps.setString(2, cliente.getApellidos());
				ps.setString(3, cliente.getDni());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al insertar el cliente", e);
		}
	}

	@Override
	public void modificar(Cliente cliente) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con
					.prepareStatement(SQL_UPDATE)) {
				ps.setString(1, cliente.getNombre());
				ps.setString(2, cliente.getApellidos());
				ps.setString(3, cliente.getDni());
				ps.setInt(4, cliente.getIdclientes());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una update");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al modificar el cliente", e);
		}

	}

	@Override
	public void borrar(Integer idclientes) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
				ps.setLong(1, idclientes);

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una delete");
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al borrar el cliente", e);
		}
	}

}
