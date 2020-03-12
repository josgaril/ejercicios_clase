<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="trabajadores">
<h1 class="titulo text-center pt-3">TRABAJADORES</h1>
	<table
		class="table table-striped table-bordered table-hover table-sm">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>DNI</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trabajadores}" var="trabajador">
				<tr>
					<th>${trabajador.idtrabajadores}</th>
					<td>${trabajador.nombre}</td>
					<td>${trabajador.apellidos}</td>
					<td>${trabajador.dni}</td>
					<td><a class="btn btn-warning"
						href="admin/trabajador?idtrabajadores=${trabajador.idtrabajadores}&op=modificar">Modificar</a> <a
						class="btn btn-danger" href="admin/trabajador/borrar?idtrabajadores=${trabajador.idtrabajadores}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>DNI</th>
				<th>Opciones</th>
			</tr>
		</tfoot>
	</table>

	<a class="btn btn-primary" href="admin/trabajador?op=agregar">Añadir</a>
	<a class="btn btn-success mx-2" href="admin/">Volver</a>

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
