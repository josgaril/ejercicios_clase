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
			//out.write(gson.toJson(usuarios.values()));
			// response.getWriter().write(new Gson().toJson(usuarios.values()));
			return;
		}

		//Usuario usuario = usuarios.get(id);
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

		Trabajador trabajador= gson.fromJson(json, Trabajador.class);
					
		Globales.daoTrabajador.agregar(trabajador);	

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
