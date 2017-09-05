
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<style>
.posRelative {
	position: relative !important;
}
</style>
		<div class="collection">
			<c:forEach items="${tetriminos}" var="item">
				<li class="collection-item avatar">
				
				<c:if test="${item.figures.size() > 0 }">
					<c:set var="figure" value="${item.figures.get(0)}"></c:set>
					<div class="mini-figure">
						<div class="mini-blocs">
							<c:forEach begin="0" end="3" var="x">
								<c:forEach begin="0" end="3" var="y">
									<c:set var="color" value="white" />
									<c:set var="bloc" value="${figure.blocExistant(x,y)}" />

									<c:if test="${ bloc != null }">
										<c:set var="color" value="${ item.couleur }" />
										<div class="mini-bloc" style="background: ${ color };">
										</div>
									</c:if>

									<c:if test="${ bloc == null }">
										<div class="mini-bloc" style="background: ${ color };">
										</div>
									</c:if>
								</c:forEach>
							</c:forEach>
						</div>

					</div>
					</c:if>
					<div> 
					 <c:out value="${item.nom}"/> 
					<a href="/tetrimino/tetrimino/delete?id=${ item.id }" class="secondary-content posRelative" title="<spring:message code="afficherTetrimino.supprimer"/>"><i class="material-icons">cancel</i> </a>
					<a href="/tetrimino/tetrimino/edit?id=${ item.id }" class="secondary-content posRelative" title="<spring:message code="afficherTetrimino.editer"/>"><i class="material-icons">edit</i></a>
					</div>
				</li>
			</c:forEach>
		</div>
		<p>
			<a class="waves-effect waves-light btn-large red lighten-1"
				href="/tetrimino/tetrimino/add"><i class="material-icons left">add</i><spring:message code="afficherTetrimino.ajouter"/></a>
		</p>