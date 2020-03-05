<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="clientes">
<h1 class="titulo text-center pt-3">CLIENTES</h1>
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
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<th>${cliente.idclientes}</th>
					<td>${cliente.nombre}</td>
					<td>${cliente.apellidos}</td>
					<td>${cliente.dni}</td>
					<td><a class="btn btn-warning"
						href="admin/cliente?idclientes=${cliente.idclientes}&op=modificar">Modificar</a> <a
						class="btn btn-danger" href="admin/cliente/borrar?idclientes=${cliente.idclientes}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>DNI</th>
				<th>Opciones</th>
			</tr>
		</thead>
	</table>

	<a class="btn btn-primary" href="admin/cliente?op=agregar">Añadir</a>
	<a class="btn btn-success mx-2" href="admin/">Volver</a>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
