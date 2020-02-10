<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/servicio/${op}" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>servicio</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="idservicios" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="idservicios" name="idservicios"
						value="${servicio.idservicios}" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input type="text" minlength="1" maxlength="45" placeholder="El nombre debe tener entre 1 y 45 caracteres"
						class="form-control ${primeravez ? '' : (servicio.errorNombre == null ? 'is-valid' : 'is-invalid') }"
						id="nombre" name="nombre" value="${servicio.nombre}">
					<div class="invalid-feedback">${servicio.errorNombre}</div>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="precio" class="col-sm-2 col-form-label">Precio</label>
				<div class="col-sm-10">
					<input type="text" pattern="\d+,\d{3}" placeholder="Precio con dos dígitos decimales"
						class="form-control ${primeravez ? '' : (servicio.errorPrecio == null ? 'is-valid' : 'is-invalid') }"
						id="precio" name="precio" value="<fmt:formatNumber value = "${servicio.precio}" type = "number" pattern="#0.000"/>">
					<div class="invalid-feedback">${servicio.errorPrecio}</div>
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
