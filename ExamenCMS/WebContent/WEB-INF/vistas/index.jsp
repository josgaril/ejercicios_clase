<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<header class="jumbotron">
	<h2 class="display-6">Libreria Josete</h2>
	<h4> Su librería de confianza</h4>
</header>

<section id="libros">
	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Descuento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th>${libro.id}</th>
					<td>${libro.nombre}</td>
					<td>${libro.precio} €</td>
					<td>${libro.descuento} %</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="index?op=agregar">Añadir</a>

</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
