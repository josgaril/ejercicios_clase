<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="sesionesO">
	<h1 class="titulo text-center pt-3">SESIONES</h1>
	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive-xl">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Cliente</th>
				<th>Trabajador</th>
				<th>Servicio</th>
				<th>Fecha</th>
				<th>Reseña</th>
				<th>Calificación</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sesionesO}" var="sesionO">
				<tr>
					<th>${sesionO.id}</th>
					<td>${sesionO.clienteO.nombre} ${sesionO.clienteO.apellidos}</td>
					<td>${sesionO.trabajadorO.nombre} ${sesionO.trabajadorO.apellidos}</td>
					<td>${sesionO.servicioO.nombre}</td>
					<td><fmt:formatDate value="${sesionO.fecha}" pattern="dd-MM-yyyy HH:mm" /></td>
					<td>
						<c:if test="${s.resena != '' }">
							<a href="javascript:alert('${sesionO.resena}')">${fn:substring(sesionO.resena, 0, 20)}
								${ fn:length(sesionO.resena) > 20 ? '...' : '' } </a>
						</c:if>
					</td>
					<td>${sesionO.calificacion}</td>

					<td><a class="btn btn-warning"
						href="admin/sesionO?id=${sesionO.id}&op=modificar">Modificar</a> <a
						class="btn btn-danger"
						href="admin/sesionO/borrar?id=${sesionO.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Cliente</th>
				<th>Trabajador</th>
				<th>Servicio</th>
				<th>Fecha</th>
				<th>Reseña</th>
				<th>Calificación</th>
				<th>Opciones</th>
			</tr>
		</tfoot>
	</table>

	<a class="btn btn-primary" href="admin/sesionO?op=agregar">Añadir</a> <a
		class="btn btn-success mx-2" href="admin/">Volver</a>

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
