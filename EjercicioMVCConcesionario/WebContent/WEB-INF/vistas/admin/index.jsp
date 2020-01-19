<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Zona de administrador:</h1>
	<section>
		<a class="btn btn-primary btn-large" href="admin/indexmoto" role="button">Motos</a>
		<a class="btn btn-primary btn-large" href="admin/indexcoche" role="button">Coches</a>
		<a class="btn btn-primary btn-large" href="admin/indexquad" role="button">Quads</a>
	</section>
	
<%-- <section id="motos">
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
			<c:forEach items="${motos}" var="moto">
				<tr>
					<th>${moto.id}</th>
					<td>${moto.marca}</td>
					<td>${moto.modelo}</td>
					<td>${moto.precio}</td>
					<td><a href="${moto.url}">${moto.url}</a></td>
					<td><img class="img-thumbnail" style="height: 4rem;"
						src="imgs/motos/${moto.id}.jpg" /></td>
					<td><a class="btn btn-warning"
						href="admin/moto?id=${moto.id}&op=modificar">Modificar</a> <a
						class="btn btn-danger" href="admin/borrar?id=${moto.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/moto?op=agregar">Añadir</a>

</section> --%>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
