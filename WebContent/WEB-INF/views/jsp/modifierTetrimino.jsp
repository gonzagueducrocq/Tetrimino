<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

		<form:form method="POST" class="row center" modelAttribute="tetri">
			<input type="text" name="id" class="row center" value="${ tetri.id }"
				hidden />
			<h5>Nom Tetrimino</h5>
			<form:input path="nom" class="row center"/>
			<h5>Couleur</h5>
			<form:input path="couleur" class="row center"/>
			<br>
			<button class="btn waves-effect waves-light red lighten-1"
				type="submit" name="action">
				Modifier <i class="material-icons right" >send</i>
			</button>

		</form:form>

		<a class="waves-effect waves-light btn red lighten-1"
			href="/tetrimino/tetrimino/addFigure?id=${tetri.id}">Nouvelle figure</a>

		<c:forEach items="${tetri.figures}" var="item">
			<div class="figure">
				<div class="blocs">
					<c:forEach begin="0" end="3" var="x">
						<c:forEach begin="0" end="3" var="y">
							<c:set var="color" value="white" />
							<c:set var="bloc" value="${item.blocExistant(x,y)}"/>
	
							<c:if test="${ bloc != null }">
								<c:set var="color" value="${ tetri.couleur }" />
								<div class="bloc" style="background: ${ color };">
									<a href="/tetrimino/tetrimino/deleteBloc?id=${bloc.id}&x=${ x }&y=${ y }">&nbsp;</a>
								</div>
							</c:if>
	
							<c:if test="${ bloc == null }">
								<div class="bloc" style="background: ${ color };">
									<a href="/tetrimino/tetrimino/addBloc?id=${item.id}&x=${ x }&y=${ y }">&nbsp;</a>
								</div>
							</c:if>
						</c:forEach>
					</c:forEach>
				</div>
				
				<div class="icon remove">
					<a href="/tetrimino/tetrimino/deleteFigure?id=${ item.id }">
						<i class="material-icons">clear</i>
					</a>
				</div>
				
				<div class="icon moins">
					<a href="/tetrimino/tetrimino/ordonner?id=${ item.id }&sens=0">
						<i class="material-icons">arrow_upward</i>
					</a>
				</div>
				
				<div class="icon plus">
					<a href="/tetrimino/tetrimino/ordonner?id=${ item.id }&sens=1">
						<i class="material-icons">arrow_downward</i>
					</a>
				</div>
			</div>
		</c:forEach>