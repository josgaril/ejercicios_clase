<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h3>COCHES DISPONIBLES</h3>
<section id="coches" class="row">
	<c:forEach items="${coches}" var="coche">
		<article id="coche"
			class="card col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<!-- ID: ${coche.id} -->
			<div class="card-body">
				<img src="imgs/coches/${coche.id}.jpg" class="card-img-top" alt="">
				<h3 class="card-title">${coche.marca}</h3>
				<p class="card-text">
					${coche.modelo} 
					${coche.precio} 
					<a href="${coche.url}">${coche.url}</a>
				</p>
			</div>
		</article>
	</c:forEach>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
