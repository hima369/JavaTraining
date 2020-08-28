<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
</head>

<%
	String vistorname = request.getParameter("newuser");
	String visitorcontact = request.getParameter("phone");
	String visitoremail = request.getParameter("email");
	String selectedproduct = request.getParameter("ProductItem");
	String selectedcost = request.getParameter("CostItem");

%>
<body>
	<h1>Order Summary</h1>

	<table border="1">
		<tbody>
			<tr>
				<td>VisitorName</td>
				<td><%=vistorname %></td>
			</tr>
			<tr>
				<td>VisitorContact</td>
				<td><%=visitorcontact %></td>
			</tr>
			<tr>
				<td>VisitorEmail</td>
				<td><%=visitoremail %></td>
			</tr>
			<tr>
				<td>VisitorProduct</td>
				<td><%=selectedproduct %></td>
			</tr>
		
			<tr>
				<td>ProductCost</td>
				<td><%=selectedcost %></td>
			</tr>
		
		</tbody>
	
	</table>

</body>
</html>