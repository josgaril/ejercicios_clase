<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Empezando la construcción de la página</h1>

<header class="jumbotron">
	<h2 class="display-6">Bienvenidos al salón de masajes SAMAJA</h2>
</header>

<section id="trabajadores" class="row">
	<c:forEach items="${trabajadores}" var="trabajador">
		<article class="libro col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<p class="autor">${trabajador.id}</p>
			<p class="autor">${trabajador.nombre}</p>
			<p class="autor">${trabajador.apellidos}</p>
			<p class="autor">${trabajador.dni}</p>
		</article>
	</c:forEach>
</section>


<h3>Mostrando trabajadores</h3>

<p> TRABAJADORES</p>
<section id="trabajadores">

	<table
		class="table table-striped table-bordered table-hover table-sm table-responsive">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>DNI</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trabajadores}" var="trabajador">
				<tr>
					<th>${trabajador.id}</th>
					<td>${trabajador.nombre}</td>
					<td>${trabajador.apellidos}</td>
					<td>${trabajador.dni}</td>
					<td><a class="btn btn-warning"
						href="admin/trabajador?id=${trabajador.id}&op=modificar">Modificar</a> <a
						class="btn btn-danger" href="admin/borrar?id=${trabajador.id}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-primary" href="admin/trabajador?op=agregar">Añadir</a>

</section>
<h4>Fin de la pagina</h4>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
