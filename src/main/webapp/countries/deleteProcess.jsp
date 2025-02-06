
<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
String id = request.getParameter("country_id");
CountryDTO countryDTO = new CountryDTO();
countryDTO.setCountry_id(id);

CountryDAO countryDAO = new CountryDAO();
int result = countryDAO.delete(countryDTO);





%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%if(result>0){ %>
		<h3>나라 삭제 성공</h3>
	<%}else { %>
		<h3>나라 삭제 실패</h3>
	<%} %>
	<a href="/">Home</a>
	<a href="./list.jsp">나라 리스트</a>

</body>
</html>