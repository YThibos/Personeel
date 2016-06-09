<%@ page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>

<!DOCTYPE HTML>

<html>

<head>
	<v:head title="Werknemer ${werknemer.voornaam} ${werknemer.familienaam}"/>
</head>

<body>

	<v:menu/>
	
	<h1>Werknemer ${werknemer.voornaam} ${werknemer.familienaam}</h1>
	
	<dl>
		<dt>Voornaam</dt>
		<dd>${werknemer.voornaam}</dd>
	</dl>
	<dl>
		<dt>Familienaam</dt>
		<dd>${werknemer.familienaam}</dd>
	</dl>
	<dl>
		<dt>Email adres</dt>
		<dd>${werknemer.email}</dd>
	</dl>
	<dl>
		<dt>Salaris</dt>
		<dd>${werknemer.salaris}</dd>
	</dl>
	<dl>
		<dt>Jobtitel</dt>
		<dd>${werknemer.jobtitel}</dd>
	</dl>
	<c:if test="${not empty werknemer.werknemers}">
	<dl>
		<dt>Ondergeschikten</dt>
		<c:forEach items="${werknemer.werknemers}" var="ondergeschikte">
			<c:url value="/werknemers/${ondergeschikte.id}" var="url"/>
			<dd><a href="${url}">${ondergeschikte}</a></dd>
		</c:forEach>
	</dl>
	</c:if>
	<dl>
		<dt>Foto</dt>
		<dd><img alt="foto" src="<c:url value="/images/${werknemer.id}.jpg"/>" /></dd>
	</dl>
	

</body>

</html>