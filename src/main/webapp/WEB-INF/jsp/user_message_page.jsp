<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User messages</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">${userName} messages</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Message text</th>
				        <th width="220">Actions</th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${messages}" var="message">
					<tr>
						<td>${message.messageText}</td>
						<td>
						    <a href="<c:url value='/message/edit/${message.id}' />" class="btn btn-success custom-width">edit</a>
    						<a href="<c:url value='/message/delete/${message.id}' />" class="btn btn-danger custom-width">delete</a>
						</td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
   	</div>
</body>
</html>