package com.ipartek.formacion.sdm.repositorios;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.sdm.modelos.Cliente;

public class ClientesPoolMySQL implements Dao<Cliente> {

	private static final String SQL_GET_ALL = "CALL clientesGetAll()";

	private static final String SQL_GET_BY_ID = "CALL clientesGetById(?)";

	private static final String SQL_INSERT = "CALL clientesInsert(?,?,?,?)";

	private final String url, usuario, password;

	private static DataSource pool;

	// "SINGLETON"
	private ClientesPoolMySQL(String url, String usuario, String password) {
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}

	private static ClientesPoolMySQL instancia;

	/**
	 * Se usará para inicializar la instancia
	 * 
	 * @param url
	 * @param usuario
	 * @param password
	 * @return La instancia
	 */
	public static ClientesPoolMySQL getInstancia(String url, String usuario, String password) {
		// Si no existe la instancia...
		if (instancia == null) {
			// ...la creamos
			instancia = new ClientesPoolMySQL(url, usuario, password);
			// Si existe la instancia, pero sus valores no concuerdan...
		} else if (!instancia.url.equals(url) || !instancia.usuario.equals(usuario)
				|| !instancia.password.contentEquals(password)) {
			// ...lanzar un error
			throw new AccesoDatosException("No se pueden cambiar los valores de la instancia una vez inicializada");
		}

		// Devolver la instancia recién creada o la existente (cuyos datos coinciden con
		// los que tiene)
		return instancia;
	}

	/**
	 * Se usará para recuperar la instancia ya existente
	 * 
	 * @return devuelve la instancia ya existente
	 */
	public static ClientesPoolMySQL getInstancia() {
		// Si no existe la instancia...
		if (instancia == null) {
			// ...no se puede obtener porque no sabemos los datos de URL, usuario y password
			throw new AccesoDatosException("Necesito que me pases URL, usuario y password");
		}

		// Si ya existe, se devuelve
		return instancia;
	}

	/**
	 * Usaremos un pool de conexiones determinado
	 * 
	 * @return devuelve la instancia del pool de conexiones
	 */
	public static ClientesPoolMySQL getInstancia(String entorno) {
		InitialContext initCtx;
		try {
			initCtx = new InitialContext();

			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource dataSource = (DataSource) envCtx.lookup(entorno);

			ClientesPoolMySQL.pool = dataSource;

			if(instancia == null) {
				instancia = new ClientesPoolMySQL(null, null, null);
			}
			
			return instancia;
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha podido conectar al Pool de conexiones " + entorno);
		}
	}
	// FIN "SINGLETON"

	private Connection getConexion() {
		try {
			if (pool == null) {
				new com.mysql.cj.jdbc.Driver();
				return DriverManager.getConnection(url, usuario, password);
			} else {
				return pool.getConnection();
			}
		} catch (SQLException e) {
			System.err
					.println("IPARTEK: Error de conexión a la base de datos: " + url + ":" + usuario + ":" + password);
			e.printStackTrace();

			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (CallableStatement s = con.prepareCall(SQL_GET_ALL)) {
				try (ResultSet rs = s.executeQuery()) {
					ArrayList<Cliente> clientes = new ArrayList<>();

					Cliente cliente;

					while (rs.next()) {
						cliente = new Cliente(rs.getInt("idclientes"), rs.getString("nombre"),
								rs.getString("apellidos"), rs.getString("dni"));

						clientes.add(cliente);
					}

					return clientes;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error al crear la sentencia", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar", e);
		}
	}

	@Override
	public Cliente obtenerPorId(Integer id) {
		try (Connection con = getConexion()) {
			try (CallableStatement s = con.prepareCall(SQL_GET_BY_ID)) {
				s.setInt(1, id);
				try (ResultSet rs = s.executeQuery()) {
					Cliente cliente = null;

					if (rs.next()) {
						cliente = new Cliente(rs.getInt("idclientes"), rs.getString("nombre"),
								rs.getString("apellidos"), rs.getString("dni"));
					}

					return cliente;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error al crear la sentencia", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar", e);
		}
	}

	@Override
	public void agregar(Cliente cliente) {
		try (Connection con = getConexion()) {
			try (CallableStatement s = con.prepareCall(SQL_INSERT)) {
				s.setString(1, cliente.getNombre());
				s.setString(2, cliente.getApellidos());
				s.setString(3, cliente.getDni());

				s.registerOutParameter(4, java.sql.Types.INTEGER);

				int numeroRegistrosModificados = s.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Número de registros modificados: " + numeroRegistrosModificados);
				}

			} catch (SQLException e) {
				throw new AccesoDatosException("Error al crear la sentencia", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar", e);
		}
	}
	
	@Override
	public void modificar(Cliente objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public void borrar(Integer id) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

}
