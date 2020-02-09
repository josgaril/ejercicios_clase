<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Empezando la construcción de la página</h1>

<header class="jumbotron">
	<h2 class="display-6">Bienvenidos al salón de masajes SAMAJA</h2>
</header>
<h2>Mostramos listado de los clientes</h2>
<section id="clientes" class="row">
	<c:forEach items="${clientes}" var="cliente">
		<article class="cliente col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id: ">${cliente.idclientes}</p>
			<p class="nombre: ">${cliente.nombre}</p>
			<p class="apellidos: ">${cliente.apellidos}</p>
			<p class="dni: ">${cliente.dni}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
