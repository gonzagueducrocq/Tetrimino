<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.min.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="/tetrimino/css/figure.css" type="text/css"
	rel="stylesheet" media="screen,projection" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<style>
.posRelative {
	position: relative !important;
}
</style>

<title>Bienvenue sur Tetrimino</title>
</head>

<body>
	<c:import url="/inc/menu.jsp" />

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<div class="container">
		<div class="collection">
			<c:forEach items="${tetriminos}" var="item">
				<li class="collection-item avatar">
				
				<c:if test="${item.figures.size() > 0 }">
					<c:set var="figure" value="${item.figures.get(0)}"></c:set>
					<div class="figure">
						<div class="blocs">
							<c:forEach begin="0" end="3" var="x">
								<c:forEach begin="0" end="3" var="y">
									<c:set var="color" value="white" />
									<c:set var="bloc" value="${figure.blocExistant(x,y)}" />

									<c:if test="${ bloc != null }">
										<c:set var="color" value="${ item.couleur }" />
										<div class="bloc" style="background: ${ color };">
										</div>
									</c:if>

									<c:if test="${ bloc == null }">
										<div class="bloc" style="background: ${ color };">
										</div>
									</c:if>
								</c:forEach>
							</c:forEach>
						</div>

					</div>
					</c:if>
					 <c:out value="${item.id}" /> | <c:out value="${item.nom}" /> | <c:out value="${item.couleur}" /> 
					<a href="admin/supprimerPiece?id=${ item.id }" class="secondary-content posRelative" title="Supprimer"><i class="material-icons">cancel</i> </a>
					<a href="admin/modifPiece?id=${ item.id }" class="secondary-content posRelative" title="Editer"><i class="material-icons">edit</i></a>
					
				</li>
			</c:forEach>
		</div>
		<p>
			<a class="waves-effect waves-light btn-large red lighten-1"
				href="admin/ajoutTetrimino"><i class="material-icons left">add</i>Ajouter
				Tetrimino</a>
		</p>
	</div>
</body>
</html>