package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import com.ipartek.formacion.model.Curso;
import com.ipartek.formacion.model.Persona;

public class PersonaDAO implements IPERSONADAO{

	private static final Logger LOGGER = Logger.getLogger(PersonaDAO.class.getCanonicalName());

	private static final String SQL_GET_ALL = 
			"	SELECT \r\n" + 
			"	id as persona_id,\r\n" + 
			"	nombre as persona_nombre,\r\n" + 
			"	apellidos as persona_apellidos,\r\n" + 
			"	dni as persona_dni,\r\n" + 
			"	avatar as persona_avatar,\r\n" + 
			"	sexo as persona_sexo,\r\n" + 
			"	rol as persona_rol\r\n" + 
			"	FROM persona";

	
	private static final String SQL_GET_ALL2 = 
			"	SELECT \r\n" + 
			"	p.id as persona_id,\r\n" + 
			"	p.nombre as persona_nombre,\r\n" + 
			"	p.apellidos as persona_apellidos,\r\n" + 
			"	p.dni as persona_dni,\r\n" + 
			"	p.avatar as persona_avatar,\r\n" + 
			"	p.sexo as persona_sexo,\r\n" + 
			"	p.rol as persona_rol,\r\n" + 
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
			"	pf.sexo as profesor_sexo, \r\n" + 
			"	pf.rol as profesor_rol\r\n" + 
			"	FROM persona p \r\n" + 
			"	LEFT JOIN cursos_contratados cc ON p.id = cc.idPersona \r\n" + 
			"	LEFT JOIN curso c ON cc.idCurso = c.id\r\n" + 
			"	LEFT JOIN persona pf ON c.profesor = pf.id\r\n" + 
			"	LIMIT 500";
	
	private static final String SQL_GET_ALL_ROL = 
			"	SELECT \r\n" + 
			"	p.id as persona_id,\r\n" + 
			"	p.nombre as persona_nombre,\r\n" + 
			"	p.apellidos as persona_apellidos,\r\n" + 
			"	p.dni as persona_dni,\r\n" + 
			"	p.avatar as persona_avatar,\r\n" + 
			"	p.sexo as persona_sexo,\r\n" + 
			"	p.rol as persona_rol,\r\n" + 
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
			"	pf.sexo as profesor_sexo, \r\n" + 
			"	pf.rol as profesor_rol\r\n" + 
			"	FROM persona p \r\n" + 
			"	LEFT JOIN cursos_contratados cc ON p.id = cc.idPersona \r\n" + 
			"	LEFT JOIN curso c ON cc.idCurso = c.id\r\n" + 
			"	LEFT JOIN persona pf ON c.profesor = pf.id\r\n" + 
			"	LEFT JOIN rol r ON p.rol = r.id \n" + 
			"	WHERE r.nombre LIKE ? \n" + 
			"	ORDER BY persona_id , curso_nombre LIMIT 500";
	
	private static final String SQL_GET_ALL_NOMBRE = 
			"	SELECT \r\n" + 
			"	p.id as persona_id,\r\n" + 
			"	p.nombre as persona_nombre,\r\n" + 
			"	p.apellidos as persona_apellidos,\r\n" + 
			"	p.dni as persona_dni,\r\n" + 
			"	p.avatar as persona_avatar,\r\n" + 
			"	p.sexo as persona_sexo,\r\n" + 
			"	p.rol as persona_rol,\r\n" + 
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
			"	pf.sexo as profesor_sexo, \r\n" + 
			"	pf.rol as profesor_rol\r\n" + 
			"	FROM persona p \r\n" + 
			"	LEFT JOIN cursos_contratados cc ON p.id = cc.idPersona \r\n" + 
			"	LEFT JOIN curso c ON cc.idCurso = c.id\r\n" + 
			"	LEFT JOIN persona pf ON c.profesor = pf.id\r\n" + 
			"	LEFT JOIN rol r ON p.rol = r.id \n" + 
			"	WHERE r.nombre LIKE ? and p.nombre LIKE ? \n" + 
			"	ORDER BY persona_id , curso_nombre LIMIT 500";
	private static final String SQL_GET_BY_ID = 		
			"	SELECT \r\n" + 
			"	id as persona_id,\r\n" + 
			"	nombre as persona_nombre,\r\n" + 
			"	apellidos as persona_apellidos,\r\n" + 
			"	dni as persona_dni,\r\n" + 
			"	avatar as persona_avatar,\r\n" + 
			"	sexo as persona_sexo,\r\n" + 
			"	rol as persona_rol\r\n" + 
			"	FROM persona\r\n" + 
			"	WHERE id = ?";

