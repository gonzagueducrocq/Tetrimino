<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="/tetrimino/css/materialize.min.css" type="text/css"
	rel="stylesheet" media="screen,projection" />
<link href="/tetrimino/css/tetrimino.css" type="text/css"
	rel="stylesheet" media="screen,projection" />
	<link href="/tetrimino/css/figure.css" type="text/css"
	rel="stylesheet" media="screen,projection" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<title><tiles:insertAttribute name="title" /></title>
</head>
<body>

	<tiles:insertAttribute name="navigation" />
	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/tetrimino/js/materialize.min.js"></script>
		<script type="text/javascript" src="/tetrimino/js/tetrimino.js"></script>

</body>

</html>