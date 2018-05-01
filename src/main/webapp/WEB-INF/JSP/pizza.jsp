<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> 
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>

<!doctype html>
<html lang='nl'>
<vdab:head title="Pizza"/>
<body>
	<vdab:menu/>
	<h1>${pizza.naam}</h1>
	<dl>
		<dt>Nummer</dt><dd>${pizza.id}</dd>
		<dt>Naam</dt><dd>${pizza.naam}</dd>
		<dt>Prijs in Euro</dt><dd><spring:eval expression='pizza.prijs'/></dd>
		<dt>Prijs in Dollar</dt><dd><spring:eval expression='inDollar.waarde'/></dd>
		<dt>Pikant</dt><dd>${pizza.pikant ? 'ja' : 'neen'}</dd>
	</dl>
</body>
</html>