<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/newStyle.css">
</head>
<body>

Hi ${param.realName} . This is part of the First MVC Controller.

<p>
<br/>

<h2>Hey everyone</h2>
${finalMessage}

</p>

<img alt="This is a photo" src="${pageContext.request.contextPath}/resources/images/image.jpg"></img>

</body>
</html>