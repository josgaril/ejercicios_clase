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
import com.ipartek.formacion.sdm.modelos.Servicio;
import com.ipartek.formacion.sdm.modelos.SesionO;
import com.ipartek.formacion.sdm.modelos.Trabajador;

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
			response.getWriter().write("Error al extraer id de sesión");
			return;
		}

		if (id == null) {
			out.write(gson.toJson(Globales.daoSesionO.obtenerTodos()));
			return;
		}

		SesionO sesion = Globales.daoSesionO.obtenerPorId(id);

		if (sesion == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de sesión no encontrado.");
			return;
		} else {
			out.write(gson.toJson(sesion));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = null;
		try {
			id = extraerID(request);
			if (id != null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Error.No se debe pasar un ID para agregar una sesión");
			return;
		}
		String json = extraerJSON(request);
		SesionO sesionJson = gson.fromJson(json, SesionO.class);

		if (validacionesSesion(response, sesionJson, id)) {
			
			SesionO sesion=Globales.daoSesionO.agregar(sesionJson);
			response.getWriter().write(gson.toJson(sesion));
			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

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
			response.getWriter().write("Error.Se debe pasar un ID para modificar la sesión");
		}

		String json = extraerJSON(request);
		SesionO sesionJson = gson.fromJson(json, SesionO.class);

		if (!id.equals(sesionJson.getId())) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter()
					.write("Id de la sesión no coincide con la que se quiere modificar. No se ha podido modificar");
			return;
		}

		// los id son iguales. hay que comprobar si existe o no
		boolean existe = false;
		Iterable<SesionO> sesionesTodas = Globales.daoSesionO.obtenerTodos();
		for (SesionO sesionX : sesionesTodas) {
			if (sesionX.getId() == sesionJson.getId()) {
				existe = true;
			}
		}
		if (!existe) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de sesión no encontrado");
		}

		// Validaciones de sesion
		if (validacionesSesion(response, sesionJson, id)) {
			Globales.daoSesionO.modificar(sesionJson);
			response.getWriter().write(gson.toJson(sesionJson));
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

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
			response.getWriter().write("Debe introducir el id de una sesión existente para eliminarlo");
			return;
		}

		SesionO sesionABorrar = Globales.daoSesionO.obtenerPorId(id);
		if (sesionABorrar == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Id de sesión no encontrado. No se ha podido borrar");
			return;
		}
		Globales.daoSesionO.borrar(id);
		response.getWriter().write("Sesión eliminada");

	}

	private boolean validacionesSesion(HttpServletResponse response, SesionO sesionJson, Integer id)
			throws IOException {
		boolean correcto = true;
		// Comprobamos que existe el cliente
		Iterable<Cliente> clientesTodos = Globales.daoCliente.obtenerTodos();
		boolean existeCliente = false;
		for (Cliente clienteX : clientesTodos) {
			if (clienteX.getIdclientes() == sesionJson.getClienteO().getIdclientes()) {
				existeCliente = true;
			}
		}
		if (!existeCliente) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("El cliente no existe.  \n");
			correcto = false;
		}

		// Comprobamos que existe el trabajador
		Iterable<Trabajador> trabajadoresTodos = Globales.daoTrabajador.obtenerTodos();
		boolean existeTrabajador = false;
		for (Trabajador trabajadorX : trabajadoresTodos) {
			if (trabajadorX.getIdtrabajadores() == sesionJson.getTrabajadorO().getIdtrabajadores()) {
				existeTrabajador = true;
			}
		}
		if (!existeTrabajador) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("El trabajador no existe. \n");
			correcto = false;
		}
		// Comprobamos que existe el servicio
		Iterable<Servicio> serviciosTodos = Globales.daoServicio.obtenerTodos();
		boolean existeServicio = false;
		for (Servicio servicioX : serviciosTodos) {
			if (servicioX.getIdservicios() == sesionJson.getServicioO().getIdservicios()) {
				existeServicio = true;
			}
		}
		if (!existeServicio) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("El servicio no existe. \n");
			correcto = false;
		}

		// Comprobamos si se ha pasado id (modificar) o no (agregar)
		// Si el id es null estamos agregando
		if (id == null) {
			// Conprobamos que no existe otra sesión a la hora indicada
			Iterable<SesionO> sesionesTodas = Globales.daoSesionO.obtenerTodos();
			for (SesionO sesionX : sesionesTodas) {
				if (sesionJson.getFecha().equals(sesionX.getFecha())) {
					response.getWriter().write("Ya hay otra sesión en esa fecha a esa hora");
					correcto = false;
				}
			}
			return correcto;
		} else {
			// estamos modificando
			Iterable<SesionO> sesionesTodas = Globales.daoSesionO.obtenerTodos();
			SesionO sesionExistente = Globales.daoSesionO.obtenerPorId(id);
			for (SesionO sesionX : sesionesTodas) {
				if (sesionJson.getFecha().equals(sesionX.getFecha())
						&& !sesionJson.getFecha().equals(sesionExistente.getFecha())) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("Ya hay otra sesión en esa fecha a esa hora");
					correcto = false;
				}
			}
			return correcto;
		}

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
