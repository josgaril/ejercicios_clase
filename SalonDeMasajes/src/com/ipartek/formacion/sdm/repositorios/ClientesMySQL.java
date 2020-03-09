package com.ipartek.formacion.sdm.repositorios;

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

import com.ipartek.formacion.sdm.modelos.Cliente;

public class ClientesMySQL implements Dao<Cliente> {
	private static final String SQL_SELECT_ALL = "CALL clientesGetAll()";
	private static final String SQL_SELECT_BY_ID = "CALL clientesGetById(?)";

	private static final String SQL_INSERT = "CALL clientesInsert(?,?,?,?)";
	private static final String SQL_UPDATE = "CALL clientesUpdate(?,?,?,?)";
	private static final String SQL_DELETE = "CALL clientesDelete(?)";
	private static final String SQL_MAX_ID = 
			"SELECT idclientes, nombre, apellidos, dni \r\n" + "FROM clientes\r\n" +
			"ORDER BY idclientes DESC\r\n" +
			"LIMIT 1";

	private static String url, usuario, password;
	// SINGLETON

	// Creamos la variable 'instancia'
	private static ClientesMySQL instancia;

	// Constructor privado de ClientesMySQL
	private ClientesMySQL(String url, String usuario, String password) {
		ClientesMySQL.url = url;
		ClientesMySQL.usuario = usuario;
		ClientesMySQL.password = password;

	}

	// Inicializamos la instancia
	public static ClientesMySQL getInstancia(String pathConfiguracion) {
		try {
			// si no existe la instancia..
			if (instancia == null) {
				// obtenemos los datos del archivo de configuración
				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				// ..la creamos con el constructor de ClientesMySQL
				instancia = new ClientesMySQL(configuracion.getProperty("mysql.url"),
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
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (CallableStatement sp = (CallableStatement) con.prepareCall(SQL_SELECT_ALL)) {
				try (ResultSet rs = sp.executeQuery()) {
					ArrayList<Cliente> clientes = new ArrayList<>();

					while (rs.next()) {
						clientes.add(new Cliente(rs.getInt("idclientes"), rs.getString("nombre"),
								rs.getString("apellidos"), rs.getString("dni")));
					}
					return clientes;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de clientes", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los clientes", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los clientes", e);
		}
	}

	@Override
	public Cliente obtenerPorId(Integer idclientes) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_SELECT_BY_ID)) {
				cs.setInt(1, idclientes);

				try (ResultSet rs = cs.executeQuery()) {

					if (rs.next()) {
						return new Cliente(rs.getInt("idclientes"), rs.getString("nombre"), rs.getString("apellidos"),
								rs.getString("dni"));
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de clientes", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener cliente con id: " + idclientes, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el cliente con id: " + idclientes, e);
		}
	}

	@Override
	public Cliente agregar(Cliente cliente) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_INSERT)) {
				cs.setString(1, cliente.getNombre());
				cs.setString(2, cliente.getApellidos());
				cs.setString(3, cliente.getDni());

				cs.registerOutParameter(4, java.sql.Types.INTEGER);

				int numeroRegistrosModificados = cs.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
				return ultimoCliente(cliente);
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Agregar cliente", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para agregar cliente", e);
		}
	}

	private Cliente ultimoCliente(Cliente cliente) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_MAX_ID)) {
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return new Cliente(rs.getInt("idclientes"), rs.getString("nombre"), rs.getNString("apellidos"),
								rs.getString("dni"));
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al obtener el ultimo cliente", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener el ultimo cliente", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el ultimo cliente", e);
		}
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_UPDATE)) {
				cs.setInt(1, cliente.getIdclientes());
				cs.setString(2, cliente.getNombre());
				cs.setString(3, cliente.getApellidos());
				cs.setString(4, cliente.getDni());

				int numeroRegistrosModificados = cs.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una update");
				}
				return cliente;
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Modificar cliente", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para modificar cliente", e);
		}

	}

	@Override
	public void borrar(Integer idclientes) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_DELETE)) {
				cs.setLong(1, idclientes);

				int numeroRegistrosModificados = cs.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una delete");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Borrar cliente con id: " + idclientes, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para eliminar el cliente con id: " + idclientes, e);
		}
	}

}
