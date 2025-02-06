<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String id = request.getParameter("country_id");
String name = request.getParameter("country_name");
String region = request.getParameter("region_id");

CountryDTO countryDTO = new CountryDTO();
countryDTO.setCountry_id(id);
countryDTO.setCountry_name(name);
countryDTO.setRegion_id(Integer.parseInt(region));

CountryDAO countryDAO = new CountryDAO();
int result = countryDAO.update(countryDTO);


String r = "나라 수정 실패";
if(result > 0){
	r ="나라 수정 성공";
}

%>




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