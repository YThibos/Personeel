<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="v" uri="http://vdab.be/tags"%>

<!DOCTYPE HTML>

<html>

<head>
	<v:head title="Opslag"/>
</head>

<body>

	<h1>Opslag voor ${werknemer}</h1>
	
	<dl>
		<dt>Huidig salaris</dt>
		<dd>${werknemer.salaris}</dd>
	</dl>
	
	<sform:form action="" commandName="opslag" method="post" id="opslagForm">
		<sform:label path="bedrag">Bedrag</sform:label>
		<sform:input path="bedrag" type="number"  min="1" required="required" autofocus="autofocus"/>
		<input type="submit" value="opslag" id="submitButton">
		
		<script>
			document.getElementById("opslagForm").onsubmit= function() {
				document.getElementById("submitButton").disabled=true;
			};
</script>
	</sform:form>

</body>

</html>