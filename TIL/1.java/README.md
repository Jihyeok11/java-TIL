# 21.03.08


## 자바 설치



`1. 프로그래밍 소스파일 작성`

​	 => 에디터(메모장)

`2. 자바 컴파일 방법`

​	=> javac 소스파일명

`3. 소스파일 실행 결과`

​	=> java 소스파일명





#### 1. 프로그래밍 소스 파일 작성 (메모장)

```java
class First {
    public static void main(String args[]){
        System.out.println("처음 작성하는 자바 프로그램");
    }
}
```

###### - 맨 위의 First는 파일의 이름과 같아야 한다.



#### 2. 자바 컴파일

- 환경 변수 변경

jdk 설치 폴더 안에

 `~\bin\javac.exe`가 있고,

`~\jre\java.exe`가 있는데 얘만 별도의 설정이 없이 사용 가능

`javac`는 별도의 환경변수 설정 필요

path jdk 설치폴더에 \bin 추가 설정

`제어판 => 시스템 => 고급시스템 설정 => 고급 => 환경 변수 => path 편집 =>새로만들기 C\Kdigital\jdk8\bin 추가 => 맨 위로 올린다`

이제 windows에 javac가 어디에 있는지 알려주었다. cmd 창에서 사용 가능해졌다

- javac로 컴파일 실행

  - `cd c:\Kdigital `로 ls 변경
  - `javac First.java`

  - 아무 말 없으면 오류 없음
  - 컴퓨터 언어(java)를 이진수로 변경하는 작업이다.

#### 3. 자바 실행

- java 명령 실행

dos(cmd) 에서 아래처럼 작성(<span style="color:red">* 확장자 명까지 쓰지 않는다.</span>)

```bash
$ java First
```

> Out : `처음 작성하는 자바 프로그램` 



## Eclipse 설치

( Java, sql, html, javascript 에 이용)

- workspace ( 이클립스 작성 모든 소스파일 저장 폴더) 지정
  
  - C:\Kdigital\workspace 로 경로 설정
- Eclipse는 위의 과정을 편리하게 하며, 자동 완성 기능 있어서 편리함
- 초기 설정
  - 글씨 크기
    - windows - preferences - General - Appearance - Color and Fonts - Basic - Text Font
  - 한글 설정
    - preferences - General - workspace - Text File Encoding - other - UTF-8로 변경
    - `sysout` + `ctrl + space` 하면 `System.out.println();`이 자동완성

- java project 생성
  - file - new - Projct... - java project
  - 이름 입력

- 자바 소스 작성

  - File - New - Class
  - (클래스) Name 입력
  - 편리성을 위해 public static void main(String[] args) 에 체크

- java 작성

  - ```java
    class A { <<<== 저장 파일명이 A.java여야 한다.
        public statid void main(String args[]) {  <<<=== 여기까지 Eclipse가 자동으로 작성. 
        System.out.println(".....");  <==== 세미클론(;)까지 한 문장. 그러므로 엔터 쳐도 상관 없음
    }
    }
    ```



## Java

- 문장

  - 실행 가능한 문장
    - System.out.println("...") <= 한줄 프린트 한 이후 엔터( div과 비슷 )
    - System.out.print("...") <= 한 줄 프린트 ( span과 비슷)
      - `\n`으로 엔터키 대신 가능
      - `\t`으로 탭(tab)키 대신 가능

  

  - 실행 불가능한 문장

    - 1줄 주석

      ```java
      // 주석 처리
      ```

    - 여러 줄 주석

      ```java
      /* 
      dufj
      여러 줄 주석
      /*
      ```



- 변수  :  프로그램에서 연산 데이터와 연식 결과를 저장하고 사용하기 위해 붙이는 이름

  - ```java
    // [타입] [이름] = [초기값] ;
    ```

  - 타입 종류

    - 논리값

      - <span style = "color:red">boolean ( 1byte )</span> - 참 거짓 만 구분하므로 실제로는 1bit만 사용

        ```java
        boolean b1 = true;
        boolean f1 = false;
        ```

        

    - 단일문자 (문자 1개)

      - <span style = "color:red">char ( 2 byte )</span>

        - 단일 따옴표(`'`)만을 사용한다.
        - 미국 : 알파벳 + 숫자 + 특수문자 몇개 = 2**7 , 128문자 사용 (7bit)
        - 유럽 : 7bit 부족, 8bit 사용
        - 아시아 : 한자문화권, 다국어 필요 1byte로 부족, 2byte 사용 ( 65536 문자 ) 
        - 유니 코드 체계 : 모든 문자들을 2byte로 하는 독립적인 체계 
                                       java도 유니 코드 체계 사용

        ```java
        char c1 = 'a'; // 2byte 사용
        char c2 = '가'; // 2byte 사용
        char c3 = '\n'; // 2byte 사용 ( 특수 문자 )
        ```

    

    - 문자열
      - String ( 2 byte * 단어 개수) 
        - '' 이 아닌 " "를 사용

    - 정수

      - byte ( 1 byte )
        - 1byte = 8bit = 1bit + 7bit
        - 1 bit는 부호(양 : 0, 음 : 1)
        - 7 bit는 숫자 (범위 : -2^7 ~ 2^7 -1)

      ```java
      byte b2 = 10;
      byte b3 = 200; // byte로 사용 불가능. 에러가 뜬다
      ```

      

      - short ( 2 byte )
        - 1 bit는 범위
        - 15bit는 숫자( 범위 : -2^15 ~ 2^16-1)
      - <span style = "color:red">int ( 4 byte ) </span> 가장 많이 사용
        - 1 bit는 범위
        - 31bit는 숫자( 범위 : -2^31 ~ 2^31-1)
      - long ( 8 byte )
        - 1 bit는 범위
        - 63bit는 숫자( 범위 : -2^63 ~ 2^63-1)

    - 실수

      - float ( 4 byte )
      - <span style = "color:red">double ( 8 byte )</span>

      

    - 예시

      합격( 1 ) / 불합격 ( 0 ) < === 정보가 데이터 2개면 이진수 1자리

      정보 데이터 4개면 이진수 2자리면 가능

      ...

      정보 데이터가 256개면 이진수 8자리로 가능

      

      2진수 1자리 는 1 bit 이다

      2진수 8자리면 8 bit = 1 byte

      

  - 변수 

    - i는 정수 10을 저장하고 있다라는 표현

      ```java
      int i = 10;
      ```

    - f는 실수 3.14을 저장하고 있다 라는 표현

      ```java
      double f = 2.56;
      ```

    - 자바 메모리 변수 저장

      클래스 영역 + stack 영역 + heap 영역

      ```java
      int i = 10;
      String s = "java";
      double d = 3.14;
      
      -----
      기본형 변수 (boolean, char, byte, short, int, long ,float, double)
      /* 스택 영역 (last in first out 구조)
         d(8byte) = 3.14
         s(8byte) = java
         i(4byte) = 10
         순으로 저장 
      */
      s = "servlet"; // 를 실행하면 초기 8byte로 저장되어 있기 때문에 크기 부족하다.
      
      
      참조형 변수
      /*
      이를 고치기 위해서 heap 영역 생성
      String s = "java";
      heap 영역에 
          100번지 = java
      stack 영역에
      	s(4byte) = 100번지
      로 저장
      
      s = "sevelet";
      heap영역에
          200번지 = servlet
      stack 영역에
          s(4byte) = 200번지 즉 새로운 메모리 구조
      */
      
      ```

  - 연산자

    

    - |      | 변환               | 산술            | 비교             | 논리             | 대입 | 조건 삼항 |
      | ---- | ------------------ | --------------- | ---------------- | ---------------- | ---- | --------- |
      | 단항 | 형변환(데이터타입) | 증가 ++,감소 -- | X                | not:!            | X    | ?:        |
      | 이항 | x                  | +,-,*,/,%       | >, >=,<,<=,==,!= | and: && or: \|\| | =    | ?:        |
      - 10 나누기 3
        - `10 / 3 은 3.3333` 이 아니라 `3`이 나온다( 정수 3으로 나눴으므로)
        - 10/ (double)3 이 3.3333
      - 10 을 3으로 나눈 나머지
        - 10 % 3 = >1
      - 증감 연산자 ( ++ : 현재값 1 증가, -- 현재값에서 1 감소)

      ```bash
      x = 5 
      y = x++
      => x :	6, y : 5 (증가된 이전의 값)
      y = ++x
      => x :	6, y : 6 (증가된 이후의 값)
      
      x = 5 
      y = x--
      => x :	4, y : 5 (증가된 이전의 값)
      y = --x
      => x :	4, y : 4 (증가된 이후의 값)
      
      int x = 10;
      sysout(x++);
      10이 출력된다. 그러나 x 값은 이제 11
      ```

      ```java
      String result = x > 10 ? "크다":"작다";
      double result = x > 10 ? 0 : 1.1 ;
      int result = x > 10? 0:(int)1.1 // 위처럼 0 또는 1
      ```

      - 연산자 우선 순위 규칙
        - 단항 > 이항 ( 대입 연산자 제외) > 삼항 >= 

  - 형변환 

    - 형태 : (데이터 타입) 변수
    - boolean는 제외
    - int = 0
    - boolean b = (boolean)i);
      - true, false는 2개 표현 가능
    - 자동형변환 : 형변환연산자 생략
      - byte > shot > int > long > float > double

    ```java
    int j = 10;
    double dj = (double)j; //자동으로 double 로 형변환
    ```

    - 명시적 형변환 : 형변환 연산자를 명시해야한다. (자동 형변환이 안될 때 사용)

    ```java
    double d3 = 3.141519;
    int i3 = d3; // 불가능
    int i3 = (int)d3;
        
    ```

    

  - 클래스, 변수, 메소드 전부 우리가 이름을 붙여서 사용한다.

    - 클래스 :  명사, 대문자 시작
    - 변수 : 명사, 소문자 시작 (두번쨰 단어는 대문자)
    - 메소드 : 동사, 소문자 시작 (두번쨰 단어는 대문자)

    ```bash
    name = 변수에 적합
    Name = 클래스에 적합
    saveName = 메소드에 적합
    ```

  - 초기 값

  

  - 컴파일 오류 발생 방지를 위한 규칙
    - 숫자와 일반문자, 특수문자 구성 가능
    - 숫자로 시작이 불가능
    - 자바 예약어( 키워드 즉, 미리 의미 부여 사용 단어) 불가능
    - 대소문자 구분
    - 식별자의 길이는 무제한이다. (정확하게는  2**16(약 65000개) 까지 가능 )



