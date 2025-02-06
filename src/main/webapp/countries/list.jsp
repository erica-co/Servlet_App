<%@page import="com.winter.app.countries.CountryDTO"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% CountryDAO countryDAO = new CountryDAO();
	List<CountryDTO> ar = countryDAO.getList();
	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>Country List</h1>
	<h3>표현식 자바의 변수나 값을 html로 출력할 때 사용</h3>
	<table>
		<thead>
			<tr>
				<th>나라 아이디</th><th>나라 이름</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0;i<ar.size();i++){ %>
			<tr>
				<td>
					<%= ar.get(i).getCountry_id() %>
				</td>
				<td>
					<a href="./detail.jsp?country_id=<%=ar.get(i).getCountry_id()%>"><%= ar.get(i).getCountry_name()%></a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<div>
		<a href="./add.jsp">부서 등록</a>
	</div>

</body>
</html>