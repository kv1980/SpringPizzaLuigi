<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title="Pizza toevoegen"/>
<body>
	<vdab:menu/>
	<h1>Toevoegen</h1>
	<c:url value='/pizzas/toevoegen' var='url'/>
	<form:form action='${url}' modelAttribute='pizza' method='post' id='pizzaform'>
		<form:label path='naam'>Naam: <form:errors path='naam'/></form:label>
			<form:input path='naam' autofocus='autofocus' required='required'/>
		<form:label path='prijs'>Prijs: <form:errors path='prijs'/></form:label>
			<form:input path='prijs' type='number' required='required' min='0'/>
		<form:checkbox path='pikant'/><form:label path='pikant'>Pikant</form:label>
		<input type='submit' value='Toevoegen' id='toevoegknop'>
	</form:form>
	<script>
		document.getElementById('pizzaform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled=true;
		}
	</script>
</body>
</html>