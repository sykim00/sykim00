<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>header</title>
	<link href="${conPath }/css/header.css" rel="stylesheet">
</head>
<body>
<header>
	<div class="gnb">
	<c:if test="${empty member}">
		<ul>
			<li><a href="${conPath }/member.do?method=join">회원가입</a></li>
			<li><a href="${conPath }/member.do?method=login">로그인</a></li>
		</ul>
	</c:if>
	<c:if test="${not empty member}">
		<ul>
			<li><a href="${conPath }/member.do?method=modify">정보수정</a></li>
			<li><a href="${conPath }/member.do?method=logout">로그아웃</a></li>
			<li><a>${member.mname }님</a></li>
		</ul>
	</c:if>
	</div>
	<div class="logo" onclick="location.href='${conPath}/main.do'">LOGO</div>
	<div class="lnb">
		<ul>
			<li><a href="${conPath}/main.do">홈</a></li>
			<li><a href="${conPath }/book.do?method=list&pageNum=1">도서보기</a></li>
			<li><a href="${conPath }/book.do?method=register">도서등록</a></li>
		</ul>
	</div>
</header>
</body>
</html>
