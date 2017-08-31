<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="light-red lighten-1" role="navigation">
<div class="nav-wrapper container">
	<a id="logo-container" href="/tetrimino/home" class="brand-logo">Tetrimino</a>

	<c:if test="true">
		<ul class="right hide-on-med-and-down">
			<li><a href="/tetrimino/tetriminos">Liste Tetriminos</a></li>
		</ul>
		<ul id="nav-mobile" class="side-nav">
			<li><a href="/tetrimino/tetriminos">Liste Tetriminos</a></li>
		</ul>
		<ul class="right hide-on-med-and-down">
			<li><a href="/tetrimino/joueurs">Liste Joueurs</a></li>
		</ul>
		<ul id="nav-mobile" class="side-nav">
			<li><a href="/tetrimino/joueurs">Liste Joueurs</a></li>
		</ul>
		
		<c:if test="true">
			<ul class="right hide-on-med-and-down">
				<li><a href="/tetrimino/parties">Liste Parties</a></li>
			</ul>
			<ul id="nav-mobile" class="side-nav">
				<li><a href="/tetrimino/parties">Liste Parties</a></li>
			</ul>
		</c:if>
	
		<ul class="right hide-on-med-and-down">
			<li><a href="/tetrimino/account/logout">D�connexion</a></li>
		</ul>
		<ul id="nav-mobile" class="side-nav">
			<li><a href="/tetrimino/account/logout">D�connexion</a></li>
		</ul>
	
		<a href="#" data-activates="nav-mobile" class="button-collapse"><i
			class="material-icons">menu</i></a>
	</c:if>
</div>
</nav>