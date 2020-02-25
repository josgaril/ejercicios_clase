<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <fmt:setLocale value="es_ES" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Salon de masajes</title>

<base href="${pageContext.request.contextPath}/" />

<!-- Bootstrap 4 -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- DataTables con aspecto Bootstrap 4 -->
<link rel="stylesheet" href="css/dataTables.bootstrap4.min.css" />
<!-- Font Awesome -->
<link rel="stylesheet" href="css/all.min.css" />

<link rel="stylesheet" href="css/SalonMasajes.css" />


<!-- jQuery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>

<script>
	$(document).ready(function() {
		$('.table').DataTable();
	});

	//CODIGO JAVASCRIPT PARA SUBMENUS
	$(function() {
		// ------------------------------------------------------- //
		// Multi Level dropdowns
		// ------------------------------------------------------ //
		$("ul.dropdown-menu [data-toggle='dropdown']").on(
				"click",
				function(event) {
					event.preventDefault();
					event.stopPropagation();

					$(this).siblings().toggleClass("show");

					if (!$(this).next().hasClass('show')) {
						$(this).parents('.dropdown-menu').first().find('.show')
								.removeClass("show");
					}
					$(this).parents('li.nav-item.dropdown.show').on(
							'hidden.bs.dropdown',
							function(e) {
								$('.dropdown-submenu .show')
										.removeClass("show");
							});

				});
	});
	//FIN CODIGO PARA SUBMENUS
</script>

</head>
<body>

	<!-- 		<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top"> -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<a class="navbar-brand" href="#">SAMAJA</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav">


				<!-- Level one dropdown -->
				<li class="nav-item dropdown"><a id="dropdownMenu1" href="#"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
					class="nav-link dropdown-toggle">Administrador <i class="fas fa-user-cog"></i></a>
					<ul aria-labelledby="dropdownMenu1"
						class="dropdown-menu border-0 shadow">
						<!-- 	<li><a href="#" class="dropdown-item">Some action </a></li>
						<li><a href="#" class="dropdown-item">Some other action</a></li>

						<li class="dropdown-divider"></li> -->

						<!-- Level two dropdown-->
						<li class="dropdown-submenu"><a id="dropdownMenu2"
							href="admin/trabajadores" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"
							class="dropdown-item dropdown-toggle">Trabajadores</a>
							<ul aria-labelledby="dropdownMenu2"
								class="dropdown-menu border-0 shadow">
								<li><a tabindex="-1" href="admin/trabajadores"
									class="dropdown-item">Listado</a></li>
								<li><a tabindex="-1" href="admin/trabajador?op=agregar"
									class="dropdown-item">Agregar</a></li>
							</ul>
						</li>
						<li class="dropdown-submenu"><a id="dropdownMenu2"
							href="admin/trabajadores" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"
							class="dropdown-item dropdown-toggle">Clientes</a>
							<ul aria-labelledby="dropdownMenu2"
								class="dropdown-menu border-0 shadow">
								<li><a tabindex="-1" href="admin/clientes"
									class="dropdown-item">Listado</a></li>
								<li><a tabindex="-1" href="admin/cliente?op=agregar"
									class="dropdown-item">Agregar</a></li>
							</ul>
						</li>
							<li class="dropdown-submenu"><a id="dropdownMenu2"
							href="admin/trabajadores" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"
							class="dropdown-item dropdown-toggle">Servicios</a>
							<ul aria-labelledby="dropdownMenu2"
								class="dropdown-menu border-0 shadow">
								<li><a tabindex="-1" href="admin/servicios"
									class="dropdown-item">Listado</a></li>
								<li><a tabindex="-1" href="admin/servicio?op=agregar"
									class="dropdown-item">Agregar</a></li>
							</ul>
						</li>
							<li class="dropdown-submenu"><a id="dropdownMenu2"
							href="admin/trabajadores" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"
							class="dropdown-item dropdown-toggle">Sesiones</a>
							<ul aria-labelledby="dropdownMenu2"
								class="dropdown-menu border-0 shadow">
								<li><a tabindex="-1" href="admin/sesiones"
									class="dropdown-item">Listado</a></li>
								<li><a tabindex="-1" href="admin/sesionO?op=agregar"
									class="dropdown-item">Agregar</a></li>
							</ul>
						</li>
						<!-- End Level two -->
					</ul></li>
				<!-- End Level one -->

				<!-- Example split danger button -->
				<div class="btn-group">
					<a class="nav-link" href="admin/index">Administración <i
						class="fas fa-user-cog"></i>
					</a>
					<button type="button"
						class="btn btn-dark dropdown-toggle dropdown-toggle-split"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">

						<a class="dropdown-item text-gray" href="admin/trabajadores">Trabajadores</a>
						<a class="dropdown-item" href="admin/clientes">Clientes</a> <a
							class="dropdown-item" href="admin/servicios">Servicios</a> <a
							class="dropdown-item" href="admin/sesionesO">Sesiones</a>
					</div>
				</div>

<!-- 				Acceso normal a Administracion
				<li class="nav-item"><a class="nav-link" href="admin/index">Administración
						<i class="fas fa-user-cog"></i>
				</a></li> -->
			</ul>
			
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="indexTrabajadores">Trabajadores <i
						class="fas fa-user-tie"></i>
				</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="indexClientes">Clientes
						<i class="fas fa-users"></i>
				</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="indexServicios">Servicios
						<i class="fas fa-briefcase"></i>
				</a></li>
			</ul>
			
			<!-- <ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="indexSesiones">Sesiones
						<i class="fas fa-concierge-bell"></i>
				</a></li>
			</ul> -->

			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="indexSesionesO">SesionesO
						<i class="fas fa-concierge-bell"></i>
				</a></li>
			</ul>

			<c:choose>
				<c:when test="${sessionScope.usuario != null}">
					<span class="navbar-text ml-3"> ${sessionScope.usuario} </span>
					<img src="imgs/${sessionScope.usuario}.jpg"
						alt="Imagen ${sessionScope.usuario}" class="fotoPerfil ml-1 mr-3">

					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
						</li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="login">Login
								<i class="fas fa-user-cog"></i>
						</a></li>
					</ul>
				</c:otherwise>
			</c:choose>

		</div>
	</nav>
	<c:if test="${mensaje != null}">
		<div
			class="alert alert-${mensaje.nivelBootstrap} alert-dismissible fade show"
			role="alert">
			${mensaje.texto}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

		<%
			session.removeAttribute("mensaje");
		%>
	</c:if>
	<main class="container-fluid">