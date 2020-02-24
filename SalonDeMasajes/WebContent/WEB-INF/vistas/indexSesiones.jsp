<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2 class="titulo my-3">Listado de sesiones</h2>
<section id="sesiones" class="row">
	<c:forEach items="${sesiones}" var="sesion">
		<article class="sesion col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id">id: ${sesion.id}</p>
			<p class="idcliente">idcliente: ${sesion.clientes_idclientes}</p>
			<p class="idtrabajador">idtrabajador: ${sesion.trabajadores_idtrabajadores}</p>
			<p class="idservicio">idservicio: ${sesion.servicios_idservicios}</p>
			<p class="fecha">fecha: <fmt:formatDate value="${sesion.fecha}" pattern="dd-MM-yyyy HH:mm" /></p>
			<p class="reseña">reseña: ${sesion.resena}</p>
			<p class="calificacion">calificacion: ${sesion.calificacion}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
