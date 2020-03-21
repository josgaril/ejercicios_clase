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

import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Cliente;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Curso;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Profesor;

public class CursoMySQL implements Dao<Curso> {

	private static final String SQL_GET_ALL = 
			  "SELECT * \r\n" 
			+ "FROM curso c\r\n"
			+ "INNER JOIN profesor p ON c.profesor_codigo = p.codigo\r\n"
			+ "INNER JOIN cliente cl ON c.cliente_codigo = cl.codigo\r\n"
			+ "ORDER BY c.codigo";

	private static final String SQL_GET_BY_CODIGO = 
			  "SELECT * \r\n" 
			+ "FROM curso c\r\n"
			+ "INNER JOIN profesor p ON c.profesor_codigo = p.codigo\r\n"
			+ "INNER JOIN cliente cl ON c.cliente_codigo = cl.codigo\r\n" 
			+ "WHERE c.codigo=?";

	private static String url, usuario, password;

	// SINGLETON

	private static CursoMySQL instancia;

	private CursoMySQL(String url, String usuario, String password) {
		CursoMySQL.url = url;
		CursoMySQL.usuario = usuario;
		CursoMySQL.password = password;
	}

	public static CursoMySQL getInstancia(String pathConfiguracion) {

		try {
			if (instancia == null) {

				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				instancia = new CursoMySQL(configuracion.getProperty("mysql.url"),
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
			new com.mysql.cj.jdbc.Driver();
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos", e);
		}
	}

	@Override
	public Iterable<Curso> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Curso> cursos = new ArrayList<>();

					Profesor profesor;
					Cliente cliente;
					Curso curso;
					while (rs.next()) {
						profesor = new Profesor(rs.getInt("p.codigo"), rs.getLong("p.nss"), rs.getString("p.nombre"),
								rs.getString("p.apellidos"), rs.getTimestamp("p.fNacimiento"), rs.getString("p.dni"),
								rs.getString("p.direccion"), rs.getString("p.poblacion"), rs.getInt("p.codigopostal"),
								rs.getInt("p.telefono"), rs.getString("p.email"), rs.getBoolean("p.activo"));
						cliente = new Cliente(rs.getInt("cl.codigo"), rs.getString("cl.nombre"),
								rs.getString("cl.email"), rs.getInt("cl.telefono"), rs.getString("cl.direccion"),
								rs.getString("cl.poblacion"), rs.getInt("cl.codigopostal"),
								rs.getString("cl.identificador"), rs.getBoolean("cl.activo"));
						curso = new Curso(rs.getInt("c.codigo"), rs.getString("c.nombre"),
								rs.getString("c.identificador"), rs.getTimestamp("c.fInicio"),
								rs.getTimestamp("c.fFin"), rs.getInt("c.nHoras"), rs.getString("c.temario"),
								rs.getBoolean("c.activo"), cliente, rs.getBigDecimal("c.precio"), profesor);
						cursos.add(curso);
					}
					return cursos;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al accedor a los registros de cursos",e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los cursos", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los cursos", e);
		}
	}

	@Override
	public Curso obtenerPorCodigo(Integer codigo) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_CODIGO)) {
				ps.setInt(1, codigo);

				try (ResultSet rs = ps.executeQuery()) {
					
					Profesor profesor;
					Cliente cliente;
					Curso curso;
					if (rs.next()) {
						profesor = new Profesor(rs.getInt("p.codigo"), rs.getLong("p.nss"), rs.getString("p.nombre"),
								rs.getString("p.apellidos"), rs.getTimestamp("p.fNacimiento"), rs.getString("p.dni"),
								rs.getString("p.direccion"), rs.getString("p.poblacion"), rs.getInt("p.codigopostal"),
								rs.getInt("p.telefono"), rs.getString("p.email"), rs.getBoolean("p.activo"));
						cliente = new Cliente(rs.getInt("cl.codigo"), rs.getString("cl.nombre"),
								rs.getString("cl.email"), rs.getInt("cl.telefono"), rs.getString("cl.direccion"),
								rs.getString("cl.poblacion"), rs.getInt("cl.codigopostal"),
								rs.getString("cl.identificador"), rs.getBoolean("cl.activo"));
						curso = new Curso(rs.getInt("c.codigo"), rs.getString("c.nombre"),
								rs.getString("c.identificador"), rs.getTimestamp("c.fInicio"),
								rs.getTimestamp("c.fFin"), rs.getInt("c.nHoras"), rs.getString("c.temario"),
								rs.getBoolean("c.activo"), cliente, rs.getBigDecimal("c.precio"), profesor);
						return curso;
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al accedor a los registros de cursos",e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener curso: " + codigo, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el curso: " + codigo, e);
		}
	}

	@Override
	public Curso agregar(Curso curso) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public Curso modificar(Curso curso) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

	@Override
	public void borrar(Integer codigo) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
	}

}
