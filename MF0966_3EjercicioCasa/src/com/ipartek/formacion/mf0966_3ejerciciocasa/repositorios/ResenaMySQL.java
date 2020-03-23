package com.ipartek.formacion.mf0966_3ejerciciocasa.repositorios;

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

import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Alumno;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Cliente;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Curso;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Profesor;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Resena;

public class ResenaMySQL implements ResenaDao {
	// private static final String SQL_GET_ALL = "SELECT * FROM resena";

	private static final String SQL_GET_ALL = "SELECT * \r\n" + "FROM resena r \r\n"
			+ "INNER JOIN alumno a ON a.codigo = r.alumno_codigo\r\n"
			+ "INNER JOIN curso c ON c.codigo = r.curso_codigo\r\n"
			+ "INNER JOIN profesor p ON p.codigo = c.profesor_codigo\r\n"
			+ "INNER JOIN cliente cl ON cl.codigo = c.cliente_codigo\r\n" + "ORDER BY r.codigo";

	private static final String SQL_GET_BY_CODIGO = "SELECT * \r\n" + "FROM resena r\r\n"
			+ "INNER JOIN alumno a ON a.codigo = r.alumno_codigo\r\n"
			+ "INNER JOIN curso c ON c.codigo = r.curso_codigo\r\n"
			+ "INNER JOIN profesor p ON p.codigo = c.profesor_codigo\r\n"
			+ "INNER JOIN cliente cl ON cl.codigo = c.cliente_codigo\r\n" + "WHERE r.codigo=?\r\n";

	private static final String SQL_INSERT = "Call resenaCreate(?,?,?,?)";
	private static final String SQL_UPDATE = "Call resenaUpdate(?,?,?,?)";
	private static final String SQL_DELETE = "Call resenaDelete(?)";

	private static final String SQL_GET_BY_CODIGO_CURSO = 
			"SELECT c.codigo AS codigoCurso,a.nombre AS nombreAlumno, a.apellidos AS apellidosAlumno, r.comentario AS comentarioResena\r\n" + 
			"FROM resena r \r\n" + 
			"INNER JOIN curso c ON r.curso_codigo = c.codigo \r\n" + 
			"INNER JOIN profesor p ON c.profesor_codigo=p.codigo \r\n" + 
			"INNER JOIN alumno a ON r.alumno_codigo = a.codigo\r\n" + 
			"WHERE c.codigo=?\r\n" + 
			"ORDER BY apellidosAlumno, nombreAlumno";

	private static String url, usuario, password;

	// SINGLETON

	private static ResenaMySQL instancia;

	private ResenaMySQL(String url, String usuario, String password) {
		ResenaMySQL.url = url;
		ResenaMySQL.usuario = usuario;
		ResenaMySQL.password = password;
	}

	public static ResenaMySQL getInstancia(String pathConfiguration) {
		try {
			if (instancia == null) {

				Properties configuracion = new Properties();
				configuracion.load(new FileInputStream(pathConfiguration));

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
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la conexión a la base de datos");
		}
	}

	@Override
	public Iterable<Resena> obtenerTodos() {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)) {
				try (ResultSet rs = ps.executeQuery()) {

					ArrayList<Resena> resenas = new ArrayList<>();

					Resena resena;
					Alumno alumno;
					Cliente cliente;
					Profesor profesor;
					Curso curso;

					while (rs.next()) {
						alumno = new Alumno(rs.getInt("a.codigo"), rs.getString("a.nombre"),
								rs.getString("a.apellidos"), rs.getTimestamp("a.fNacimiento"),
								rs.getString("a.direccion"), rs.getString("a.poblacion"), rs.getInt("a.codigopostal"),
								rs.getInt("a.telefono"), rs.getString("a.email"), rs.getString("a.dni"),
								rs.getInt("a.nHermanos"), rs.getBoolean("a.activo"));

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

						resena = new Resena(rs.getInt("r.codigo"), alumno, curso, rs.getString("r.comentario"));
						resenas.add(resena);
					}
					return resenas;
				} catch (Exception e) {
					throw new AccesoDatosException("Error al accceder a los registros de reseñas", e);
				}
			} catch (Exception e) {
				throw new AccesoDatosException("Error en las entencia Obtener todas las reseñas", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todas las reseñas", e);
		}
	}

