<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='nl'>
<vdab:head title="Welkom"/>
<body>
	<vdab:menu/>
	<h1>Welkom bij Pizza Luigi</h1>
	<img src='<c:url value="/images/pizza.jpg"/>' alt='pizza' class='fullwidth'>
	<h2>${boodschap}</h2>
	<h2>De zaakvoerder</h2>
	<dl>
		<dt>Naam</dt><dd>${zaakvoerder.naam}</dd>
		<dt>Aantal kinderen</dt><dd>${zaakvoerder.aantalKinderen}</dd>
		<dt>Gehuwd</dt><dd>${zaakvoerder.gehuwd ? 'Ja' : 'Neen'}</dd>
		<dt>Adres</dt><dd>${zaakvoerder.adres.straat} ${zaakvoerder.adres.huisNr}<br>
						  ${zaakvoerder.adres.postcode} ${zaakvoerder.adres.gemeente}</dd>
				
	</dl>
	<c:if test='${not empty laatstBezocht }'>
		<p>Je bezocht onze website laatst op <spring:eval expression='laatstBezocht.waarde'/>.</p>
	</c:if>
	<p>Deze pagina werd ${aantalKeerBekeken} keer bekeken.</p>
	<p>${identificatie.emailAdres}</p>
</body>
</html>
