package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import com.ipartek.formacion.model.Curso;
import com.ipartek.formacion.model.Persona;

public class CursoDAO implements IDAO<Curso> {

	private static final String SQL_GET_ALL = 
			"	SELECT \r\n" + 
			"	c.id as curso_id,\r\n" + 
			"	c.nombre as curso_nombre,\r\n" + 
			"	c.imagen as curso_imagen,\r\n" + 
			"	c.precio as curso_precio, \r\n" + 
			"	c.profesor as curso_profesor,\r\n" + 
			"	pf.id as profesor_id,\r\n" + 
			"	pf.nombre as profesor_nombre,\r\n" + 
			"	pf.apellidos as profesor_apellidos,\r\n" + 
			"	pf.dni as profesor_dni,\r\n" + 
			"	pf.avatar as profesor_avatar,\r\n" + 
			"	pf.sexo as profesor_sexo,\r\n" + 
			"	pf.rol as profesor_rol\r\n" + 
			"	FROM persona pf RIGHT JOIN curso c ON c.profesor = pf.id \r\n" + 
			"	LIMIT 500";

	private static final String SQL_GET_BY_NOMBRE = 
			"	SELECT \r\n" + 
			"	c.id as curso_id,\r\n" + 
			"	c.nombre as curso_nombre,\r\n" + 
			"	c.imagen as curso_imagen,\r\n" + 
			"	c.precio as curso_precio, \r\n" + 
			"	c.profesor as curso_profesor,\r\n" + 
			"	pf.id as profesor_id,\r\n" + 
			"	pf.nombre as profesor_nombre,\r\n" + 
			"	pf.apellidos as profesor_apellidos,\r\n" + 
			"	pf.dni as profesor_dni,\r\n" + 
			"	pf.avatar as profesor_avatar,\r\n" + 
			"	pf.sexo as profesor_sexo,\r\n" + 
			"	pf.rol as profesor_rol\r\n" + 
			"	FROM persona pf RIGHT JOIN curso c ON c.profesor = pf.id\r\n" + 
			"	WHERE c.nombre LIKE ? \r\n" + 
            " 	ORDER BY c.id desc\n" + 
            "	LIMIT 500";

	private static final String SQL_GET_BY_ID = 
			"	SELECT \r\n" + 
			"	c.id as curso_id,\r\n" + 
			"	c.nombre as curso_nombre,\r\n" + 
			"	c.imagen as curso_imagen,\r\n" + 
			"	c.precio as curso_precio, \r\n" + 
			"	c.profesor as curso_profesor,\r\n" + 
			"	pf.id as profesor_id,\r\n" + 
			"	pf.nombre as profesor_nombre,\r\n" + 
			"	pf.apellidos as profesor_apellidos,\r\n" + 
			"	pf.dni as profesor_dni,\r\n" + 
			"	pf.avatar as profesor_avatar,\r\n" + 
			"	pf.sexo as profesor_sexo,\r\n" + 
			"	pf.rol as profesor_rol\r\n" + 
			"	FROM persona pf RIGHT JOIN curso c ON c.profesor = pf.id \r\n" + 
			"	WHERE c.id = ? ";

	private static final String SQL_GET_BY_PROFESOR = 
			"SELECT \r\n" + 
			"c.id as curso_id,\r\n" + 
			"c.nombre as curso_nombre,\r\n" + 
			"c.imagen as curso_imagen,\r\n" + 
			"c.precio as curso_precio, \r\n" + 
			"c.profesor as curso_profesor,\r\n" + 
			"pf.id as profesor_id,\r\n" + 
			"pf.nombre as profesor_nombre,\r\n" + 
			"pf.apellidos as profesor_apellidos,\r\n" + 
			"pf.dni as profesor_dni,\r\n" + 
			"pf.avatar as profesor_avatar,\r\n" + 
			"pf.sexo as profesor_sexo,\r\n" + 
			"pf.rol as profesor_rol\r\n" + 
			"FROM persona pf RIGHT JOIN curso c ON c.profesor = pf.id\r\n" + 
			"WHERE pf.id = ? \r\n" + 
			"LIMIT 500";

	private static final String SQL_UPDATE = "UPDATE curso set profesor = ? WHERE id = ?";
	
	private static Logger LOGGER = Logger.getLogger(CursoDAO.class.getCanonicalName());

	private static CursoDAO INSTANCIA = null;
	
	private CursoDAO() {
		super();
	}
	
