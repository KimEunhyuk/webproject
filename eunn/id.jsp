<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디와 비밀번호를 다시 입력해주세요</title>
</head>
<body>

<center>
<br><br><br><br><br><br><br><br><br><br><br>
<h3>아이디와 비밀번호를 다시 입력해주세요</h3>
<p>


<!-- controller?command=applicant  -->

	<form action="controller?command=applicant" method="post" >
	
	ID : <input type="text" name="applicantId">
	PW : <input type="text" name="password">
	<input type="submit" value="확인">
	</form>
	
</center>

</body>
</html>