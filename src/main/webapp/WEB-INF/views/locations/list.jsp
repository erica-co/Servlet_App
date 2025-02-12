<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="../template/common.jsp"%>
<link rel="stylesheet" href="../resources/css/location_list.css">
</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<section class="wrap_left contents">
		<%@ include file="../template/nav.jsp"%>
		<div class="right contents_right">
			<div class="contents_right_list">
	
	<table>
		<thead>
			<tr>
				<th>Country_Id</th><th>City</th><th>Postal_code</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="d" varStatus="st">
				
				<tr>
					<td>
						${pageScope.d.country_id }
					</td>
					<td>
						<a href="./detail.do?location_id=${d.location_id}">${d.city}</a>
					</td>
					<td>
						${d.postal_code}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<a href="./add.do">위치 등록</a>
	</div>
	
	</section>

	<%@ include file="../template/footer.jsp"%>
	
</body>
</html>