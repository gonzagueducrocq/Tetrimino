<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<nav class="light-red lighten-1" role="navigation">
<div class="nav-wrapper container">
	<a id="logo-container" href="/tetrimino/home" class="brand-logo">Tetrimino</a>

	<c:if test="true">
		<ul class="right hide-on-med-and-down">
			<li><a href="/tetrimino/tetriminos"><spring:message code="navigation.listeTetriminos"/></a></li>
		</ul>
		<ul id="nav-mobile" class="side-nav">
			<li><a href="/tetrimino/tetriminos"><spring:message code="navigation.listeTetriminos"/></a></li>
		</ul>
		<ul class="right hide-on-med-and-down">
			<li><a href="/tetrimino/joueurs"><spring:message code="navigation.listeJoueurs"/></a></li>
		</ul>
		<ul id="nav-mobile" class="side-nav">
			<li><a href="/tetrimino/joueurs"><spring:message code="navigation.listeJoueurs"/></a></li>
		</ul>
		
		<c:if test="true">
			<ul class="right hide-on-med-and-down">
				<li><a href="/tetrimino/parties"><spring:message code="navigation.listeParties"/></a></li>
			</ul>
			<ul id="nav-mobile" class="side-nav">
				<li><a href="/tetrimino/parties"><spring:message code="navigation.listeParties"/></a></li>
			</ul>
		</c:if>
	
		<ul class="right hide-on-med-and-down">
			<li><a href="/tetrimino/account/logout"><spring:message code="navigation.deconnexion"/></a></li>
		</ul>
		<ul id="nav-mobile" class="side-nav">
			<li><a href="/tetrimino/account/logout"><spring:message code="navigation.deconnexion"/></a></li>
		</ul>
	
		<a href="#" data-activates="nav-mobile" class="button-collapse"><i
			class="material-icons"><spring:message code="navigation.menu"/></i></a>
	</c:if>
</div>
</nav>