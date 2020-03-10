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
	private static final String REGEX_APELLIDOS = "(\\p{L}+)[([ '])(\\p{L})]+";
	private static final String REGEX_DNI = "[XYZ\\d]\\d{7}[A-Z]";

	// Creamos el objeto gson
	private static Gson gson = new Gson();

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
			out.write("Id de cliente no encontrado.");

		} else {
			// si lo encuentra, lo escribe.
			out.write(gson.toJson(cliente));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Comprobamos que no se le haya pasado ningún id, sino lanzamos excepción, la
		// cual nos indica que la solicitud es incorrecta
		Integer id = extraerId(request);
		try {
			if (id != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Error.No se debe pasar un ID para agregar un cliente");
			return;
		}
		// Declaramos la variable json, que guardará el texto escrito.
		String json = extraerJSON(request);

		// Creamos un cliente al que le pasamos el texto escrito en json
		Cliente clienteJson = gson.fromJson(json, Cliente.class);

		Integer ultimoId = Globales.daoCliente.agregar(clienteJson);
		response.getWriter().write(gson.toJson(Globales.daoCliente.obtenerPorId(ultimoId)));

		
		/*
		 * // Validaciones if (validacionesCliente(clienteJson, response, id)) {
		 * 
		 * // Si la validacion es correcta, se agrega el cliente
		 * 
		 * Cliente nuevoCliente = Globales.daoCliente.agregar(clienteJson);
		 * response.getWriter().write(gson.toJson(nuevoCliente));
		 * 
		 * 
		 * Integer ultimoId = Globales.daoCliente.agregar(clienteJson);
		 * response.getWriter().write(gson.toJson(Globales.daoCliente.obtenerPorId(
		 * ultimoId)));
		 * 
		 * 
		 * // El cliente se ha creado correctamente y muestra el código 201
		 * response.setStatus(HttpServletResponse.SC_CREATED); } else { return; }
		 */

	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Declaramos la variable json en la que guardamos el texto escrito
		String json = extraerJSON(request);

		// Guarda en cliente el texto escrito en Json, que es de la clase Cliente
		Cliente clienteJson = gson.fromJson(json, Cliente.class);

		// Declaramos la variable id
		Integer id = null;

		// Extraemos el id, o el valor null si no tiene y nos da una excepcion
		// indicando que se debe pasar id para modificar el cliente.
		try {
			id = extraerId(request);

			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Error.Se debe pasar el id del cliente a modificar.");

			return;
		}

		// Si el id no corresponde con el del cliente dará error y saldrá.
		if (!id.equals(clienteJson.getIdclientes())) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter()
					.write("Id de cliente no coincide con el que se quiere modificar. No se ha podido modificar");
			return;
		}

		// En caso de que coincida el id, buscamos cliente con ese id
		boolean existe = false;
		Iterable<Cliente> clientestodos = Globales.daoCliente.obtenerTodos();
		for (Cliente clienteX : clientestodos) {
			if (clienteX.getIdclientes() == clienteJson.getIdclientes()) {
				existe = true;
			}
		}
		// si no encuentra el cliente con ese id, error de No encontrado
		if (!existe) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de cliente no encontrado.");
			return;
		}

		// Validaciones del cliente
		if (validacionesCliente(clienteJson, response, id)) {
			// Modifica el cliente
			Cliente clienteModificado = Globales.daoCliente.modificar(clienteJson);
			response.getWriter().write(gson.toJson(clienteModificado));

		} else {
			return;
		}

		// Muestra el cliente añadido con el id correspondiente
		/*
		 * Cliente clienteJsonModificado = Globales.daoCliente.obtenerPorId(id);
		 * response.getWriter().write(gson.toJson(clienteJsonModificado));
		 */
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
			response.getWriter().write("Debe introducir el id de un cliente existente para eliminarlo");
			return;
		}

		// Buscamos el cliente con ese id para eliminarlo
		Cliente clienteABorrar = Globales.daoCliente.obtenerPorId(id);
		if (clienteABorrar == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de cliente no encontrado. No se ha podido borrar");
		} else {
			// Borra el cliente
			Globales.daoCliente.borrar(id);
			// Muestra el mensaje de que el cliente se ha eliminado
			response.getWriter().write("Cliente eliminado");
		}
	}

	private boolean validacionesCliente(Cliente clienteJson, HttpServletResponse response, Integer id)
			throws IOException {
		boolean correcto = true;

		if (clienteJson.getNombre() == null && clienteJson.getNombre().trim().length() < 1
				|| clienteJson.getNombre().length() > 45) {
			response.getWriter().write("El nombre del cliente debe tener entre 1 y 45 caracteres.\n");
			correcto = false;
		} else if (clienteJson.getNombre() != null && !clienteJson.getNombre().matches(REGEX_NOMBRE)) {
			response.getWriter()
					.write("Solo se admiten nombres con caracteres de letras y espacios en nombres compuestos. \n");
			correcto = false;
		}

		if (clienteJson.getApellidos() == null || clienteJson.getApellidos().trim().length() < 1
				|| clienteJson.getApellidos().length() > 90) {
			response.getWriter().write("Apellido/s del cliente obligatorio.Entre 1 y 90 caracteres. \n");
			correcto = false;
		} else if (clienteJson.getApellidos() != null && !clienteJson.getApellidos().matches(REGEX_APELLIDOS)) {
			response.getWriter().write(
					"Solo se admiten apellidos con caracteres de letras, apóstrofe y espacios entre apellidos.\n");
			correcto = false;
		}

		if (clienteJson.getDni() == null || clienteJson.getDni().trim().length() < 1) {
			response.getWriter().write("DNI obligatorio. \n");
			correcto = false;
		} else if (clienteJson.getDni() != null && !clienteJson.getDni().matches(REGEX_DNI)) {
			response.getWriter().write("Formato de DNI incorrecto. \n");
			correcto = false;
		}

		// Si estamos agregando un cliente(no pasamos id), comprobamos que el dni del
		// nuevo cliente no esté duplicado
		if (id == null) {
			Iterable<Cliente> todosLosClientes = Globales.daoCliente.obtenerTodos();
			for (Cliente clienteX : todosLosClientes) {
				if (clienteX.getDni().equals(clienteJson.getDni())) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("El DNI del cliente a agregar está duplicado");
					correcto = false;
				}
			}
		} else {
			/*
			 * En caso de estar modificando un cliente(ya disponemos de su id), comprobamos
			 * que el dni del nuevo cliente no esté duplicado
			 */
			Iterable<Cliente> todosLosClientes = Globales.daoCliente.obtenerTodos();
			Cliente cliente = Globales.daoCliente.obtenerPorId(id);
			for (Cliente clientX : todosLosClientes) {
				if (clientX.getDni().equals(clienteJson.getDni()) && !clienteJson.getDni().equals(cliente.getDni())) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("El DNI del cliente a modificar está duplicado");
					correcto = false;
				}
			}
		}

		return correcto;
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
