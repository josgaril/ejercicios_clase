<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Libro</title>
</head>
<body>
	<h1>Aregar nuevo libro</h1>
	<form action="libro">
		<input readonly name="id" type="number" value="${libro.id}" />
	 	<input name="titulo" value="${libro.titulo}"/>
	 	<input name="isbn" value="${libro.isbn}"/>
	 	<input name="paginas" value="${libro.paginas}"/>
	 	<input name="formato" value="${libro.formato}"/>
	 	<button>Aceptar</button>
	</form>

</body>
</html>