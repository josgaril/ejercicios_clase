package appRestFinal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.model.dao.CursoDAO;

class CursoDAOTest {

	
	@BeforeAll
	static void testBeforeClass(){
		System.out.println("Primero obtener la instancia");

		CursoDAO cursoDAO = CursoDAO.getInstance();

	
	}
	
	@Test
	void testGetInstance() {
		System.out.println("getinstancia");

		CursoDAO cursoDAO = CursoDAO.getInstance();
		assertNotNull(cursoDAO);
		
	}

	@Test
	void testGetAll() {
		CursoDAO cursoDAO = (CursoDAO) CursoDAO.getInstance().getAll();
		assertNotNull(cursoDAO);
	}

	@Test
	void testGetAllFilter() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
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

}
