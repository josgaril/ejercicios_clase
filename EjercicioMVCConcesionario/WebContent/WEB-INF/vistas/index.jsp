<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<header class="jumbotron">
	<h1 class="display-">CVJ Concesionario de Vehículos Josete</h1>
	<p class="lead">Su concesionario de confianza</p>
</header>

<section id="vehiculos" class="row">
	<article class="card col-12 col-sm-6 col-md-6 col-lg-4 col-xl-3"
		style="width: 18rem;">
		<img src="imgs/vehiculos/motos.jpg" class="card-img-top"
			alt="Imagen de motos">
		<div class="card-body">
			<a href="indexmoto" class="btn btn-primary">MOTOS</a>
		</div>
	</article>
	<article class="card col-12 col-sm-6 col-md-6 col-lg-4 col-xl-3"
		style="width: 18rem;">
		<img src="imgs/vehiculos/coches.jpg" class="card-img-top"
			alt="Imagen de coches">
		<div class="card-body">
			<a href="indexcoche" class="btn btn-primary">COCHES</a>
		</div>
	</article>
	<article class="card col-12 col-sm-6 col-md-6 col-lg-4 col-xl-3"
		style="width: 18rem;">
		<img src="imgs/vehiculos/kuads.jpg" class="card-img-top"
			alt="Imagen de quads">
		<div class="card-body">
			<a href="indexquad" class="btn btn-primary">QUADS</a>
		</div>
	</article>
</section>

<p>Navegue por el menú para visitar los vehículos deseados</p>

<%-- <h3>MOTOS</h3>
<section id="motos" class="row">
	<c:forEach items="${motos}" var="moto">
		<article id="moto" class="card col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<!-- ID: ${moto.id} -->
			<div class="card-body">
				<img src="imgs/motos/${moto.id}.jpg" class="card-img-top" alt="">
				<h3 class="card-title">${moto.marca}</h3>
				<p class="card-text">
					${moto.modelo}
					${moto.precio}
					<a href="${moto.url}">${moto.url}</a>
				</p>
			</div>
		</article>
	</c:forEach>
</section> --%>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
