<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h3>VIDEOS</h3>
<section id="videos" class="row">
	<c:forEach items="${videos}" var="video">
		<article id="video" class="card col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
			<!-- ID: ${video.id} -->
			<div class="card-body">
				<img src="imgs/video/${video.id}.jpg" class="card-img-top" alt="">
				<h3 class="card-title">${video.nombre}</h3>
				<p class="card-text">
					<a href="${video.url}">${video.url}</a>
				</p>
			</div>
		</article>
	</c:forEach>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
