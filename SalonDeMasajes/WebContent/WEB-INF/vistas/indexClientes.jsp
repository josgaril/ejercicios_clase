<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2 class="titulo my-3">Listado de clientes</h2>
<section id="clientes" class="row">
	<c:forEach items="${clientes}" var="cliente">
		<article class="cliente col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<hr>
			<p class="id">id: ${cliente.idclientes}</p>
			<p class="nombre">nombre: ${cliente.nombre}</p>
			<p class="apellidos">apellidos: ${cliente.apellidos}</p>
			<p class="dni">dni: ${cliente.dni}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
