<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="/tetrimino/css/materialize.min.css" type="text/css"
	rel="stylesheet" media="screen,projection" />
<link href="/tetrimino/css/tetrimino.css" type="text/css"
	rel="stylesheet" media="screen,projection" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Modification de tetrimino</title>
</head>

<body>
	<c:import url="/inc/menu.jsp" />

	<c:set var="placeholderNom">
		<c:choose>
			<c:when test="${ empty erreurs['nom'] }">Nom</c:when>
			<c:otherwise>${ erreurs['nom'] }</c:otherwise>
		</c:choose>
	</c:set>
	<c:set var="placeholderCouleur">
		<c:choose>
			<c:when test="${ empty erreurs['couleur'] }">Couleur</c:when>
			<c:otherwise>${ erreurs['couleur'] }</c:otherwise>
		</c:choose>
	</c:set>

	<div class="container">
		<form method="POST" class="row center">
			<input type="text" name="id" class="row center" value="${ tetri.id }"
				hidden />
			<h5>Nom Tetrimino</h5>
			<input type="text" name="nom" class="row center"
				value="${ tetri.nom }"
				placeholder="<c:out value="${ placeholderNom }" />" />
			<h5>Couleur</h5>
			<input type="text" name="couleur" class="row center"
				value="${ tetri.couleur }"
				placeholder="<c:out value="${ placeholderCouleur }" />" />

			<button class="btn waves-effect waves-light red lighten-1"
				type="submit" name="action">
				Modifier <i class="material-icons right">send</i>
			</button>

		</form>

		<a class="waves-effect waves-light btn red lighten-1"
			href="ajoutFigure?id=${tetri.id}">Nouvelle figure</a>

		<c:forEach items="${tetri.figures}" var="item">
			<div class="figure">
				<c:forEach begin="0" end="3" var="x">
					<c:forEach begin="0" end="3" var="y">
						<c:set var="color" value="white" />
						<c:set var="bloc" value="${item.blocExistant(x,y)}"/>

						<c:if test="${ bloc != null }">
							<c:set var="color" value="${ tetri.couleur }" />
							<div class="bloc" style="background: ${ color };">
								<a href="suppressionBloc?id=${bloc.id}&x=${ x }&y=${ y }">&nbsp;</a>
							</div>
						</c:if>

						<c:if test="${ bloc == null }">
							<div class="bloc" style="background: ${ color };">
								<a href="ajoutBloc?id=${item.id}&x=${ x }&y=${ y }">&nbsp;</a>
							</div>
						</c:if>
							
					</c:forEach>
				</c:forEach>
			</div>
		</c:forEach>

	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/tetrimino/js/materialize.min.js"></script>

</body>
</html>