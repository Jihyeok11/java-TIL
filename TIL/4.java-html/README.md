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

   



# 21.04.13

### JSP 표준 태그 라이브러리(JSTL)

- jstl core library 설치
  - https://tomcat.apache.org/taglibs/standard/ 에서 원하는 jstl 설치(jstl-1.2.jar)
  - eclipse에서 사용하고 있는 프로젝트 내에 있는 `WEB-INF - lib`폴더에 설치한 `jstl-1.2.jar`를 옮겨주면 끝



그동안의 라이브러리

- ojdbc6.jar
  - 모든 jre system libray에서 사용 (사용되고 있는 library 폴더로 옮겨서 사용했으므로)
  - main + servlet | jsp
- jstl.jar
  - 현재 다이나믹 웹 프로젝트에서만 적용
  - 위치는 `webcontent\web-inf\lib\jstl-1.2.jar`

- 모든 다이나믹 웹 프로젝트 라이브러리
  - `Libraries - Apach Tomcat v9.0`



- jstl 사용

  ```jsp
  <!-- 맨위에 c태그를 사용할 것이라고 선언-->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  ```

<Hr>

### 스프링 설치



- https://spring.io/tools window 버전 확인해서- 설치
- 설치받은것을 원하는 폴더로 옮기고 더블 클릭
- sts-4 폴더 클릭
- wokspace 설정
  - `C:\kdigital\workspace_spring`
- 설치가 완료되면 `Help` 클릭후, `Eclipse Marketplace` 클릭하여 `Spring Tools 3 Add-on for Spring Tools 4 ... ` Install한다

---

### 스프링



프로그램 구현한 것을 개발하면서 기존 개발을 수정하기 위해 사용(?)

- 프레임워크
  - 기능을 미리 클래스타 인터페이스 등으로 만들어 제공하는 반제품. 즉, 어느정도 완성된 상태로 제공하는 기능
- 스프링의 주요 기능
  - Core
  - Context
  - DAO
  - ORM
  - AP{}
  - Web
  - WebM

 

- 새로운 spring

  - `File - New - Other`클릭

  - `Spring`에서 `Spring Legacy Project` 클릭

  - name : spring

    Templates:spring MVC Project

     하고 Next

  - `Please specify the top-eftl ...`라고 잇으면

    `multi.campus.spring`라고 치고 끝



- 셋팅
  - 생성된 spring에 들어가서 pom.xml클릭후, 
    - 11번째 줄에 있는 java-version을 1.8로 변경
    - 12번째 줄에 있는 org.springframework-version를 4.3.18로 변경
  - spring 폴더 오른쪽 클릭 후, properties
    - Java Compiler 에서 1.6 자바 default 박스 해제해서 버전을 1.8로 바꾸고 apply
    - Project Facets 클릭해서 Dynamic Web Module클릭후 Runtimes에서 New를 클릭,
    - Apache Tomcat v9.0 설정후 Browse.. 클릭해서 Apache Tomcat9가 설치된 곳으로 설정 (C:\Kdigital\tomcat9)



---

`Help - install new software`에서 work with : `http://download.eclipse.org/releases/luna/201406250900` 검색

아래에서 Web.XML.Java EE and .. 클릭하고 Next