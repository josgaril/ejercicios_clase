<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<header class="jumbotron">
	<h1 class="display-">CVJ Concesionario de Vehículos Josete</h1>
	<p class="lead">Su concesionario de confianza</p>
</header>

<section id="vehiculos" class="row container-fluid">
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
		<img src="imgs/vehiculos/quads.jpg" class="card-img-top"
			alt="Imagen de quads">
		<div class="card-body">
			<a href="indexquad" class="btn btn-primary">QUADS</a>
		</div>
	</article>
		<article class="card col-12 col-sm-6 col-md-6 col-lg-4 col-xl-3"
		style="width: 18rem;">
		<img src="imgs/vehiculos/tractores.jpg" class="card-img-top"
			alt="Imagen de tractores">
		<div class="card-body">
			<a href="indextractor" class="btn btn-primary">TRACTORES</a>
		</div>
	</article>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
