package com.ipartek.formacion.MF0966_3Examen.repositorios;

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

import com.ipartek.formacion.MF0966_3Examen.modelos.Curso;
import com.ipartek.formacion.MF0966_3Examen.modelos.Profesor;

public class CursoMySQL implements Dao<Curso> {

	private static final String SQL_SELECT_ALL = "SELECT * \r\n"
			+ "FROM curso c\r\n" + "INNER JOIN profesor p ON c.profesor_codigo=p.codigo ORDER BY c.codigo";

	private static final String SQL_GET_BY_CODIGO = "SELECT * \r\n" + "FROM curso cur\r\n"
			+ "INNER JOIN profesor p ON cur.profesor_codigo = p.codigo\r\n"
			+ "INNER JOIN cliente c ON cur.cliente_codigo = c.codigo WHERE cur.codigo =?";

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
			throw new AccesoDatosException("Error en la conexión a la base de datos");
		}
	}

	@Override
	public Iterable<Curso> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Curso> cursos = new ArrayList<>();

					Profesor profesor;
					Curso curso = null;

					while (rs.next()) {
						
						profesor = new Profesor(rs.getString("p.nombre"), rs.getString("p.apellidos"));
						curso = new Curso(rs.getInt("c.codigo"),rs.getString("c.nombre"), rs.getString("c.identificador"),
								rs.getInt("c.nHoras"), profesor);
						cursos.add(curso);
					}
					return cursos;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de cursos", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los cursos", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los cursos", e);
		}
	}

	@Override
	public Curso obtenerPorId(Integer codigo) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_CODIGO)) {
				ps.setInt(1, codigo);

				try (ResultSet rs = ps.executeQuery()) {

					Profesor profesor;
					Curso curso = null;

					if (rs.next()) {
						profesor = new Profesor(rs.getString("p.nombre"), rs.getString("p.apellidos"));
						curso = (new Curso(rs.getInt("c.codigo"),rs.getString("c.nombre"), rs.getString("c.identificador"),
								rs.getInt("c.nHoras"), profesor));
						return curso;
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de cursos");
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener cursos con id: " + codigo, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener el cursos id: " + codigo, e);
		}
	}


	@Override
	public Curso agregar(Curso objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
		// return null;
	}

	@Override
	public Curso modificar(Curso objeto) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");
		//return null;
	}

	@Override
	public void borrar(Integer id) {
		throw new UnsupportedOperationException("NO ESTA IMPLEMENTADO");

	}

}
