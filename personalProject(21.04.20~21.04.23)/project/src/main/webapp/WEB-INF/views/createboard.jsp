<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/resources/jquery-3.2.1.min.js"></script>
<script>
function resize(obj) {
  obj.style.height = "1px";
  obj.style.height = (12+obj.scrollHeight)+"px";
}
</script>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#createBoard").on('click',function(){
		if($('#board_item').val() == ''){
			alert("상품명은 필수입니다");
			$('#board_item').focus();
			return;
		}else if($('#board_contents').val() == ''){
			alert("상품 정보는 필수입니다.");
			$('#board_contents').focus();
			return;
		}else if($('#board_price').val() == ''){
			alert("가격입력은 필수입니다.");
			$('#board_price').focus();
			return;
		}
		
		$.ajax({
			url: '<%=request.getContextPath()%>/createboard',
			data: { 
				'board_item' : $("#board_item").val(), 
				'board_contents': $("#board_contents").val(), 
				'board_price': $("#board_price").val() 
			},
			type: 'post',
			dataType: 'json',
			success: function(server){
				alert("글작성 완료");
				console.log(server);
				
			},
			error: function(error){
				console.log(error)
			}
		})
	})
});
</script>

<style>
	.btn__{
		display:flex;
		justify-content : flex-end;
	}
	
	.btn{
		margin: 2px 4px;	
	}
</style>
</head>
<body>

<form action="<%=request.getContextPath()%>/createboard" method="post">
	<div class="container">
		<h1 style="text-align:center; margin-top:20px;">판매글 작성</h1>
				
		<div class="input-group m-1 row">
		  <span class="input-group-text col-1" id="basic-addon1">상품명</span>
		  <input type="text" class="form-control" id="board_item" name="board_item" placeholder="상품명을 적어주세요" aria-label="Username" aria-describedby="basic-addon1">
		</div>
				
		<div class="input-group m-1 row">
		  <span class="input-group-text col-1">내용</span>
		  <textarea class="form-control" id="board_contents" name="board_contents" placeholder="상품과 관련된 내용을 적어주세요" class="autosize" onkeydown="resize(this)" onkeyup="resize(this)" aria-label="With textarea"></textarea>
		</div>
		
		<div class="input-group m-1 row">
		  <span class="input-group-text col-1">가격</span>
		  <input type="text" class="form-control col-10" id="board_price" placeholder="상품 가격" name="board_price" aria-label="Dollar amount (with dot and two decimal places)">
		  <span class="input-group-text col-1" >&#8361;</span>
		</div>
		<div class="btn__">
			<a href="/project">
				<button type="button" class="btn btn-outline-danger btn-sm"> 취 소 </button>	
			</a>
			<input type="button" class="btn btn-outline-primary btn-sm" id="createBoard" value="글작성">
		</div>
	</div>
</form>

</body>
</html>