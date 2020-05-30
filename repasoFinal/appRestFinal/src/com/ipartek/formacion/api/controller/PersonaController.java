package com.ipartek.formacion.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.model.Curso;
import com.ipartek.formacion.model.Persona;
import com.ipartek.formacion.model.dao.CursoDAO;
import com.ipartek.formacion.model.dao.PersonaDAO;

@Path("/personas")
@Produces("application/json")
@Consumes("application/json")
public class PersonaController {

	private static final Logger LOGGER = Logger.getLogger(PersonaController.class.getCanonicalName());

	private static PersonaDAO personaDAO = PersonaDAO.getInstance();
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	@Context
	private ServletContext context;

	public PersonaController() {
		super();
	}
	
	/*
	 * @GET public Response getAll(){ LOGGER.info("getAll"); Response response =
	 * Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
	 * 
	 * ArrayList<Persona> personas = new ArrayList<Persona>(); personas =
	 * (ArrayList<Persona>) personaDAO.getAll(); response =
	 * Response.status(Status.OK).entity(personas).build(); return response;
	 * 
	 * }
	 */
	
	@GET
	public Response getAll(@QueryParam("rol") String rol, @QueryParam("nombre") String nombre) {
		LOGGER.info("GetAll");
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		if (rol==null || "".equals(rol.trim())) {
			LOGGER.info("Visualizamos todos");
			personas = (ArrayList<Persona>) personaDAO.getAll();
			
		}else {
			if ( "".equals(nombre)) {
				try {
					personas = (ArrayList<Persona>) personaDAO.getAllByRol(rol);
					LOGGER.info("Visualizamos por rol " + rol);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					personas = (ArrayList<Persona>) personaDAO.getAllNombre(rol, nombre);
					LOGGER.info("Visualizamos por rol " + rol);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		response = Response.status(Status.OK).entity(personas).build();
		return response;
		
	}
	
	
	@GET
	@Path("/{id: \\d+}")
	public Response getById(@PathParam("id") int id) {
		
		LOGGER.info("getByID(" + id + ")");
		Response response = Response.status(Status.NOT_FOUND).entity(null).build();
		ArrayList<String> errores = new ArrayList<String>();
		
		
		try {
			Persona persona = new Persona();
			persona = personaDAO.getById(id);
			response = Response.status(Status.OK).entity(persona).build();
			
		} catch (Exception e) {
			/*
			 * LOGGER.warning("Error al obtener la persona");
			 * errores.add("Error al obtener la persona"); response =
			 * Response.status(Status.BAD_REQUEST).entity(errores).build();
			 */
			errores.add(e.getMessage());
			LOGGER.warning("No se ha encontrado la persona con id " + id);
			response = Response.status(Status.NOT_FOUND).entity(errores).build();
		}
		
		return response;
	}
	
	@POST
	public Response insert(Persona persona) {
		LOGGER.info("Insert(" + persona + ")");
		ArrayList<String> errores = new ArrayList<String>();
		
		Set<ConstraintViolation<Persona>> violations = validator.validate(persona);

		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		
		if (violations.isEmpty()) {
			try {
				personaDAO.insert(persona);
				response = Response.status(Status.CREATED).entity(persona).build();
				LOGGER.info("Se ha creado la persona: " + persona);
			} catch (Exception e) {
				LOGGER.warning(e.getMessage());
				if (e.getMessage().contains("dni_UNIQUE")) {
					errores.add("El DNI introducido pertenece a otra persona");
					LOGGER.warning("El DNI introducido pertenece a otra persona");
				}else {
					errores.add("Error al agregar persona");
					LOGGER.warning("Error al agregar persona");
				}
				response = Response.status(Status.CONFLICT).entity(errores).build();
			}
		} else {

			for (ConstraintViolation<Persona> violation : violations) {
				errores.add(violation.getPropertyPath() + ": " + violation.getMessage());
			}
			LOGGER.warning("No se cumplen las validaciones para crear la persona: " + errores);
			response = Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		
		return response;
	}
	
	@PUT
	@Path("/{id: \\d+}")
	public Response update(@PathParam("id") int id, Persona persona) {
		LOGGER.info("update persona(" + persona + ")");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		ArrayList<String> errores = new ArrayList<String>();
		
		Set<ConstraintViolation<Persona>> violations = validator.validate(persona);

		if (violations.isEmpty()) {

			try {
				personaDAO.update(persona);
				LOGGER.info("Se ha modificado la persona" + persona);
				response = Response.status(Status.OK).entity(persona).build();
			} catch (Exception e) {
				LOGGER.warning(e.getMessage());
				if (e.getMessage().contains("dni_UNIQUE")) {
					errores.add("El DNI introducido pertenece a otra persona");
					LOGGER.warning("El DNI introducido pertenece a otra persona");
				}else {
					errores.add("Error al modificar persona");
					LOGGER.warning("Error al modificar persona");
				}
				response = Response.status(Status.CONFLICT).entity(errores).build();
			}

		}else {

			for (ConstraintViolation<Persona> violation : violations) {
				errores.add(violation.getPropertyPath() + ": " + violation.getMessage());
			}
			LOGGER.warning("No se cumplen las validaciones para modificar la persona: " + errores);
			response = Response.status(Status.BAD_REQUEST).entity(errores).build();

		}
		return response;
	}
	
	@DELETE
	@Path("/{id: \\d+}")
	public Response delete(@PathParam("id") int id) {
		LOGGER.info("delete persona(" + id + ")");
		Response response = Response.status(Status.NOT_FOUND).entity(null).build();
		ArrayList<String> errores = new ArrayList<String>();
		Persona persona = new Persona();
		
		try {
			persona = personaDAO.delete(id);
			response = Response.status(Status.OK).entity(persona).build();
		} catch (Exception e) {
			LOGGER.warning("No se puede eliminar porque tiene cursos activos");
			errores.add("No se puede eliminar porque tiene cursos activos");
			response = Response.status(Status.CONFLICT).entity(errores).build();
		}
		
		return response;
	}
	
	@POST
	@Path("/{idPersona}/curso/{idCurso}")
	public Response contratarCurso(@PathParam("idPersona") int idPersona, @PathParam("idCurso") int idCurso) {
		LOGGER.info("Contratar curso " + idCurso + " para la persona " + idPersona);
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		ArrayList<String> message = new ArrayList<String>();
		ArrayList<String> errores = new ArrayList<String>();
		
		try {
			personaDAO.contratarCurso(idPersona, idCurso);
			Curso curso = CursoDAO.getInstance().getById(idCurso);
			LOGGER.info("Curso Contratado");
			message.add("Curso Contratado");
			response = Response.status(Status.CREATED).entity(curso).build();
		} catch (Exception e) {
			if (e.getMessage().contains("Duplicate entry")) {
				errores.add("Ya tiene contratado ese curso");
			}
			if (e.getMessage().contains("fk_personas_has_cursos_cursos1")) {
				errores.add("No existe el curso introducido");
			}
			if (e.getMessage().contains("fk_personas_has_cursos_personas1")) {
				errores.add("No existe la persona introducida");
			}
			LOGGER.info("Error al contratar curso: " + errores);
			response = Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		return response;	
	}
	
	@DELETE
	@Path("/{idPersona}/curso/{idCurso}")
	public Response deleteCursoContratado(@PathParam("idPersona") int idPersona, @PathParam("idCurso") int idCurso) {
		LOGGER.info("delete curso(" + idCurso + ") de la persona (" + idPersona + ")");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		ArrayList<String> message = new ArrayList<String>();
		ArrayList<String> errores = new ArrayList<String>();
		try {
			personaDAO.eliminarCursoContratado(idPersona, idCurso);
			LOGGER.info("Curso eliminado correctamente");
			message.add("Curso eliminado correctamente");
			response = Response.status(Status.OK).entity(message).build();

		} catch (Exception e) {
			errores.add(e.getMessage());
			response = Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		
		return response;
		
	}
}
