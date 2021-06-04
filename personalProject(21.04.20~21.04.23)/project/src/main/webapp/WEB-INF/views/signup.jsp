<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>


<script type="text/javascript">
	$(document).ready(function(){
		$("#signUp").on('click', function(){
			if($.trim($("#userId").val()) == ''){
				alert("아이디는 필수입니다");
				$("#userId").focus();
				return
			} else if($.trim($('#password').val()) == ''){
				alert("패스워드는 필수입니다.");
				$('#password').focus();
				return
			}
			

			if ($('#password').val() == $('#passwordCheck').val()){
				$.ajax({
					url : '<%=request.getContextPath()%>/signup',
					data: {'id': $("#userId").val(), 'pw':$("#password").val(), 'username':$("#username").val()},
					type: 'post',
					dataType: 'json',
					
					success: function(server){
						alert($("#username").val() + "님 반갑습니다 로그인 부탁드립니다");	
						top.location.href = 'login';
					},
					error: function(error){
						alert("이미 존재한 아이디 입니다");
						console.log(error);
					}
				})
			} else {
				alert("비밀번호확인은 비밀호와 같아야 합니다")
			}
		})
	})
</script>

<style>
* {
    margin: 0;
    font-family: var(--bs-font-sans-serif);
}

body {
    display: flex;
    align-items: center;
    padding-top: 40px;
    padding-bottom: 40px;
    background-color: #f5f5f5;
}

.form-sign{
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
}

.btn__{
	display: flex;
	justify-content: flex-end;
}

.btn {
margin:3px;
}

</style>


<body>
<div class="container">
	<h1 style="text-align:center; margin-top: 10px">회원가입</h1>
	<div class="row">
	<div class="col-3"></div>
	<div class="col-6">
		<hr>
		<form action="login" >
			<div class="form-sign">
				<div class="form-floating mb-3">
				  <input type="userId" class="form-control" name="userId" id="userId" placeholder="userId">
				  <label for="floatingInput">id를 입력해주세요</label>
				</div>
				<div class="form-floating mb-3">
				  <input type="password" class="form-control" name="password" id="password" placeholder="Password">
				  <label for="floatingPassword">비밀번호를 입력해주세요</label>
				</div>
				<div class="form-floating mb-3">
				  <input type="password" class="form-control" name="passwordCheck" id="passwordCheck" placeholder="Password">
				  <label for="floatingPassword">비밀번호를 다시 입력해주세요</label>
				</div>
				<div class="form-floating mb-3">
				  <input type="text" class="form-control" name="username" id="username" placeholder="username">
				  <label for="floatingPassword">원하는 닉네임을 적으세요</label>
				</div>
			</div>
			<div class="btn__">
				<input type="button" class="btn btn-outline-danger btn-sm"  value="취소" onclick="location.href='/project/login'" />
				<input type="button" id="signUp" class="btn btn-outline-primary btn-sm" value="회원가입">
			</div>
		</form>
		<hr />
		</div>
	</div>
	</div>
</body>

</html>
<%-- 
$("#checkId").on('click',function(){
	alert("중복확인, 결과는?")
	$.ajax({
		url : '<%=request.getContextPath()%>/checkid',
		data: {'id': $("#userId").val() },
		type: 'post',
		dataType: 'json',
		
		success: function(server){
			console.log(server)
		},
		error: function(error) {
			console.log(error)
		}
	})
})
 --%>