# 21.03.09



## 제어문

- 순차적 실행

- 일반적인 구조

  ```java
  class A{
      public static void main(String args[]) {
          문장 1;
          문장 2;
          ... 문장 n;
      }
  }
  ```

- 1개 문장을 여러 번 수행, 생략 구조

- 조건문 : 특정 조건 만족하면 해당 문장 수행

  ​				만족하지 못하면 해당 문장 수행 x

  - x > 10 ? "크다" : "작다"; (조건 삼항연산자)

    - 조건 삼항연산자에 다른 문장을 삽입이 불가능하다
    - x > 10? sysout"크다":sysout"작다"; 이런식이 불가능

    

  - if-else

    - if (조건1 - boolean의 결과로 true / false){

      ​	조건 1이 true일 때 수행하는 문장;	

      }

      (false 일 때는 수행 안한다.)

    - else if(조건 2) {

      ​	조건 2이 true 일 때 수항하는 문장;

      }

    - else {

      ​	조건1,조건2 모두 false 일 때 수행하는문장;

      }

    - if (조건1){

      ​	(조건 1이 true 일 때)

      ​	if(조건2){

      ​		(조건 1,2 모두 true 일 때)

      ​	}

      ​	else{

      ​		(조건 1은 true, 조건 2는 false 일 때)

      ​	}

      }

      else{

      ​	( 조건 1 false)	

      }

- switch(정수)  : 정수의 동등비교만 가능

  정수에 대한 값에 대한 조건

  case (정수의 조건):

  ​    문장1;

  ​	break;

  case (다른 정수의 조건):

  ​	문장 2;

  ​	break;

  default:  <= case 1, case 2에 해당되지 않을 때 실행

  ​	문장 3;



## 반복문

- for

  - 반복 횟수를 앞에 지정

  - 사용법

    for(반복시작문장; 반복조건식문장; 변화식문장){

    ​	반복 수행할 문장

    }



- while

  - 횟수 지정없음, 유4무한으로 반복 가능

  - 사용법

    while (반복문장, 변화식문장- 생략가능){

    ​	반복 시킬 문장

    }

    

    ex)

    int i = 10;

    while(i <= 100){

    ​	sysout(i);

    ​	i = 45;

    } <= 무한 반복

    

    int i = 10;

    while(i <= 100){

    ​	sysout(i);

    ​	i = 200;

    } <= 1회만 반복 (i값 변경)



- do - while 

  - 최소 1번 수행 필수, 무한 횟수 반복

  

  - int i = 1-1;

    do{

    ​	sysout(i);

    ​    i++;

    ​    }while(i<=100){

    

    }

- 중첩 for

  for (int i = 1; i <= 5; i++){

  ​	for(int j=1; j<=3;j++){

  ​		sysout(i+ ","+j);

  ​	}	

  }

## 이동문



- break
  - switch 블록에서 사용되면 { }내의 문장 수행하지 않고 { } 이후로 이동
  - 반복문( for, while, do-while) 내부에서 사용

- continue



## 자바 배열

- 정의

  - 동일 타입의 데이터를 여러개 모아놓은 참조형 변수 형태

- 참조형 변수와 비슷 (heap 영역에 값을 저장하고 stack에 주조값만 정보를 저장)

  - ex) int i = 10;

