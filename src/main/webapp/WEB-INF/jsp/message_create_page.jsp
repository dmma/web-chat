<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit message form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">

		<div class="well lead">Edit message form</div>
	 	<form:form method="POST" modelAttribute="message" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
            <form:input type="hidden" path="user.id" id="user.id"/>

			<div class="row">
				<div class="form-group col-lg-12">
					<label class="col-lg-3 control-lable" for="userName">User</label>
					<div class="col-lg-7">
						<form:input type="text" path="user.name" id="user.name" class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-lg-12">
					<label class="col-lg-3 control-lable" for="messageText">Message text</label>
					<div class="col-lg-7">
						<form:input type="text" path="messageText" id="messageText" class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Create" class="btn btn-primary btn-sm"/> <a href="<c:url value='/message' />" class="btn btn-info btn-sm">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>