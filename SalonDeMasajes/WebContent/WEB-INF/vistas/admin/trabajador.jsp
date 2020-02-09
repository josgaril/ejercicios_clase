<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/trabajador/${op}" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>trabajador</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${trabajador.id}" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input type="text" minlength="1" maxlength="45" placeholder="El nombre debe tener entre 1 y 45 caracteres"
						class="form-control ${primeravez ? '' : (trabajador.errorNombre == null ? 'is-valid' : 'is-invalid') }"
						id="nombre" name="nombre" value="${trabajador.nombre}">
					<div class="invalid-feedback">${trabajador.errorNombre}</div>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="apellidos" class="col-sm-2 col-form-label">Apelllidos</label>
				<div class="col-sm-10">
					<input type="text" minlength="1" maxlength="90" placeholder="El apelido debe tener entre 1 y 90 caracteres"
						class="form-control ${primeravez ? '' : (trabajador.errorApellidos == null ? 'is-valid' : 'is-invalid') }"
						id="apellidos" name="apellidos" value="${trabajador.apellidos}">
					<div class="invalid-feedback">${trabajador.errorApellidos}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="dni" class="col-sm-2 col-form-label">DNI</label>
				<div class="col-sm-10">
					<input type="text" minlength="9" maxlength="9" placeholder="El nombre debe tener 9 caracteres"
						class="form-control ${primeravez ? '' : (trabajador.errorDni == null ? 'is-valid' : 'is-invalid') }"
						id="dni" name="dni" value="${trabajador.dni}">
					<div class="invalid-feedback">${trabajador.errorDni}</div>
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
