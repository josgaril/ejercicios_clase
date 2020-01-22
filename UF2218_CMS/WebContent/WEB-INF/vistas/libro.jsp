<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="index" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>Nuevo Libro</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row" hidden>
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${objeto.id}" required tabindex="-1" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (libro.errorNombre == null ? 'is-valid' : 'is-invalid') }"
						id="nombre" name="nombre" minlength="2" maxlength="150" value="${libro.nombre}" required autofocus>
					<div class="invalid-feedback">${libro.errorNombre}</div>
				</div>

			</div>
			<div class="form-group row">
				<label for="url" class="col-sm-2 col-form-label">Precio</label>
				<div class="col-sm-10">
				<input type="number" class="form-control ${primeravez ? '' : (libro.errorPrecio == null ? 'is-valid' : 'is-invalid') }" id="precio"
						name="precio" min="0.01" value="${libro.precio}" step="0.01" required>
					<div class="invalid-feedback">${libro.errorPrecio}</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Descuento</label>
				<div class="col-sm-10">
					<input type="number" class="form-control ${primeravez ? '' : (libro.errorDescuento == null ? 'is-valid' : 'is-invalid') }" id="descuento"
						name="descuento" value="${libro.descuento}"	 min="0" max="100" required>
					<div class="invalid-feedback">${libro.errorDescuento}</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary" name="btn" value="nuevoRegistro">Aceptar</button>
					<a href="index?op=atras"
						role="button" class="btn btn-danger" required>Atras</a>
				</div>
			</div>
		</fieldset>
	</form>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
