<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%-- <jsp:forward page="home.do"/> --%>
	<%-- <jsp:forward page="empList.do"/> --%>
	<%-- <jsp:forward page="dummyInsert.do"/> --%>
	<jsp:forward page="empDeptList.do"/>
</body>
</html>