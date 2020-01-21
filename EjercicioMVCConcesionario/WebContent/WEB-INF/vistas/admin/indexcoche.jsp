<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="coches">

	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive">
		<thead>
			<tr>
				<th>Id</th>
				<th>Marca</th>
				<th>Modelo</th>
				<th>Precio</th>
				<th>URL</th>
				<th>Imagen</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${coches}" var="coche">
				<tr>
					<th>${coche.id}</th>
					<td>${coche.marca}</td>
					<td>${coche.modelo}</td>
					<td>${coche.precio} €</td>
					<td><a href="${coche.url}" target="_blank">${coche.url}</a></td>
					<td><img class="img-thumbnail" style="height: 4rem;"
						src="imgs/coches/${coche.modelo}.jpg" /></td>
					<td><a class="btn btn-warning"
						href="admin/coche?id=${coche.id}&op=modificar">Modificar</a> <a
						class="btn btn-danger" href="admin/borrarcoche?id=${coche.id}&op=borrar">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/coche?op=agregar">Añadir</a>
	<a class="btn btn-success" href="admin/index"> Atrás</a>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
