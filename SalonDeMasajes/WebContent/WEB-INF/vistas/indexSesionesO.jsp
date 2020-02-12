<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Empezando la construcción de la página</h1>

<header class="jumbotron">
	<h2 class="display-6">Bienvenidos al salón de masajes SAMAJA</h2>
</header>
<h2>Listado de las sesiones</h2>
<section id="sesionesO" class="row">
	<c:forEach items="${sesionesO}" var="sesionO">
		<article class="sesionO col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id">id: ${sesionO.id}</p>
			<p class="cliente">cliente: ${sesionO.clienteO}</p>
			<p class="trabajador">trabajador: ${sesionO.trabajadorO}</p>
			<p class="servicio">servicio: ${sesionO.servicioO}</p>
			<p class="fecha">fecha: ${sesionO.fecha}</p>
			<p class="reseña">reseña: ${sesionO.resena}</p>
			<p class="calificacion">calificacion: ${sesionO.calificacion}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
