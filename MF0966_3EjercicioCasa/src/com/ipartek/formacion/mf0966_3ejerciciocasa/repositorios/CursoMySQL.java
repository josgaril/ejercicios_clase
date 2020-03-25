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

import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Alumno;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Cliente;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Curso;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Profesor;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Resena;

public class CursoMySQL implements CursoDao {

	// TODOS LOS CURSOS CON TODOS LOS CAMPOS
	private static final String SQL_GET_ALL = 
			"SELECT * \r\n" + "FROM curso c\r\n" + 
			"INNER JOIN profesor p ON c.profesor_codigo = p.codigo\r\n"+ 
			"INNER JOIN cliente cl ON c.cliente_codigo = cl.codigo\r\n" + 
			"ORDER BY c.codigo";
	
	// TODOS LOS CURSOS CON LOS CAMPOS PEDIDOS
	private static final String SQL_GET_ALL_REALIZADOS = 
			"SELECT c.codigo AS codigoCurso, c.nombre AS nombreCurso, c.identificador AS identificadorCurso, c.nHoras AS nHorasCurso, p.nombre AS nombreProfesor, p.apellidos AS apellidosProfesor\r\n " + 
			"FROM curso c \r\n" + 
			"INNER JOIN profesor p ON c.profesor_codigo = p.codigo\r\n"+ 
			"WHERE c.fFin<NOW()" + 
			"ORDER BY nombreCurso";
	
	private static final String SQL_GET_BY_CODIGO = 
			"SELECT c.codigo AS codigoCurso, c.nombre AS nombreCurso, c.identificador AS identificadorCurso , c.fInicio AS fInicioCurso, c.fFin AS fFinCurso, c.nHoras AS nHorasCurso, c.temario AS temarioCurso, c.activo AS activoCurso, c.precio AS precioCurso,\r\n" + 
			"p.codigo AS codigoProfesor, p.nss AS nssProfesor, p.nombre AS nombreProfesor, p.apellidos AS apellidosProfesor, p.fNacimiento AS fNacimientoProfesor, p.dni AS dniProfesor, p.direccion AS direccionProfesor, p.poblacion AS poblacionProfesor, p.codigopostal AS codigopostalProfesor, p.telefono AS telefonoProfesor, p.email AS emailProfesor, p.activo AS activoProfesor,\r\n" +  
			"cl.codigo AS codigoCliente, cl.nombre AS nombreCliente, cl.email AS emailCliente, cl.telefono as telefonoCliente, cl.direccion AS direccionCliente, cl.poblacion AS poblacionCliente, cl.codigopostal AS codigopostalCliente, cl.identificador AS identificadorCliente, cl.activo AS activoCliente,\r\n" + 
			"r.codigo AS codigoResena, r.alumno_codigo AS codigoAlumno, a.nombre AS nombreAlumno, a.apellidos AS apellidosAlumno, r.comentario AS comentarioResena\r\n" + 
			"FROM curso c\r\n" + 
			"INNER JOIN profesor p ON c.profesor_codigo = p.codigo\r\n" + 
			"INNER JOIN cliente cl ON c.cliente_codigo = cl.codigo\r\n" + 
			"INNER JOIN resena r ON r.curso_codigo = c.codigo\r\n" + 
			"INNER JOIN alumno a ON r.alumno_codigo = a.codigo\r\n" + 
			"WHERE c.codigo=?\r\n" + 
			"ORDER BY apellidosAlumno, nombreAlumno";


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
			throw new AccesoDatosException("Fallo de lectura/escritura en el fichero", e);
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

