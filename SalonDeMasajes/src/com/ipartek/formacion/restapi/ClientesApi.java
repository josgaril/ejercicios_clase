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
import com.ipartek.formacion.sdm.modelos.Cliente;

@WebServlet("/api/clientes/*")
public class ClientesApi extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String URL_ID_VALIDA = "^/\\d+$";

	private static final String REGEX_NOMBRE = "(\\p{L}+)[([ ])(\\p{L})]+";
//	private static final String REGEX_NOMBRE = "[\\p{L} ]+";
	private static final String REGEX_APELLIDOS = "(\\p{L}+)[([ '])(\\p{L})]+";
//	private static final String REGEX_APELLIDOS = "[\\p{L} ']+";
	private static final String REGEX_DNI = "[XYZ\\d]\\d{7}[A-Z]";

	// (\\p{L}+)(([ ])(\\p{L}+))? "(\\p{L}+)[([ '])(\\p{L}+)]+"

	// Creamos el objeto gson
	private static Gson gson = new Gson();
	// private static boolean validacion = true;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Declaramos la variable out que es tipo PrintWriter
		PrintWriter out = response.getWriter();
		// Declaramos la variable id
		Integer id = null;

		try {
			// llamamos al metodo extraerId para ver si se ha pasado un id, sino devolverá
			// null
			id = extraerId(request);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Si el id es null, escribe todos los clientes, convertidos a Json y acabamos
		if (id == null) {
			out.write(gson.toJson(Globales.daoCliente.obtenerTodos()));
			return;
		}
		// En caso de pasar el id de un cliente, obtenemos ese cliente
		Cliente cliente = Globales.daoCliente.obtenerPorId(id);

		// Si el cliente es null, error No encontrado.
		if (cliente == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			// si lo encuentra, lo escribe.
			out.write(gson.toJson(cliente));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Comprobamos que no se le haya pasado ningún id, sino lanzamos excepción, la
		// cual nos indica que la solicitud es incorrecta
		try {
			if (extraerId(request) != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Declaramos la variable json, que guardará el texto escrito.
		String json = extraerJSON(request);
		// Creamos un cliente al que le pasamos el texto escrito en json
		Cliente cliente = gson.fromJson(json, Cliente.class);

		// Validaciones
		// validacion = validacionesCliente(cliente, response);
		if (validacionesCliente(cliente, response)) {
			// Agrega el cliente
			Globales.daoCliente.agregar(cliente);
		} else {
			return;
		}

		// Muestra en pantalla el cliente añadido
		response.getWriter().write(gson.toJson(cliente));
		// El cliente se ha creado correctamente y muestra el código 201
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Declaramos la variable json en la que guardamos el texto escrito
		String json = extraerJSON(request);
		// Guarda en cliente el texto escrito en Json, que es de la clase Cliente
		Cliente cliente = gson.fromJson(json, Cliente.class);
		// Declaramos la variable id
		Integer id = null;
		// Extraemos el id, o el valor null si no tiene y nos da una excepcion
		// indicando respuesta incorrecta.
		try {
			id = extraerId(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Si el id no corresponde con el del cliente dará error y sadlrá.
		if (id != cliente.getIdclientes()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// Validaciones
		// validacion = validacionesCliente(cliente, response);
		if (validacionesCliente(cliente, response)) {
			// Modifica el cliente
			Globales.daoCliente.modificar(cliente);
		} else {
			return;
		}

		// Muestra el cliente añadido
		response.getWriter().write(gson.toJson(cliente));

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Declaramos la variable id
		Integer id = null;
		// Extraemos el id, o el valor null si no tiene y nos da una excepcion
		// indicando respuesta incorrecta.
		try {
			id = extraerId(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Borra el cliente
		Globales.daoCliente.borrar(id);
		// Muestra el mensaje de que el cliente se ha eliminado
		response.getWriter().write("Cliente eliminado");
	}

	private static String extraerJSON(HttpServletRequest request) throws IOException {
		// Leemos la cadena de texto pasado
		BufferedReader br = request.getReader();

		StringBuffer sb = new StringBuffer();
		String linea;
		// Mientras haya lineas por leer sigue añadiendo las lineas al buffer
		while ((linea = br.readLine()) != null) {
			sb.append(linea);
		}
		// Devolvemos el buffer leido
		return sb.toString();
	}

	private boolean validacionesCliente(Cliente cliente, HttpServletResponse response) throws IOException {
		boolean correcto = true;
		if (cliente.getNombre() == null) {
			response.getWriter().write("Nombre del cliente obligatorio.  \n");
			correcto = false;
		}else if (cliente.getNombre() != null && cliente.getNombre().length() < 1 || cliente.getNombre().length() > 45){
			response.getWriter().write(
					"El nombre debe tener entre 1 y 45 caracteres.\n");
			correcto = false;
		} else if (cliente.getNombre() != null && !cliente.getNombre().matches(REGEX_NOMBRE)) {
			response.getWriter().write(
					"Solo se admiten nombres con caracteres de letras y espacios en nombres compuestos. \n");
			correcto = false;
		}

		if (cliente.getApellidos() == null || cliente.getApellidos().length() < 1
				|| cliente.getApellidos().length() > 90) {
			response.getWriter().write("Apellido/s del cliente obligatorio.  \n");
			correcto = false;
		} else if (cliente.getApellidos() != null && !cliente.getApellidos().matches(REGEX_APELLIDOS)) {
			response.getWriter().write(
					"Solo se admiten apellidos con caracteres de letras, apóstrofe y espacios entre apellidos.Entre 1 y 90 caracteres.\n");
			correcto = false;
		}

		//TODO CONTROLAR ERROR SI SE METE UN DNI DUPLICADO

		if (cliente.getDni() == null || cliente.getDni().length() < 1) {
			response.getWriter().write("DNI obligatorio. \n");
			correcto = false;
		} else if (cliente.getDni() != null && !cliente.getDni().matches(REGEX_DNI)) {
			response.getWriter().write("Formato de DNI incorrecto. \n");
			correcto = false;
		}
		return correcto;
	}

	private static Integer extraerId(HttpServletRequest request) {
		// declaramos path para guardar la url
		String path = request.getPathInfo();
		// si path es null o solo contiene la "/" devolvemos null
		if (path == null || path.equals("/")) {
			return null;
		}
		// si la url recibida no es valida mandamos RuntimeException
		if (!path.matches(URL_ID_VALIDA)) {
			throw new RuntimeException("URL de petición no válida");
		}
		// devolvemos el id, para ello extraemos la cadena de la url desde el primer
		// caracter
		return Integer.parseInt(path.substring(1));
	}
}
