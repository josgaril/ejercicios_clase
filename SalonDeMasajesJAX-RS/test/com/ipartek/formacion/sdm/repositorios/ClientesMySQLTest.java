package com.ipartek.formacion.sdm.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.sdm.modelos.Cliente;

class ClientesMySQLTest {

	private static String pathConfig = "WebContent/WEB-INF/dao.properties";
	private static Dao<Cliente> dao = ClientesMySQL.getInstancia(pathConfig);
	private static int ultimoId = 0;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetInstancia() {
		fail("Not yet implemented");
	}

	@Test
	void testObtenerTodos() {
		for (Cliente cliente : dao.obtenerTodos()) {
			switch (cliente.getIdclientes()) {
			case 1:
				assertEquals(new Cliente(1, "Roberto", "Loyoa Gil", "78963256U"), cliente);
				break;
			case 2:
				assertEquals(new Cliente(2, "Vanesa", "Romero Cuesta", "74112588Y"), cliente);
				break;
			}
		}
	}

	@Test
	void testObtenerPorId() {
		assertNull(dao.obtenerPorId(0));
		assertNotNull(dao.obtenerPorId(2));
	}

	@Test
	void testAgregar() {
		Cliente cliente = new Cliente("Nombre Cliente Nuevo", "Apellidos Cliente Nuevo", "12345678A");
		ultimoId = cliente.getIdclientes();
		dao.agregar(cliente);
		assertNotNull(cliente, "Fila no insertada");
	}

	@Test
	void testModificar() {
		Cliente c1 = dao.obtenerPorId(ultimoId);
		Cliente c2 = dao.obtenerPorId(ultimoId);
		assertEquals(c1, c2);
		c2.setNombre("siuuu");
		dao.modificar(c2);
		assertNotEquals(dao.obtenerPorId(ultimoId), c1);
	}

	@Test
	void testBorrar() {
		assertNotNull(dao.obtenerPorId(id));
		dao.borrar(id);
		assertNull(dao.obtenerPorId(id));
	}

}