- 배열 변수 사용

  - 배열 변수 선언문

    - ```java
      (데이터타입) (배열 변수명) [] ;
      ```

  - 배열 생성

    - ```java
      배열 변수명 = new 데이터타입 [ length ];
      ```

      (배열변수명.length 라고 치면 배열 길이(갯수)를 알 수 있다)

  - 배열 변수값 초기화

    - 배열변수명[index]
    - 0 <= index < length

    

  - 예제

    - ar 이름으로 5개 정수 저장 {23,45,10,1,100}

      1. 배열 변수 선언문 ( 둘 다 가능 )

         int ar [ ];

         int [ ] ar;

      2. 배열 생성

         ar = new int[5];

         sysout(ar.length) = 5 <= 4byte(int byte) * 5 = 20byte 사용

      3. 배열 변수 초기화

         ar[0] = 23;

         ar[1] = 45;

         ...

         ar[4] = 100;

         ar[5]는 오류

  - 배열 값을 저장하지 않았을 때 자동 초기화 값

    boolean => false

    char => '\u0000\'

    - 유니코드 는 16진수이며, '\u0000'에 해당하는 16진수 값을 말한다

    int => 0

    double => 0.0

    String 참조형변수 => null
    

    - 예제)

      String s2;

      sysout(s2) => null





- 난수
  - Math.random() : 0보다 크거나 같고 1보다는 작은 실수값 생성
  - 0.0 <= Math.random() * 100 < 100.0 인 실수
  - 0 <= (int)(Math.random() * 100 )  < 100 인 정수
  - 0<= (int)(Math.random() * 100) + 1 < 101 인 정수
- int 'a' = 97
- int 'A' = 65
- int '0' = 48
  - char 65 = 'A'



- if(잠조형변수 != null){ ... }
- if(잠조형변수 == null){ ... }



- 

  ```java
  String sa = "java";
  String sb = "java";
  String sc = new String("java");
  String sd = new String("java");
  
  // 아래 2개 차이는 무엇인가???
  String ar [] = new String[5];
  String sd = new String("java");
  ```

  1. String sa = "java";

     stack 영역에 sa: 100(임의의 주소)를 저장

     

  2. String sb = "java";

     stack 영역에 sb : 100(임으의 주소)를 저장

     stack 영역에 sa: 100(임의의 주소)를 저장 (기존에 있던 값)

     

  3. String sc = new String("java");

     stack 영역에 sc :300(임의의 주소)를 저장

     stack 영역에 sb : 100(임의의 주소)를 저장 (기존에 있던 값)

     stack 영역에 sa: 100(임의의 주소)를 저장 (기존에 있던 값)

     

  4. STring sd = new String("java");

     stack 영역에 sd :400(임의의 주소)를 저장

     stack 영역에 sc : 300(임의의 주소)를 저장 (기존에 있던 값)

     stack 영역에 sb : 100(임의의 주소)를 저장 (기존에 있던 값)

     stack 영역에 sa: 100(임의의 주소)를 저장 (기존에 있던 값)

     

  <span style="color:red">결론!!!!! </span>

  ​	sa == sb 이다!!

  ​	sa != sc

  ​	sa != sd
  
  ​	sa.eqauls(sb) = true가 나온다.



# 2차원 배열

- 초기화 (3가지 전부 가능)

  - int ar [] [] ;
  - int [] ar [];
  - int [] [] ar;

- 배열 선언

  - 3행 4열

    ` int [3][4]`

  - n행 m열

    `int [n][m]`



- 예시

  - 3행 4열에 1부터 12까지 나타내는 법

    ```java
    int [][] two_ar = new int[3][4];
    for (int i=0; i<two_ar.length; i++) {
    	for (int j=0; j<two_ar[i].length; j++) {
    		two_ar[i][j] = two_ar[i].length*i+j+1;
    		System.out.print(two_ar[i][j] + "\t");
    	}
    	System.out.println();
    }
    ```

  - 1행은 1열, 2행은 2열, 3행은 3열 ... 각 배열에는 1부터 증가하는 수를 나타내는 법

    ```java
    int [][] two_ar = new int[3][];
    for (int i=0; i<two_ar.length; i++) {
        two_ar[i] = new int[i+1];
        for (int j=0; j<two_ar[i].length; j++) {
            two_ar[i][j] = two_ar[i].length*i+j+1;
            System.out.print(two_ar[i][j] + "\t");
        }
        System.out.println();
    }
    ```



### 특별 for구문

```java
names = [1,2,3,4,5] 라고 가정
for (String n:names) {
    System.out.print(n);
}
out : 12345
```



# enum

- enum으로 파일을 작성

  ex) enum으로 Week.java 생성

  ```java
  public enum Week {
  	// 변수 이름만 열거
  	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
  }
  ```

  

- 새로운 class에서 enum을 넘겨받을 수 있다.

  ex) 

  ```java
  Week today = null; // Week 내용 사용할 것이다 라고 선언
  ```

  

### 객체과 클래스

- 1980년 C언어 탄생

- c -> c++ -> 1995년 자바 언어 탄생

- 탄생 비화

- 

  절차지향언어

  ​	성적처리프로그램{

  ​	학생이름, 과정명, 점수-데이터

  ​	수강하다(){} <= 절차

  ​	시험보다() {}

  ​	평가하다(){ 수정해서 구현}

  ​	}

  ​	취업관리프로그램{

  ​	학생이름, 회사이름, 과정명,,,

  ​	 수강하다(){}

  ​	}

  

  - 여기서 학생이름, 과정명이 중복되어 있다는 불편함이 있었다.

  - 먼가 한 군데를 수정하는데 다른데도 수정필요하는 유지보수가 생겼다.

    ==> 객체 지향 탄생



- 객체 지향언어 => 절차지향언어에 있던 것들을 관리하기 편하게 분할, 

  학생{

  ​	학생이름, 과정명

  ​	수강하다(){} 

  }

  평가자{

  ​	점수, 평가하다(){ 수정구현}	

  }

  성적처리프로그램{

  ​	학생,.수강하다() {}

  ​	학생.시험하다(){}

  ​	평가자.평가하다(){}

  }

  취업관리프로그램{

  ​	학생.수강하다()

  ​	회사.설명회하다()

  }

  회사{

  ​	회사명, 급여, 위치, 직원수 ...

  ​	설명회하다(){}

  }

  

  - 수정하기 쉽다(유지보수가 쉽다.) 한 군데만 바꾸면 상위는 불러오기만 하니까
  - 작성된 코드 재사용 가능 => 반복적 정의하지 않아서 간결함



#### 객체

- 정의 

  현실세계에서 필요한 것들을 컴퓨터 내부로 구현할 때, 자바에서는

- 표현(명사로 표현할 수 있는 것들)

  컴퓨터가 하는 일, 회사원이 하는 일, 학생이 하는 일

- 특성

  - 정적 특성 = 상태, 정ㅈ보, 속성 표현 데이터들

  - 동적 특성(메소드 정의) = 행위, 동작, 기능 (변화 가능)

  - 예시

    

    ​	교육생)

    정적 특성 : 이름, 나이, 수강명, 위치, 일시, 수료여부, 성적

    동적 특성 : 수강하다, 등하원하다, 휴식하다, 졸다, 점심먹다

    

    ​	교육생 진화 -> 회사원)

    정적 특성 : 이름, 나이, (수강명),급여, 위치,( 일시, 수료여부, 성적) 직급 부서

    동적 특성 : (수강하다), (등하원하다), 휴식하다, 졸다, 점심먹다, 일하다, 출퇴근하다

    

    * 구현할 객체에 따라 요소들이 바뀔 수가 있다.

    

    1000명의 교육생이 있다면, 1000개의 객체표현을 할 틀이 필요하다. 이를 <span style="color:red">클래스</span>라고 한다.

    자바에서는 클래스는 객체를 표현하는 template를 말한다.

  - 클래스 생성

    교육생 클래스 생성

    class 교육생 {

    ​	String 이름;

    ​	int 나이;

    ​	String 수강명;

    ​	Calendar 일시;

    ​	boolean 수료여부;

    ​	...

    ​	수강하다(){

    ​	}

    ​	휴식하다() {

    ​	}

    }

    

