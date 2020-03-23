<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="cursos">
	<h1 class="titulo text-center pt-3">Detalle del curso</h1>

	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive-xl">
		<thead class="thead-dark">
			<tr>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Identificador</th>
				<th>Fecha de inicio</th>
				<th>Fecha Fin</th>
				<th>Numero de horas</th>
				<th>Temario</th>
				<th>Activo</th>
				<th>Cliente</th>
				<th>Precio</th>
				<th>Profesor</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>${curso.codigo}</th>
				<td>${curso.nombre}</td>
				<td>${curso.identificador}</td>
				<td>${curso.fInicio}</td>
				<td>${curso.fFin}</td>
				<td>${curso.nHoras}</td>
				<td>${curso.temario}</td>
				<td>${curso.activo}</td>
				<td>${curso.cliente.nombre}</td>
				<td>${curso.precio}</td>
				<td>${curso.profesor.nombre}${curso.profesor.apellidos}</td>
			</tr>
		</tbody>
		<tfoot class="thead-dark">
			<tr>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Identificador</th>
				<th>Fecha de inicio</th>
				<th>Fecha Fin</th>
				<th>Numero de horas</th>
				<th>Temario</th>
				<th>Activo</th>
				<th>Cliente</th>
				<th>Precio</th>
				<th>Profesor</th>
			</tr>
		</tfoot>
	</table>

	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive-xl">
		<thead class="thead-dark">
			<tr>
				<th>Alumno</th>
				<th>Comentario</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resena}" var="resena">
				<tr>
					<td>${resena.alumno.nombre}${resena.alumno.apellidos}</td>
					<td>${resena.comentario}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="thead-dark">
			<tr>
				<th>Alumno</th>
				<th>Comentario</th>
			</tr>
		</tfoot>
	</table>

	<a class=" btn btn-success" href="admin/cursos">Atrás</a>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
