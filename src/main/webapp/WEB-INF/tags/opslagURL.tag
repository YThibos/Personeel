<%@ tag description='URL link generator naar opslag pagina' pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ attribute name='id' required='true' type='java.lang.Long'%>

<c:url value="/werknemers/${id}/opslag" var="opslagURL"/>
<a href="${opslagURL}">Opslag</a>