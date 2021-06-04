<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<script type="text/javascript">
	$(document).ready(function(){
		$('#login').click(function(){
			if($.trim($('#userId').val()) == ''){
				alert("아이디를 입력해 주세요.");
				$('#userId').focus();
				return;
			}else if($.trim($('#password').val()) == ''){
				alert("패스워드를 입력해 주세요.");
				$('#password').focus();
				return;
			}
			
			$.ajax({
				url: '<%=request.getContextPath()%>/login',
				data: {'id': $("#userId").val(), 'pw':$("#password").val() },
				type: 'post',
				dataType: 'json',
				
				success: function(data){
					console.log(data.result);
					if (data.result=="성공"){
						alert( $("#userId").val()+"님 반갑습니다")
						top.location.href = '/project';
					}else{
						$("#error_msg").html("아이디나 비밀번호를 다시 입력해주세요");
					}
				},
				error: function(error){
					console.log("에러")
					console.log(error)
				}
			})
		});
		
	});
</script>
<style>
body {
    display: flex;
    align-items: center;
    padding-top: 40px;
    padding-bottom: 40px;
    background-color: #f5f5f5;
}

#error_msg {
	color: pink;
}
* {
    margin: 0;
    font-family: var(--bs-font-sans-serif);
}

.form-sign{
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
}

.btn{
	margin: 3px;
	
}
</style>

<head>
	<meta charset="UTF-8">
	<title >로그인</title>
</head>
<body>
<div class="container">
	<h1 style="text-align:center">로그인 페이지</h1>
	<hr>
	<div class="row">
		<div class="col-4"></div>
		
		<div class="col-4">
			<form id="loginFrm" method="post" class="align-self-center">
				<div class="form-sign">
					<div class="form-floating mb-3">
					  <input type="userId" class="form-control" name="userId" id="userId" placeholder="name@example.com">
					  <label for="floatingInput">id를 입력해주세요</label>
					</div>
					<div class="form-floating">
					  <input type="password" class="form-control" name="password" id="password" placeholder="Password">
					  <label for="floatingPassword">비밀번호를 입력해주세요</label>
					</div>
				</div>
			</form>
			<div class="d-flex bd-highlight mb-3">
				<input type="button" value="메인으로"	class="me-auto p-2 bd-highlight btn btn-outline-primary btn-sm" onclick="location.href='/project'" />
				<input type="button" id="login" class="p-2 bd-highlight btn btn__right btn-outline-danger btn-sm" value="로그인" />
				<input type="button" id="signUp" class="p-2 bd-highlight btn btn__right btn-outline-primary btn-sm" value="회원가입"	onclick="location.href='signup'" />
			</div>
		</div>
	</div>
</div>
		
	<div id="error_msg" class="error_msg"></div>
	<hr />
		
</body>
</html>