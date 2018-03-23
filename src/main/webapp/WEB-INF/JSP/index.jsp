<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
 		<c:param name='title' value="Pizza Luigi's welkom"/> 
	</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp'/>
	<h1>Welkom bij Pizza Luigi</h1>
	<img src='images/pizza.jpg' alt='pizza' class='fullwidth'>
	<h2>${boodschap}</h2>
	<h2>De zaakvoerder</h2>
	<dl>
		<dt>Naam</dt><dd>${zaakvoerder.naam}</dd>
		<dt>Aantal kinderen</dt><dd>${zaakvoerder.aantalKinderen}</dd>
		<dt>Gehuwd</dt><dd>${zaakvoerder.gehuwd ? 'Ja' : 'Neen'}</dd>
		<dt>Adres</dt><dd>${zaakvoerder.adres.straat} ${zaakvoerder.adres.huisNr}<br>
						  ${zaakvoerder.adres.postcode} ${zaakvoerder.adres.gemeente}</dd>
				
	</dl>
</body>
</html>
