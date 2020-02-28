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
    	
	private static final String URL_ID_VALIDA = "^/\\d+$";

	//Creamos el objeto gson
	private static Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Creamos la variable out que es tipo PrintWriter
		PrintWriter out = response.getWriter();
		//Creamos la variable id
		Integer id = null;
		
		try {
			//llamamos al metodo extraerId para ver si se ha pasado un id, sino devolverá null
			id = extraerId(request);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		//Si el id es null, escribe todos los clientes, convertidos a Json y acabamos
		if (id == null) {
			out.write(gson.toJson(Globales.daoCliente.obtenerTodos()));
			return;
		}
		//En caso de pasar el id de un cliente, obtenemos ese cliente 
		Cliente cliente = Globales.daoCliente.obtenerPorId(id);

		//Si el cliente es null, error No encontrado.
		if (cliente == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			//si lo encuentra, lo escribe.
			out.write(gson.toJson(cliente));
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
		//Declaramos la variable json, a la que le pasamos el texto
		String json = extraerJSON(request);
		//Creamos un cliente al que le pasamos el texto escrito en json
		Cliente cliente= gson.fromJson(json, Cliente.class);
					
		Globales.daoCliente.agregar(cliente);	
		
		response.getWriter().write(gson.toJson(cliente));
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String json = extraerJSON(request);
		Cliente cliente = gson.fromJson(json, Cliente.class);

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

		if (id != cliente.getIdclientes()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		Globales.daoCliente.modificar(cliente);

		response.getWriter().write(gson.toJson(cliente));
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

		Globales.daoCliente.borrar(id);

		response.getWriter().write("Cliente eliminado");
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
		//declaramos path para indicar la url recibida
		String path = request.getPathInfo();
		//si path es null o solo contiene la "/" devolvemos null
		if (path == null || path.equals("/")) {
			return null;
		}
		//si la url recibida no es valida mandamos RuntimeException
		if (!path.matches(URL_ID_VALIDA)) {
			throw new RuntimeException("URL de petición no válida");
		}
		//devolvemos el id, para ello extraemos la cadena de la url desde el primer caracter
		return Integer.parseInt(path.substring(1));
	}
}