- 객체 생성

  클래스 변수와 메소드 복사하여 메모리 저장

  교육생 s1 = new 교육생();



- 클래스 문법

  ```java
  class 이름 // 클래스 선언. 원한다면 이름 뒤에 [extends..], [implements ...] 혹은 맨 앞에 [modifier] 추가 가능
  {
  //    변수
  //    생성자
  //    메소드
  }
  ```

  - 클래스 이름은 대문자 명사를 사용, 숫자시자 X 키워드X, 특수문자는 $,_만 가능

  - modifier

    - class, 변수, 생성자, 메소드 (활용 요소들) 앞에 [modifier] 추가 가능하다. 사용하면 사용방법이나 접근 제한 지정 역할 키워드를 말한다

    - 종류

      | 역할      | modifier  | class | var       | method       | 생성자 |
      | --------- | --------- | ----- | --------- | ------------ | ------ |
      | 접근 권한 | public    | o     | o         | o            | o      |
      |           | protected | x     | o         | o            | o      |
      |           | privated  | x     | o         | o            | o      |
      | 사용방버  | static    | x     | o         | o            | x      |
      |           | final     | o     | o         | o            | x      |
      |           | abstract  | o     | x         | o            | x      |
      | 기타      |           |       | volatile  | native       |        |
      |           |           |       | transient | synchrosized |        |

- 변수

  `[변수타입][이름] = 값;`

- 생성자

- 메소드



- 클래스 생성

  int i = 10;

  int [] ar = new int[5];

  String s = new String("java");

  ```java
  클래스명 변수명 = new 클래스명();
  객체참조변수명.멤버변수 = 속성값
      
  Employee e1 = ew Employee();
  e1.id = 100;
  ```

  참조형 변수(배열, String )를 쓸 때에는 처음에 new를 붙여서 쓴다(enum말고)



- Employee e1 = new Employee(); 를보자

  처음에는 e1 = null값이다. 클래스 Employee 안에 객체값이 정의가 되면(e1.id = "100";) e1은 임의의 주소를 가르키게 된다.



- private 
  - 변수, 메소드, 생성자 앞에서 선언
  - 사용 영역을 현재 클래스로 제한할 때 쓴다.
- no modifier
  - 클래스, 변수, 메소드, 생성자 앞에서 선언
  - 사용 영역을 헌재 패키지로 제한할 때 쓴다.
- protected
  - 클래스, 변수, 메소드, 생성자 앞에서 선언
  - 사용 영역을 현재 패키지, 다른 패키지의 상속받은 클래스로 제한할 때 쓴다.
- public
  - 클래스, 변수, 메소드 생성자 앞에서 선언
  - 사용 영역 제한이 없다.



#### 메소드

class 이름{

​	멤버변수

​	타입 변수명;



​	메소드

​	(modifier) [리턴타입 ] [메소드명] ( [매개변수]){

​	}

}

- 리턴타입

  - [modifier] 리턴타입 이름([ 매개변수 ])

  - public > protected > no modifier > private

  - A,B가 같은 패키지에 있을 때

    class A{

    ​	private int i;

    }

    class B{

    ​	public static void main(String args[]){

    ​		A a1 = new A();

    ​		(private때문 사용 불가능)a1.i = 100;

    ​		(private때문 사용 불가능)(a1.i)

    ​	}

    }

  - private 사용 예시

    class Login{

    ​	String id;

    ​	private String pw;

    ​	void setPw(String newpw){ // 로그인 한 사람만 pw를 바꿀 수 있게 한다.

    ​		pw = newpw; // 은행에서는 newpw도 자기만의 암호화한 변수로 한다.

    ​	}

    ​	String getPw(){ // 로그인 한 사람만 볼 수 있게 Login 클래스 접속 할 때만 볼 수 있게 한다.

    ​		return pw;

    ​	}

    }

    

    class LoginTest{

    ​	public static void main(Sttring[] args){

    ​	Login l = new Login();

    ​	l.id = "multi";

    ​	l.pw = "1234"; // 이 값을 아무나 변경 못하게 하려 한다.

    ​	}

    }



getters, setters 만드는 법은

​	Source 클릭----  Generate Getters and Setters...  ---  원하는 변수에 Getters, Setters 클릭



- 매개변수

  - 메소드 정의

    ```java
    void ma(){
        int i = 10;
        return i*i;
    }
    ```

    ```java
    int ma(int j){
        return j*j;
    }
    ```

    
# 21.03.11

- 기본 생성자 대신에 사용자 정의 생성자 변경 가능 => 기본 생성자 자동 삭제

- 생성자 형태

  [modifier] 클래스이름([매개변수]){

  ​	객체 생성시 수행 문장 정의

  ​	= heap 멤버변수값 "xxx" 변경 문장

  }



​	[ modifier] 리턴타입 메소드이름([매개변수]){

​		기능 수행 문장 정의

​	}



- 생성자 overloading

   1개의 클래스에 같은 이름 메소드 여러개 정의를 기술

  매개변수 리스트마다 다르게 정의

  리턴타입, modifier 제한이 없다





- this 키워드

  - 자기 자신의 객체를 의미한다.

  - 사용방법

    - 멤버변수와 지역변수의 이름이 같을 때 구분을 위해 사용 

    - 멤버변수와 매개변수의 이름이 같을 때 구분을 위해 사용

      ```java
      class A{
          int i = 10; // i는 A 클래스 전체에서 사용 가능 (멤버 변수)
          int ma(int b){ // int b는 매개변수라고 한다
              int c = 30; // c는 mb 메소드에서만 사용 가능 (지역 변수)
              return i + b + c;
          }
          void mb(){
              // i 사용 가능
          }
      }
      ```

      

    - 1개의 생성자에서 다른 생성자를 호출할 때(생성자 overloading 구현되어 있을 때)

      new 생성자([매개변수값 전달]) => this ([매개변수값 전달])



## static

```java
class 멀티회사원{
    String 회사명 = "멀티"; //<= 1개 변수값 모든 객체 공유
	String 급여; // 메모리 저장 - 각 객체마다 개별적으로 저장
}

class 캠퍼스학생{
	String 학교명 = "캠퍼스";
    String 학생명;
}
        
```

- 동일한 1개의 값을 공유하는 성격으로의 1개 저장(회사명, 학교명)

- 객체 생성 이전에 메모리를 저장하고 프로그램이 종료될 때까지 계속 메모리에 유지되어야 한다.(삭제되어서는 안된다.)









## 상속

