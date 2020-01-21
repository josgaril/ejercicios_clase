<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h3>QUADS DISPONIBLES</h3>
<section id="quads" class="row container">
	<c:forEach items="${quads}" var="quad">
		<article id="quad"
			class="card col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<!-- ID: ${quad.id} -->
			<div class="card-body">
				<img src="imgs/quads/${quad.modelo}.jpg" class="card-img-top" alt="">
				<h3 class="card-title">${quad.marca}</h3>
				<h4 class="card-text">${quad.modelo}</h4>
				<p class="card-text">Precio: ${quad.precio} €</p>
				<p class="card-text">
					<a href="${quad.url}">${quad.url}</a>
				</p>
			</div>
		</article>
	</c:forEach>
</section>

<div class="container-fluid d-flex justify-content-end">
	<a href="indexquad"
		class="btn btn-primary btn-sm active d-block d-md-none" role="button"
		aria-pressed="true">TOP</a>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
