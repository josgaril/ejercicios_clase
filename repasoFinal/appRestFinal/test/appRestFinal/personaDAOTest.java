package appRestFinal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.model.Persona;
import com.ipartek.formacion.model.dao.IDAO;
import com.ipartek.formacion.model.dao.PersonaDAO;

class personaDAOTest {
	
	private static IDAO<Persona> dao = null;
	Persona persona = new Persona();
	private static Statement s = null;

	@BeforeAll
	static void testBeforeAll() throws SQLException{
		dao = PersonaDAO.getInstance();
		//Connection con = ConnectionManager.getConnection();
		//s = con.createStatement();
	}
	
	@AfterAll
	static void testAfterAll() throws SQLException{
//		s.close();
	}
	
	@BeforeEach
	public void testBefore() {
		System.out.println("testBefore()");
	}
	
	@AfterEach
	public void testAfter() {
		System.out.println("testAfter()");
	}


	@Test
	void testGetInstancia() {
		System.out.println("testGetInstancia()");

		assertNotNull(PersonaDAO.getInstance());	
	}
	
	@Test
	void testGetAll() {
		System.out.println("testGetAll()");
		dao.getAll();
		List<Persona> personas = dao.getAll();
		for(Persona persona: personas) {
			System.out.println(persona);

			/*for(Persona persona: dao.getAll()) {
			System.out.println(persona);
			 * switch(persona.getId()) { case 1: assertEquals(new Persona(1,
			 * "Primero","avatar1.png","h",1), persona); break; case 2: assertEquals(new
			 * Persona(1, "Segundo","avatar2.png","h",2), persona); break; default:
			 * fail("Se ha encontrado un registro no esperado: " + persona); }
			 */
		}
	}
	
	
}