	public synchronized static CursoDAO getInstance() {
		if (INSTANCIA == null) {
			INSTANCIA = new CursoDAO();
		}
		return INSTANCIA;
	}

	@Override
	public List<Curso> getAll() {
		LOGGER.info("CursoDAO getAll");
		 ArrayList<Curso> cursos = new ArrayList<Curso>();
		 
		 HashMap<Integer, Curso> hmCursos = new HashMap<Integer, Curso>();
		 try (Connection con = ConnectionManager.getConnection();
				 PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				 ResultSet rs = pst.executeQuery()){
			 
			 	LOGGER.info(pst.toString());
			 	
			 	while(rs.next()) {
			 		//mapper(rs,hmCursos);
			 		cursos.add(mapper(rs, hmCursos));
			 	}
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		
		 return cursos;
		
	}

	public List<Curso> getAllByNombre(String filtro){
		LOGGER.info("cursoDAO getAllByNombre()");
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		HashMap<Integer, Curso> hmCursos = new HashMap<Integer, Curso>();
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_NOMBRE)){
			
				pst.setString(1, "%" + filtro + "%");
				LOGGER.info(pst.toString());
				try(ResultSet rs = pst.executeQuery()){
					
					while(rs.next()) {
						cursos.add(mapper(rs, hmCursos));
					}
				}
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cursos;
	}
	
	private Curso mapper(ResultSet rs, HashMap<Integer, Curso> hmCursos) throws SQLException {
		
		Curso curso = new Curso();

			curso.setId(rs.getInt("curso_id"));
			curso.setNombre(rs.getString("curso_nombre"));
			curso.setPrecio(rs.getFloat("curso_precio"));
			
			Persona profesor = new Persona();
			profesor.setId(rs.getInt("profesor_id"));
			profesor.setNombre(rs.getString("profesor_nombre"));
			profesor.setApellidos(rs.getString("profesor_apellidos"));
			profesor.setDni(rs.getString("profesor_dni"));
			profesor.setAvatar(rs.getString("profesor_avatar"));
			profesor.setSexo(rs.getString("profesor_sexo"));
			profesor.setRol(rs.getInt("profesor_rol"));
			
			curso.setProfesor(profesor);
		
		return curso;
	}

	@Override
	public Curso getById(int id) throws Exception {
		LOGGER.info("CursoDAO getById()");
		Curso curso = new Curso();
		HashMap<Integer, Curso> hmCursos = new HashMap<Integer,Curso>();
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)){
			pst.setInt(1, id);
			LOGGER.info(pst.toString());
			
			try(ResultSet rs = pst.executeQuery()){
				
				if (rs.next()) {
					curso = mapper(rs, hmCursos);
				}else {
					throw new Exception("No se ha encontrado el curso " + id);
				}
			}
		}catch(SQLException e) {
			throw new SQLException("Error SQL al obtener cursos por id",e);
		}
		
		return curso;
	}

	public ArrayList<Curso> getByProfesor(int idProfesor) throws SQLException{
		LOGGER.info("cursoDAO getByProfesor");
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		HashMap<Integer, Curso> hmCursos = new HashMap<Integer, Curso>();
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_PROFESOR)){
		
			pst.setInt(1, idProfesor);
			LOGGER.info(pst.toString());
		
			try(ResultSet rs = pst.executeQuery()){
				
				if (rs.next()) {
					cursos.add(mapper(rs, hmCursos));
					while(rs.next()) {
						cursos.add(mapper(rs, hmCursos));
					}
				}
			}
			
		}catch( SQLException e) {
			throw new SQLException(e);
		}

		return cursos;
		
	}
	
	@Override
	public Curso insert(Curso curso) throws Exception, SQLException {
		throw new UnsupportedOperationException("NO ESTÁ IMPLEMENTADO");

	}

	
	public Curso update(Curso curso) throws Exception, SQLException {
		LOGGER.info("update cursos()");
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)){
			
			if (curso.getProfesor()== null) {
				pst.setObject(1, curso.getProfesor());
			}else {
				pst.setObject(1, curso.getProfesor().getId());				
			}
			pst.setObject(2, curso.getId());
			LOGGER.info(pst.toString());
			
			int registrosModificados = pst.executeUpdate();
			if (registrosModificados !=1) {
				throw new Exception("Se ha hecho mas o menos de un update para el curso");
			}
		}catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return curso;
		
		

	}

	@Override
	public Curso delete(int id) throws Exception {
		throw new UnsupportedOperationException("NO ESTÁ IMPLEMENTADO");
	}
	
	
	
}
