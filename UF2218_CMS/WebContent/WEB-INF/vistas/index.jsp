<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<section id="objeto" class="table-responsive col my-3">
	<h2>LIBROS</h2>
	<table width="100%" class="table table-striped table-bordered" id="dataTable">
		<thead class="tableTitles">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Descuento</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<td>${libro.id}</td>
					<td>${libro.nombre}</td>
					<td>${libro.precio}</td>
					<td>${libro.descuento}</td>
					<td><a class="btn btn-warning disabled"
						href="index?id=${libro.id}&op=modificar">Modificar</a> 
						<a class="btn btn-danger my-1 disabled" data-id="${objeto.id}" data-name="${objeto.nombre}" 
						data-href="index?id=${objeto.id}&op=borrar" ">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-12 table-sm">
		<a class="btn btn-primary" href="index?op=agregar">Añadir</a>
	</div>
</section>




<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
