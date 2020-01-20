<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<h3>MOTOS DISPONIBLES</h3>
<section id="motos" class="row">
	<c:forEach items="${motos}" var="moto">
		<article id="moto" class="card col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<!-- ID: ${moto.id} -->
			<div class="card-body">
				<img src="imgs/motos/${moto.modelo}.jpg" class="card-img-top" alt="">
				<h3 class="card-title">${moto.marca}</h3>
				<p class="card-text">${moto.modelo}<p>
				<p class="card-text">Precio: ${moto.precio}</p>
				<p class="card-text"><a href="${moto.url}">${moto.url}</a></p>
				</p>
			</div>
		</article>
	</c:forEach>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
