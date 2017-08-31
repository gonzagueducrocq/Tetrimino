<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<form:form method="POST" class="row center" modelAttribute="tetri">
		<p><c:out value ="${ placholderNom }"/></p>
			<h5>Nom Tetrimino</h5>
			<form:input  path="nom" class="row center"/>
			<h5>Couleur</h5>
			<form:input path="couleur" class="row center" />
			<br>
			<button class="btn waves-effect waves-light red lighten-1" type="submit" name="action">
				Ajouter <i class="material-icons right">send</i>
			</button>
		</form:form>