- 자바에서의 상속

  ```java
  class 사람 {
      이름 나이
  	밥먹다 잠자다 (매서드)
  }
  
  class 학생 {
      이름 나이
  	학년 성적
  	밥먹다 잠자다 공부하다
  }
  
  class 회사원{
      이름 나이
  	급여 직급 부서
  	밥먹다 잠자다 일하다
  }
  
  3개의 클래스를 순서대로 만들 것이다. 학생에 있는 이름과 나이는 사람에도 있으므로 반복을 줄이자(객체 지향)
      
  class 학생 extends 사람 { // 사람에 있던 내용들을 새로운 클래스인 학생에 포함시켰다
      학년 성적
      공부하다
  }
  
  class 회사원 extends 사람{
      급여 직급 부서
  	밥먹다 잠자다 일하다
  }
  
  ==> 학생은 사람을 상속받는다
      사람은 학생의 상위클래스(super class, parent class)이다.
      학생은 사람의 하위클래스(sub class, child class)이다.
  ```

  



```java
class A{
    i 선언;
    ma() {
        
    }
}
class B{
    ...
	A a1 = new A();
    a1.i 가능
}

class C extends A{
    sysout(i) // A에 있는 i값을 사용할 수 있게 된다.
}


class 자동차(){
	전진(){}
    후진(){}
    정지(){}
}

class 운전자(){
    운전하다(){
        자동차 car = new 자동차();
        car.전진();
    }
}
```



- extends 뒤에 다중 상속 불가능

  조교는 교수처럼 가르치기도 하고, 학생처럼 배우기도 한다고 해서 아래처럼 쓸 수 없다

  ```java
  class 조교 extends 교수, 학생{
      
  }
  ```

   이를 해결하기 위해 인터페이스를 사용한다



- 자바의 클래스 멤버변수

  - priavte 변수는 상속 불가능

  - 상위 클래스, 하위 클래스 모두 동일한 변수가 있다면 하위 클래스 변위 우선적으로 사용된다.

  - 이를 해결하기 위해, 

    - this 객체 사용

      this.멤버변수명 ==> 멤버변수와 지역변수, 멤버변수와 매개변수 이름 같을 때 구분

      this(다른 생성자로 전달값)

      

    - super 상위 객체

      super.멤버 변수명 ==> 상위 멤버변수와 하위 멤버 변수의 이름이 같을 때 구분

      super.메소드() ==> 메소드도 이런식으로 사용 가능하다

      super(); ==> 상위 기본 생성자를 호출
      						생성자 내부 첫 문장 자동 정의

      super(매개변수 ); ==> 상위 매개변수 정의 생성자 호출

      ​										생성자 내부 첫문장 명시적 정의7

      

      



- overloading
  - 1개의 클랫에 여러개의 메소드를 정의 가능할 때
  - 매개 변수 리스트 다르게 정의
  - 리턴타입, modifier 상관없이 사용



- overriding

  - 뜻은 '우선시하다'

  - 상속관계에 있는 2개의 클래스에 대하여 메소드 정의 가능할 때

  - 매개변수 리스트가 같아야 한다

  - 리턴타입이 같아야 한다

  - modifier가 같거나 더 더 넓어야 한다

    [ modifier 넓이 ]

    private < (default) < protected < public

  - 상위 클래스, 하위 클래스에 동일명의 메소드가 존재하면 하위 클래스 메소드를 우선적으로 한다.



- 자바 객체지향 조건
  - 캡슐화와 정보은닉
  - 상속 가능
  - 다형성(polymorphism) : 메소드의 overloading 과 overriding 처럼 한개의 이름이 여러 역할을 할 수 있다.





#### final

- 변수 앞, 메소드 앞, 클래스 앞 사용 가능
- 수정이 불가능을 의미 => overriding (상속 받은 내용을 변경하는 작업) 불가능
- final 클래스 - 이 클래스는 상속 금지 ( 모든 메소드 overriding 금지 )
- 객체를 생성해서만 쓸 수 있다.
- Math{}, String{} 등 모두 final 메소드 이다.



#### abstrct

- 추상적이다

  ```java
  class 도형{
      void 면적() {
          ??? //도형마다 면적 구하는 공식이 다르니까 쓸 수 없다. 이게 abstract
      }
      둘레() {
          ???
      }
  }
  
  abstract class 도형{
      abstract void 면적() {
          ??? //도형마다 면적 구하는 공식이 다르니까 쓸 수 없다. 이게 abstract
      }
  	abstract 둘레() {
          ???
      }
  }
  ```

- 선언부만 있고 구현부 없는 메소드 앞에 사용

- 사용법

  - abstract 메소드 

    - 선언부만 있고 구현부가 없는 메소드 앞에서 사용
    - override 의무화

  - abstract 클래스 

    - abstract 메소드 1개 이상 포함할 때
    - 클래스 앞에 사용 객체를 만들수가 없으므로 상속을 의무화 하고 있다.

    ```java
    abstract class 도형(){ // 다른 클래스 쓸거면 extends 꼭 해야해
        abstract void 면적(){ // 상속할 거면 이거 꼭 override 해야만 해
            
        }
        abstract void 둘레(){ // 상속할 거면 이거 꼭 override 해야만 해
            
        }    
    }
    
    class 사각형 extends 도형{
        // 도형으로 부터 상속받은 것을 오버라이딩을 할 것인지 안할것인지 ?
    	// abstract 할 경우 overriding 의무화
        void 면적() {가로 * 세로;}
        void 둘레() { (가로 + 세로)*2;}
    }
    
    class 원 extends 도형 {
        void 면적(){ 반지름 * 반지름 * 3.14 ;}
        void 둘레(){ 반지름 * 2 * 3,14;}
    }
    ```



---

```java
class A {
	int i;
	A(){
		i = 10;
		System.out.println("A 생성자 호출");
	}
}
class B extends A{
	int j;
	B(){
		j = 100;
		System.out.println("B 생성자 호출");
	}
}
public class SuperTest {

	public static void main(String[] args) {
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);
	}
}
```

