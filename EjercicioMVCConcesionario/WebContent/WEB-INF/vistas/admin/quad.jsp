<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/quad" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>Quad</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="id" name="id"
						value="${quad.id}" readonly>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="marca" class="col-sm-2 col-form-label">Marca</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (quad.errorMarca == null ? 'is-valid' : 'is-invalid') }"
						id="marca" name="marca" value="${quad.marca}">
					<div class="invalid-feedback">${quad.errorMarca}</div>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="modelo" class="col-sm-2 col-form-label">Modelo</label>
				<div class="col-sm-10">
					<input
						class="form-control ${primeravez ? '' : (quad.errorModelo== null ? 'is-valid' : 'is-invalid') }"
						id="modelo" name="modelo" value="${quad.modelo}">
					<div class="invalid-feedback">${quad.errorModelo}</div>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="precio" class="col-sm-2 col-form-label">Precio</label>
				<div class="col-sm-10 input-group ">
					<input type="number"
						class="form-control ${primeravez ? '' : (quad.errorPrecio == null ? 'is-valid' : 'is-invalid') }"
						id="precio" name="precio" value="${quad.precio}"
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
						class="form-control ${primeravez ? '' : (quad.errorUrl == null ? 'is-valid' : 'is-invalid') }"
						id="url" name="url" value="${quad.url}">
					<div class="invalid-feedback">${quad.errorUrl}</div>
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
