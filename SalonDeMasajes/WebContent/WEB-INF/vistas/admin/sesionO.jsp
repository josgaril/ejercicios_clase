<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/sesionO/${op}" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>sesionO</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${sesionO.id}" readonly>
				</div>
			</div>

			<div class="form-group row">
				<label for="clientes_idclientes" class="col-sm-2 col-form-label">IdCliente</label>
				<div class="col-sm-10">
					<%-- <input type="number"
						class="form-control ${primeravez ? '' : (sesion.errorClientes_idclientes == null ? 'is-valid' : 'is-invalid') }"
						id="clientes_idclientes" name="clientes_idclientes"
						value="${sesion.clientes_idclientes}"> --%>
					<select
						class="form-control ${primeravez ? '' : (sesionO.errorClientes_idclientes == null ? 'is-valid' : 'is-invalid') }"
						id="clientes_idclientes" name="clientes_idclientes"
						value="${sesionO.clienteO}">
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>11</option>
					</select>
					<div class="invalid-feedback">${sesionO.errorClienteO}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="trabajadores_idtrabajadores"
					class="col-sm-2 col-form-label">IdTrabajador</label>
				<div class="col-sm-10">
					<input type="number"
						class="form-control ${primeravez ? '' : (sesionO.errorTrabajadores_idtrabajadores == null ? 'is-valid' : 'is-invalid') }"
						id="trabajadores_idtrabajadores"
						name="trabajadores_idtrabajadores" value="${sesionO.trabajadorO}">
					<div class="invalid-feedback">${sesionO.errorTrabajadorO}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="servicios_idservicios" class="col-sm-2 col-form-label">IdServicio</label>
				<div class="col-sm-10">
					<input type="number"
						class="form-control ${primeravez ? '' : (sesionO.errorServicios_idservicios == null ? 'is-valid' : 'is-invalid') }"
						id="servicios_idservicios" name="servicios_idservicios"
						value="${sesionO.servicioO}">
					<div class="invalid-feedback">${sesionO.errorServicioO}</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
				<div class="col-sm-10">
					<input type="date"
						class="form-control ${primeravez ? '' : (sesionO.errorFecha == null ? 'is-valid' : 'is-invalid') }"
						id="fecha" name="fecha" value="${sesionO.fecha}">
					<div class="invalid-feedback">${sesionO.errorFecha}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="resena" class="col-sm-2 col-form-label">Reseña</label>
				<div class="col-sm-10">
					<input type="text" maxlength="1000"
						placeholder="La reseña debe tener como máximo 1000 caracteres"
						class="form-control ${primeravez ? '' : (sesionO.errorResena == null ? 'is-valid' : 'is-invalid') }"
						id="resena" name="resena" value="${sesionO.resena}">
					<div class="invalid-feedback">${sesionO.errorResena}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="calificacion" class="col-sm-2 col-form-label">Calificación</label>
				<div class="col-sm-10">
					<select class="form-control<%-- ${primeravez ? '' : (video.errorUrl == null ? 'is-valid' : 'is-invalid') } --%>" id="calificacion" name="calificacion">
						<option></option>
						<option ${sesion.calificacion == 'No recomendable' ? 'selected': '' }>No recomendable</option>
						<option ${sesion.calificacion == 'Aceptable' ? 'selected': '' }>Aceptable</option>
						<option ${sesion.calificacion == 'Para repetir' ? 'selected': '' }>Para repetir</option>
					</select>
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
