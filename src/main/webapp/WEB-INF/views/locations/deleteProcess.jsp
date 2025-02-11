<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	String id = request.getParameter("country_id");
 	LocationDAO locationDAO = new LocationDAO();
 	LocationDTO locationDTO = new LocationDTO();
 	locationDTO.setCountry_id(id);
 	int result= locationDAO.delete(locationDTO);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(result>0){ %>
		<h3>location 삭제 성공</h3>
	<%}else { %>
		<h3>location 삭제 실패</h3>
	<%} %>
	<a href="/">Home</a>
	<a href="./list.jsp">location 리스트</a>
</body>
</html>