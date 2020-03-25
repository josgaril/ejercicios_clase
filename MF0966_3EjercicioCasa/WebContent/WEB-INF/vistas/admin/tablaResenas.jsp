<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h3>Reseñas de los alumnos</h3>
<section id="cursos">

	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive-xl">
		<thead class="thead-dark">
			<tr>
				<th>Codigo</th>
				<th>Alumno</th>
				<th>Curso</th>
				<th>Comentario</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resenas}" var="resena">
				<tr>
					<th>${resena.codigo}</th>
					<td>${resena.alumno.nombre} ${resena.alumno.apellidos}</td>
					<td>${resena.curso.nombre}</td>
					<td>
						<c:if test="${r.comentario!= '' }">
							<a href="javascript:alert('${resena.comentario}')">${fn:substring(resena.comentario, 0, 20)}
								${ fn:length(resena.comentario) > 20 ? '...' : '' } </a>
						</c:if>
<%-- 					resena.comentario. <javascript <%=  %> > Poner... y que salga el cuadro con el comentario completo</td> --%>
					<td>
						<a class="btn btn-warning" href="admin/resena?codigo=${resena.codigo}&op=modificar">Modificar</a> 
						<a class="btn btn-danger" href="admin/resena/borrar?codigo=${resena.codigo}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="thead-dark">
			<tr>
				<th>Codigo</th>
				<th>Alumno</th>
				<th>Curso</th>
				<th>Comentario</th>
				<th>Opciones</th>	
			</tr>
		</tfoot>
	</table>
	<a class="btn btn-primary" href="admin/resena?op=agregar">Añadir</a>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
