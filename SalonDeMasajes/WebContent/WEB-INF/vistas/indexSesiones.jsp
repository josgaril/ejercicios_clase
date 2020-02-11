<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Empezando la construcción de la página</h1>

<header class="jumbotron">
	<h2 class="display-6">Bienvenidos al salón de masajes SAMAJA</h2>
</header>
<h2>Listado de las sesiones</h2>
<section id="sesiones" class="row">
	<c:forEach items="${sesiones}" var="sesion">
		<article class="sesion col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id">id: ${sesion.id}</p>
			<p class="idcliente">idcliente: ${sesion.clientes_idclientes}</p>
			<p class="idtrabajador">idtrabajador: ${sesion.trabajadores_idtrabajadores}</p>
			<p class="idservicio">idservicio: ${sesion.servicios_idservicios}</p>
			<p class="fecha">fecha: ${sesion.fecha}</p>
			<p class="reseña">reseña: ${sesion.resena}</p>
			<p class="calificacion">calificacion: ${sesion.calificacion}</p>
		</article>
	</c:forEach>
	<hr>
	<p>hola</p>
	
	<c:forEach items="${clientes}" var="cliente">
		<article class="cliente col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id">id: ${cliente.idclientes}</p>
			<p class="nombre">nombre: ${cliente.nombre}</p>
			<p class="apellidos">apellidos: ${cliente.apellidos}</p>
			<p class="dni">dni: ${cliente.dni}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
