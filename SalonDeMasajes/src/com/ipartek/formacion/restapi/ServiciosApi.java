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
import com.ipartek.formacion.sdm.modelos.Servicio;

@WebServlet("/api/servicios/*")
public class ServiciosApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL_ID_VALIDA = "^/\\d+$";

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
		// Comprobamos que no se le haya pasado ningún id
		try {
			if (extraerID(request) != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Declaramos la variable json, que guardará el texto escrito.
		String json = extraerJSON(request);
		// Creamos un cliente al que le pasamos el texto escrito en json
		Servicio servicio = gson.fromJson(json, Servicio.class);
		// Agrega el cliente
		Globales.daoServicio.agregar(servicio);
		// Muestra en pantalla el cliente añadido
		response.getWriter().write(gson.toJson(servicio));
		// El cliente se ha creado correctamente y muestra el código 201
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Declaramos la variable json en la que guardamos el texto escrito
		String json = extraerJSON(request);
		// Guarda en cliente el texto escrito en Json, que es de la clase Cliente
		Servicio servicio = gson.fromJson(json, Servicio.class);
		// Declaramos la variable id
		Integer id = null;
		// Extraemos el id, o el valor null si no tiene y nos da una excepcion
		// indicando respuesta incorrecta.
		try {
			id = extraerID(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// Si el id no corresponde con el del cliente dará error y sadlrá.
		if (id != servicio.getIdservicios()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Modifica el cliente
		Globales.daoServicio.modificar(servicio);
		// Muestra el cliente añadido
		response.getWriter().write(gson.toJson(servicio));
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Declaramos la variable id
		Integer id = null;
		// Extraemos el id, o el valor null si no tiene y nos da una excepcion
		// indicando respuesta incorrecta.
		try {
			id = extraerID(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Borra el cliente
		Globales.daoServicio.borrar(id);
		// Muestra el mensaje de que el cliente se ha eliminado
		response.getWriter().write("El servicio ha sido eliminado");
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
		// declaramos path para guardar la url
		String path = request.getPathInfo();
		// si path es null o solo contiene la "/" devolvemos null
		if (path == null || path.contentEquals("/")) {
			return null;
		}
		// si la url recibida no es valida mandamos RuntimeException
		if (!path.matches(URL_ID_VALIDA)) {
			throw new RuntimeException("URL de petición no válida");
		}
		// devolvemos el valor del id convertido a su tipo(integer en este caso),
		// para ello extraemos la cadena de la url desde el primer caracter
		return Integer.parseInt(path.substring(1));
	}

}
