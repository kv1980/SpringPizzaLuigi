<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
	<vdab:head title="Headers"/>
	<body>
		<vdab:menu/>
		Je browser wordt uitgevoerd op 
		${opWindows ? "Windows" : "een niet-Windows besturingsysteem"}.
	</body>
</html>