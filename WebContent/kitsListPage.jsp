<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
  <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kits List</title>
</head>
<body>

	<jsp:include page="AdminHomepage.jsp" />
<%-- <jsp:include page="header.jsp" /> --%>
	<h3>Kits</h3>
	<c:choose>
		<c:when test="${kits==null || kits.isEmpty() }">
			<p>No Items Found</p>
		</c:when>
	<c:otherwise>
	<table border="1" cellspacing="5px" cellpadding="5px">
		<tr>
			<th>kitID</th>
			<th>productitem</th>
			<th>cost</th>
			<th>productdescription</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${kits }" var="kit">		
			<tr>
				<td>${kit.kitID }</td>
				<td>${kit.productitem }</td>
				<td>${kit.cost }</td>
				<td>${kit.productdescription }</td>
				<td>
					<a href="deletekit?kitID=${kit.kitID }">DELETE</a> <span>|</span>
					<a href="editkit?kitID=${kit.kitID }">EDIT</a> <span>|</span>
				</td>			
			</tr>	
		</c:forEach>
	</c:otherwise>	
	</c:choose>

</body>
</html>