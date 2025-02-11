<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>location 추가 페이지</h1>
	
	<form action="./addProcess.do" method="post">
		<input type="text" name="STREET_ADDRESS" value="street_address">
		<input type="text" name="STATE_PROVINCE]" value="state_province">
		<input type="text" name="CITY" value="city">
		<input type="text" name="POSTAL_CODE" value="postal_code">
		<button type="submit">등록</button>
		
	</form>

</body>
</html>