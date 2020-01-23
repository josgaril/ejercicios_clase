<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<!-- EL ADMINISTRADOR PUEDE VER TODOS LOS LIBROS, 
	Y TIENE LAS OPCIONES DE AÑADIR, MODIFICAR Y BORRAR LIBROS -->
	
<section id="libros">
	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Descuento</th>
				<th>Autor</th>
				<th>Imagen</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th>${libro.id}</th>
					<td>${libro.nombre}</td>
					<td>${libro.precio}€</td>
					<td>${libro.descuento}%</td>
					<td>${libro.autor}</td>
					<td><img src="${libro.imagen}" alt="Imagen ${libro.nombre}"
						class="img-thumbnail" style="height: 4rem" /></td>
						
					<%-- Si queremos que el administrador tambien tenga acceso a la URL de la imagen:
					<td><a href="${libro.imagen}"><img src="${libro.imagen}"
						alt="Imagen ${libro.nombre}" class="img-thumbnail" style="height: 4rem"/></a></td>
					
					 --%>
					<td><a class="btn btn-warning"
						href="admin/libro?id=${libro.id}&op=modificar">Modificar</a> <a
						class="btn btn-danger" href="admin/borrar?id=${libro.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/libro?op=agregar">Añadir</a>

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
