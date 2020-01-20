<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="quads">

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
			<c:forEach items="${quads}" var="quad">
				<tr>
					<th>${quad.id}</th>
					<td>${quad.marca}</td>
					<td>${quad.modelo}</td>
					<td>${quad.precio} €</td>
					<td><a href="${quad.url}">${quad.url}</a></td>
					<td><img class="img-thumbnail" style="height: 4rem;"
						src="imgs/quads/${quad.modelo}.jpg" /></td>
					<td>
						<a class="btn btn-warning" href="admin/quad?id=${quad.id}&op=modificar">Modificar</a> 
					<a class="btn btn-danger" href="admin/quad?id=${quad.id}&op=borrar">Borrar</a>
<%-- 						<a class="btn btn-danger" href="admin/borrarquad?id=${quad.id}&op=borrar">Borrar</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/quad?op=agregar">Añadir</a>
	<a class="btn btn-success" href="admin/index"> Atrás</a>

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
