<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title="Mandje"/>
<body>
	<vdab:menu/>
	<h1>Mandje</h1>
	<c:url value='/mandje' var='url'/>
	<form:form action='${url}' modelAttribute='mandjeForm' method='post' id='mandjeform'>
		<form:label path='pizzaId'>Pizza: <form:errors path='pizzaId'/></form:label>
			<form:select path='pizzaId' items='${allePizzas}' itemLabel='naam' itemValue='id'/>
		<input type='submit' value='Toevoegen' id='toevoegknop'>
	</form:form>
	<c:if test='${not empty pizzasInMandje}'>
		<h2>Pizza's in mandje</h2>
		<ul>
			<c:forEach items='${pizzasInMandje}' var='pizza'>
				<li><c:out value='${pizza.naam}'/></li>
			</c:forEach>
		</ul>
	</c:if>
	<script>
		document.getElementById('mandjeform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled=true;
		}
	</script>
</body>
</html>