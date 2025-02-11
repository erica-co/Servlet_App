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

<%@include file="../template/common.jsp"%>
<link rel="stylesheet" href="../resources/css/location_list.css">
</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<section class="wrap_left contents">
		<%@ include file="../template/nav.jsp"%>
		<div class="right contents_right">
			<div class="contents_right_list">
	
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
					<a href="./detail.do?location_id=<%=ar.get(i).getLocation_id()%>"><%= ar.get(i).getCity() %></a>
				</td>
				<td>
					<%= ar.get(i).getPostal_code() %>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<div>
		<a href="./add.do">위치 등록</a>
	</div>
	
	</section>

	<%@ include file="../template/footer.jsp"%>
	
</body>
</html>