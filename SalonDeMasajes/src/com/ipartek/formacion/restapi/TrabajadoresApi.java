package com.ipartek.formacion.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
			return;
		}

		if (id == null) {
			out.write(gson.toJson(Globales.daoTrabajador.obtenerTodos()));
			// out.write(gson.toJson(usuarios.values()));
			// response.getWriter().write(new Gson().toJson(usuarios.values()));
			return;
		}

		// Usuario usuario = usuarios.get(id);
		Trabajador trabajador = Globales.daoTrabajador.obtenerPorId(id);

		if (trabajador == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			out.write(gson.toJson(trabajador));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (extraerId(request) != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String json = extraerJSON(request);

		Trabajador trabajador = gson.fromJson(json, Trabajador.class);

		// Validaciones
		// validacion = validacionesCliente(cliente, response);
		if (validacionesTrabajador(trabajador, response)) {
			// Agrega el cliente
			Globales.daoTrabajador.agregar(trabajador);
		} else {
			return;
		}

		response.getWriter().write(gson.toJson(trabajador));

		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = extraerJSON(request);
		Trabajador trabajador = gson.fromJson(json, Trabajador.class);

		Integer id = null;

		try {
			id = extraerId(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		if (id != trabajador.getIdtrabajadores()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		Globales.daoTrabajador.modificar(trabajador);

		response.getWriter().write(gson.toJson(trabajador));

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
			return;
		}

		Globales.daoTrabajador.borrar(id);

		response.getWriter().write("Trabajador eliminado");
	}

	private boolean validacionesTrabajador(Trabajador trabajador, HttpServletResponse response) throws IOException {
		boolean correcto = true;
		if (trabajador.getNombre() == null || trabajador.getNombre().length() < 1
				|| trabajador.getNombre().length() > 45) {
			response.getWriter().write("Nombre del trabajador obligatorio.Entre 1 y 45 caracteres.  \n");
			correcto = false;
		} else if (trabajador.getNombre() != null && !trabajador.getNombre().matches(REGEX_NOMBRE)) {
			response.getWriter().write(
					"Solo se admiten nombres con caracteres de letras y espacios en nombres compuestos. \n");
			correcto = false;
		}

		if (trabajador.getApellidos() == null || trabajador.getApellidos().length() < 1
				|| trabajador.getApellidos().length() > 90) {
			response.getWriter().write("Apellido/s del trabajador obligatorio.  \n");
			correcto = false;
		} else if (trabajador.getApellidos() != null && !trabajador.getApellidos().matches(REGEX_APELLIDOS)) {
			response.getWriter().write(
					"Solo se admiten apellidos con caracteres de letras, apóstrofe y espacios entre apellidos.Entre 1 y 90 caracteres.\n");
			correcto = false;
		}

		if (trabajador.getDni() == null || trabajador.getDni().length() < 1) {
			response.getWriter().write("DNI obligatorio. \n");
			correcto = false;
		} else if (trabajador.getDni() != null && !trabajador.getDni().matches(REGEX_DNI)) {
			response.getWriter().write("Formato de DNI incorrecto. \n");
			correcto = false;
		}

		// TODO CONTROLAR ERROR SI SE METE UN DNI DUPLICADO
		ArrayList<Trabajador> trabajadores = new ArrayList<>();

		for (Trabajador persona : trabajadores) {
			if (persona.getDni() == trabajador.getDni()) {
				response.getWriter().write("El DNI está duplicado");
				correcto = false;
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
