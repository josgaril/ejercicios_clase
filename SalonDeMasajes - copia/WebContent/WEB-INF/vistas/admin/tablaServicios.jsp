<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="servicios">
	<h1 class="titulo text-center pt-3">SERVICIOS</h1>
	<table
		class="table table-striped table-bordered table-hover table-sm">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${servicios}" var="servicio">
				<tr>
					<th>${servicio.idservicios}</th>
					<td>${servicio.nombre}</td>
					<td><fmt:formatNumber type="currency"
							value="${servicio.precio}" pattern="#0.000" /> €</td>

					<td><a class="btn btn-warning"
						href="admin/servicio?idservicios=${servicio.idservicios}&op=modificar">Modificar</a>
						<a class="btn btn-danger"
						href="admin/servicio/borrar?idservicios=${servicio.idservicios}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Opciones</th>
			</tr>
		</tfoot>
	</table>

	<a class="btn btn-primary" href="admin/servicio?op=agregar">Añadir</a>
	<a class="btn btn-success mx-2" href="admin/">Volver</a>
	

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
