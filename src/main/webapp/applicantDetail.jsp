<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
	System.out.println(url);
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>재능 기부자 상세 정보 화면</title>
</head>
<body>
<br><br><br>
<center>


<h3>재능 기부자</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>지원자 id</th><th>name</th><th>phone</th>
	</tr>
 	<tr>
 		<td>${applicant.id}</td>
 		<td>${applicant.name}</td>
 		<td>${applicant.phone}</td>
 	</tr>
</table>

<br><br><br>
<a href="probono?command=activistUpdateReq&activistId=${activist.id}">수정하기</a>

<a href="probono?command=activistDelete&activistId=${activist.id}">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>


</center>
</body>
</html>







