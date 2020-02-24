<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2 class="titulo my-3">Servicios disponibles</h2>
<section id="servicios" class="row">
	<c:forEach items="${servicios}" var="servicio">
		<article class="servicio col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id">id: ${servicio.idservicios}</p>
			<p class="nombre">nombre: ${servicio.nombre}</p>
			<p class="precio">precio: <fmt:formatNumber type="currency"
						value="${servicio.precio}" pattern="#0.000" /> €</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
