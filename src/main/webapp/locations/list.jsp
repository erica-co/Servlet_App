<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDAO locationDAO = new LocationDAO ();
	List<LocationDTO> ar = locationDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 50%;
		margin: 0 auto;
		border: 1px solid skyblue;
		border-collapse: collapse;
	}
	
	table th, table td {
		border: 1px solid skyblue;
		height: 40px;
		text-align: center;
	}



</style>
</head>
<body>
	<h1>Location List</h1>
	<table>
		<thead>
			<tr>
				<th>Country_Id</th><th>City</th><th>Postal_code</th>
			</tr>
		</thead>
		<tbody>
				<%for(int i=0;i<ar.size();i++){ %>
			<tr>
				<td>
					<%= ar.get(i).getCountry_id()%>
				</td>
				<td>
					<a href="./detail.jsp?location_id=<%=ar.get(i).getLocation_id()%>"><%= ar.get(i).getCity() %></a>
				</td>
				<td>
					<%= ar.get(i).getPostal_code() %>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<div>
		<a href="./add.jsp">부서 등록</a>
	</div>
</body>
</html>