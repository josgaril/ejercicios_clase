<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/tractor" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>Tractor</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${tractor.id}" readonly>
				</div>
			</div>

			<div class="form-group row">
				<label for="marca" class="col-sm-2 col-form-label">Marca</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (tractor.errorMarca == null ? 'is-valid' : 'is-invalid') }"
						id="marca" name="marca" value="${tractor.marca}">
					<div class="invalid-feedback">${tractor.errorMarca}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="modelo" class="col-sm-2 col-form-label">Modelo</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (tractor.errorModelo== null ? 'is-valid' : 'is-invalid') }"
						id="modelo" name="modelo" value="${tractor.modelo}">
					<div class="invalid-feedback">${tractor.errorModelo}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="precio" class="col-sm-2 col-form-label">Precio</label>
				<div class="col-sm-10 input-group ">
					<input type="number"
						class="form-control ${primeravez ? '' : (tractor.errorPrecio == null ? 'is-valid' : 'is-invalid') }"
						id="precio" name="precio" value="${tractor.precio}"
						placeholder="precio" aria-label="precio"
						aria-describedby="simboloprecio">
					<div class="input-group-append">
						<span class="input-group-text" id="simboloprecio"> €</span>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="url" class="col-sm-2 col-form-label">URL</label>
				<div class="col-sm-10">
					<input type="url"
						class="form-control ${primeravez ? '' : (tractor.errorUrl == null ? 'is-valid' : 'is-invalid') }"
						id="url" name="url" value="${tractor.url}">
					<div class="invalid-feedback">${tractor.errorUrl}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="imagen" class="col-sm-2 col-form-label">IMAGEN</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (tractor.errorImagen== null ? 'is-valid' : 'is-invalid') }"
						id="imagen" name="imagen" value="${tractor.imagen}">
					<div class="invalid-feedback">${tractor.errorImagen}</div>
				</div>
			</div>


			<div class="form-group row">
				<label for="fecha" class="col-sm-2 col-form-label">FECHA PUBLICACIÓN</label>
				<div class="col-sm-10">
					<input id="fecha" class="form-control" type="text" name="fecha" value="${tractor.fecha}" readonly>
				</div>
			</div>

		<!-- 	Falta por implementar bien para la fecha actual
			<div class="form-group row">
				<label for="fechareg" class="col-sm-2 col-form-label">Fecha de
					registro</label>
				<div class="col-sm-10">
					<input id="fechareg" class="form-control" type="date" name="fechareg" value="" readonly>
				</div>
			</div> -->


			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
				</div>
			</div>
		</fieldset>
	</form>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
