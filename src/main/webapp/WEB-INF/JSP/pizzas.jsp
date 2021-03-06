<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>

<!doctype html>
<html lang='nl'>
	<vdab:head title="Pizza's"/>
	<body>
		<vdab:menu/>
		<c:if test='${not empty param.boodschap}'>
			<div class='boodschap'>${param.boodschap}</div>
		</c:if>
		<h1>Pizza's</h1>
		<c:forEach var='index' begin='1' end='4'>
			&#9733; <%-- de HTML code van een symbool ster --%>
		</c:forEach>
		<ul class='zebra'>
			<c:forEach var='pizza' items='${pizzas}'>
			<li>${pizza.id} : <c:out value='${pizza.naam}'/> <spring:eval expression='pizza.prijs'/> &euro; 
				${pizza.pikant ? "&#9889; PIKANT &#9889;" : " niet pikant"} 
				<spring:url value='pizzas/{id}' var='url'>
					<spring:param name='id' value='${pizza.id}'/>
				</spring:url>
				<a href='${url}'>Detail</a>
			 </li>
			</c:forEach>	
		</ul>
	</body>
</html>