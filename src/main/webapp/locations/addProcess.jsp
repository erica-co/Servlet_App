<%@page import="com.winter.app.locations.LocationDTO"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDTO locationDTO = new LocationDTO();

	String address = request.getParameter("STREET_ADDRESS");
	String state = request.getParameter("STATE_PROVINCE");
	String city = request.getParameter("city");
	String code = request.getParameter("POSTAL_CODE");
	
	locationDTO.setStreet_address(address);
	locationDTO.setState_province(state);
	locationDTO.setCity(city);
	locationDTO.setPostal_code(code);
	
	LocationDAO locationDAO = new LocationDAO();
	int result = locationDAO.add(locationDTO);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>location 등록 진행 페이지</h1>
	
	<%if(result>0){ %>
		<h3>등록 성공</h3>
	<%}else { %>
		<h3>등록 실패</h3>
	<%} %>
	<a href="/">Home</a>
	<a href="./list.jsp">location 리스트</a>
	
	

</body>
</html>