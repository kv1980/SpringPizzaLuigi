<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title="Prijzen"/>
<body>
	<vdab:menu/>
	<h1>Prijzen</h1>
	<ul>
		<c:forEach var='prijs' items='${prijzen}'>
			<c:url var='url' value='/pizzas'>
				<c:param name='prijs' value='${prijs}'/>
			</c:url>
			<li>
				<a href='${url}'>${prijs}</a>
			</li>
		</c:forEach>
	</ul>
 	<c:if test='${not empty pizzas}'>
		<h2>${prijs}</h2>
		<ul>
			<c:forEach items='${pizzas}' var='pizza'>
				<spring:url var='url' value='/pizzas/{id}'>
					<spring:param name='id' value='${pizza.id}'/>
				</spring:url>
				<li>
					<a href='${url}'><c:out value='${pizza.naam}'/></a>
				</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>