- B b1 = new B(); (B는 A 클래스를 상속받고 있다)

  B 객체 생성 = B 멤버변수와 메모드 메모리 복사

   \+ 자동으로 A 객체 생성 = A 멤버변수와 메소드 메모리 복사

  - 순서도

    Object()  > A() > B()

  - 메모리

    (100번 주소) : Object에 대한 객체 [ 멤버변수 + 메소드]

    (200번 주소 ) : A에 대한 객체[i = 10], sysout( A 생성자 호출 )

    (300번 주소 ) : B에 대한 객체 [ j = 100

    b1 은 300번 주소인 B를 받게 된다.

    ​      	 300번 주소는 200번 주소를 사용 할 수 있다.

    ​	       200번 주소는 100번 주소를 사용 할 수 있다.

    sysout(b1.i)를 하면 300번 주소에서 i값을 찾는다.

      					없으면 200번 주소에서 i 값을 찾는다. 찾았다 (10 출력)

    sysout(b1.j)를 하면 300번 주소에서 j값을 찾는다. 찾았다 (100 출력)



- 제일 위에 있는 클래스는 A는 (extends Object)가 생략되어 있다. 즉 Object로부터 모든것을 상속하는 것이다.



### 다형성



- 기본형 변수의 형변환(String ->> int는 불가능)

- 자동 형변환 형변환 연산자 생략 가능 경우

  - byte > short > int > long  - float > double

  - char > int > long -float > double

- 명시적형변환 - 형변환연산자 명시
  - 자동 형변환 반대



이제 클래스 간의 형 변환

- 상속관계끼리의 형 변환

- 자동형변환 - 형변환 연산자 생략 가능한 경우 ( 하위 클래스의 객체를 상위 클래스 타입으로 변환할 때 가능)

  `(상위 클래스) 변수명 = new 하위생성자();`

  ```java
  class A{}
  class B extends A{}
  class C extends A{}
  class D extends C{}
  class E{}
  
  /* 자동 형변환 */
  A a1 = new A(); // 형변환 필요 없다
  A a2 = new B(); // 자동으로 형변환
  A a3 = new C(); // 자동으로 형변환
  A a4 = new D(); // 자동 형변환
  C c1 = new D(); // 자동 형변환
  A a5 = new E(); // 자동 형변환 오류 
  B b1 = new A(); // 자동 형변환 오류 (상 - 하위 오류)
  
  a3 = a2; // 이건 쌉가능
  ```

- 명시적형변환 - 형변환연산자 명시

  - 자동형변환되었다가 다시 원래 하위타입으로 복원 (하위 변수와 하위 메소드 사용이 필요해서. 단, 오버라이딩 메소드에서 하위객체 포함)

  ```java
  class A{
      i;
      ma()
  }
  class B extends A{
      j;
      mb()
  }
  
  A a2 = new B();  // 얘는 자동 형변환
  a2.i; // 형변환 가능( A거라서 가능)
  a2.j; // 형변환 불가능
  a2.ma(); //형변환 가능
  a2.mb(); // 형변환 불가능
  
  // 명시적 형변환
  A a2 = new B();
  B b2 = (B) a2; // 얘가 명시적 형변환
  a2.i; // 형변환 가능( A거라서 가능)
  a2.j; // 명시적 변환 가능
  a2.ma(); //형변환 가능
  a2.mb(); // 명시적 변환 가능
  
  ```

  

- 객체들 타입을 통일해야 하는 경우

  - 서로 다른 객체들을 1개의 배열로 저장하고 싶은 경우

    A ar[] = newA[5]

    ar[0] = new A();

    ar[1] = new B();

    ar[2] = new C();

    

  -  Sample s = new Sample();

    s.test(new A())

    s.test(new B()) // B와 C는 A에게 상속되므로 자동 형변환

    s.test(new C())

    

  - 멤버 변수에 여러 객체들의 타입이 들어가야 하는데 이를 통일

    ```java
    class 자동차{
        한국타이어 mytire = new 한국타이어(); // 한국 타이어만 사용할 수 있는데, 금호타이어도 쓸 수 있게 상속을 새로 해준다.
    }
    class 한국타이어 {}
    class 금호타이어 {}
    
    
    // 특정 클래스(타이어) 생성
    class 자동차{
        한국타이어 mytire = new 한국타이어();
    }
    class 타이어{}
    class 한국타이어 extends 타이어{}
    class 금호타이어 extends 타이어{}
    
    
    ```

    

```java
Parent p1 = new Parent(); // no 형변환
Child c1 = new Child(); // no 형변환
Parent p2 = new Child(); // 자동 형변환(상위 변수 = new 하위;) 타입이 Parent
Child c2 = (Child) p2; // ( 타입을 Child로 명시적 형변환 )
Child c3 = new Parent(); // 자동 형변환 불가능!
Child c3 = (Child) new Parent(); // 명시적 형변환 시도, 하지만 원래대로 되돌릴 수가 없다. 그러므로 명시적 형변환 불가능 컴파일은 가능하나 오류뜸

```



- p1 ()
  - parent 를 만들때 parent(임의 주소 200)의 상위 단계인 Object(임의 주소 100) 를 참조하게 된다.
- c1
  - Child (300) 을 만들 때 parent를 참조, parent는 Object를 참조



![image-20210311173907328](../../Users/새컴퓨터/AppData/Roaming/Typora/typora-user-images/image-20210311173907328.png)

- C3은 참조할 값이 없어서 error가 된다.



```java

Parent p2 = new Child(); // 자동 형변환(상위 변수 = new 하위;) 타입이 Parent
Child c2 = (Child) p2;

Parent p3 = new Parent();
Child c3 = (Child) p3;

p2는 원래 Child 였으나, p3는 Parent 객체이지 Child가 아니므로 실행이 안된다
```

# 21.03.12

## 인터페이스



- 다중 상속 가능
- public abstract 자동 선언 메소드만 가진다
- 인터페이스 타입 객체 생성 불가능하다
- 생성자가 없다
- public final static 자동 선언 변수만 가진다.









```java
interface 학생{
    int 학번;
    void 공부하다();
    void 점심먹다();
}

interface 교수{
    void 가르치다();
    void 점심먹다();
}

조교 s = new 조교();
s.공부하다();
s.가르치다();
s.점심먹다();

//////
// 멤버변수 메소드 생성자 추가 정의
학생 s = new 학생(); // 학생타입으로 직접 만드는 것은 불가능
학생 s = new 조교(); // 자동 형변환로 가능
s.변수명; // 학생 타입에서 사용
s.메소드명; // s.overring 되어 있으면 조교

s.공부하다(); // 학생으로부터 가능
s.가르치다(); // 조교꺼라서 불가능
s.점심먹다(); // 학생꺼 가능

교수 s = new 조교(); // 이것도 가능1(자동 형변환)
s.공부하다; // 교수로 부터 상속 받은 것이 아니므로 안된다
s.가르치다; // rksmd
s.점심먹다();



```



- Eclipse 메뉴에서 'Source' - 'Override/Implement Methods'를 클릭하면 override 해야하는 요소들을 알려주고 ok 누르면 자동으로 해준다.



```java
class A{}

class B{}

class C extends A{}

class D{} //추가 B,C를 상속하고 시싶다

// 이럴때 interface 사용

interface D {}

class B implements D {}

class C extends A implements D{}
    
```







### 예외 처리

- try - catch - finally

```java
try{
    1;
} catch(AException e){
    3;
} catch(BException e){
    4;
} catch(Exception e){
    5
}finally{
    2; ==> 반드시 수행
}
6;

// 1번 문장 예외 없으면 : 1 -> 2 -> 5
// AException : 3 -> 2 -> 6
// BException : 4 -> 2 -> 6
// 다른 Exception : 5 -> 2 -> 6
```



- throws - 예외 발생 문장을 포함한 메소드를 호출하는 다른 메소드 내부 처리

  - throws RuntimeException 종류는 생략 가능

    - class xxxxException extends Exception{} : 예외처리 필수

    - class xxxxException extends RuntimeException{} 

      RuntimeException도 Exception 상속을 받고 있긴 하다. Runtimeexception은 실행시, 워낙 자주 발생해서 편리성과 메모리 할당을 효율적으로 사용하기 위해 자바 컴파일러에 체크하지 말라고 생략하게 만들었다.



- throw
  - 예외적, 인위적, 강제적, 의도적 발생







### Object 클래스

- import 안해도 된다
- 메소드들은 자바 모든 클래스를 상속, 자동으로 포함된다
- toString()
- equals()



# 21.03.15

String - 기본 문자열 표현 조작 50여개 기능

```java
String s = "java";
s = s + "program";
StringBuffer sb = new StringBuffer("java");
sb.append("proram");




```

| stack   | heap                           |
| :---- | :---- |
| s : 100 | 100 : ["java"]                 |
|         | 200S: ["javaprogram"] 새로 추가 |
| s : 200, sb : 100 |  |
|  | 300:["javaprogram"] (String buffer에 의한 생성) |
| sb : 300 |  |

- 100 주소는 사용하지 않으니 메모리 삭제 가능





# 정규 표현식

- [abc] : a나 b나 c 만 가능
- [a-zA-Z0-9] : 알파벳 소,대문자, 숫자 중 1개 가능
- \w : [a-ZA-Z0-9]
- [0-9] : 숫자 1개
- \d : [0-9]
- [abc]{3} : a나 b나 c만 구성된 문자열 3개
- [abc]{3,5} : a나 b나 c만 구성된 문자열 3~5개
- [abc]{3,} : a나 b나 c만 구성된 문자열 3개 이상
- [abc]+ : a나 b나 c만 구성된 문자열 1개 이상
- [abc]* : a나 b나 c만 구성된 문자열 0개 이상
- [abc]? : a나 b나 c만 구성된 문자열 0-1개





## java.util.Date

#### Date 클래스

- `Date now = new Date();`  : 현재 시스템 날짜 시간 
- `Date now = new Date(1/1000 초 값); ` : 1970년 1월 1일 0시 0초 ~ 경과한 날짜 시간
- `Date now = new Date(2021, 3, 15); 혹은 Date now = new Date(2021,3,15,12,12,12); ` :이런식으로 하는것은 오차범위가 커서 사용 자제
- Date안에 있는 대부분의 메소드 들은 사용 자제를 권고



#### Calendar 클래스

- `Calendar cal = new Calendar();` 라는 표현은 없다
  - class는 `abstract class Calendar ... {...}` 라고 쓰여있어서 안된다

- Calendar cal = Calendar.getInstance(); 
  - static 메소드
  - singleton pattern 
  - ( private 생성자로 만들고, public static Calendar getInstance(){여기서 객체 선언`new Caldendar();`} 로 선언)

```java
cal.get(Calendar.YEAR);
cal.get(Calendar.MONTH)+1;
cal.get(Calendar.DAY_OF_MONTH);
cal.get(Calendar.HOUR);
cal.get(Calendar.MINUTE);
cal.get(Calendar.SECOND);

// 위를 한 줄로 표현
import java.text.SimpleDateFormat
    
SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss"); // E는 요일
sd.format(new Date());

Calendar cal = Calendar.getInstance();
sd.format()
```









## 멀티 스레드

- SetName() : 멀티스레드 이름 설정
- getName() : 멀티스레드이름 조회
- SetPriority(1- 10) : 우선 순위 설정 ( 기본 값이 5)
- SetPriority(Thread.MAX_PRIORITY) : 최우선 우선 순위 설정
- SetPriority(Thread.MIN_PRIORITY) : 최하위 우선 순위 설정
- SetPriority(Thread.NORM_PRIORITY) : 우선 순위 5(기본값)로 설정
- getPriority() : 우선순위 조회



# 21.03.18

자바

- 크기 동적 변경 가능
- 자바 틀 - 순서, 값만 저장. 키와 값의 한 쌍, 중복 데이터 저장 가능



collections framework 클래스들

- java.util.List 인터페이스 : 
  - 메소드 구현이 없다. 클래스로 다중 상속 메소드 오버라이딩으로 구현해야 한다
  - 순서를 갖고 데이터를 관리한다. -==> 인덱스 사용 가능
  - 같은 데이터를 중복 저장 허용 한다
    - ArryList
    - LinkedList
    - Vectork
    - Stack 
- java.util.Set 인터페이스
  - 메소드 구현이 없다
  - 클래스로 다중 상속하여 메소드 오버라이딩으로 구현 해야 한다
  - 순서가 없어서 데이터 관리할 때 인덱스 사용이 불가능하다
  - 같은 데이터 중복 저장이 불가능하다
    - 로또번호 6개 저장
    - add();
    - HashSet, TreeSet 
- java.util.Map 인터페이스
  - 데이터가 키와 값의 한 쌍으로 되어 있다
  - 키는 중복이 안되지만, 값은 중복 가능하
  - 데이터를 관리하는 순서가 없다

| List                              | Set                               | Map                                |
| --------------------------------- | --------------------------------- | ---------------------------------- |
| 데이터 = 값                       | 데이터 = 값                       | 데이터 = (키, 값)                  |
| 순서가 있다<br />중복 데이터 허용 | 순서가 없다<br />중복 데이터 불가 | 키는 중복 불가<br />값은 중복 허용 |
| ArrayList                         | HashSet                           | HashMap                            |

- 공통점
  - 뎌러가지 데이터 타입 저장 가능
  - 동적 크기 변경
  - 참조형데이터만 저장 가능 (int, double 등은 Inter 클래스 / Double클래스로 대체해서 쓴다)



### Array



- ArrayList

```java
int i [] = new int[50];
ArryList list = new ArrayList();
```



- 메소드 
  - List 인터페이스 상속
  - 오버라이딩
  - 저장
    - add(저장할 객체 - Object o) 
      - list.add(100), list.add(3.14), list.add("aaa") 전부 가능
      - int(double) 기본형은 Integer(Double) 클래스 객체 참조형으로 본다
    - add(int index, Object o) 정의
      - 지정할 위치가 있어야 한다
  - 수정
    - list.set(1,"java");
  - 삭제
    - list.remove(1)
  - 조회
    - list.size() : 데이터 갯수 조회 (리턴값 : int)
    - list.contains("java") : 특정 데이터 저장 여부 조회 (리턴값 : boolean)
    - list.indexOf("java") : 데이터 저장위치 조회 ( 리턴값 : int ) 
    - list.get(2) : 특정 위치 저장 데이터 조회 (리턴값 : Object )



- HashSet

  - 인덱스 값이 없어서 순서없이 값이 저장

  - `for i`처럼 순서대로 읽기 위해선 `Iterator`와 `hasNext`, `next`를 알아야 한다

    ```java
    HashSet mySet = new Hashset();
    set.add(100);
    set.add("String");
    Employee e1 = new Employee();
    set.add(e1);
    
    //반복자 설정
    Iterator it = mySet.iterator();
    
    //while문 설정
    while (it.hasNext()){
        sysout(o.tostring); // Employee의 toString이 이전에 overriding 되었다고 가정
    }
    ```



- 배열(List 혹은 Array 혹은 Set)의 사이즈 만큼의 for구문

```java
int [] ar = new int [5]:
// 배열
for ( int one: ar /* 배열, array, set 아무거나 가능*/){
    System.out.println(one);
}

// ArrayList
ArrayList list = new ArrayList();

for ( Object one : list){
    sysout(one);
}

// Set
for (Integer one : lotto) {
    sysout(one) 
}
```



### map



HashMap map = new HashMap();

```java
HashMap<String> map = new HashMap <String>();
HashMap<String> map = newHashmap(); // 둘다 가능

map.put("id",100);
map.put("score", 100);
map.put("score",200); // <== score key 값을 수정
map.get("id");
map.size();
```



# 21.03.22



### java.io



- 한글

  - java.util.Scanner 클래스

    ```java
    Scanner sc = new Scanner(System.in);
    sc.nextInt(); // 100을 입력하면 정수 100
    sc.nextDouble(); // Double 타입
    sc.nextLine(); // String타입
    
    System.out - java.io.PrintStream(OutputStream 하위)
    ```





- FileInputStream : .txt파일(한글 깨짐), *gif, *jpg, *mp3
- FileOutputStream : .txt파일,  *gif, *jpg, *mp3
- FileReader : .txt(한글 안깨짐)
- FileWriter: .txt(한글 안깨짐)

- File : 파일 입출력 기능이 없다

  ​			windows의 탐색기? 처럼 파일과 디렉토리 정보를 제공해 주는 메소드 이다

  ​			ex) a.txt.의 바이트? 저장경로? 마지막 수정 시각? 파일이냐 디렉토리냐? 등을 알려줌



