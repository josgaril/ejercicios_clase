package com.ipartek.formacion.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.model.Curso;
import com.ipartek.formacion.model.dao.CursoDAO;

@Path("/cursos")
@Produces("application/json")
@Consumes("application/json")
public class CursoController {

	private static Logger LOGGER = Logger.getLogger(CursoController.class.getCanonicalName());
	
	private static CursoDAO cursoDAO = CursoDAO.getInstance();
	
	@Context
	private ServletContext context;
	
	public CursoController() {
		super();
	}
	
	@GET
	public Response getAll(@QueryParam("filtro") String filtro){
		LOGGER.info("CursoController getAll()");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		ArrayList<Curso> cursos  = new ArrayList<Curso>();
		if (filtro == null || "".equals(filtro.trim())) {
			cursos  = (ArrayList<Curso>) cursoDAO.getAll();
			LOGGER.info("cursos obtenidos" + cursos);
		}else {
			cursos= (ArrayList<Curso>) cursoDAO.getAllByNombre(filtro);
			LOGGER.info("cursos obtenidos con filtro: " + filtro);
		}
		response = Response.status(Status.OK).entity(cursos).build();
		
		return response;
	}
	
	/*
	 * @GET
	 * 
	 * @Path("/{id: \\d+}")
	 * 
	 * public Response getById(@PathParam("id") int id) { LOGGER.info("getById(" +
	 * id + ")"); Response response =
	 * Response.status(Status.NOT_FOUND).entity(null).build(); ArrayList<String>
	 * errores = new ArrayList<String>();
	 * 
	 * try { Curso curso = new Curso(); curso = cursoDAO.getById(id);
	 * LOGGER.info("Recibido el curso: " + curso); response =
	 * Response.status(Status.OK).entity(curso).build(); } catch (Exception e) {
	 * LOGGER.info("No se ha encontrado el curso " + id);
	 * errores.add("No se ha encontrado el curso " + id); response =
	 * Response.status(Status.NOT_FOUND).entity(errores).build(); }
	 * 
	 * return response; }
	 */
	
	@GET
	@Path("/{id: \\d+}")
	public Response getByProfesor(@PathParam("id") int id) {
		LOGGER.info("getByProfesor");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ArrayList<String> mensaje = new ArrayList<String>();
		ArrayList<String> error = new ArrayList<String>();
		
		try {
			cursos = cursoDAO.getByProfesor(id);
			mensaje.add("Encontrados cursos: " + cursos);
			response = Response.status(Status.OK).entity(cursos).build();
		} catch (SQLException e) {
			error.add(e.getMessage());
			LOGGER.warning(e.getMessage());
			response = Response.status(Status.BAD_REQUEST).entity(error).build();
		}
		return response;
	}
	
	@PUT
	@Path("/{id: \\d+}")
	public Response update (@PathParam("id") int idCurso, Curso curso) {
		LOGGER.info("update curso(" + idCurso + ")");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		
		ArrayList<String> errores = new ArrayList<String>();
		try {
			cursoDAO.update(curso);
			LOGGER.info("Curso Modificado");
			response = Response.status(Status.OK).entity(curso).build();

		} catch (Exception e) {
			errores.add(e.getMessage());
			response = Response.status(Status.BAD_REQUEST).entity(errores).build();

		}
		
		
		return response;
	}
		
}
