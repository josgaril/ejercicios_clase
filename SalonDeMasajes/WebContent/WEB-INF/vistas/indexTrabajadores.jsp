<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Empezando la construcción de la página</h1>

<header class="jumbotron">
	<h2 class="display-6">Bienvenidos al salón de masajes SAMAJA</h2>
</header>
<h2>Mostramos listado de los trabajadores</h2>
<section id="trabajadores" class="row">
	<c:forEach items="${trabajadores}" var="trabajador">
		<article class="trabajador col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="id: ">${trabajador.idtrabajadores}</p>
			<p class="nombre: ">${trabajador.nombre}</p>
			<p class="apellidos: ">${trabajador.apellidos}</p>
			<p class="dni: ">${trabajador.dni}</p>
		</article>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
