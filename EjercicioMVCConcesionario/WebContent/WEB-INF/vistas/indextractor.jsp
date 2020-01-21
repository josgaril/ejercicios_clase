<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h3>QUADS DISPONIBLES</h3>
<section id="tractores" class="row container">
	<c:forEach items="${tractores}" var="tractor">
		<article id="tractor"
			class="card col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<!-- ID: ${tractor.id} -->
			<div class="card-body">
				<img src="imgs/tractores/${tractor.imagen}.jpg" class="card-img-top" alt="">
				<h3 class="card-title">${tractor.marca}</h3>
				<h4 class="card-text">${tractor.modelo}</h4>
				<p class="card-text">Precio: ${tractor.precio} €</p>
				<p class="card-text">
					<a href="${tractor.url}" target="_blank">${tractor.url}</a>
				</p>
			</div>
		</article>
	</c:forEach>
</section>

<div class="container-fluid d-flex justify-content-end">
	<a href="indextractor"
		class="btn btn-primary btn-sm active d-block d-md-none" role="button"
		aria-pressed="true">TOP</a>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
