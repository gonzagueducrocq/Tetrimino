<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<form:form method="post" action="logIn" modelAttribute="user">
<table>


<tr>
<td><form:label path="username"><spring:message code="login.nomutilisateur"/></form:label></td>
<td><form:input path="username" /></td>
<td><form:errors path="username" /></td>

</tr>

<tr>
<td><form:label path="password"><spring:message code="login.motdepasse"/></form:label></td>
<td><form:input path="password" /></td>
<td><form:errors path="password" /></td>
</tr>

<tr>
<td colspan="1"><input class="btn waves-effect waves-light red lighten-1" type="submit" value="<spring:message code="login.connexion"/>"/></td>
</tr>
</table>
</form:form>
