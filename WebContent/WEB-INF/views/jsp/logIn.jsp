<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<form:form method="post" action="logIn" modelAttribute="user">
<table>


<tr>
<td><form:label path="username">Nom utilisateur</form:label></td>
<td><form:input path="username" /></td>
<td><form:errors path="username" /></td>

</tr>

<tr>
<td><form:label path="password">Mot de passe</form:label></td>
<td><form:input path="password" /></td>
<td><form:errors path="password" /></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Se connecter"/></td>
</tr>
</table>
</form:form>
