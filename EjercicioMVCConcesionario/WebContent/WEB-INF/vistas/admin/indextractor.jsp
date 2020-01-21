<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="tractores">

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
			<c:forEach items="${tractores}" var="tractor">
				<tr>
					<th>${tractor.id}</th>
					<td>${tractor.marca}</td>
					<td>${tractor.modelo}</td>
					<td>${tractor.precio} €</td>
					<td><a href="${tractor.url}" target="_blank">${tractor.url}</a></td>
					<td><img class="img-thumbnail" style="height: 4rem;"
						src="imgs/tractores/${tractor.imagen}.jpg" /></td>
					<td>
						<a class="btn btn-warning" href="admin/tractor?id=${tractor.id}&op=modificar">Modificar</a> 
					<a class="btn btn-danger" href="admin/tractor?id=${tractor.id}&op=borrar">Borrar</a>
<%-- 						<a class="btn btn-danger" href="admin/borrartractor?id=${tractor.id}&op=borrar">Borrar</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/tractor?op=agregar">Añadir</a>
	<a class="btn btn-success" href="admin/index"> Atrás</a>

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
