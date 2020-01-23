<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<header class="jumbotron">
	<h2 class="display-3">Libros Josete</h2>
</header>

<!-- INCLUIMOS UN LISTADO PARA VER TODOS LOS LIBROS -->

<section id="libros" class="row">
	<c:forEach items="${libros}" var="libro">
		<article id="libros"
			class="card col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<div class="card-body">
				<p class="card-text">
					<a href="${libro.imagen}"> <img src="${libro.imagen}" alt="Imagen los futbolisimos" class="img-fluid" target="_blank"></a>
				</p>
				<p class="card-text">${libro.nombre}</p>
				<p class="card-text"><b>${libro.autor}</b></p>
				<p class="card-text">${libro.precio}€</p>
				<p class="card-text descuento text-center text-white">- ${libro.descuento}%</p>
			</div>
		</article>
	</c:forEach>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
