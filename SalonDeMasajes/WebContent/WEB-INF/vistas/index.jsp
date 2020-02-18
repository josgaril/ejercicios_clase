<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<header class="jumbotron">
	<h2 class="display-6">Bienvenidos al salón de masajes SAMAJA</h2>
</header>

<a class="btn btn-primary" href="indexTrabajadores" role="button">Trabajadores</a>
<a class="btn btn-primary" href="indexClientes" role="button">Clientes</a>
<a class="btn btn-primary" href="indexServicios" role="button">Servicios</a>
<a class="btn btn-primary" href="indexSesiones" role="button">Sesiones</a>
<a class="btn btn-primary" href="indexSesionesO" role="button">SesionesO</a>
<hr>
<h3>Listado de servicios disponibles</h3>
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
<a class="btn btn-primary" href="admin/sesionO?op=agregar">Contratar servicio</a>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
