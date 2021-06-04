<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<style>
	.btn__{
		display: flex;
		justify-content : flex-end;
	}
	.btn{
		margin: 2px 4px;	
	}
	a{
		text-decoration : none;
	}
</style>
<script>
$(document).ready(function() {
});
</script>
</head>
<body>
<div class="container">
<h1 style="text-align:center;" class="mt-4">최근 판매글</h1>
<div class="btn__">
	<a href="createboard"><button class="btn btn-outline-primary btn-sm">글쓰기</button></a>
	<a href="login" ><button class="btn btn-outline-primary btn-sm">로그인</button></a><br>
</div>
	<table class="table table-success table-striped mt-2">
		<tr>
			<td>번호</td>
			<td>판매 물품</td>
			<td>상품 설명</td>
			<td>가격</td>
			<td>판매 시간</td>
		</tr>
		<c:forEach items="${boardlist }" var="vo">
			<tr>
				<td>${vo.no }</td>
				<td>${vo.item }</td>
				<td>${vo.contents}</td>
				<td>${vo.price } 원</td>
				<td>${vo.sell_time }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>

</html>