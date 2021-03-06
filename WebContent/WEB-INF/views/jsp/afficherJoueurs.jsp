<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<style>
.posRelative {
	position: relative !important;
}
</style>
		<ul class="collection">

			<c:forEach items="${joueurs}" var="item">
			
						<c:set var="etatJoueur">
				<c:choose>
					<c:when test="${item.banni}"><spring:message code="afficherJoueur.joueurBanni"/></c:when>
					<c:otherwise><spring:message code="afficherJoueur.joueurActif"/></c:otherwise>
				</c:choose>
			</c:set>
			
			
			    <li class="collection-item avatar">
			      <span class="title"><b><c:out value="${item.username}" /></b></span>
			      <p><c:out value="${item.nom}" /><br>
			         <c:out value="${item.prenom}" /><br>
			         <c:out value="${etatJoueur}" />
			         <a href="/tetrimino/joueur/bannir?id=<c:out value="${ item.id }"/>" class="secondary-content" title="<spring:message code="afficherJoueur.bannir"/>" onclick="Materialize.toast('Effectu� !', 4000, 'rounded')"><i class="material-icons">gavel</i></a>
			      </p>
			    </li>
			
				<%-- <li class="collection-item avatar"><c:out value="${item.id}" /> |
					 <c:out value="${item.username}" /> |
					<c:out value="${etatJoueur}" /> 
					<c:if test="${ !empty sessionScope.admin }">
						<a href="tetrimino/joueur/bannir?id=<c:out value="${ item.id }"/>" class="secondary-content posRelative" title="Bannir"><i	class="material-icons">gavel</i></a>
					</c:if>
				</li> --%>
			</c:forEach>
		
		</ul>