```java
File f1 = new File("c:/test/a/A.java"); // A.java에 대한 객체를 만들 수 있게 되었다
f1.isFile() ;// File인지 아닌지 물어보는것
// true
File f2 = new File("c:/test/a"); 
f2.isFile();
// false , 디렉토리이므로 

File f3 = new File("C:\\test\\a\\A.java"); // 슬래시 1개(/)와 역슬래시 2개(\\)가 같은 의미이다
File f1 = new File("A.java"); // 디렉토리를 이렇게 쓰면 현재 사용하고 있는 프로젝트 폴더안에 있는 A.java를 의미하게 된다.
File f1 = new File("."); // .은 현재 폴더(주로 프로젝트 폴더)를 의미
file f1 = new File(".."); // 현재의 상위 디렉토리 경로


```

- isDirectory() : 디렉토리인지(boolean)

- canRead() : 파일 입력 가능한지(boolean)
- canWrite() : 파일 출력 가능한지 (boolean)

- exists() : 

  ```java
  File f = new File("me.txt");
  //me.txt가 현재 자바 프로젝트에 만약 있는지 없는지 알기위해 사용
  ```

- length() : 파일의 총 바이트수 ( int )

- lastModified() : 수정 최종시각을 1/1000초 단위로 알려준다 ( long )

