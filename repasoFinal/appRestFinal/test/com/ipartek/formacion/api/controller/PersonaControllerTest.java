package com.ipartek.formacion.api.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.model.Persona;
import com.ipartek.formacion.model.dao.ConnectionManager;
import com.ipartek.formacion.model.dao.IDAO;
import com.ipartek.formacion.model.dao.PersonaDAO;

class PersonaControllerTest {
	private static final Logger LOGGER = Logger.getLogger(PersonaControllerTest.class.getCanonicalName());

	private static PersonaDAO personaDAO = null;

	private static Statement s = null;
	private static String pathConfig = "context.xml";
	
	
	private static IDAO<Persona> dao = null;

	private static Properties configuracion = null;
	private static Long id = 0L;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		personaDAO = PersonaDAO.getInstance();
		
		Properties prop = new Properties(); 
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8181");
		
		Context context = new InitialContext(prop);
		/*
		 * Properties configuracion = new Properties(); configuracion.load(new
		 * FileInputStream(pathConfig));
		 * 
		 * Connection con = DriverManager.getConnection(
		 * configuracion.getProperty("url"), configuracion.getProperty("username"),
		 * configuracion.getProperty("password")); s = con.createStatement();
		 */
		
		//System.out.println("Instancia de personaDAO generada");
		Connection con = ConnectionManager.getConnection();
		//PreparedStatement pst = con.prepareStatement("SELECT * FROM curso");
		//LOGGER.info(pst.toString());
		//con.createStatement();
		s = con.createStatement();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		s.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		s.executeUpdate("TRUNCATE personas");
		
		s.executeUpdate("INSERT INTO personas (nombre, apellidos) VALUES ('Primero', 'Primerez'), ('Segundo', 'Segundez')");

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPersonaController() {
		fail("Not yet implemented");
	}
 
	@Test
	void testGetInstancia() {
		assertNotNull(PersonaDAO.getInstance());	
	}
	
	@Test
	void testGetAll() {
		/*
		 * System.out.println("test getAll"); ArrayList<Persona> personas =
		 * (ArrayList<Persona>) personaDAO.getAll(); System.out.println(personas);
		 */
	}

	@Test
	void testGetById() {
		System.out.println("test getById");
	}

	@Test
	void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testContratarCurso() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCursoContratado() {
		fail("Not yet implemented");
	}

}
