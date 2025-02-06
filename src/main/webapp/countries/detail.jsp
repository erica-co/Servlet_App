<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
CountryDTO countryDTO = new CountryDTO();
String id = request.getParameter("country_id");

countryDTO.setCountry_id(id);
CountryDAO countryDAO = new CountryDAO();

countryDTO = countryDAO.getDetail(countryDTO);


%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>County Detail </h1>

	<% if(countryDTO != null){ %>
		<h3><%= countryDTO.getCountry_id() %></h3>
		<h3><%= countryDTO.getCountry_name() %></h3>
		<h3><%= countryDTO.getRegion_id() %></h3>
		
		<a href="./update.jsp?country_id=<%= countryDTO.getCountry_id() %>">나라 수정</a>
		<a href="./deleteProcess.jsp?country_id=<%= countryDTO.getCountry_id() %>">나라 삭제</a>
		
	<%}else { %>
		<h3>없는 나라 정보</h3>
	<%} %>



</body>
</html>