	@Override
	public Resena obtenerPorCodigo(Integer codigo) {
		try (Connection con = getConexion()) {
			try (PreparedStatement ps = con.prepareStatement(SQL_GET_BY_CODIGO)) {
				ps.setInt(1, codigo);

				try (ResultSet rs = ps.executeQuery()) {

					Resena resena;
					Alumno alumno;
					Cliente cliente;
					Profesor profesor;
					Curso curso;

					if (rs.next()) {
						alumno = new Alumno(rs.getInt("a.codigo"), rs.getString("a.nombre"),
								rs.getString("a.apellidos"), rs.getTimestamp("a.fNacimiento"),
								rs.getString("a.direccion"), rs.getString("a.poblacion"), rs.getInt("a.codigopostal"),
								rs.getInt("a.telefono"), rs.getString("a.email"), rs.getString("a.dni"),
								rs.getInt("a.nHermanos"), rs.getBoolean("a.activo"));

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

						resena = new Resena(rs.getInt("r.codigo"), alumno, curso, rs.getString("r.comentario"));
						return resena;
					} else {
						return null;
					}
				} catch (Exception e) {
					throw new AccesoDatosException("Error al accceder a los registros de reseñas", e);
				}
			} catch (Exception e) {
				throw new AccesoDatosException("Error en las sentencia Obtener reseña: " + codigo, e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener la reseña: " + codigo, e);
		}
	}

	@Override
	public Resena agregar(Resena resena) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_INSERT)) {

				cs.setInt(1, resena.getAlumno().getCodigo());
				cs.setInt(2, resena.getCurso().getCodigo());
				cs.setString(3, resena.getComentario());
				cs.registerOutParameter(4, java.sql.Types.INTEGER);

				int numeroRegistrosModificados = cs.executeUpdate();
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de 1 insert.");
				}
				resena.setCodigo(cs.getInt(4));
				return resena;
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Agregar reseña.", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para agregar una reseña.", e);
		}
	}

	@Override
	public Resena modificar(Resena resena) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_UPDATE)) {

				cs.setInt(1, resena.getCodigo());
				cs.setInt(2, resena.getAlumno().getCodigo());
				cs.setInt(3, resena.getCurso().getCodigo());
				cs.setString(4, resena.getComentario());

				int numeroRegistrosModificados = cs.executeUpdate();

				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de 1 update.");
				}
				return resena;
			} catch (Exception e) {
				throw new AccesoDatosException("Error en la sentencia Modificar reseña.", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para modificar la reseña.", e);
		}
	}

	@Override
	public void borrar(Integer codigo) {
		try (Connection con = getConexion()) {
			try (CallableStatement cs = con.prepareCall(SQL_DELETE)) {
				cs.setInt(1, codigo);

				int numeroRegistrosModificados = cs.executeUpdate();
				if (numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("Se ha hecho mas o menos de 1 insert");
				}

			} catch (Exception e) {
				throw new AccesoDatosException("Error en la sentencia Eliminar reseña: " + codigo, e);
			}
		} catch (Exception e) {
			throw new AccesoDatosException("Error al conectar para eliminar la reseña: " + codigo, e);
		}
	}

	@Override
	public Iterable<Resena> obtenerTodasPorCodigoCurso(Integer codigo) {
		try (Connection con = getConexion()) {
			try(PreparedStatement ps = con.prepareStatement(SQL_GET_BY_CODIGO_CURSO)){
				ps.setInt(1, codigo);
				
				try(ResultSet rs = ps.executeQuery()){
					ArrayList<Resena> resenas = new ArrayList<>();
					
					Alumno alumno;
					Resena resena;
					Curso curso;
					while(rs.next()) {
						
						alumno = new Alumno(rs.getString("nombreAlumno"), rs.getString("apellidosAlumno"));
						curso = new Curso(rs.getInt("codigoCurso"));
						resena= new Resena(alumno, curso, rs.getString("comentarioResena"));
						resenas.add(resena);
					}
					return resenas;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al acceder a los registros de reseñas", e);

				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener reseñas del curso: " + codigo, e);

			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener las reseñas del curso: " + codigo, e);
		}
	}

}
