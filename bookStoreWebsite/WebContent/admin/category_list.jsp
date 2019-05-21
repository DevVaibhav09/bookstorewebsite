<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Category</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Category Management</h2>
		<h3>
			<a href="category_form.jsp"> Create new Category</a>
		</h3>


	</div>
	<div align="center">
		<h4>
			<i> ${message} </i>
		</h4>

	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Indexes</th>
				<th>Category Id</th>
				<th>Category Name</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="cat" items="${listCategory}" varStatus="status1">
				<tr>
					<td>${status1.index}</td>
					<td>${cat.categoryId}</td>
					<td>${cat.categoryName}</td>
					<td><a href="edit_category?id=${cat.categoryId}"> Edit</a> 
					<a href="javascript:confirmDelete(${cat.categoryId})"> Delete</a></td>
				</tr>
			</c:forEach>
		</table>


	</div>


	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	function confirmDelete(categoryId){
		if(confirm('Are you sure you want to delete the user with id ' +categoryId + '?')){
			window.location = 'delete_category?id=' + categoryId;
		}
	}
	</script>
</body>
</html>