	private static final String SQL_INSERT = 
			"INSERT INTO persona (nombre, apellidos, dni, avatar, sexo, rol) VALUES (?,?,?,?,?,?)";

	private static final String SQL_UPDATE = 
			"UPDATE persona SET nombre = ?, apellidos = ?, dni = ?, avatar = ?, sexo = ?, rol = ? WHERE id = ?";

	private static final String SQL_DELETE = "DELETE FROM persona WHERE id = ?";

	private static final String SQL_CONTRATAR_CURSO = 
			"INSERT INTO cursos_contratados (idPersona, idCurso) VALUES(?,?)";	

	private static final String SQL_DELETE_CURSO = 
			"DELETE FROM cursos_contratados WHERE idPersona = ? AND idCurso = ?";


	private static PersonaDAO INSTANCIA = null;
	
	
	public synchronized static PersonaDAO getInstance() {
		if (INSTANCIA == null){
			INSTANCIA = new PersonaDAO();
		}
		return INSTANCIA;
	}
	
	public PersonaDAO() {
		super();
	}

	@Override
	public List<Persona> getAll() {
		LOGGER.info("PersonaDAO getAll");
		
		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer, Persona>();
		
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_GET_ALL2);
			ResultSet rs = pst.executeQuery()){
				
			LOGGER.info(pst.toString());
			
			while (rs.next()) {
				mapper(rs, hmPersonas);
			}
		} catch (SQLException e) {
			LOGGER.severe("Error SQL");
			e.printStackTrace();
		}
		
		return new ArrayList<Persona>(hmPersonas.values());
	}

	

	@Override
	public Persona getById(int id) throws Exception {
		LOGGER.info("personaDAO getByID");
		HashMap<Integer,Persona> hmPersonas = new HashMap<Integer,Persona>();
		Persona persona = new Persona();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);){
			
			pst.setInt(1, id);
			LOGGER.info(pst.toString());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				mapper(rs,hmPersonas);
			}else {
				throw new Exception("No se ha encontrado la persona: " + id);
			}
			
			persona = hmPersonas.get(id);
		}catch(SQLException e){
			LOGGER.warning("Error SQL");
			throw new SQLException("Error SQL");
		}
		return persona;
	}

	@Override
	public Persona insert(Persona persona) throws Exception, SQLException {
		LOGGER.info("personaDAO insert");
				
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			
			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellidos());
			pst.setString(3, persona.getDni());
			pst.setString(4, persona.getAvatar());
			pst.setString(5, persona.getSexo());
			pst.setInt(6, persona.getRol());
			LOGGER.info(pst.toString());
			
			int numeroRegistrosModificados = pst.executeUpdate();
			if (numeroRegistrosModificados == 1) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					persona.setId(rs.getInt(1));
				}
			} else {
				throw new Exception("Se ha hecho mas o menos de una insert");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);

			//throw new SQLException("No se ha podido agregar la persona", e);
		}
		return persona;
	}

	@Override
	public Persona update(Persona persona) throws Exception, SQLException {
		LOGGER.info("personaDAO update");
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)){
			
			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellidos());
			pst.setString(3, persona.getDni());
			pst.setString(4, persona.getAvatar());
			pst.setString(5, persona.getSexo());
			pst.setInt(6, persona.getRol());
			pst.setInt(7, persona.getId());
			LOGGER.info(pst.toString());

			int numeroRegistrosModificados = pst.executeUpdate();
			
			if (numeroRegistrosModificados != 1) {
				throw new Exception("Se ha realizado mas o menos de un update");
			}
		}catch(SQLException e) {
			throw new SQLException("No se ha podido modificar la persona" , e);
		}
		
		return persona;
	}

	@Override
	public Persona delete(int id) throws Exception {
		LOGGER.info("personaDAO delete(" + id + ")");
		Persona persona = new Persona();
		persona = getById(id);
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)){
				
			pst.setInt(1, id);
			LOGGER.info(pst.toString());
			
			int registrosModificados = pst.executeUpdate();
			
			if (registrosModificados !=1) {
				throw new SQLException("Se ha eliminado mas o menos de un registro");
			}
		}catch(SQLException e) {
			throw new SQLException("No se ha podido eliminar la persona con id: " + id, e.getMessage());
		}
		return persona;
	}

	@Override
	public boolean contratarCurso(int idPersona, int idCurso) throws Exception, SQLException {
		LOGGER.info("PersonaDAO ContratarCurso()");
		boolean correcto = false; 
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_CONTRATAR_CURSO)){
			
				pst.setInt(1, idPersona);
				pst.setInt(2, idCurso);
				LOGGER.info(pst.toString());
				
				int registrosModificados = pst.executeUpdate();
				if (registrosModificados == 1) {
					correcto = true;
				}else {
					throw new Exception("Se ha contratado mas o menos de un curso");
				}
		}catch(SQLException e) {
			LOGGER.info(e.getMessage());
			throw new SQLException(e.getMessage());
		}
		return correcto;
	}

	@Override
	public boolean eliminarCursoContratado(int idPersona, int idCurso) throws Exception {
		LOGGER.info("PersonaDAO eliminarCursoContratado()");
		
		boolean correcto = false;
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_CURSO)){
			
			pst.setInt(1, idPersona);
			pst.setInt(2, idCurso);
			LOGGER.info(pst.toString());
			
			int numeroRegistrosModificados = pst.executeUpdate();
			if(numeroRegistrosModificados == 1) {
				correcto = true;
			}else {
				throw new Exception("Se ha eliminado mas o menos de un curso contratado");
			}
		}catch(SQLException e) {
			throw new SQLException("Error SQL o de conexión para eliminar curso contratado", e);
		}
		return correcto;
	}

