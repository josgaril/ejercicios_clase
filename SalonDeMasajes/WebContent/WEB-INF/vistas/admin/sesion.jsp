<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/sesion/${op}" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>sesion</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${sesion.id}" readonly>
				</div>
			</div>

			<!-- <div class="form-group row">
				<label for="nombre_cliente" class="col-sm-2 col-form-label">Nombre
					Cliente</label>
				<div class="col-sm-10">
					<select class="form-control" id="nombre_cliente">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre_trabajador" class="col-sm-2 col-form-label">Nombre
					Trabajador</label>
				<div class="col-sm-10">
					<select class="form-control" id="nombre_trabajador">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre_servicio" class="col-sm-2 col-form-label">Nombre
					Servicio</label>
				<div class="col-sm-10">
					<select class="form-control" id="nombre_servicio">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
			</div> -->

			<div class="form-group row">
				<label for="clientes_idclientes" class="col-sm-2 col-form-label">IdCliente</label>
				<div class="col-sm-10">
					<%-- <input type="number"
						class="form-control ${primeravez ? '' : (sesion.errorClientes_idclientes == null ? 'is-valid' : 'is-invalid') }"
						id="clientes_idclientes" name="clientes_idclientes"
						value="${sesion.clientes_idclientes}"> --%>
					<select
						class="form-control ${primeravez ? '' : (sesion.errorClientes_idclientes == null ? 'is-valid' : 'is-invalid') }"
						id="clientes_idclientes" name="clientes_idclientes"
						value="${sesion.clientes_idclientes}">
						<option>1</option>
						<option>2</option>
						<option>6</option>

					</select>
					<div class="invalid-feedback">${sesion.errorClientes_idclientes}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="trabajadores_idtrabajadores"
					class="col-sm-2 col-form-label">IdTrabajador</label>
				<div class="col-sm-10">
					<input type="number"
						class="form-control ${primeravez ? '' : (sesion.errorTrabajadores_idtrabajadores == null ? 'is-valid' : 'is-invalid') }"
						id="trabajadores_idtrabajadores"
						name="trabajadores_idtrabajadores"
						value="${sesion.trabajadores_idtrabajadores}">
					<div class="invalid-feedback">${sesion.errorTrabajadores_idtrabajadores}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="servicios_idservicios" class="col-sm-2 col-form-label">IdServicio</label>
				<div class="col-sm-10">
					<input type="number"
						class="form-control ${primeravez ? '' : (sesion.errorServicios_idservicios == null ? 'is-valid' : 'is-invalid') }"
						id="servicios_idservicios" name="servicios_idservicios"
						value="${sesion.servicios_idservicios}">
					<div class="invalid-feedback">${sesion.errorServicios_idservicios}</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
				<div class="col-sm-10">
					<input type="date"
						class="form-control ${primeravez ? '' : (sesion.errorFecha == null ? 'is-valid' : 'is-invalid') }"
						id="fecha" name="fecha" value="${sesion.fecha}">
					<div class="invalid-feedback">${sesion.errorFecha}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="resena" class="col-sm-2 col-form-label">Reseña</label>
				<div class="col-sm-10">
					<input type="text" maxlength="1000"
						placeholder="La reseña debe tener como máximo 1000 caracteres"
						class="form-control ${primeravez ? '' : (sesion.errorResena == null ? 'is-valid' : 'is-invalid') }"
						id="resena" name="resena" value="${sesion.resena}">
					<div class="invalid-feedback">${sesion.errorResena}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="calificacion" class="col-sm-2 col-form-label">Calificación</label>
				<div class="col-sm-10">
					<input type="text" maxlength="156"
						placeholder="La calificación debe tener como máximo de 15 caracteres"
						class="form-control ${primeravez ? '' : (sesion.errorCalificacion == null ? 'is-valid' : 'is-invalid') }"
						id="calificacion" name="calificacion"
						value="${sesion.calificacion}">
					<div class="invalid-feedback">${sesion.errorCalificacion}</div>
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
