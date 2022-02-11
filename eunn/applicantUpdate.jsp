<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<center>

<h3>지원자 정보 수정하기</h3>
<hr><p>


<%
		System.out.println("update.jsp " + session.getAttribute("applicant"));
%>
<form action="controller?command=applicantUpdate" method="post">
<table border="1">
	<thead>
		<tr>
			<th>지원자 id</th><th>지원자명</th><th>비밀번호</th><th>핸드폰 번호</th>
		</tr>
 	<tr>
 		<td><input type="text" name="applicantId"  value="${applicant.id}" readonly></td>
 		<td>${applicant.name}</td>
 		<td>${applicant.password}</td>
 		<td><input type="text" name="phone" value="${applicant.phone}"></td>
 	</tr>
 	
 	<tr>
 		<td colspan="4">
 			<input type="submit" value="수정">
 			&nbsp;&nbsp;&nbsp;
 			<input type="reset" value="취소">
 		</td>
 	</tr>
 <!--  	
 	<tr>
 		<td>
 			<button type="button" onclick = "location.href='index.html'">메인으로 돌아가기</button>
 		</td>
 	</tr>
 -->
</table>
</form>

</center>
</body>
</html>