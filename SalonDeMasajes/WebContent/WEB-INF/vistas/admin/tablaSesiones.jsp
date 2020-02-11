<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="sesiones">
	<h1>SESIONES</h1>
	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive">
		<thead>
			<tr>
				<th>Id</th>
				<th>IdCliente</th>
				<th>IdTrabajador</th>
				<th>IdServicio</th>
				<th>Fecha</th>
				<th>Reseña</th>
				<th>Calificación</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sesiones}" var="sesion">
				<tr>
					<th>${sesion.id}</th>
					<td>${sesion.clientes_idclientes}</td>
					<td>${sesion.trabajadores_idtrabajadores}</td>
					<td>${sesion.servicios_idservicios}</td>
					<td>${sesion.fecha}</td>
					<td>${sesion.resena}</td>
					<td>${sesion.calificacion}</td>

					<td><a class="btn btn-warning"
						href="admin/sesion?id=${sesion.id}&op=modificar">Modificar</a>
						<a class="btn btn-danger"
						href="admin/sesion/borrar?id=${sesion.id}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/sesion?op=agregar">Añadir</a>

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
