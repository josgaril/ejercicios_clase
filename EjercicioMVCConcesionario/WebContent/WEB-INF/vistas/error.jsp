<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<div class="jumbotron">
	<h2 class="display-2 text-danger"> Se ha producido un error!</h2>
	<p> Compruebe la URL y acceda de nuevo</p>
<p>${exception.getMessage()}</p>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
