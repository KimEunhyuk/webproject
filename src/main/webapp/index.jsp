<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>

	<center>
		<h3>채용 사이트</h3>
		<hr>
		<p>
	</center>
	<%
		System.out.println(session.getAttribute("applicant"));
	%>

	<p>

		<!-- 완성된 로직 : 보고 이해하기 -->
		&nbsp;&nbsp;&nbsp;<a href="probono?command=probonoProjectAll">1.
			지원자 등록 </a>
	<p>

		&nbsp;&nbsp;&nbsp;<a href="probono?command=activistAll">2. 합격자 조회
		</a>
	<p>

		&nbsp;&nbsp;&nbsp;<a href="activistInsert.html">3. 마이 페이지 </a>
	<p>
	<form action="probono?command=activist" method="post">
		&nbsp;&nbsp;&nbsp; 4. 기부자 ID : <input type="text" name="activistId"><input
			type="submit" value="검색">
	</form>
	<p>
	<hr>


</body>
</html>