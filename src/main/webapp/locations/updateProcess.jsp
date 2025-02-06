<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String location_id =  request.getParameter("location_id");
	String ad =  request.getParameter("street_address");
	String state = request.getParameter("state_province");
	String city =  request.getParameter("city");
	String code =  request.getParameter("postal_code");
	String country_id =  request.getParameter("country_id");
	
	LocationDTO locationDTO = new LocationDTO();
	locationDTO.setStreet_address(ad);
	locationDTO.setState_province(state);
	locationDTO.setCity(city);
	locationDTO.setPostal_code(code);
	locationDTO.setCountry_id(country_id);
	
	LocationDAO locationDAO = new LocationDAO();
	int result = locationDAO.update(locationDTO);

	String r = "부서 수정 실패";
	
	if(result>0) {
		r= "부서 수정 성공";
	}
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3><%= r %></h3>
	<a href="/">Home</a>
	<a href="./list.jsp">부서 리스트</a>

</body>
</html>