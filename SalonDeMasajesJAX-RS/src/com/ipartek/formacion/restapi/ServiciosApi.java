package com.ipartek.formacion.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.sdm.controladores.Globales;
import com.ipartek.formacion.sdm.modelos.Servicio;

@WebServlet("/api/servicios/*")
public class ServiciosApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL_ID_VALIDA = "^/\\d+$";

	private static final String SERVICIO_NOMBRE = "(\\p{L}+)[([ ])(\\p{L})]+";

	private static final String SERVICIO_PRECIO = "\\d+[,\\.]\\d{3}";

	private static Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Integer id = null;

		try {
			id = extraerID(request);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		if (id == null) {
			out.write(gson.toJson(Globales.daoServicio.obtenerTodos()));
			return;
		}

		Servicio servicio = Globales.daoServicio.obtenerPorId(id);

		if (servicio == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		} else {
			out.write(gson.toJson(servicio));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (extraerID(request) != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String json = extraerJSON(request);

		Servicio servicio = gson.fromJson(json, Servicio.class);

		if (validacionesServicio(servicio, response)) {
			Globales.daoServicio.agregar(servicio);
		} else {
			return;
		}

		response.getWriter().write(gson.toJson(servicio));

		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = extraerJSON(request);

		Servicio servicio = gson.fromJson(json, Servicio.class);

		Integer id = null;

		try {
			id = extraerID(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		if (id != servicio.getIdservicios()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		if (validacionesServicio(servicio, response)) {
			Globales.daoServicio.modificar(servicio);
		} else {
			return;
		}

		response.getWriter().write(gson.toJson(servicio));
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = null;

		try {
			id = extraerID(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		Globales.daoServicio.borrar(id);

		response.getWriter().write("El servicio ha sido eliminado");
	}

	private boolean validacionesServicio(Servicio servicio, HttpServletResponse response) throws IOException {
		boolean correcto = true;

		if (servicio.getNombre() == null || servicio.getNombre().length() < 1 || servicio.getNombre().length() > 45) {
			response.getWriter().write("El nombre del servicio es obligatorio. Entre 1 y 45 caracteres. \n");
			correcto = false;
		} else if (servicio.getNombre() != null && !servicio.getNombre().matches(SERVICIO_NOMBRE)) {
			response.getWriter().write(
					"Solo se admiten nombres de servicio con caracteres de letras y serparación por espacios.\n");
			correcto = false;
		}
		if (servicio.getPrecio() == null || servicio.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
			response.getWriter().write("El precio del servicio es obligatorio y positivo. \n");
			correcto = false;
		} else if (servicio.getPrecio() != null && !servicio.getPrecio().toString().matches(SERVICIO_PRECIO)) {
			response.getWriter()
					.write("El precio debe tener al menos un entero y tres decimales, y debe ser positivo.\n");
			correcto = false;
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

	private static Integer extraerID(HttpServletRequest request) {

		String path = request.getPathInfo();

		if (path == null || path.contentEquals("/")) {
			return null;
		}

		if (!path.matches(URL_ID_VALIDA)) {
			throw new RuntimeException("URL de petición no válida");
		}

		return Integer.parseInt(path.substring(1));
	}

}