			// TODOS LOS CURSOS CON TODOS LOS CAMPOS
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
					throw new AccesoDatosException("Error al accedor a los registros de cursos", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error en la sentencia Obtener todos los cursos", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al conectar para obtener todos los cursos", e);
		}
	}

	@Override
	public Iterable<Curso> obtenerTodosRealizados() {
		try (Connection con = getConexion()) {

			try (PreparedStatement ps = con.prepareStatement(SQL_GET_ALL_REALIZADOS)) {
				try (ResultSet rs = ps.executeQuery()) {
					ArrayList<Curso> cursos = new ArrayList<>();
					Profesor profesor;
					Curso curso;
					while (rs.next()) {
						profesor = new Profesor(rs.getString("nombreProfesor"), rs.getString("apellidosProfesor"));
						curso = new Curso(rs.getInt("codigoCurso"),rs.getString("nombreCurso"), rs.getString("identificadorCurso"),
								rs.getInt("nHorasCurso"), profesor);
						cursos.add(curso);
					}
					return cursos;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al accedor a los registros de cursos", e);
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
					Resena resena;
					Alumno alumno;
					if (rs.next()) {
						profesor = new Profesor(rs.getInt("codigoProfesor"), rs.getLong("nssProfesor"),
								rs.getString("nombreProfesor"), rs.getString("apellidosProfesor"),
								rs.getTimestamp("fNacimientoProfesor"), rs.getString("dniProfesor"),
								rs.getString("direccionProfesor"), rs.getString("poblacionProfesor"),
								rs.getInt("codigopostalProfesor"), rs.getInt("telefonoProfesor"),
								rs.getString("emailProfesor"), rs.getBoolean("activoProfesor"));
						cliente = new Cliente(rs.getInt("codigoCliente"), rs.getString("nombreCliente"),
								rs.getString("emailCliente"), rs.getInt("telefonoCliente"),
								rs.getString("direccionCliente"), rs.getString("poblacionCliente"),
								rs.getInt("codigopostalCliente"), rs.getString("identificadorCliente"),
								rs.getBoolean("activoCliente"));

						/*
						 * alumno = new Alumno(rs.getInt("codigoAlumno"), rs.getString("nombreAlumno"),
						 * rs.getString("apellidosAlumno"), rs.getTimestamp("fNacimientoAlumno"),
						 * rs.getString("direccionAlumno"), rs.getString("poblacionAlumno"),
						 * rs.getInt("codigopostalAlumno"), rs.getInt("telefonoAlumno"),
						 * rs.getString("emailAlumno"), rs.getString("dniAlumno"),
						 * rs.getInt("nHermanosAlumno"), rs.getBoolean("activoAlumno"));
						 */

						curso = new Curso(rs.getInt("codigoCurso"), rs.getString("nombreCurso"),
								rs.getString("identificadorCurso"), rs.getTimestamp("fInicioCurso"),
								rs.getTimestamp("fFinCurso"), rs.getInt("nHorasCurso"), rs.getString("temarioCurso"),
								rs.getBoolean("activoCurso"), cliente, rs.getBigDecimal("precioCurso"), profesor);

						/*
						 * resena= new Resena(alumno, curso, rs.getString("comentario"));
						 */
						return curso;

						/*
						 * DETALLE DE UN CURSO CON SUS CAMPOS try (ResultSet rs = ps.executeQuery()) {
						 * 
						 * 
						 * Profesor profesor; Cliente cliente; Curso curso; if (rs.next()) { profesor =
						 * new Profesor(rs.getInt("p.codigo"), rs.getLong("p.nss"),
						 * rs.getString("p.nombre"), rs.getString("p.apellidos"),
						 * rs.getTimestamp("p.fNacimiento"), rs.getString("p.dni"),
						 * rs.getString("p.direccion"), rs.getString("p.poblacion"),
						 * rs.getInt("p.codigopostal"), rs.getInt("p.telefono"),
						 * rs.getString("p.email"), rs.getBoolean("p.activo")); cliente = new
						 * Cliente(rs.getInt("cl.codigo"), rs.getString("cl.nombre"),
						 * rs.getString("cl.email"), rs.getInt("cl.telefono"),
						 * rs.getString("cl.direccion"), rs.getString("cl.poblacion"),
						 * rs.getInt("cl.codigopostal"), rs.getString("cl.identificador"),
						 * rs.getBoolean("cl.activo")); curso = new Curso(rs.getInt("c.codigo"),
						 * rs.getString("c.nombre"), rs.getString("c.identificador"),
						 * rs.getTimestamp("c.fInicio"), rs.getTimestamp("c.fFin"),
						 * rs.getInt("c.nHoras"), rs.getString("c.temario"), rs.getBoolean("c.activo"),
						 * cliente, rs.getBigDecimal("c.precio"), profesor); return curso;
						 */
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException("Error al accedor a los registros de cursos", e);
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
