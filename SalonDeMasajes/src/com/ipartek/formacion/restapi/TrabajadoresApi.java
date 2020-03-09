package com.ipartek.formacion.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.Trabajador;

@WebServlet("/api/trabajadores/*")
public class TrabajadoresApi extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String URL_ID_VALIDA = "^/\\d+$";

	private static final String REGEX_NOMBRE = "(\\p{L}+)[([ ])(\\p{L})]+";
	private static final String REGEX_APELLIDOS = "(\\p{L}+)[([ '])(\\p{L})]+";
	private static final String REGEX_DNI = "[XYZ\\d]\\d{7}[A-Z]";

	private static Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Integer id = null;

		try {
			id = extraerId(request);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Error al obtener trabajador/es");
			return;
		}

		if (id == null) {
			out.write(gson.toJson(Globales.daoTrabajador.obtenerTodos()));
			return;
		}

		Trabajador trabajador = Globales.daoTrabajador.obtenerPorId(id);

		if (trabajador == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de trabajador no encontrado.");
		} else {
			out.write(gson.toJson(trabajador));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = extraerId(request);
		try {
			if (id != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Error.No se debe pasar un ID para agregar un trabajador");
			return;
		}

		String json = extraerJSON(request);

		Trabajador trabajadorJson = gson.fromJson(json, Trabajador.class);

		

		// Validaciones del trabajador
		if (validacionesTrabajador(trabajadorJson, response, id)) {
			Globales.daoTrabajador.agregar(trabajadorJson);

			// Obtenemos el id del nuevo cliente TODO Buscar el ultimo id con la sentencia
			// de max(id)
			Integer ultimoID = null;
			Iterable<Trabajador> trabajadoresTodos = Globales.daoTrabajador.obtenerTodos();
			for (Trabajador trabajadorX : trabajadoresTodos) {
				ultimoID = trabajadorX.getIdtrabajadores();
			}

			// Muestra en pantalla el cliente añadido 
			Trabajador trabajadorJsonAgregado = Globales.daoTrabajador.obtenerPorId(ultimoID);
			response.getWriter().write(gson.toJson(trabajadorJsonAgregado));
			
		} else {
			return;
		}

		//response.getWriter().write(gson.toJson(trabajadorJson));

		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = extraerJSON(request);
		Trabajador trabajadorJson = gson.fromJson(json, Trabajador.class);

		Integer id = null;

		try {
			id = extraerId(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("No se ha pasado id del trabajador a modificar");
			return;
		}

		if (!id.equals(trabajadorJson.getIdtrabajadores())) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter()
					.write("Id de trabajador no coincide con el que se quiere modificar. No se ha podido modificar");
			return;
		}

		// En caso de que coincida el id, buscamos cliente con ese id
		boolean existe = false;
		Iterable<Trabajador> trabajadorestodos = Globales.daoTrabajador.obtenerTodos();
		for (Trabajador trabajadorX : trabajadorestodos) {
			if (trabajadorX.getIdtrabajadores() == trabajadorJson.getIdtrabajadores()) {
				existe = true;
			}
		}
		// si no encuentra el cliente con ese id, error de No encontrado
		if (existe == false) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de trabajador no encontrado. ");
			return;
		}

		// Validaciones del trabajador
		if (validacionesTrabajador(trabajadorJson, response, id)) {
			Globales.daoTrabajador.modificar(trabajadorJson);
			Trabajador trabajadorJsonModificado = Globales.daoTrabajador.obtenerPorId(id);
			response.getWriter().write(gson.toJson(trabajadorJsonModificado));
		} else {
			return;
		}

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = null;

		try {
			id = extraerId(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Debe introducir el id de un trabajador existente para eliminarlo");
			return;
		}

		Trabajador trabajadorABorrar = Globales.daoTrabajador.obtenerPorId(id);

		if (trabajadorABorrar == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de trabajador no encontrado. No se ha podido eliminar");
		} else {
			Globales.daoTrabajador.borrar(id);
			response.getWriter().write("Trabajador eliminado");
		}
	}

	private boolean validacionesTrabajador(Trabajador trabajadorJson, HttpServletResponse response, Integer id)
			throws IOException {
		boolean correcto = true;
		if (trabajadorJson.getNombre() == null || trabajadorJson.getNombre().trim().length() < 1
				|| trabajadorJson.getNombre().length() > 45) {
			response.getWriter().write("Nombre del trabajador obligatorio.Entre 1 y 45 caracteres.  \n");
			correcto = false;
		} else if (trabajadorJson.getNombre() != null && !trabajadorJson.getNombre().matches(REGEX_NOMBRE)) {
			response.getWriter()
					.write("Solo se admiten nombres con caracteres de letras y espacios en nombres compuestos. \n");
			correcto = false;
		}

		if (trabajadorJson.getApellidos() == null || trabajadorJson.getApellidos().trim().length() < 1
				|| trabajadorJson.getApellidos().length() > 90) {
			response.getWriter().write("Apellido/s del trabajador obligatorio.Entre 1 y 90 caracteres. \n");
			correcto = false;
		} else if (trabajadorJson.getApellidos() != null && !trabajadorJson.getApellidos().matches(REGEX_APELLIDOS)) {
			response.getWriter().write(
					"Solo se admiten apellidos con caracteres de letras, apóstrofe y espacios entre apellidos.\n");
			correcto = false;
		}

		if (trabajadorJson.getDni() == null || trabajadorJson.getDni().trim().length() < 1) {
			response.getWriter().write("DNI obligatorio. \n");
			correcto = false;
		} else if (trabajadorJson.getDni() != null && !trabajadorJson.getDni().matches(REGEX_DNI)) {
			response.getWriter().write("Formato de DNI incorrecto. \n");
			correcto = false;
		}

		if (id == null) {
			// Si estamos agregando un trabajador(no pasamos id), comprobamos que el dni del
			// nuevo trabajador no esté duplicado
			Iterable<Trabajador> todosLosTrabajadores = Globales.daoTrabajador.obtenerTodos();
			for (Trabajador persona : todosLosTrabajadores) {
				if (persona.getDni().equals(trabajadorJson.getDni())) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("El DNI del trabajador a agregar está duplicado");
					correcto = false;
				}
			}
		} else {
			/*
			 * En caso de estar modificando un trabajador(ya disponemos de su id),
			 * comprobamos que el dni del nuevo trabajador no esté duplicado
			 */
			Iterable<Trabajador> todosLosTrabajadores = Globales.daoTrabajador.obtenerTodos();
			Trabajador trabajador = Globales.daoTrabajador.obtenerPorId(id);
			for (Trabajador trabajadorX : todosLosTrabajadores) {

				if (trabajadorX.getDni().equals(trabajadorJson.getDni())
						&& !trabajadorJson.getDni().equals(trabajador.getDni())) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("El DNI del trabajador a modificar está duplicado");
					correcto = false;
				}
			}
		}

		return correcto;

	}

	private static String extraerJSON(HttpServletRequest request) throws IOException {
		BufferedReader br = request.getReader();

		StringBuffer sb = new StringBuffer();
		String linea;

		while ((linea = br.readLine()) != null) {
			sb.append(linea);
		}

		return sb.toString();
	}

	private static Integer extraerId(HttpServletRequest request) {
		String path = request.getPathInfo();

		if (path == null || path.equals("/")) {
			return null;
		}

		if (!path.matches(URL_ID_VALIDA)) {
			throw new RuntimeException("URL de petición no válida");
		}

		return Integer.parseInt(path.substring(1));
	}
}
