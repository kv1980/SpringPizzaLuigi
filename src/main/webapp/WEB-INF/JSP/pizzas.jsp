<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<li>${entry.key} : <c:out value='${entry.value.naam}'/> ${entry.value.naam} ${entry.value.prijs} &euro; 
				${entry.value.pikant ? "&#9889; PIKANT &#9889" : " niet pikant"} 

<!-- alternatief voor keuze pikant
				<c:if test='${entry.value.pikant}'> &#9889; PIKANT &#9889 </c:if>
-->			
<!-- alternatief voor keuze pikant
				<c:choose> 
 					<c:when test='${entry.value.pikant}'>&#9889; PIKANT &#9889;</c:when>
					<c:otherwise> niet pikant </c:otherwise>
 				</c:choose>	 
-->			
				<c:url var='url' value='/pizzas/detail'>
					<c:param name='id' value='${entry.key}'/>
				</c:url>
				<a href='${url}'>Detail</a>
			 </li>
			</c:forEach>	
		</ul>
	</body>
</html>