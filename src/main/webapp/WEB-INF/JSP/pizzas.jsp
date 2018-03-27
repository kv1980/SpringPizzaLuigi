<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<!doctype html>
<html lang='nl'>
	<head>
		<c:import url='/WEB-INF/JSP/head.jsp'>
 			<c:param name='title' value="Pizza Luigi's soorten"/>
		</c:import>
	</head>
	<body>
		<c:import url='/WEB-INF/JSP/menu.jsp'/>
		<h1>Pizza's</h1>
		<c:forEach var='index' begin='1' end='4'>
			&#9733; <%-- de HTML code van een symbool ster --%>
		</c:forEach>
		<ul class='zebra'>
			<c:forEach var='entry' items='${pizzas}'>
			<li>${entry.key} : <c:out value='${entry.value.naam}'/> ${entry.value.prijs} &euro; 
				${entry.value.pikant ? "&#9889; PIKANT &#9889;" : " niet pikant"} 
				<spring:url value='pizzas/{id}' var='url'>
					<spring:param name='id' value='${entry.key}'/>
				</spring:url>
				<a href='${url}'>Detail</a>
			 </li>
			</c:forEach>	
		</ul>
	</body>
</html>