
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<a href="/tetrimino/tetrimino/delete?id=${ item.id }" class="secondary-content posRelative" title="Supprimer"><i class="material-icons">cancel</i> </a>
					<a href="admin/modifPiece?id=${ item.id }" class="secondary-content posRelative" title="Editer"><i class="material-icons">edit</i></a>
					
				</li>
			</c:forEach>
		</div>
		<p>
			<a class="waves-effect waves-light btn-large red lighten-1"
				href="/tetrimino/tetriminos"><i class="material-icons left">add</i>Ajouter
				Tetrimino</a>
		</p>