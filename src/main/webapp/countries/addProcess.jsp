<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
CountryDTO countryDTO = new CountryDTO();

String id =request.getParameter("country_id");
String name = request.getParameter("country_name");
String region = request.getParameter("region_id");

countryDTO.setCountry_id(id);
countryDTO.setCountry_name(name);
countryDTO.setRegion_id(Integer.parseInt(region));

CountryDAO countryDAO = new CountryDAO();
int result = countryDAO.add(countryDTO);



%> 






<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<h1>나라 등록 진행 페이지</h1>
	
	<%if(result>0){  %>
		<h3>나라 등록 성공</h3>
		
	<%}else { %>
		<h3>나라 등록 실패</h3>
	<%} %>
	<a href="/">Home</a>
	<a href="./list.jsp">부서 리스트</a>
	

</body>
</html>