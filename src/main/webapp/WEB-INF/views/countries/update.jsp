<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String id = request.getParameter("country_id");
CountryDTO countryDTO = new CountryDTO();
countryDTO.setCountry_id(id);

CountryDAO countryDAO = new CountryDAO();
countryDTO = countryDAO.getDetail(countryDTO);



%>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>업데이트</h2>

	<form action="./updateProcess.jsp" method="post">
		<input type="hidden" name="country_id" value="<%= countryDTO.getCountry_id()%>">
		<input type="text" name="country_name" value="<%= countryDTO.getCountry_name() %>">
		<input type="text" name="region_id" value="<%= countryDTO.getRegion_id()%>">
		<button type="submit">수정</button>
	
	</form>






</body>
</html>