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
import com.ipartek.formacion.sdm.modelos.SesionO;

@WebServlet("/api/sesionesO/*")
public class SesionesApi extends HttpServlet {
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
			out.write(gson.toJson(Globales.daoSesionO.obtenerTodos()));
			return;
		}

		SesionO sesion = Globales.daoSesionO.obtenerPorId(id);

		if (sesion == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		} else {
			out.write(gson.toJson(sesion));
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
		SesionO sesion = gson.fromJson(json, SesionO.class);
		Globales.daoSesionO.agregar(sesion);
		response.getWriter().write(gson.toJson(sesion));
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = null;

		try {
			id = extraerID(request);
			if (id == null) {
				throw new Exception();
			}
		} catch (Exception e1) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		String json = extraerJSON(request);
		SesionO sesion = gson.fromJson(json, SesionO.class);

		if (id!= sesion.getId()){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Error al modificar la sesion");

			return;
		}

		Globales.daoSesionO.modificar(sesion);
		response.getWriter().write(gson.toJson(sesion));
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = null;

		try {
			if (extraerID(request) == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		Globales.daoSesionO.borrar(id);
		response.getWriter().write("Sesión eliminada");

	}

	private static Integer extraerID(HttpServletRequest request) {
		String path = request.getPathInfo();

		if (path == null || path.equals("/")) {
			return null;
		}

		if (!path.matches(URL_ID_VALIDA)) {
			throw new RuntimeException("URL introducida no válida");
		}

		return Integer.parseInt(path.substring(1));
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

}