- getName() : 파일 이름이 뭔지

- getParent() : 파일 저장 결로명

- createNewFile() : 파일 생성

- mkdir() : 디렉토리 생성

- delete() : 파일, 디렉토리 삭제

- getCanonicalPath() :현재 경로를 절대경로로 출력

---

다시,

#### 파일 입력

- 객체 생성 / 메소드 이름이 동일하다

- FileInputStream <=== 1바이트 (텍스트, 이미지, 동영상, 음향)

  - 아래 2가지는 서로 같다

  - FileInputStream fi = new FileInputStream ("a.txt | a.gif | a.mp3 | a.avi ");

  - File f = new File("a.txt | a.gif | a.mp3 | a.avi");

    FileInputStream fi = new FileInputStream(f);

- FileReader - 2바이트( 문자, 텍스트

  - char c = 'a'; ==> 2 바이트

- fi.read() ; ==> int로 리턴 입력 데이터는 1바이트

- fi.read();

  - ```java
    while(true){
        if(fi.read() == -1){break;}
    } // 파일을 끝까지 읽을 때 까지 read
    ```

  - 



- FileReader <=== 2바이트 (텍스트 )

  - FileReader fr = new FileReader("a.txt");

  - File f = new File("a.txt");

    FileReader fr = new FileReader(f);



#### 파일 출력

- 반복문 사용 불가

- FileOutputStream

  - FileOutputStream fo = new FIleOutputStream('a.txt");

  - File f = new FIle("a.txt");

    FileOuput fo = new FileOutputStream(f)

  

  - fo.write(97); ===> 파일에 a를 출력

    fo.write(65); ===> 파일에 A를 출력

    fo.write(48); ===> 파일에 0을 출력

- close() 메소드 호출이 필요



#### 파일 복사

- a.txt파일을 b.txt 파일로 복사





----

java.util.Scanner <= 정수, 실수, 한글, 문자열 사용 가능

Scanner sc = new Scanner(System.in); ===> 표준 엡력데이터를 데이터타입으로 변환하여 입력



FileReader fr = new FileReader("a.txt");

Scanner sc = new Scanner(fr);

===> 파일 데이터를 데이터타입으로 변환

입력으로 `이자바 100 3.55`로 했을 때 이 값을 3개로 나눠서 사용

처음에 sc.next() 로 이자바 받는다

다음에 sc.nextInt()로 100을 받고

다음에 sc.nextDouble()로 3.55를 받는다







#### Network



네트워크 : 컴퓨터의 물리적 / 무선 연결 통신 상태

서버 : 클라이언트 요청을 처리하여 결과를 리턴해주는 컴퓨터

클라이언트 : 요청하는 컴퓨터



- 컴퓨터의 사용 네트워크 목록 보는법 (cmd 실행)

```bash
$ ipconfig /all
```

- java.net

  - tcp 통신(프로토콜)

  - udp 통신(프로토콜)

  - 프로토콜

    - 네트워크 내부에서 A - B 컴퓨터가 연결할려면 서로간의 규칙이 있어야 한다. 규칙을 프로토콜

    - 서버와 클라이언트간에는 통일한 프로토콜을 사용한다

- tcp 프로토콜
  - 전화 열결
    - 서버가 데이터를 출력 - 클라이언트가 입력
    - 클라이언트가 출력을 하면 서버가 입력
  - 연결 해제



- java.net.ServerSocket



- java.net.Socket



- tcp server 클래스

  1.  ServerSocket 생성 (port = 9999)

     

     3. tcp 연결 , 클라이언트는 대기 - 승인 - socket에 리턴

     

     5. 클라이언트로부터 데이터 전송 받는다 > 서버 입력
     6. 처리 결과를 클라이언트로 전송한다 > 서버 출력

     9. Socket close > 연결 해제
     10. 끝났으니 또 다른 클라이언트 요청을 대기 하고 승인해준다



- tcp client 클래스

  2. Socket 생성("tcp server 컴퓨터 ip ", 9999)

  

  4. 서버로 데이터 전송 = 클라이언트 출력



		7. 서버로부터 데이터 전송을 받는다 > 클라이언트 입력
		8. Socket close



# 21.03.31

![image-20210331103343441](C:\Users\새컴퓨터\AppData\Roaming\Typora\typora-user-images\image-20210331103343441.png)



- Eclipse에서 File -New- Dynamic WebProject - target runtime에 new Runtim 클릭
- Apache Tomcat v9.0 선택 - Tomcat installation directory에 tomcat 설치한 폴더경로(kdigital - tomcat9) 설정

- setting
  - window - preferences - general - workspace - text file encoding - utf-8로 변경
  - ​									        web - html files - Enclding 을 ISO 10646/Unicode(UTF-8) 로 변경
  - ​									        web - jsp files - Enclding 을 ISO 10646/Unicode(UTF-8) 로 변경
  - window - Web Browser - Chrome으로 변경