package com.ipartek.formacion.MF0966_3Examen.repositorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.MF0966_3Examen.modelos.Alumno;
import com.ipartek.formacion.MF0966_3Examen.modelos.Curso;
import com.ipartek.formacion.MF0966_3Examen.modelos.Profesor;
import com.ipartek.formacion.MF0966_3Examen.modelos.Resena;

public class ResenaMySQL implements Dao<Resena> {

	private static final String SQL_SELECT_ALL = "SELECT * \r\n" + "FROM resena r\r\n"
			+ "INNER JOIN curso c ON r.curso_codigo = c.codigo\r\n"
			+ "INNER JOIN profesor p ON c.profesor_codigo=p.codigo\r\n"
			+ "INNER JOIN alumno a ON r.alumno_codigo = a.codigo";
	private static final String SQL_SELECT_BY_ID = "SELECT * \r\n" + "FROM resena r\r\n"
			+ "INNER JOIN curso c ON r.curso_codigo = c.codigo\r\n"
			+ "INNER JOIN profesor p ON c.profesor_codigo=p.codigo\r\n"
			+ "INNER JOIN alumno a ON r.alumno_codigo = a.codigo\r\n" + "WHERE r.id= ?";
	private static final String SQL_INSERT = "INSERT INTO resena (resena, curso_codigo, alumno_codigo) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE resena set resena=?, curso_codigo=?, alumno_codigo=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM resena WHERE id=?";

	private static String url, usuario, password;
	// SINGLETON

	private static ResenaMySQL instancia;

	private ResenaMySQL(String url, String usuario, String password) {
		ResenaMySQL.url = url;
		ResenaMySQL.usuario = usuario;
		ResenaMySQL.password = password;

	}

	public static ResenaMySQL getInstancia(String pathConfiguracion) {
		try {

			if (instancia == null) {

				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguracion));

				instancia = new ResenaMySQL(configuracion.getProperty("mysql.url"),
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
	public Iterable<Resena> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Resena> resenas = new ArrayList<>();

					Curso curso;
					Alumno alumno;
					Profesor profesor;
					Resena resena = null;

					while (rs.next()) {

						alumno = new Alumno(rs.getInt("a.codigo"), rs.getString("a.nombre"),
								rs.getString("a.apellidos"), rs.getDate("a.fNacimiento"), rs.getString("a.direccion"),
								rs.getString("a.poblacion"), rs.getInt("a.codigopostal"), rs.getInt("a.telefono"),
								rs.getString("email"), rs.getString("dni"), rs.getInt("nHermanos"),
								rs.getBoolean("activo"));
						profesor = new Profesor(rs.getString("p.nombre"), rs.getString("p.apellidos"));
						curso = new Curso(rs.getInt("c.codigo"), rs.getString("c.nombre"),
								rs.getString("c.identificador"), rs.getInt("c.nHoras"), profesor);

						resena = new Resena(rs.getInt("r.id"), rs.getString("r.resena"), curso, alumno);
						resenas.add(resena);
					}
					return resenas;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de resenas", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos las resenas", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los resenas", e);
		}
	}

	@Override
	public Resena obtenerPorId(Integer id) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_SELECT_BY_ID)) {
				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {

					Curso curso;
					Alumno alumno;
					Profesor profesor;
					Resena resena = null;

					if (rs.next()) {
						alumno = new Alumno(rs.getInt("a.codigo"), rs.getString("a.nombre"),
								rs.getString("a.apellidos"), rs.getDate("a.fNacimiento"), rs.getString("a.direccion"),
								rs.getString("a.poblacion"), rs.getInt("a.codigopostal"), rs.getInt("a.telefono"),
								rs.getString("email"), rs.getString("dni"), rs.getInt("nHermanos"),
								rs.getBoolean("activo"));
						profesor = new Profesor(rs.getString("p.nombre"), rs.getString("p.apellidos"));
						curso = new Curso(rs.getInt("c.codigo"), rs.getString("c.nombre"),
								rs.getString("c.identificador"), rs.getInt("c.nHoras"), profesor);

						resena = new Resena(rs.getInt("r.id"), rs.getString("r.resena"), curso, alumno);
						return resena;
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de resenas", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener resena con id: " + id, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener la resena con id: " + id, e);
		}
	}

	@Override
	public Resena agregar(Resena resena) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

				ps.setString(1, resena.getResena());
				ps.setInt(2, resena.getCurso().getCodigo());
				ps.setInt(3, resena.getAlumno().getCodigo());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}

				Integer idGenerado = null;
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					idGenerado = generatedKeys.getInt(1);
				}
				resena.setId(idGenerado);
				return resena;
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Agregar sesión", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para agregar la sesión", e);
		}
	}

	@Override
	public Resena modificar(Resena resena) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {

				ps.setString(1, resena.getResena());
				ps.setInt(2, resena.getCurso().getCodigo());
				ps.setInt(3, resena.getAlumno().getCodigo());
				ps.setInt(4, resena.getId());

				int numeroRegistrosModificados = ps.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho más o menos de una insert");
				}
				return resena;
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Modificar sesión", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para modificar la sesión", e);
		}
	}

	@Override
	public void borrar(Integer id) {
		try (Connection con = getConexion()) {
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
