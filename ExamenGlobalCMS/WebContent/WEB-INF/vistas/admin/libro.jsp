<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<!-- FORMULARIO PARA LOS LIBROS -->

<div class="row">
	<form action="admin/libro" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>Libro</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${libro.id}" readonly>
				</div>
			</div>

			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (libro.errorNombre == null ? 'is-valid' : 'is-invalid') }"
						id="nombre" name="nombre" min="2" max="150" value="${libro.nombre}"
						placeholder="Nombre del libro" required>
					<div class="invalid-feedback">${libro.errorNombre}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="precio" class="col-sm-2 col-form-label">Precio</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (libro.errorPrecio == null ? 'is-valid' : 'is-invalid') }"
						type="number" id="precio" name="precio" min="0.01" step="0.01"
						value="${libro.precio}" placeholder="Precio del libro" required>
					<div class="invalid-feedback">${libro.errorPrecio}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="descuento" class="col-sm-2 col-form-label">Descuento</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (libro.errorDescuento == null ? 'is-valid' : 'is-invalid') }"
						type="number" id="descuento" name="descuento"
						value="${libro.descuento}" placeholder="Descuento del libro"
						required>
					<div class="invalid-feedback">${libro.errorDescuento}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Autor</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (libro.errorAutor == null ? 'is-valid' : 'is-invalid') }"
						id="autor" name="autor" value="${libro.autor}"
						placeholder="Autor del libro">
					<div class="invalid-feedback">${libro.errorAutor}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Imagen</label>
				<div class="col-sm-10">
					<input
						class="form-control"
						id="imagen" name="imagen" value="${libro.imagen}"
						placeholder="Por defecto">
				</div>
			</div>

			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
				</div>
			</div>
			
		</fieldset>
	</form>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
