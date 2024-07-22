<%@page import="com.yedam.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>actionForm.jsp</title>
</head>
<body>
	<h3>액션태그연습.</h3>
	<%
	request.setAttribute("myName", "정현우");
	StudentVO student = new StudentVO();
	student.setStdNo("100");
	student.setStdName("정현우");
	request.setAttribute("student", student);
	String msg = "Hello";
	%>

	<mytag:set var="msg" value="Hello2"></mytag:set>
	<mytag:set var="age" value="20" />

	<h3>Jsp Standard Tag Library & Expression Language(P:358)</h3>
	<p>${10 + 4 }</p>
	<p>${10 > 20}</p>
	<p>${'Hello' += 'World'}</p>
	<p>${10 > 5 ? '참' : '거짓' }</p>
	<p>이름은 ${myName }</p>
	<p>학생정보 ${student}</p>
	<p>학생이름은 ${student.stdName }, 학번은 ${student.stdNo }</p>
	<p>Msg 값은 ${msg }</p>
	<p>${age >= 20 ? '성인' : '미성년자' }</p>
	<mytag:if test="${age >= 20}">
		<p>성인</p>
	</mytag:if>
	<mytag:choose>
		<mytag:when test="${age >= 20 }">
			<p>성인</p>
		</mytag:when>
		<mytag:otherwise>
			<p>미성년자</p>
		</mytag:otherwise>
	</mytag:choose>
	<mytag:forEach var="i" begin="1" end="10" step="2">
		<p>${i }</p>
	</mytag:forEach>
	<p>구구단 4단 출력</p>
	<mytag:forEach var="n" begin="1" end="9">
		<p>4 * ${n } = ${4*n}</p>
	</mytag:forEach>
	
</body>
</html>