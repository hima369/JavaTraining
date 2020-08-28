<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kit form</title>
</head>
<body>

<%-- <jsp:include page="header.jsp" /> --%>
<jsp:include page="AdminHomepage.jsp" />

<h3>Kit Form</h3>
<h3>${kit.kitID==null?"New Kit":"Edit Kit" }</h3>
<form action='${kit.kitID==null?"addkit":"savekit" }' method="POST">
<div>
	<label>kitID: </label>
	<input type="number" value="${kit.kitID}" name = "kitID" required 
	${kit.kitID==null?"":"readonly" }/>
 </div>
 
 <div>
	<label>productitem: </label>
	<input type="text" value="${kit.productitem}" name = "productitem" minlength="3" maxlength = "20" required />
 </div>
 
 <div>
	<label>cost: </label>
	<input type="decimal" value="${kit.cost}" name = "cost" required />
 </div>
 
 <div>
	<label>productdescription: </label>
	<input type="text" value="${kit.productdescription}" name = "productdescription" required />
 </div>
 
 <button>Save</button>

</form>


</body>
</html>