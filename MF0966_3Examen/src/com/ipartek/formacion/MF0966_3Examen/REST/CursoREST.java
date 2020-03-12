package com.ipartek.formacion.MF0966_3Examen.REST;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.MF0966_3Examen.controladores.Globales;
import com.ipartek.formacion.MF0966_3Examen.modelos.Curso;

@Path("/cursos")
@Produces("application/json")
@Consumes("application/json")
public class CursoREST {

	private static final Logger LOGGER = Logger.getLogger(CursoREST.class.getCanonicalName());

	@Context
	private ServletContext context;

	@GET
	public Iterable<Curso> obtenerTodos() {
		LOGGER.info("ObtenerTodos");
		LOGGER.info(context.toString());

		return Globales.daoCurso.obtenerTodos();
	}

	@GET
	@Path("/{id: \\d+}")
	public Curso obtenerPorId(@PathParam("id") Integer id) {
		LOGGER.info("ObtenerPorID(" + id + ")");

		Curso curso= Globales.daoCurso.obtenerPorId(id);
		if (curso == null) {
			LOGGER.warning("No se ha encontrado el curso (" + id + ")");
			throw new WebApplicationException("No se ha encontrado el curso (" + id + ")", Status.NOT_FOUND);
		}

		return curso;
	}

	@POST
	public Response insertar(Curso curso) {
		LOGGER.info("Insertar");
		Globales.daoCurso.agregar(curso);
		return Response.status(Status.CREATED).entity(curso).build();
	}

	@PUT
	@Path("/{id: \\d+}")
	public Curso modificar(@PathParam("id") Integer id, Curso curso) {
		LOGGER.info("Modificar");

		if (!curso.getCodigo().equals(id)) {
			LOGGER.warning("No coinciden los ids");
			throw new WebApplicationException("No coinciden los ids", Status.BAD_REQUEST);
		}

		boolean existe = false;
		Iterable<Curso> cursosTodos = Globales.daoCurso.obtenerTodos();
		for (Curso cursoX : cursosTodos) {
			if (cursoX.getCodigo() == curso.getCodigo()) {
				existe = true;
			}
		}
		if (!existe) {
			LOGGER.warning("No se ha encontrado el curso(" + id + ")");
			throw new WebApplicationException("No se ha encontrado el curso(" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoCurso.modificar(curso);
		return curso;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String borrar(@PathParam("id") Integer id) {
		LOGGER.info("Borrar");

		Curso curso = Globales.daoCurso.obtenerPorId(id);
		if (curso == null) {
			LOGGER.warning("No se ha encontrado el curso(" + id + ")");
			throw new WebApplicationException("No se ha encontrado el curso (" + id + ")", Status.NOT_FOUND);
		}
		Globales.daoCurso.borrar(id);
		return "{}";
	}

}
