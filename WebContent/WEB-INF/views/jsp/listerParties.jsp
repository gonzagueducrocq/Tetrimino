<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<style>
.posRelative {
	position : relative !important;
}
</style>


<div class="collection">
	<c:forEach items="${parties}" var="item">

		<c:set var="etatPartie">
			<c:choose>
				<c:when test="${item.finie}"><spring:message code="listerParties.partieFinie"/> </c:when>
				<c:otherwise><spring:message code="listerParties.partieEnCours"/> </c:otherwise>
			</c:choose>
		</c:set>
		
		<c:set var="scoreJoueur1">null</c:set>
		<c:set var="scoreJoueur2">null</c:set>
		
		<c:forEach items="${ item.scores }" var="score">
			<c:if test="${ score.joueur.id eq item.joueur1.id }">
				<c:set var="scoreJoueur1">${ score.points }</c:set>
			</c:if>
			<c:if test="${ score.joueur.id eq item.joueur2.id }">
				<c:set var="scoreJoueur2">${ score.points }</c:set>
			</c:if>
		</c:forEach>

		<div class="collection-item avatar">
			<spring:message code="listerParties.partie"/> <c:out value="${item.id}" /><br>
			<spring:message code="listerParties.score"/> <c:out value="${item.joueur1.username}" /> : <c:out value="${ scoreJoueur1 }" /><br>
			<spring:message code="listerParties.score"/> <c:out value="${item.joueur2.username}" /> : <c:out value="${ scoreJoueur2 }" /><br>
			<c:out value="${etatPartie}" />
		</div>
	</c:forEach>
</div>