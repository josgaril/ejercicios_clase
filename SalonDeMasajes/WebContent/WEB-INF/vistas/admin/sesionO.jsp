<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/sesionO/${op}" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>${op} sesionO</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${sesionO.id}" readonly>
				</div>
			</div>

			<div class="form-group row">
				<label for="cliente" class="col-sm-2 col-form-label">Cliente</label>
				<div class="col-sm-10">
					<select
						class="form-control ${primeravez ? '' : (sesionO.errorClienteO == null ? 'is-valid' : 'is-invalid') }"
						id="cliente" name="cliente">
						<option disabled selected value="">Selecciona un cliente</option>
						<c:forEach items="${clientes}" var="cliente" >
								<option ${cliente.idclientes == sesionO.clienteO.idclientes? 'selected': '' } value="${cliente.idclientes}">${cliente.nombre} ${cliente.apellidos}</option>
						
						</c:forEach>
					</select>
					<div class="invalid-feedback">${sesionO.errorClienteO}</div>					
				</div>
			</div>

			<div class="form-group row">
				<label for="trabajador"
					class="col-sm-2 col-form-label">Trabajador</label>
				<div class="col-sm-10">
					<select
						class="form-control ${primeravez ? '' : (sesionO.errorTrabajadorO == null ? 'is-valid' : 'is-invalid') }"
						id="trabajador" name="trabajador">
						<option disabled selected value="">Selecciona un trabajador</option>
						<c:forEach items="${trabajadores}" var="trabajador" >
							<option ${trabajador.idtrabajadores== sesionO.trabajadorO.idtrabajadores? 'selected': '' } value="${trabajador.idtrabajadores}">${trabajador.nombre} ${trabajador.apellidos}</option>			
						</c:forEach>
					</select>
					<div class="invalid-feedback">${sesionO.errorTrabajadorO}</div>					
				</div>
			</div>

			<div class="form-group row">
				<label for="servicio" class="col-sm-2 col-form-label">Servicio</label>
				<div class="col-sm-10">
					<select
						class="form-control ${primeravez ? '' : (sesionO.errorServicioO == null ? 'is-valid' : 'is-invalid') }"
						id="servicio" name="servicio">
						<option disabled selected value="">Selecciona un servicio</option>
						<c:forEach items="${servicios}" var="servicio" >
							<option ${servicio.idservicios == sesionO.servicioO.idservicios ? 'selected': '' } value="${servicio.idservicios}">${servicio.nombre}</option>			
						</c:forEach>
					</select>
					<div class="invalid-feedback">${sesionO.errorServicioO}</div>					
				</div>
			</div>
			
			<div class="form-group row">
				<label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
				<div class="col-sm-10">
					<input type="datetime-local"
						class="form-control ${primeravez ? '' : (sesionO.errorFecha == null ? 'is-valid' : 'is-invalid') }"
						id="fecha" name="fecha" value="<fmt:formatDate value="${sesionO.fecha}" pattern="yyyy-MM-dd'T'HH:mm" />" />
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
					<select class="form-control ${primeravez ? '' : (sesionO.errorCalificacion == null ? 'is-valid' : 'is-invalid') }" id="calificacion" name="calificacion">
						<option selected value="">No ha calificado</option>
						<option ${sesionO.calificacion == 'No recomendable' ? 'selected': '' }>No recomendable</option>
						<option ${sesionO.calificacion == 'Aceptable' ? 'selected': '' }>Aceptable</option>
						<option ${sesionO.calificacion == 'Para repetir' ? 'selected': '' }>Para repetir</option>
					</select>
					<div class="invalid-feedback">${sesionO.errorCalificacion}</div>
					
				</div>
			</div>

				<div class="form-group row">
					<div class="offset-sm-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Aceptar</button>
						<a class="btn btn-success mx-2" href="admin/sesionesO" role="button">Cancelar</a>
					</div>
				</div>
		</fieldset>
	</form>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
