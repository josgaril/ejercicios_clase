<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h2>Bienvenidos a Ipartek, su centro de estudios</h2>

<section id="cursos" class="row">

	<c:forEach items="${cursos}" var="curso">
		<div class="card" style="width: 18rem;">
		  <img src="imgs/${curso.nombre}.jpg" class="card-img-top " alt="imagen del curso" style="height:200px">
		  <div class="card-body">
		    <a href="curso/detalle?codigo=${curso.codigo}">${curso.nombre}</a>
		  </div>
		    <div class="card-body">
		    <p class="card-text">Identificador: ${curso.identificador}</p>
		  </div>
		    <div class="card-body">
		    <p class="card-text">Duración: ${curso.nHoras} h.</p>
		  </div>
		    <div class="card-body">
		    <p class="card-text">Profesor: ${curso.profesor.nombre} ${curso.profesor.apellidos}</p>
		  </div>
		</div>
	</c:forEach>
</section>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
