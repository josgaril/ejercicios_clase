package com.ipartek.formacion.mf0966_3ejerciciocasa.REST;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;

import com.ipartek.formacion.mf0966_3ejerciciocasa.controladores.Globales;
import com.ipartek.formacion.mf0966_3ejerciciocasa.modelos.Curso;

@Path("/cursos")
@Produces("application/json")
@Consumes("application/json")
public class CursoREST {
	
	private static final Logger LOGGER = Logger.getLogger(CursoREST.class.getCanonicalName());

	@Context
	private ServletContext context;
	 
	@GET
	public Iterable<Curso> obtenerTodos(){
		LOGGER.info("ObtenerTodos");
		LOGGER.info(context.toString());

		return Globales.daoCurso.obtenerTodos();
	}
	
	@GET
	@Path("/{codigo: \\d+}")
	public Curso obtenerPorCodigo(@PathParam("codigo") Integer codigo) {
		LOGGER.info("Obtener por Codigo");
		
		Curso curso = Globales.daoCurso.obtenerPorCodigo(codigo);
		if (curso==null) {
			LOGGER.warning("No se ha encontrado el curso (" + codigo + ")");
			throw new WebApplicationException("No se ha encontrado el curso (" + codigo + ")", Status.NOT_FOUND);
		}
		return curso;		
	}
	
}
