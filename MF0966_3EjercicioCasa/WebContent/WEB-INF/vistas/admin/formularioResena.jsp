<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<form action="admin/resena/${op}" method="post"
		class="offset-xl-3 offset-md-2 offset-sm-1 col-sm-10 col-md-8 col-xl-6">
		<fieldset>
			<legend>${op} reseña</legend>

			<input type="hidden" id="op" name="op" value="${op}">

			<div class="form-group row">
				<label for="codigo" class="col-sm-2 col-form-label">Código</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="codigo" name="codigo"
						value="${resena.codigo}" readonly>
				</div>
			</div>

			<div class="form-group row">
				<label for="alumno" class=" col-sm-2 col-form-label">Alumno</label>
				<div class="col-sm-10">
					<select
						class="form-control ${primeravez ? '' : (resena.errorAlumno == null ? 'is-valid' : 'is-invalid') }"
						id="alumno" name="alumno">
						<option disabled selected value="">Selecciona un alumno</option>
						<c:forEach items="${alumnos}" var="alumno">
							<option ${alumno.codigo == resena.alumno.codigo? 'selected': '' }
								value="${alumno.codigo}">${alumno.nombre}
								${alumno.apellidos}</option>
						</c:forEach>
						<!-- Comprobar si el alumno está logeado, y si eso se bloquea la opcion de elegir alumno -->
					</select>
					<div class="invalid-feedback">${resena.errorAlumno}</div>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="curso" class="col-sm-2 col-form-label">Curso</label>
				<div class="col-sm-10">
					<select
						class="form-control ${primeravez? '': (resena.errorCurso == null? 'is-valid ' : 'is-invalid')}"
						id="curso" name="curso">
						<option disabled selected value="">Selecccione un curso</option>
						<c:forEach items="${cursos}" var="curso">
							<option ${curso.codigo == resena.curso.codigo? 'selected' : ''}
								value="${curso.codigo}">${curso.nombre}</option>
						</c:forEach>
						<!-- Si el alumno indica un curso para poner una reseña, se bloquea la opcion de elegir curso-->
					</select>
					<div class="invalid-feedback">${resena.errorCurso}</div>
				</div>
			</div>


			<div class="form-group row">
				<label for="comentario" class="col-sm-2 col-form-label">Comentario</label>
				<div class="col-sm-10">
					<input type="text" maxlength="1000"
						placeholder="La reseña debe tener como máximo 1000 caracteres"
						class="form-control ${primeravez? '' : (resena.errorComentario == null? 'is-valid' : 'is-invalid')}"
						id="comentario" name="comentario" value="${resena.comentario}">
					<div class="invalid-feedback">${reseña.errorComentario}</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a class="btn btn-success" href="admin/resenas" role="button">Cancelar</a>
				</div>
			</div>
		</fieldset>
	</form>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
