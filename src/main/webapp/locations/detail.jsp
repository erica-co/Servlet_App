<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDTO locationDTO = new LocationDTO();
	String location_id = request.getParameter("location_id");
	locationDTO.setLocation_id(Long.parseLong(location_id));
  	LocationDAO locationDAO = new LocationDAO();
  	locationDTO = locationDAO.getDetail(locationDTO);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Location Detail Page</h1>
	
	<%if(locationDTO != null){ %>
		<h3><%= locationDTO.getLocation_id() %></h3>
		<h3><%= locationDTO.getCountry_id() %></h3>
		<h3><%= locationDTO.getPostal_code()%></h3>
		<h3><%= locationDTO.getStreet_address()%></h3>
		<h3><%= locationDTO.getState_province() %></h3>
		
		<a href="/update.jsp?location_id=<%= locationDTO.getLocation_id() %>">부서 수정</a>
		<a href="./deleteProcess.jsp?country_id=<%= locationDTO.getCountry_id() %>">부서 삭제</a>
		
	<%}else { %>
		<h3>없음</h3>
	<%} %>
	
</body>
</html>