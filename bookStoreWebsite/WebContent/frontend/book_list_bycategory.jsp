<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book in List ${category.categoryName} </title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<hr>

	<div align="center">
		<h1> ${category.categoryName} </h1><hr>
	</div>
	<div align="center">
	<c:forEach items="bookListbyCategory" var="book">
		${book.title}
		</c:forEach>
	
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>