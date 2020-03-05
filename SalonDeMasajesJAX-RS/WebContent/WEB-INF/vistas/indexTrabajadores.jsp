<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2 class="titulo my-3">Listado de los trabajadores</h2>
<section id="trabajadores" class="row">
	<c:forEach items="${trabajadores}" var="trabajador">
		<article class="trabajador col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<hr>
			<p class="id">id: ${trabajador.idtrabajadores}</p>
			<p class="nombre">nombre: ${trabajador.nombre}</p>
			<p class="apellidos">apellidos: ${trabajador.apellidos}</p>
			<p class="dni">dni: ${trabajador.dni}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
