<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- La biblioteca core tiene el prefijo c y contiene etiquetas como c:forEach y c:if --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- La biblioteca fmt tiene el prefijo fmt y contiene etiquetas como fmt:formatNumber y fmt:formatDate --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libros</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>titulo</th>
				<th>isbn</th>
				<th>paginas</th>
				<th>opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<%-- ${libro.id} == libro.getId() == null ? "" : libro.getId() --%>
					<th>${libro.id}</th>
					<th>${libro.titulo}</th>
					<th>${libro.isbn}</th>
					<th>${libro.paginas}</th>
					<th>${libro.formato}</th>
					<th>
						<a href="libros?id=${libro.id}&op=modificar">Modificar</a>
						<a href="libros?id=${libro.id}&op=borrar">Borrar</a>
					</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="libros?op=agregar">Añadir</a>
</body>
</html>
