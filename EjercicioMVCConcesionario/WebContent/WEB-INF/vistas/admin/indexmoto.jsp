<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="motos">

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
					<td>${moto.precio} €</td>
					<td><a href="${moto.url}" target="_blank">${moto.url}</a></td>
					<td><img class="img-thumbnail" style="height: 4rem;"
						src="imgs/motos/${moto.modelo}.jpg" /></td>
					<td><a class="btn btn-warning"
						href="admin/moto?id=${moto.id}&op=modificar">Modificar</a> 
						<a class="btn btn-danger" href="admin/moto?id=${moto.id}&op=borrar">Borrar</a>

						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/moto?op=agregar">Añadir</a>
	<a class="btn btn-success" href="admin/index"> Atrás</a>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
