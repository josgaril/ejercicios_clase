<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<header class="logoEmpresa">
	<img src="imgs/LogoEmpresa2.jpg" alt="Logo de la empresa"
		class="img-fluid mb-3" />
</header>

<!-- <header class="jumbotron"> -->
<!-- 	<h2 class="display-6">Bienvenidos al salón de masajes SAMAJA</h2> -->
<!-- </header> -->
<div class="EnlacesListados">
	<a class="btn btn-primary" href="indexTrabajadores" role="button">Trabajadores</a>
	<a class="btn btn-primary" href="indexClientes" role="button">Clientes</a>
	<a class="btn btn-primary" href="indexServicios" role="button">Servicios</a>
	<a class="btn btn-primary" href="indexSesiones" role="button">Sesiones</a>
	<a class="btn btn-primary" href="indexSesionesO" role="button">SesionesO</a>
</div>
<hr>
<h3>Listado de servicios disponibles</h3>
<section id="servicios" class="row">

	<c:forEach items="${servicios}" var="servicio">
		<div class="card col-12 col-sm-6 col-md-6 col-lg-4 col-xl-3 img"
			style="width: 18rem;">
			<img src="imgs/${servicio.nombre}.jpg" class="card-img-top" style="height:200px"
				alt="foto ${servicio.nombre}">
			<div class="card-body">
				<h5 class="card-title">${servicio.nombre}</h5>
				<p class="precio">
					precio:
					<fmt:formatNumber type="currency" value="${servicio.precio}"
						pattern="#0.000" />
					€
				</p>
				<a href="#" class="btn btn-primary">Contratar</a>
			</div>
		</div>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
