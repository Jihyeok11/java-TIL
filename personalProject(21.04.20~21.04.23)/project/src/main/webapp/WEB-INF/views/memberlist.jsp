<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function() {
	
});
</script>
</head>
<body>
<h1>모든 회원을 출력</h1>
<c:forEach items="${memberlist }" var="vo">
	${vo }
</c:forEach>
</body>
</html>