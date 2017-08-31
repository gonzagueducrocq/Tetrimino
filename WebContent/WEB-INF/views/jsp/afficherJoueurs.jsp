<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.posRelative {
	position: relative !important;
}
</style>
		<ul class="collection">

			<c:forEach items="${joueurs}" var="item">
			
						<c:set var="etatJoueur">
				<c:choose>
					<c:when test="${item.banni}">Joueur banni</c:when>
					<c:otherwise>Joueur actif</c:otherwise>
				</c:choose>
			</c:set>
			
			
			    <li class="collection-item avatar">
			      <span class="title"><b><c:out value="${item.username}" /></b></span>
			      <p><c:out value="${item.nom}" /><br>
			         <c:out value="${item.prenom}" /><br>
			         <c:out value="${etatJoueur}" />
			         <a href="/tetrimino/joueur/bannir?id=<c:out value="${ item.id }"/>" class="secondary-content" title="Bannir" onclick="Materialize.toast('Effectué !', 4000, 'rounded')"><i class="material-icons">gavel</i></a>
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