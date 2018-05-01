<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> 
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>

<!doctype html>
<html lang='nl'>
<vdab:head title="Pizza tussen prijzen"/>
<body>
	<vdab:menu/>
	<h1>Van tot prijs</h1>
	<c:url value='/pizzas' var='url'/>
	<form:form action='${url}' modelAttribute='vanTotPrijsForm' method='get'> 
		<form:label path='van'>Van: <form:errors path='van'/></form:label>
		<form:input path='van' autofocus='autofocus' type='number' required='required' min='0'/>
		<form:label path='tot'>Tot: <form:errors path='tot'/></form:label>
		<form:input path='tot' type='number' required='required' min='0'/>
		<input type='submit' value='zoeken'><form:errors cssClass='fout'/>
	</form:form>	
	<c:if test='${not empty pizzas}'>
		<ul>
			<c:forEach var='pizza' items='${pizzas}'>
				<spring:url var='url' value='/pizzas/{id}'>
					<spring:param name='id' value='${pizza.id}'/>
				</spring:url>
				<li>
					<a href='${url}'><c:out value='${pizza.naam}'/></a>
					(${pizza.prijs})
				</li>
			</c:forEach>		
		</ul>
	</c:if>
</body>
</html>