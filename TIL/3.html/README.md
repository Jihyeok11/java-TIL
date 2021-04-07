# jquery





### jQuery 라이브러리 갖고오기

 - jquery 사이트에서 현재 버전의 jquery-xxxx-min.js를 설치  
 - Download the compressed, production jQuery ... 누르면 js 파일 읽어준다 그걸 복사해서 붙여넣기해서 적당히 이용
 - `<script>https://code.jquery.com/jquery-3.6.0.min.js</script>를 적어준다

```html
<script>
	window.onload = function(){}
    // 를 이제는
    $(document).ready (function(){}) // 으로 사용
</script>
```



# 21.04.06

### html 파일 만들때 설정

windows - preferences - web - HTML Fiels - Editor - templates - new HTML files(5) 더블클릭

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="${encoding}">
<title>Insert title here</title>
<script src = "jquery-3.2.1.min.js"></script>
<script>
$$(document).ready(function(){

});//ready end
</head>
<body>
${cursor}
</body>
</html>
```