private Persona mapper(ResultSet rs, HashMap<Integer, Persona> hpersonas) throws SQLException {
		
		int key = rs.getInt("persona_id");
		Persona p = hpersonas.get(key);

		// Comprobamos si existe el id en el HashMap, si no existe se crea
		if (p == null) {
			p = new Persona();
			p.setId(key);
			p.setNombre(rs.getString("persona_nombre"));
			p.setApellidos(rs.getString("persona_apellidos"));
			p.setDni(rs.getString("persona_dni"));
			p.setAvatar(rs.getString("persona_avatar"));
			p.setSexo(rs.getString("persona_sexo"));
			p.setRol(rs.getInt("persona_rol"));
		}
		
		// Añadimos los cursos
		int idCurso = rs.getInt("curso_id");
		// Comprobamos si existe el curso, en caso contrario se crea
		if (idCurso != 0) {
			Curso curso = new Curso();
			curso.setId(idCurso);
			curso.setNombre(rs.getString("curso_nombre"));
			curso.setImagen(rs.getString("curso_imagen"));
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
			p.getCursos().add(curso);
		}
	
		
		
		hpersonas.put(key, p);
		return p;
	}
	
	public List<Persona> getAllByRol(String rol) throws SQLException{
		LOGGER.info("personaDAO getAllByRol");
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer , Persona>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_ROL)){
			
			pst.setString(1, rol);
			LOGGER.info(pst.toString());
			
			try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					mapper(rs, hmPersonas);
				}
			}
		}catch(SQLException e) {
			throw new SQLException(e.getMessage());
		}
		
		return new ArrayList<Persona> (hmPersonas.values());
		
	}
	
	public List<Persona> getAllNombre(String rol, String nombre) throws SQLException {
		LOGGER.info("PersonaDAO getAllNombre");
		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer, Persona>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_NOMBRE)){
			
				pst.setString(1, rol);
				pst.setString(2, nombre);
				LOGGER.info(pst.toString());
				
				try (ResultSet rs = pst.executeQuery()){
					while(rs.next()) {
						mapper(rs, hmPersonas);
					}
				}
			
		}catch(SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return new ArrayList<Persona> (hmPersonas.values());
		
	}
}
