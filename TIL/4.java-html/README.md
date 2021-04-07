# 21.04.07

## 웹 서버 프로그래밍



1. client가 서버로 브라우저를 통해 http 프로토콜로 경로(url - .../경로/html) 로 내용 실행을 요청한다
2. 서버는 요청을 분석한다
3. 서버가 html파일을 찾아서 클라이언트에게 전송한다
4. 클라이언트 웹브라우저에 표현을 추력한다



- 





---

웹서버

- 클라이언트가 요청을 하면 (http Request) 서버가 처리를 통해 파일을 보낸다(http response)

- html 문서를 읽기 위해서는 웹 브라우저가 필요하다
- 웹 서버는 html 문서 파일을 찾아서 보내주거나 html 문서를 생성 하는 프로그램을 호출, 실행 결과를 보내주는 일도 한다. 이떄 호출되는 프로그램을 웹 어플리케이션 서버라고 한다
- 웹 어플리케이션 서버
  - 웹 서버(tomcat)를 실행하여 결과 html을 파일 에 넣어서 표현한 프로그램이다
  - servlet, jsp 실행 (자바 기반의 웹 어플리케이션 기술들)
- servlet
  - 자바 클래스 기반의 웹 어플리케이션 기술

- tomcat이 웹서버(요청 -- 응답) 그피고 웹 어플리케이션 서버(서버 실행 => 컨테이너 라고 한다)도 한다





---

eclipse 실행

Dynamic Web Project 만들기 - next - next 누르면 `Generate web.xml deployment descripor` 체크 해서 만든다

- WebContent안에 Web-INF 안에 lib는 Java Resources에 있는 Libraries와 관련된 내용들이 들어간다



new class - superclass변경( servlet을 쓸거라서 Object가 아니다.  browser 클릭 - HttpServlet 검색하여 클릭 ) - FInish

결과 [ TestServlet.java ]

```java
package servlettest;

import javax.servlet.http.HttpServlet;

public class TestServlet extends HttpServlet {

}

```

이를 아래처럼 적어보자

```java
package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:9090/servlettest/servlet/servlettest.TestServlet
// 1. 정의한다. 2. 서블릿클래스 - 서블릿 이름으로 등록한다 3.
public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		PrintWriter out = response.getWriter();
		String msg = "Hello Servlet";
		out.println("<html><head><title>제목</title></head><body><h1>"+msg+"</h1></body></html>");
	}
}

```



실행하면 `http://localhost:9090/servlettest/servlet/servlettest.TestServlet`가 실행된다 이 url을 변경하자

- WebCont - WebINF - xeb.xml에 설정 변경 (아래에 Design, Source중에서 Source 클릭)

```xml
</web-app> 위에다가 아래 내용을 적는다

<servlet>
	<servlet-name>test</servlet-name>
    <servlet-class>servlettest.TestServlet</servlet-class>
    
    <servlet-name>test</servlet-name>
    <url-pattern>/test</url-pattern>
</servlet>
```



---

- new - servlet  실행

- java package (dynamic package) 로 바꿔주고, 새로 생성할 class name 설정 ,next
- URL mapping을 원하는 걸로 설정 finish

```java
package servlettest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//아래는 WebServlet annotation이라고 한다
@WebServlet("/second") // 이제 url이 http://127.0.0.1:9090/servlettest/second로 변경되었다

public class SecondServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
```

바로 실행 가능





class A extends HttpServlet => http 요청 특화 처리 , doGet/doPost 등 선택적으로  오버라이딩

classB extends GenericServlet ==> Servlet 메소드 일부 구현 / 나머지 오버라이딩

class C implements Servlet ===> 5개 메소드 모두 오버라이딩

---

서블릿 라이프 사이클

1. 클라이언트1은 브라우저에서 `http://ip:port/프로젝트명/서블릿url`을 요청한다
2. 서버는 웹서버가 웹 어클리케이션 서버로 위임한다
3. 위임받은 웹어플리케이션 서버가 서블릿 객체 메모리를 로딩한다
4. 서블릿 객체 멀티스레드를 실행한다
5. 즉, init 호출한다 - 서블릿 처리 이전에 초기화
6. doGet 호출하여 응답한다
7. 클라이언트2는 브라우저에서 `http:ip:port/프로젝트명/서블릿url`을 요청한다
8. 서버는 웹서버가 웹어플리케이션 서버로 위임한다.
9. init은 하지않고 doGet 호출하여 응답한다
10. 서버 종료나 서블릿 소스 변경으로 재 컴파일 시에는 기존의 서블리 객체 메모리를 삭제한다 
11. 즉, destory()를 호출한다 - init 변수 메모리 삭제





---

login 활용해보기



1. WebContent에 html 작성

   [ loginform.html ]

   ```html
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <script src = "jquery-3.2.1.min.js"></script>
   <script>
   $(document).ready(function(){
   
   });//ready end
   </script>
   </head>
   <body>
   <h1>로그인 폼</h1>
   <form action="login"> <!-- http://127.0.0.1:9090/servlettest/loginform.html와 같은말 -->
   
   아이디입력 : <input type="text" name=id><br>
   암호입력 : <input type="password" name=pw><br>
   
   <input type="submit" value="로그인버튼" ><br>
   
   </form>
   </body>
   </html>
   
   <!-- http://127.0.0.1:9090/servlettest/loginform.html로 -->
   
   ```

2. Java Resources - src에 새로운 servlet 추가

   `member` package로`LoginServlet.java` 생성

   [ Java Resources - src - member - LoginServlet.java]

   ```java
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <script src = "jquery-3.2.1.min.js"></script>
   <script>
   $(document).ready(function(){
   
   });//ready end
   </script>
   </head>
   <body>
   <h1>로그인 폼</h1>
   <form action="login"> <!-- http://127.0.0.1:9090/servlettest/loginform.html와 같은말 -->
   
   아이디입력 : <input type="text" name=id><br>
   암호입력 : <input type="password" name=pw><br>
   
   <input type="submit" value="로그인버튼" ><br>
   
   </form>
   </body>
   </html>
   ```

   