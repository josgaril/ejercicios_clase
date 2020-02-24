<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2 class="titulo my-3">Listado de sesiones</h2>
<section id="sesionesO" class="row">
	<c:forEach items="${sesionesO}" var="sesionO">
		<article class="sesionO col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id">ID: ${sesionO.id}</p>
			<p class="cliente">Cliente: ${sesionO.clienteO.nombre} ${sesionO.clienteO.apellidos}</p>
			<p class="trabajador">Trabajador: ${sesionO.trabajadorO.nombre} ${sesionO.trabajadorO.apellidos}</p>
			<p class="servicio">Servicio: ${sesionO.servicioO.nombre}</p>
			<p class="fecha">Fecha: <fmt:formatDate value="${sesionO.fecha}" pattern="dd-MM-yyyy HH:mm" /></p>
			<p class="reseña">Reseña: ${sesionO.resena}</p>
			<p class="calificacion">Calificacion: ${sesionO.calificacion}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
