#  실습1

> SQL의 이해와 활용

```sql
create table Student(
    No number(5) constraint Student_No not null primary key,
    name varchar2(10),
    det varchar2(20),
    addr varchar2(80),
    tel varchar2(20)
);

insert into Student values(1, '홍길동', '국문학과', '서울', '010-1111-1111');
insert into STudent values(2, '고길동', '수학과', '인천', '010-2222-2222');
```



# 21.03.24

# 오라클



- 자바 : 프로그래밍 언어로, 컴퓨터 다목적 프로그램을 제작
  - 데이터들을 파일에 저장 (영구적 저장)



- 파일을 사용한 데이터 저장
  - 데이터 분리의 기준이 없다
  - 데이터 타입 기준이 없다
  - 특정 위치 데이터 접근이 불가능
  - 중복 데이터 가능성이 있다



- connect system/`암호명`(난 system으로 설정했음) : 연결
- orcale 11g express edition의 특징
  - 무료이다 
  - 크기 제한이 없다
  - 데이터 베이스를 1개만 사용한다
  - 프리미엄 버전인 enterprise 혹은 standard edtion은 업그레이드(유료, 여러 db,)
  - 연산자 대소문자 구문 없다(암호는 예외적)



- system schema = 계정(super user) : 테이블들
- hr : 테이블들 조회 실습



- RUN 입력 실행 툴

  - RUN SQL COMMAND LINE 실행

    - ```sql
      connect system/암호 -- 연결하겠다는 뜻 Oracle의 독자적인 sql이다
      conn system/암호 -- 위와 동일
      ```
    ```
      
    - ```sql
      -- 시스템에 연결한 채로
      alter user hr identified by hr account unlock;
    ```

    - ```sql
      connect hr/hr -- hr 테이블 실습 가능
      ```
      
      system 계정을 연결햇다가 hr 계정으로 연결하면 자동으로 system계정 disconnect 된다.

    - tab 테이블에 있는 모든걸 보여줘

      ```sql
      select * from tab; 
      ```

    - 테이블 자이즈 변경

      ```sql
      set pagesize 100; -- 세로사이즈 100
      set linesize 150; -- 가로사이즈 150
      ```

    

    - 급여 컬럽

      ```sql
      select first_name, salary from employees;
      ```

    - 급여 12배로 연봉 조회

      ```sql
      select first_name, salary, salary*12 from employees;
      ```

    - 실레 컬럼명을 조회하여 임시로 변경 (alias라고 한다)

      ```sql
      select first_name as 이름, salary as 월급, salary *12 as 연봉 from employees;
      ```

    - 직종 코드 종류만 출력 (중복 제외)

      ```sql
      select job_id from employees; -- 중복해서 보여준다
      select distinct job_id from employees; -- 중뵉된거 삭제
      ```

    - 대문자로 바꿔서 출력해보겠다

      ```sql
      select first_name, upper(first_name) from employees;
      ```

    - 테이블에 있는 컬럼들 확인하는 법

      ```sql
      desc employees;
      ```

       Name                                                                                Null?    Type
      ----------------------------------------------------------------------------------- -------- --------------------------------------------------------
       EMPLOYEE_ID                                                                         NOT NULL NUMBER(6)
       FIRST_NAME                                                                                   VARCHAR2(20)
       LAST_NAME                                                                           NOT NULL VARCHAR2(25)
       EMAIL                                                                               NOT NULL VARCHAR2(25)
       PHONE_NUMBER                                                                                 VARCHAR2(20)
       HIRE_DATE                                                                           NOT NULL DATE
       JOB_ID                                                                              NOT NULL VARCHAR2(10)
       SALARY                                                                                       NUMBER(8,2)
       COMMISSION_PCT                                                                               NUMBER(2,2)
       MANAGER_ID                                                                                   NUMBER(6)
       DEPARTMENT_ID                                                                                NUMBER(4)

    ---

    - 현재 날짜

      ```sql
      select sysdate from dual;
      ```

      SYSDATE

      21/03/24 

      

      rr/mm/dd 형식

      - rr : 0-49값은 2000년대, 50-99값은 1900년대를 의미

    ---

    

    - (Data Difinition language - DDL)

      - 테이블 생성
      - 테이블 변경
      - 테이블 삭제

      

    - DML (Data Maipulation Langueage)

      - 데이터 조작 언어

    - DCL ( Data Controll lang )

      - 트랜젝션 제어 언어 (alter)

    - TCL (Transcation Controll Lang)

    - ```sql
      disconnect -- 연결해제
      disconn -- 위와 동일
      ```

- 연산자

  - 산술 연산자

    - +,-,*,/
    
  - 비교 연산자

    - `>`,`>=`,`<`,`<=`, `!=`, `=`

  - 논리 연산자

    - `not`, `and`,`or`

  - 목록연산자

    - in (...)

  - 유사연산자

    - like '%?' 

      ```sql
      select first_name from employees where first_name like '%r'; -- r로 끝나는 first_name
      ```

      ```sql
      select first_name from employees where first_name like '%er%'; --er이 들어가는 first_name
      ```

    - like '_ ?'

      ```sql
      select job_id from employees where job_id like '___MAN'; -- (세글자)+MAN인 것들을 출력
      
      select job_id from employees where job_id like '__\_MAN' escape '\'; -- (2글자)+'_'+MAN인 것들을 출력 (특수기호 자체를  쓸려면 \를 쓰고, escape '\'를 붙여준다)
      ```

    ex) like 연산자 활용

    ```sql
    -- employees 테이블에서 first_name, hire_date를 조회하는데, 입사년도가 05년도 이후일떄만 조회
    select first_name, hire_date from employees where hire_date >= '05/01/01';
    ```

  - 범위 연산자

    - between

  - rownum

    - 조회하는 행번호 생성함수

      ```sql
      SQL> select rownum, hire_date from employees;
      
          ROWNUM HIRE_DAT
      ---------- --------
               1 03/06/17
               2 05/09/21
               3 01/01/13
               ...
               107 05/09/28
      ```

          ROWNUM HIRE_DAT
      ---------- --------
               1 03/06/17
               2 05/09/21
               3 01/01/13
               4 06/01/03
               5 07/05/21
               6 05/06/25
               7 06/02/05
               8 07/02/07
               ...

    - subquery

      ex ) 최근 입사자 5명만 순서대로 조회하라

      ```sql
      SQL> select rownum, hire_date from employees where rownum<=5 order by hire_date desc;
      
          ROWNUM HIRE_DAT
      ---------- --------
               5 07/05/21
               4 06/01/03
               2 05/09/21
               1 03/06/17
               3 01/01/13
      문제점 ) ROWNUM을 한 것을 바탕으로 order_by를 하기때문에 ROWNUM이 뒤죽박죽이 된다. 그러니 order_by를 먼저 한 것을 바탕으로 ROWNUM을 생성해보자
      
      
      SQL> select rownum, hire_date from (select * from employees order by hire_date desc) /* 내림차순으로 하나의 테이블  */  where rownum<=5;
      
          ROWNUM HIRE_DAT
      ---------- --------
               1 08/04/21
               2 08/04/21
               3 08/03/24
               4 08/03/08
               5 08/02/23
      ```

      

    - sales 부서에 근무하는 사원의 이름 조회

      ```sql
      select first_name, departments.department_name from employees, departments where departments.department_name = 'Sales';
      ```

      

      ```sql
      select first_name, department_id from employees where department_id = (select department_id from departments where department_name='Sales');
      ```

      

      - Susan과 같은 부서에 근무하는 사원의 직종과 급여 조회

        ```sql
        select job_id, salary from employees where department_id = (select department_id from employees where first_name = 'Susan');
        ```

        

      - William과 같은 직종을 가진 사원의 부서, 급여 조회

        ```sql
        select department_id, salary from employees where job_id IN (select job_id from employees where first_name = 'William');
        ```

        - in은 목록 연산자 

          in (1,2,3)을 하면 select 한거 1,2,3을 선택

      - subquery 리턴값이 1개 이면 `=`을 쓰는데, 한 개인지 여러개인지 잘 모르겠으면 in을 쓰면 된다.

        (위에 Susan 문제는 운이 좋아서 (select department_id from departments where department_name='Sales') 결과가 한 개 나와서 가능했었다.)

        

        ```sql
        select job_id, salary from employees where department_id in (select department_id from employees where first_name = 'Susan');
        ```

        으로 고쳐써도 똑같은 결과가 나온다

        

      - Susan 보다 급여를 더 많이 받는사원의 사번, 이름, 급여 조회 (Susan은 1명)

        ```sql
        select employee_id, first_name, salary from employees where salary >= (select salary from employees where first_name='Susan');
        ```

        

      - William 보다 급여를 많이 받거나 동일하게 받는 사원의 사번, 이름, 급여 조회 ( William은 2명)

        ```sql
        select employee_id, first_name, salary from employees where salary >= (select salary from employees where first_name='Susan');
         -- 에러가 뜬다 (Subquery 결과가 여러개라서)
         
         조건을 제대로 딱 정해줘야 한다.
         1. 모든 William의 급여와 같거나 많을 때로 할건지
        
        select employee_id, first_name, salary from employees where salary >= all (select salary from employees where first_name='Susan'); 	
        
         2. 1명의 William의 급여와 같거나 많을 때 로 할건지
        
        select employee_id, first_name, salary from employees where salary >= any (select salary from employees where first_name='Susan');
        ```

      

  - subquery 비교 정리

    - 단일행 리턴 : `=`,`!=`,`>`,`>=`,`<`,`<=`
    - 다중행 리턴 : `in`,`not int`,`all`,`any`

- 차순 
  - 오름차순

    - 숫자는 0부터 ~, 알파벳은 a-z, 한글은 가-하

    ```sql
    select first_name from employees order by first_name asc; -- 알파벳순 오름차순
    ```

  - 내림차순

    ```sql
    select first_name from employees order by first_name asc;
    ```

    

  - 예시

    ```sql
    -- 연봉 별로 내림차순으로 그사람의 이름과 같이 출력하라( 이름은 알파벳 순으로 )
    select first_name, salary from employees order by salary desc, first_name;
    --혹은
    select first_name, salary from employees order by 1 desc;
    ```

    

- 입사월이 6월인 입사자를 찾아라, 이름, 급여, 입사날 조회 (as 사용) , 입사일이 가장 최근이 사원부터

  ```sql
  select first_name as 이름, salary as 급여, hire_date as 입사날 from employees where hire_date = '07/06/21' order by hire_date desc;
  
  select first_name, salary, hire_date from employees where hire_date like '___06%' order by 3 desc, 2 desc;
  ```

  - 최근 입사자 5명만 조회(hire_date는 desc로 정렬)

    ```sql
    select hire_date from employees where rownum<=5 order by hire_date desc;
    ```



- employees 테이블에서 commission_pct 칼럼을 조회하는데 값이 있는 데이터만 조회(null 제외)

  ```sql
  select commission_pct from employees where commission_pct != null;
  
  select commission_pct from employees where commission_pct != ''; -- commission_pct가 date 혹은 varchar 타입일 때에는 사용할 수 있는데, commission_pct는 Number(2,2)라서 no rows 출력된다.
  -- NUMBER(2,2) 뜻은 십의 자리까지 2칸사용+ 소수점 2자리까지
  
  select commission_pct from employees where commission_pct is null; -- null 인 값만 불러온다
  
  select commission_pct from employees where commission_pct is not null; -- null이 아닌 값만 불러온다
  
  이제 is null, is not null을 사용하도록 한다
  ```







---

- 다시

  - ddl 
    - create
    - alter
    - drop
  - dml
    - isert
    - update
    - delete
  - dcl
    - grant
    - revoke
  - tcl
    - commit
    - rollback

  - dql
    - select
    - from 
    - where
    - group by









---

- xe는 ORACLE의 SID(Identifies the database instance)를 의미한다.

- 사이즈 변경

![image-20210330142139668](picture/image-20210330142139668.png)


# 21.03.25

### 그룹함수

- sum : 총 합
- agv : -평균값
- count :  갯수 (숫자, 문자 ,날짜)
- max : 최대값(숫자, 문자, 날짜)
- min : 최소값(숫자, 문자, 날짜)
- stdev : 표준편차 (숫자)
- variancd : 분산 ( 숫자 )



- select 문의 순서
  - from
  - where
  - group by
  - select에 있는 group by



```sql
SQL> edit
-- 방금 친 sql문이 메모장에 저장되어 뜬다
SQL> /
-- 저장된 메모장이 실행된다
```



- count

  ```sql
  select count(department_id) as 부서갯수, count(salary) as 급여개수 from employees;
  ```

  - null값을 제외하고 값이 있는 값들만 센다.

  - null값도 포함해서 출력하고 싶으면 count(*)

    ```sql
    select count(*) as 모든 인원 from employees;
    ```

  

- max , min

  ```sql
  select max(first_name), max(hire_date), max(salary) from employees;
  
  MAX(FIRST_NAME)                          MAX(HIRE MAX(SALARY)
  ---------------------------------------- -------- -----------
  Winston                                  08/04/21       24000
                                               
  -- 영어는 최대값이 Z에 가까운사람, 날짜는 가장 최근, 숫자는 가장 큰 숫자가 나온다
                                               
                                               
                                               
  select first_name, salary from employees where salary = (select max(salary) from employees) or salary = (select min(salary) from employees);
  
  FIRST_NAME                                   SALARY
  ---------------------------------------- ----------
  Steven                                        24000
  TJ                                             2100
  ```

  

- group by

  - group by 절에 다른 컬럼 기술 불가 (단, group by 쓸때 뒤에 컬럼을 쓰면 그땐 또 가능 즉, select문에도 쓰고, group by 뒤에도 쓴다)

  - department_id =80인 사원들의 급여 총합 조회

    ```sql
    select department_id, sum(salary) from employees group by department_id;
    
    DEPARTMENT_ID SUM(SALARY)
    ------------- -----------
              100       51608
               30       24900
                         7000
               90       58000
               ...
               10        4400
    
    12 rows selected.
    
    
    
    -- null 인 사람을 제외시켜보자 ( group by는 뒤로, where가 먼저 써야한다)
    
    select department_id, sum(salary) from employees where department_id is not null group by department_id;
    
    DEPARTMENT_ID SUM(SALARY)
    ------------- -----------
              100       51608
               30       24900
               90       58000
               ...
               10        4400
    
    11 rows selected.
    
    
    
    -- 부서와 직종별로 나눠서 확인 
    select department_id, job_id, sum(salary) from employees where department_id is not null group by department_id, job_id order by department_id;
    
    DEPARTMENT_ID JOB_ID               SUM(SALARY)
    ------------- -------------------- -----------
               10 AD_ASST                     4400
               20 MK_MAN                     13000
               20 MK_REP                      6000
               ...
              110 AC_MGR                     12008
    
    19 rows selected.
    
    ```

  

- having

  ```sql
  --- 부서별로 급여 총합 조회를 하되 부서별 급여 총합이 10000미만인 부서의 결과만 조회
  select department_id, sum(salary) from employees where sum(salary)<10000 group by department_id;
  -- 에러가 난다
  -- 이유는 where sum(salary)문이 가장 먼저 실행되는데 select 문에 있는 sum(salary)를 아직 구분을 못 시켜서 에러가 난다.
  ```

  - having은 group 함수가 있을 때에만 사용된다
  - group 함수 조건식이 있을 시에는 having에 의해 select 문 순서가
    	1. from
     	2. having
     	3. where 
     	4. group by 순이다

  ```sql
  select department_id, sum(salary) from employees group by department_id having sum(salary)>= 50000;
  
  DEPARTMENT_ID SUM(SALARY)
  ------------- -----------
            100       51608
             90       58000
             50      156400
             80      304500
             
             
  -- 부서별로 급여 총합을 조회하되 사원의 급여가 5000미만은 제외하고 부서별 급여 총합이 50000 이상인 부서의 결과만 조회하라
   select department_id, sum(salary) from employees where salary>= 5000 having sum(salary)>=50000 group by department_id;
  
  DEPARTMENT_ID SUM(SALARY)
  ------------- -----------
            100       51608
             90       58000
             80      304500
  
  ```

  

- roll up

  ```sql
  -- rollup 미사용( group by 사용)
  
  select department_id, job_id, sum(salary) from employees where department_id is not null group by department_id, job_id order by department_id;
  
  DEPARTMENT_ID JOB_ID               SUM(SALARY)
  ------------- -------------------- -----------
             10 AD_ASST                     4400
             20 MK_MAN                     13000
             20 MK_REP                      6000
             ...
            110 AC_MGR                     12008
  
  19 rows selected.
  
  select department_id, job_id, sum(salary) from employees where department_id is not null group by rollup(department_id, job_id);
  
  DEPARTMENT_ID JOB_ID               SUM(SALARY)
  ------------- -------------------- -----------
             10 AD_ASST                     4400
             10                             4400 -- 10번 부서에 부분합 
             20 MK_MAN                     13000
             ...
            110 AC_ACCOUNT                  8300
            110                            20308 -- 110번 부서에 대한 부분 합
                                          684416
  
  31 rows selected.
  
  각 department_id에 따라 부분합을 더 추가시켜주었다
  ```



- cube

  department_id에 따른 salary, job_id에 따른 salary 둘다 구해준다

  ```sql
   select department_id, job_id, sum(salary) from employees where department_id is not null group by cube(department_id, job_id);
  
  DEPARTMENT_ID JOB_ID               SUM(SALARY)
  ------------- -------------------- -----------
                                          684416
                AD_VP                      34000
                AC_MGR                     12008
                FI_MGR                     12008
                ...
                FI_ACCOUNT                 39600
             10                             4400
             10 AD_ASST                     4400
             20                            19000
             20 MK_MAN                     13000
             ...
            110 AC_MGR                     12008
            110 AC_ACCOUNT                  8300
  
  50 rows selected.
  ```

  





## Oracle 데이터 형식

- 문자

  - 종류

    - CHAR
    - VARCHAR2
    - NCHAR
    - NVARCHAR2
    - CLOB

  - 데이터는 대소문자 구분을 한다

  - CHAR , VARCHAR2에서 영문은 1바이트, 한글은 3바이트이다

    ```sql
    CHAR(50) 에 'ABC'를 저장
    ==> 3바이트(ABC) + 빈 47바이트
    
    VARCHAR2(50)에 'ABC'를 저장
    ===> 사용된 3바이트만 저장 
    ===>오지게 효율성 좋음
    ```

  - NCHAR, NVARCHAR2 에서 유니코드들(한글 포함)은 2바이트



- 정수 
  - 종류
    - BINARY_INT
    - INT
    - NUMBER
    - NUMBER(8,0)



- 실수
  - 종류
    - BINARY_FLOAT
    - FLOAT
    - NUMBER(8,2) ==> 정수 6, 소수2



- 날짜
  - 종류
    - DATE (초 단위 표현)
    - TIMESTAMP (1/1000초까지 표현)



- 대용량 / 기타
  - 종류
    - CLOB : 1TB 문다열 대용량 데이터
    - BLOB : 1TB 바이너리 대용량 데이터
    - 
    - BFILE : 1TB 이하
    - BIN : 1TB 이하

---



## 일반 함수

### 문자데이터 함수

- dual 테이블 

  - 가상 임시 테이블이다

  - 1행만 알려주기 위할 때 사용된다

  - ```sql
    select sysdate from dual;
    
    SYSDATE
    --------
    21/03/25
    
    select sysdate from employees;
    
    SYSDATE
    --------
    21/03/25
    21/03/25
    ...
    21/03/25
    
    107 rows selected.
    ```

- 형변환

  - cast 함수

    - 타입을 변환시키기 위한 함수(date, number,varchar2)

      ```sql
      select sysdate from dual;
      
      SYSDATE
      --------
      21/03/25
      
      
      
      select cast( sysdate as timestamp) from dual;
      CAST(SYSDATEASTIMESTAMP)
      ---------------------------------------------------------------------------
      21/03/25 11:47:28.000000
      
      
      select cast (1234.567 as number(10,2)) from dual;
      
      CAST(1234.567ASNUMBER(10,2))
      ----------------------------
                           1234.57 
                           
      -- 반올림도 시켜주네
      ```

  - to_number

    - 연산 가능

    ```sql
    select '100'+'200' from dual;
    
    '100'+'200'
    -----------
            300
    ==> 자동으로 숫자로 변환  
            
    
            
    select to_number('123,456','999,999') + '200' from dual;
    
    TO_NUMBER('123,456','999,999')+'200'
    ------------------------------------
                                  123656
    TO_NUMBER('123,456','999,999') 는 '123456'으로 읽어서 계산한다, 
                     
                     
                                  
    select to_number('$100','$999') + to_number('$200','$999') from dual;
    
    TO_NUMBER('$100','$999')+TO_NUMBER('$200','$999')
    -------------------------------------------------
                                                  300
                                                  
    to_number는 안에 있는 기호를 무시한다.
    ```

  

  - to_char

    - 

      ```sql
      $를 붙인채로 숫자를 문자로 바꿔라
      select to_char(123456.789, '$999999') from dual;
      
      TO_CHAR(123456.789
      ------------------
       $123,457
              
      
      소수점도 출력        
      select to_char(123456.700, '$999,999.99') from dual;
      
      TO_CHAR(123456.700,'$999
      ------------------------
       $123,456.70
      ```

  

  - 현재 오라클 설정 날짜형태

    - Dict 에서 nls 찾는 법

       ```sql
        select * from dict;
        -- dict 테이블에 있는 모든 값 찾기
       ```

       ```sql
        select table_name from dict where table_name like '%NLS%';
        
        TABLE_NAME
        ------------------------------------------------------------
        NLS_DATABASE_PARAMETERS
        NLS_INSTANCE_PARAMETERS
        NLS_SESSION_PARAMETERS
        V$NLS_PARAMETERS
        V$NLS_VALID_VALUES
        GV$NLS_PARAMETERS
        GV$NLS_VALID_VALUES
        
        7 rows selected.
       ```

       ```sql
         select * from nls_session_parameters;
        
        PARAMETER
        --------------------------------------------------------------------------------------
        VALUE
        --------------------------------------------------------------------------------------
        NLS_LANGUAGE
        KOREAN
        
        NLS_TERRITORY
        KOREA
        
        NLS_CURRENCY
        ￦
        
        NLS_ISO_CURRENCY
        KOREA
        
        NLS_NUMERIC_CHARACTERS
        .,
        
        NLS_CALENDAR
        GREGORIAN
        
        NLS_DATE_FORMAT
        RR/MM/DD
        ...
        
        NLS_NCHAR_CONV_EXCP
        FALSE
        
        
        17 rows selected.
        
        -- NLS_DATE_FORMAT이 RR/MM/DD 인것을 알았다
        
       ```

    - 날짜 정보

      ```sql
      select to_char(sysdate, 'YYYY/MM/DD HH24:MI:SS') from dual;
      
      TO_CHAR(SYSDATE,'YYYY/MM/DDHH24:MM:SS'
      --------------------------------------
      2021/03/25 13:03:46
              
      ```

-- HH로 하면 12시간형태로, HH24로 하면 24시간 형태로
      -- 분을 나타네는 것은 MM이 아니라 MI 이다 (월과 다르게 하기 위해 다름)
              
              
      select to_char(sysdate, 'YYYY/MM/DD DAY HH24:MI:SS') from dual;
      
      TO_CHAR(SYSDATE,'YYYY/MM/DDDAYHH24:MM:SS')
      ----------------------------------------------------------------
      2021/03/25 목요일 13:03:38
      -- DAY 출력 결과는 윈도우 설정 언어별로 다르다


​      
​      select to_char(sysdate, 'YYYY"년도" MM"월" DD"일"  pm HH"시" mi"분" ss"초"') from dual;
​      
​      TO_CHAR(SYSDATE,'YYYY"년도"MM"월"DD"일"PMHH"시"MI"분"SS"초"')
​      -------------------------------------------------------------------------------------
​      2021년도 03월 25일  오후 01시 52분 00초
​              
​      -- pm을 붙여 쓰면 오전, 오후를 나타내 주고 사이에 문자를 표시하고 싶으면 큰따옴표를 사용한다


​              
​              
​      select to_char(sysdate, 'fmYYYY"년도" MM"월" DD"일"  pm HH"시" mi"분" ss"초"') from dual;
​      
​      TO_CHAR(SYSDATE,'FMYYYY"년도"MM"월"DD"일"PMHH"시"MI"분"SS"초"')
​      -------------------------------------------------------------------------------------
​      2021년도 3월 25일  오후 1시 53분 14초
​              
​      -- 0으로 시작하는 의미없는 숫자들을 제거하기위해서 앞에 fm을 붙여서 사용한다
​      ```


​    
​    
​    
  - 문자 => 날짜로 변환
  
    ```sql
    -- 하루 증가
    select sysdate + 1 from dual;
    
    SYSDATE+
    --------
    21/03/26
    
    -- 문자를 자동으로 날짜으로 변환
    select to_date('21/03/25','yy/mm/dd') from dual;
    
    -- 5년 후 조회
    select to_char(sysdate,'yyyy')+5 from dual;
    
    TO_CHAR(SYSDATE,'YYYY')+5
    -------------------------
                         2026
    
    
    /* employees 테이블에서 05년도 입사자만 뽑아라 */
    select hire_Date from employees where to_char(hire_date, 'yyyy') = '2005';
    
    HIRE_DAT
    --------
    05/09/21
    05/06/25
    ...
    05/08/17
    
    29 rows selected.
    
    
    /* employees 테이블에서 3월 입사자만 뽑아라 */
    select hire_date from employees where to_char(hire_date,'MM') = '03';
    
    HIRE_DAT
    --------
    06/03/07
    08/03/08
    ...
    07/03/17
    
    17 rows selected.
    ```

  

- 문자열

  - lnength / lengthb

  ```sql
  -- length
  select length('abc') from dual;
  
  LENGTH('ABC')
  -------------
              3
             
             
             
  -- 크기 
  select lengthb('가나다') from dual;
  
  LENGTHB('가나다')
  -----------------
                  9
  
  ```

  

  - 문자열 결합

    - ||

    ```sql
    select 'a'|| '가' from dual;
    
    'A'||'가'
    --------
    a가
    ```

    - concat

    ```sql
    select concat('가나다','abc') from dual;
    
    CONCAT('가나다','ABC')
    ------------------------
    가나다abc
    ```

  - instr

  ```sql
  -- 기존의 like와 비교
  select first_name from employees where first_name like '%er%';
  
  FIRST_NAME
  ----------------------------------------
  Hermann
  Gerald
  ...
  Jennifer
  
  14 rows selected. 
  
  
  select first_name from employees where instr(first_name, 'er') >0;
  
  FIRST_NAME
  ----------------------------------------
  Hermann
  Gerald
  ...
  Jennifer
  
  14 rows selected.
  
   
  -- 다른 예시 / 3월 입사자를 조회
  select hire_date from employees where hire_date like '___03%';
  
  HIRE_DAT
  --------
  06/03/07
  08/03/08
  ...
  07/03/17
  
  17 rows selected.
  
  select hire_date from employees where instr(hire_date, '03') = 4;
  
  ```

  

  

- 대소문자

  ```sql
  select first_name, upper(first_name), lower(first_name),initcap(first_name) from employees where department_id = 50;
  
  FIRST_NAME                               UPPER(FIRST_NAME)                        LOWER(FIRST_NAME)
             INITCAP(FIRST_NAME)
  ---------------------------------------- ---------------------------------------- -----------
  Mozhe                                    MOZHE                                    mozhe
             Mozhe
  Sarah                                    SARAH                                    sarah
             Sarah
  ...
  Matthew                                  MATTHEW                                  matthew
             Matthew
  
  45 rows selected.
  ```

  

- 교체

  ```sql
  -- 1. replace
  select replace ('이것이 Oracle이다', '이것이', 'This is') from dual;
  
  REPLACE('이것이ORACLE이다','이것이','THI'
  ----------------------------------------
  This is Oracle이다
          
  -- 2. translate
  select translate('이것이 Oracle이다', '이것','AB') from dual;
  
  TRANSLATE('이것이ORACLE이다'
  ----------------------------
  ABA OracleA다
          
  -- 각 단어마다 변환을 시켜준다, '이'는 'A'로, '것'은 'B'로'
  
  
  ```

  



- substr

  ```sql
  -- 03월 입사자
  select hire_date from employees where substr(hire_date,4,4)='03';
  
  HIRE_DAT
  --------
  06/03/07
  08/03/08
  ...
  07/03/17
  
  17 rows selected.
  ```



- 공백 삭제

  ```sql
  -- 왼쪽 공백 삭제
  select ltrim('     aa     ') from dual;
      
  LTRIM('AA')
  --------------
  aa
  
  select ltrim('##aaa####','#') from dual;
  
  LTRIM('#####
  ------------
  aa####
  
        
        
  -- 오른쪽 공백 삭제
  select rtrim('     aa     ') from dual;
  
  RTRIM('AA')
  --------------
       aa
        
  select rtrim('이거 졸잼이네ㅋㅋㅋㅋㅋㅋㅋ','ㅋ') from dual;
  
  RTRIM('이거졸잼이네ㅋㅋㅋㅋㅋㅋㅋ','ㅋ
  --------------------------------------
  이거 졸잼이네
  ```

  

  



### 숫자 데이터 함수

- mod : 나머지 값 구하기

  ```sql
  select mod(10,3) from dual;
  
   MOD(10,3)
  ----------
           1
           
  
  ```

  

- round - 반올림

  round(3.56,0) = 4

  round(3.56,1) = 3.6

  round(12345,-1) = 12350

  ```sql
  select 3456.789, round(3456.789 , 2), round(3456.789 , 0), round(3456.789 , -1) from dual;
  
    3456.789 ROUND(3456.789,2) ROUND(3456.789,0) ROUND(3456.789,-1)
  ---------- ----------------- ----------------- ------------------
    3456.789           3456.79              3457               3460
  ```

- trunc - 반올림 사용 x

  ```sql
  select 3456.789, trunc(3456.789 , 2), trunc(3456.789 , 0), trunc(3456.789 , -1) from dual;
  
    3456.789 TRUNC(3456.789,2) TRUNC(3456.789,0) TRUNC(3456.789,-1)
  ---------- ----------------- ----------------- ------------------
    3456.789           3456.78              3456               3450
  ```

  

- 예제

  - empoyees 테이블에서 홀수 사번만 조회

    ```sql
    
    EMPLOYEE_ID FIRST_NAME
    ----------- ----------------------------------------
            105 David
            167 Amit
            ...
            149 Eleni
    
    53 rows selected.
    ```

  - employees 테이블에서 입사년도별 급여 평균 조회하되 평균은 정수로 출력, 소수점 이하는 x, 반올림x

    ```sql
    select substr(hire_date,1,2), trunc(avg(salary)) from employees group by substr(hire_date,1,2);
    
    SUBSTR(HIRE_DATE TRUNC(AVG(SALARY))
    ---------------- ------------------
    04                             8600
    08                             5381
    07                             4994
    01                            17000
    03                             7750
    05                             6824
    02                             9830
    06                             5045
           
    -- groupby를 쓸 때에는 select 뒤에도 써줘야 한다는거 잊지마라!
    ```

    

#### 날짜 데이터 함수

- sysdate

  ```sql
  select add_months(sysdate,1) from dual; -- month가 아니라 months 이다
  
  ADD_MONT
  --------
  21/04/25
  
  
  -- 입사한지 경과년 수 조회
  select trunc((sysdate - hire_date)/365) from employees;
  
  -- 입사한지 경과주 수 조회
  select trunc((sysdate - hire_date)/7) from employees;
  
  -- 입사한지 경과개월 수 조회
  select trunc(months_between(sysdate, hire_date)) from employees;
  
  TRUNC(MONTHS_BETWEEN(SYSDATE,HIRE_DATE))
  ----------------------------------------
                                       213
                                       186
                                       ...
                                       225
  ```

  

#### 순위함수

- rownum, row_number(), rank(), dense_rank()



- 사용법

  ```sql
  --입사한지 오래된 사람 뽑는다
  순위함수() over( [ partition by ???? ] order by hire_date asc); -- partition by는 생략 가능
  ```

  





- 예제

  - 급여 많은 사원부터 순위를 매기자

    ```sql
    select first_name as 이름, salary as 급여, row_number() over( order by salary desc) as 급여순위 from employees;
    
    이름                                           급여   급여순위
    ---------------------------------------- ---------- ----------
    Steven                                        24000          1
    Neena                                         17000          2
    Lex                                           17000          3
    ...
    TJ                                             2100        107
    
    107 rows selected.
    
    -- 같은 급여에 대해서는 동순위를 해야하는데 안그렇고 있다
    
    
    select first_name as 이름, salary as 급여, rank() over( order by salary desc) as 급여순위 from employees;
    
    이름                                           급여   급여순위
    ---------------------------------------- ---------- ----------
    Steven                                        24000          1
    Neena                                         17000          2
    Lex                                           17000          2
    ...
    TJ                                             2100        107
    
    107 rows selected.
    
    -- 2등이 2명이면 다음 순위는 4등이 된다. 그런데 3등으로 바꿔서 해보자
    select first_name as 이름, salary as 급여, dense_rank() over( order by salary desc) as 급여순위 from employees;
    
    이름                                           급여   급여순위
    ---------------------------------------- ---------- ----------
    Steven                                        24000          1
    Neena                                         17000          2
    Lex                                           17000          2
    John                                          14000          3
    ...
    TJ                                             2100         58
    
    107 rows selected.
    
    
    
    
    
    -- 이제 부서별로 등급을 나눈다
    select first_name as 이름, salary as 급여, department_id as 부서코드,  row_number() over(partition by department_id order by salary desc) as 급여순위 from employees;
    
    이름                                           급여   부서코드   급여순위
    ---------------------------------------- ---------- ---------- ----------
    Jennifer                                       4400         10          1
    Michael                                       13000         20          1
    Pat                                            6000         20          2
    Den                                           11000         30          1
    Alexander                                      3100         30          2
    Shelli                                         2900         30          3
    Sigal                                          2800         30          4
    Guy                                            2600         30          5
    Karen                                          2500         30          6
    ...
    Shelley                                       12008        110          1
    William                                        8300        110          2
    Kimberely                                      7000                     1
    
    107 rows selected.
    ```

- nvl

  - null인 값을 원하는 다른 값으로 변경
  - nvl 안에 값의 형태는 서로 같아야 한다

  ```sql
  select first_name, nvl(commission_pct, 123) from employees;
  -- commission_pct가 숫자 이므로, 뒤에 값도 숫자가 와야 한다
  
  
  
  select first_name, nvl(to_char(commission_pct), 'No 보너스') from employees;
  
  FIRST_NAME                               NVL(TO_CHAR(COMMISSION_PCT),'NO보너스')
  ---------------------------------------- --------------------------------------------------------------------------------
  Steven                                   No 보너스
  Neena                                    No 보너스
  Lex                                      No 보너스
  ...
  Karen                                    .3
  Alberto                                  .3
  Gerald                                   .3
  Eleni                                    .2
  Shelley                                  No 보너스
  William                                  No 보너스
  
  107 rows selected.
  -- commsission_pct를 문자 형태로 바꿔서 사용하면 위처럼 변경 가능
  
  
  select first_name, nvl(to_char(commission_pct), 'No 보너스') as "너의 보너스" from employees;
  
  FIRST_NAME                               너의 보너스
  ---------------------------------------- --------------------------------------------------------------------------------
  Steven                                   No 보너스
  Neena                                    No 보너스
  ...
  William                                  No 보너스
  
  107 rows selected.
  
  -- alias(as)를 사용할 때 띄어쓰기를 포함하려면 큰 따옴표를 사용해야 한다
  ```

  


# 21.03.26

### join



- join

```sql
select employee_id, first_name, department_id from employees;


select department_id, department_name from departments;


select employee_id, first_name, employees.department_id, department_name 
from employees, departments 
where employees.department_id = departments.department_id;
```

- Inner join

  - 오라클 join

  ```sql
  
  /* Inner Join */
  -- 부서코드가 있는 사람만 나온다 (department_name 이 없어서 안나오는 값이 있다)
  select employee_id, first_name, e.department_id, department_name 
  from employees e, departments d 
  where e.department_id = d.department_id;
  
  EMPLOYEE_ID FIRST_NAME                               DEPARTMENT_ID DEPARTMENT_NAME
  ----------- ---------------------------------------- ------------- ------------------------------------------------------------
          200 Jennifer                                            10 Administration
          201 Michael                                             20 Marketing
          ...
          206 William                                            110 Accounting
  
  106 rows selected.
  ```

  - ansi join

  ```sql
  select employee_id, first_name, e.department_id, department_name 
  from employees e inner join departments d 
  on e.department_id = d.department_id;
  
  EMPLOYEE_ID FIRST_NAME                               DEPARTMENT_ID DEPARTMENT_NAME
  ----------- ---------------------------------------- ------------- ------------------------------------------------------------
          200 Jennifer                                            10 Administration
          201 Michael                                             20 Marketing
          ...
          206 William                                            110 Accounting
  
  106 rows selected.
  ```

  

  

- Outer Join

  - 오라클 조인

  ```sql
  /* Outer Join */
  -- null 존재해도 모든 제한에 대한 값이 나온다, (+)는 데이터가 부족한 쪽에 붙인다
  select employee_id, first_name, e.department_id, department_name 
  from employees e, departments d 
  where e.department_id = d.department_id;(+)
  
  EMPLOYEE_ID FIRST_NAME                               DEPARTMENT_ID DEPARTMENT_NAME
  ----------- ---------------------------------------- ------------- ------------------------------------------------------------
          200 Jennifer                                            10 Administration
          202 Pat                                                 20 Marketing
          ...
          178 Kimberely
  
  107 rows selected.
  ```

  - ansi join

  ```sql
  select employee_id, first_name, e.department_id, department_name 
  from employees e right outer join departments d 
  on e.department_id = d.department_id;
  
  EMPLOYEE_ID FIRST_NAME                               DEPARTMENT_ID DEPARTMENT_NAME
  ----------- ---------------------------------------- ------------- ------------------------------------------------------------
          200 Jennifer                                            10 Administration
          201 Michael                                             20 Marketing
          ...
                                                                     Payroll
  
  122 rows selected.
  ```

  

- 예시 London 도시 근무하는 사원명, 부서명, 도시명 조회 

  ( 사원명 = employees, 부서명 = departments, 도시명 = locations 테이블에 각각 있다 )

  (부서명과 도시명에 같은게 location_id, 사원과 부서에 같은게 department_id)

  ```sql
  select e.first_name, e.department_id, l.location_id from employees e, departments d, locations l where e.department_id = d.department_id and d.location_id = l.location_id and upper(city) = 'LONDON';
  
  FIRST_NAME                               DEPARTMENT_ID LOCATION_ID
  ---------------------------------------- ------------- -----------
  Ellen                                               80        2500
  Sundar                                              80        2500
  ...
  Eleni                                               80        2500
  
  106 rows selected.
  ```

- self join
  - 상사를 구하라

    ```sql
     select me.employee_id, me.first_name, me.manager_id, man.employee_id, man.first_name from employees me, employees man where me.manager_id = man.employee_id;
    
    EMPLOYEE_ID FIRST_NAME                               MANAGER_ID EMPLOYEE_ID FIRST_NAME
    ----------- ---------------------------------------- ---------- ----------- ----------------------------------------
            173 Sundita                                         148         148 Gerald
            172 Elizabeth                                       148         148 Gerald
            ...
            174 Ellen                                           149         149 Eleni
    
    106 rows selected.
    ```

    

  - 내 상사보다 급여를 많이 받는 사원의 이름 급여 조회

    ```sql
    select me.manager_id, me.first_name, me.salary , man.employee_id,man.first_name, man.salary from employees me, employees man where me.manager_id = man.employee_id and me.salary> man.salary;
    
    MANAGER_ID FIRST_NAME                                   SALARY EMPLOYEE_ID FIRST_NAME
            SALARY
    ---------- ---------------------------------------- ---------- ----------- ---------------------------------------- ----------
           148 Lisa                                          11500         148 Gerald
             11000
           149 Ellen                                         11000         149 Eleni
             10500
    ```



- union 

  같은 구조를 가지고 있는 2개의 테이블이 있을 때 사용

  ```sql
  /* 50번 부서이면서 급여가 5000미만인 사람 */
  -- 기존처럼 그냥 and 사용
  select first_name, department_id, salary from employees where department_id = 50 and salary<5000;
  
  FIRST_NAME                               DEPARTMENT_ID     SALARY
  ---------------------------------------- ------------- ----------
  Julia                                               50       3200
  Irene                                               50       2700
  ...
  Douglas                                             50       2600
  
  
  -- union 사용
  40 rows selected.
  
  _____________________________________________________________________________________________
  SQL> select first_name, department_id,salary from employees where salary<5000;
  
  FIRST_NAME                               DEPARTMENT_ID     SALARY
  ---------------------------------------- ------------- ----------
  David                                               60       4800
  Valli                                               60       4800
  ...
  Jennifer                                            10       4400
  
  49 rows selected.
  
  ____________________________________________________________________________________________
  SQL> select first_name, department_id, salary from employees where department_id = 50;
  
  FIRST_NAME                               DEPARTMENT_ID     SALARY
  ---------------------------------------- ------------- ----------
  Matthew                                             50       8000
  Adam                                                50       8200
  ...
  Douglas                                             50       2600
  
  45 rows selected.
  ____________________________________________________________________________________________
  
  이제 이 둘을 합친다
  
  SQL> select first_name, department_id, salary from employees where department_id = 50 union select first_name, department_id,salary from employees where department_id = 50 or salary<5000;
  
  FIRST_NAME                               DEPARTMENT_ID     SALARY
  ---------------------------------------- ------------- ----------
  Adam                                                50       8200
  Alana                                               50       3100
  ...
  Winston                                             50       3200
  
  54 rows selected.
  
  ____________________________________________________________________________________________
  
  주로, 다른 테이블을 둘이 합칠 때 이용된다. 지금처럼 같운 테이블을 2개 합치는 것은 별루다
  
  ```

  - union all

    ```sql
    select first_name, department_id, salary from employees where department_id = 50
      2  union all select first_name, department_id, salary from employees where salary<5000;
    
    FIRST_NAME                               DEPARTMENT_ID     SALARY
    ---------------------------------------- ------------- ----------
    Matthew                                             50       8000
    Adam                                                50       8200
    ...
    Jennifer                                            10       4400
    
    94 rows selected.
    
    
    --- 50이면서 5000 이하인 사람이 2번씩 중복되어 조회된다.
    ```

    

  - minus ( 차집합 )

    ```sql
    select first_name, department_id,salary from employees where department_id = 50 
    minus
    select first_name, department_id,salary from employees where salary <= 5000;
    
    FIRST_NAME                               DEPARTMENT_ID     SALARY
    ---------------------------------------- ------------- ----------
    Adam                                                50       8200
    Kevin                                               50       5800
    Matthew                                             50       8000
    Payam                                               50       7900
    Shanta                                              50       6500
    
    
    -- (조건 1) minus (조건 2) : 조건 1을 만족하지만 조건 2는 만족하지 못하는 사람을 조회
    ```
  
- intersect ( 교집합 )
  
    ```sql
    select first_name, department_id,salary from employees where department_id = 50 
    intersect
    select first_name, department_id,salary from employees where salary <= 5000;
    
    
    FIRST_NAME                               DEPARTMENT_ID     SALARY
    ---------------------------------------- ------------- ----------
    David                                               60       4800
    Valli                                               60       4800
    ...
    Jennifer                                            10       4400
    
    49 rows selected.
    
    
    -- (조건 1) intersect (조건2) : 조건 1과 조건 2를 모두 만족하는 사람을 조회
    ```
  
    





- DDL : 테이블 정의 / 변경 / 삭제	

  - 테이블 생성

    ```sql
    create table 테이블이름( 
    	컬럼명1 타입(길이) 제약조건, 
        컬럼명2 타입(길이) 제약조건, 
        컬럼명3 타입(길이) 제약조건, 
        ...
        컬럼명n 타입(길이) 제약조건
    );
    ```

  - 테이블 변경

    ```sql
    alter table 테이블이름(
    	ADD 컬럼명m 타입(길이) 제약조건 -- 추가
    )
    
    alter table 테이블이름
    	modify 컬럼명l 타입(길이) 제약조건 -- 타입이나 길이, 제약조건 등을 수정
    
    
    alter table 테이블이름
    	drop column 컬럼명k
    
    ```

    

  - 테이블 삭제

    ```sql
    drop table 테이블이름;
    -- 복구 불가능
    ```

    

- DML : 데이터 저장 / 수정 / 삭제

- TCL : 트랜잭션 처리



#### 계정 생성

- system 계정으로 연결
  
- con system/system;
  
- 현재 계정 확인

  - ```sql
    show user;
    ```

- 계정 생성

  - create user 계정 identified by 암호

    ```sql
    SQL> create user jdbc identified by jdbc;
    ```

  - DCL(Data Control Language)

    - DB에 접근과 접속 허락

      ```sql
      SQL> grant resource, connect to jdbc;
      ```

      - resouce는 객체(생성, 수정, 삭제), 데이터(입력, 수정, 조회, 삭제) 권한

    - DB 허락된 접근 해제

      ```sql
      SQL> revoke resource, connect to jdbc;
      ```

      

- 새로 만든 계정에 연결

  ```sql
  SQL> conn jdbc/jdbc
  ```



#### 테이블 생성

- 제한
  - 테이블은 길이 30정도(?) 제한이 있다
  - 숫자로 시작 불가능
  - 오라클 키워드 불가능
  - `_` 가능



- emp 테이블에 생성

  - 테이블 컬럼

    - id 정수 5자리 - 사번
    - name 문자열 20자리 - 이름
    - title -문자열 20자리
    - dept_id - 정수 5자리
    - salary 실수 정수 10자리, 소수점 2자리

    

  - 테이블 생성

    ```sql
    create table emp(
      	id number(5),
      	name varchar2(20),
      	title varchar2(20),
      	dept_id number(5),
      	salary number(10,2)
    );
    ```

  

- 테이블 수정

  - 테이블에 컬럼 추가

    ```sql
    alter table emp(
    	add indate date;
    );
    ```

    

  - 테이블 title 길이 변경

    ```sql
    alter table emp modify title varchar2(10);
    ```

  - 테이블에 있는 컬럼 삭제

    ```sql
    alter table emp drop column indate;
    
    Table altered.
    ```

  

- emp 테이블 삭제

  ```sql
  drop table emp;
  ```



#### 데이터 관리

#### dml ( insert, update, delete)

> 데이터 저장, 추가 삭제
>
> Commit, Rollback 해야 한다(ddl은 자동)

- Insert
  - 데이터 추가

    ```sql
    insert into emp values(100, '이사원', '사원', 10, 99000.5);
    
    1 row created.
    
    -----------------------------------------------------------------------------------------
    
    insert into emp(id,name) values(300, '박과장'); -- 포함되지 않은 column 값들은 null이 들어간다
    insert into emp values(200, '김대리', null, null, null); -- 위랑 비슷한 구문이다
    insert into emp values(400, '최부장', '부장', 20, 91000);
    insert into emp values(500, '박대리', '대리', 20, 91000);
    ```

  

  - 생성된 데이터 확인

    ```sql
    select * from emp;
    
            ID NAME                                     TITLE                                       DEPT_ID     SALARY
    ---------- ---------------------------------------- ---------------------------------------- ---------- ----------
           100 이사원                                   사원                                             10    99000.5
           500 박대리                                   대리                                             20      91000
           300 박과장
           200 김대리
           400 최부장                                   부장                                             20      91000
    ```

  - insert 수행을 해야 db가 영구 저장, commit; rollback

  - insert 수행 후 --> (메모리 임시 저장 - 다른 세션들이 결과를 못본다) --> commit ---> db에 반영

    

  - insert 수행 후 ---> (메모리 임시 저장 - 다른 세션들이 결과를 못본다) --> rollback --> 메모리 삭제 --

  

1. commit 실행

   < 세션 1 >

   ```sql
   SQL> commit;
   
   Commit complete.
   ```

2. 다른 세션 켜서 저장 된 것 확인

   < 세션 2 >

   ```sql
   select * from emp;
   
           ID NAME                                     TITLE                                       DEPT_ID     SALARY
   ---------- ---------------------------------------- ---------------------------------------- ---------- ----------
          100 이사원                                   사원                                             10    99000.5
          500 박대리                                   대리                                             20      91000
          300 박과장
          200 김대리
          400 최부장                                   부장                                             20      91000
   
   ```

3. 세션 1에서 컬럼 insert

   < 세션 1 >

   ```sql
   insert into emp values (600, '최사장', '임원', null, 100000);
   ```

4. 세션 2에서 확인

   < 세션 2 >

   ```sql
   select * from emp;
   
           ID NAME                                     TITLE                                       DEPT_ID     SALARY
   ---------- ---------------------------------------- ---------------------------------------- ---------- ----------
          100 이사원                                   사원                                             10    99000.5
          500 박대리                                   대리                                             20      91000
          300 박과장
          200 김대리
          400 최부장                                   부장                                             20      91000
   -- 새로 insert 한 값이 저장 안되었다.
   ```

5. 세션 1에서 commit(저장) 혹은 rollback(임시 메모리 삭제) 실행

   < 세션 1 >

   ```sql
   rollback;
   ```

6. Synchronize Lock

   -  id가 200인 사람을 찾아서 title을 대리로 바꿔라

     < 세션 1 >

     ```sql
     update emp set title='대리' where id =200;
     
     1 row updated.
     ```

   - '김대리'를 '과장'으로 바꿔라(같은 데이터인 것을 또 수정 )

     < 세션 2 >

     ```sql
     update emp set title='과장' where name = '김대리';
     
     (아무 말 안뜬다)
     ```

     Lock이 진행되었다

     - 세션1을 Insert나 rollback을 해줘야 세션 2가 실행 된다.





- update

  ```sql
  update 테이블명 set 변경을 원하는 컬럼명= 변경값 where 변경보건식;
  
  -- 테이블의 모든 행을 변경한다면
  update 테이블명 set 변경컬럼명 = 변경값;
  ```

  - emp 테이블에서 급여를 못 받는 사원 (salary 데이터가 없는 사람)을 조회하여 4000으로 수정

    ```sql
    update emp set salary = 4000 where salary is null; -- null과 비교를 할 때에는 `is`를 사용
    
    -- 완료했으면
    commit;
    
    ```

  - 이름이 박대리 사원의 부서를 이사원의 부서로 이동

    ```sql
    update emp set dept_id = (select dept_id from emp where name='이사원' and rownum=1) where name='최부장';
    
    1 row updated.
    
    select * from emp;
    
            ID NAME
    ---------- ----------------------------------------
    TITLE                                       DEPT_ID     SALARY
    ---------------------------------------- ---------- ----------
           100 이사원
    사원                                             10    99000.5
    
           500 박대리
    대리                                             20      91000
    
           300 박과장
                                                              4000
    
    commit;
    ```

    

- delete

  ```sql
  delete 테이블명 where 삭제조건식; -- 조건 맞는 데이터행만 삭제
  
  -- 테이블 모든 데이터 삭제
  deltete 테이블명; -- 테이블의 모드느 데이터행 삭제, 테이블 구조는 남는다.(drop table은 테이블마저 삭제), rollback을 하면 delete는 삭제한 것을 복구할 수 있다
  
  ```

  - id 가 100인 것을 삭제

    ```sql
    delete emp where id = 100;
    ```

- emp 테이블에 employees 테이블을 삽입

  ```sql
  insert into emp select * from employees;
  ```

  - 삽입 전에 emp에 들어있는 컬럼개수, 컬럼타입 잘 확인하고 실행할 것

  - 타입에 맞게 변형하여 넣기

    < 세션 1 >

    ```sql
    insert into emp(id, name, title, dept_id, salary) select employee_id, first_name, job_id,department_id, salary from hr.employees;
    -- emp가 갖고 있는 컬럼 5개 모두 사용하고 있으므로 emp뒤에 괄호는 생략 가능
    ```

    

  - 하지만 ,employees는 현재 hr 계정에 있다. 권한을 줘보자

    < 세션 2 >

    ```sql
    SQL> grant select on employees to jdbc;
    
    Grant succeeded.
    ```

  - employees 사용이 가능해졌는지 권한을 확인

    ```sql
    select * from hr.employees;
    
    ...
    107 rows selected.
    ```

    

- employee를 그대로 복사해서 테이블을 새로 생성

  ```sql
  create table emp_copy 
  as
  select * from hr.employees;
  ```

  



#### 시퀀스

- 시퀀스는 테이블 하나당 1개의 시퀀스만 만든다

- 시퀀스 생성

  ```sql
  create sequence 시퀀스이름; -- 1부터 시작하여 1씩 증가
  
  create sequetn 시퀀스이름 (
      start with 10,
      increatement by 5,
      maxvalue 100
  ); -- 10부터 시작하여 5씩, 최대 100
  ```

  

- 시퀀수 수정 , 삭제

  ```sql
  -- 수정
  alter sequence 시퀀스이름 start with 10 
   alter sequence 시퀀스이름 increment by 5
   
  -- 삭제
   drop sequence 시퀀스이름
  ```

  

- 시퀀스 활용

  ```sql
  시퀀스명.currval -- 현재 값
  
  시퀀스명.nextval -- (현재 값) + increment값 -- 할때마다 increment 차이만큼 증가
  
  확인은 dual 테이블을 통해서 본다
  
  ```

  

- 예시

  ```sql
  -- emp에 sequnce 활용
  create sequence emp_seq;
  
  -- 데이터 추가
  insert into emp values(emp_seq.nextval, '이자바', '사원',30,45000.55); -- 1번의 값으로 '이자바','사월',30,45000.55 추가
  
  
  -- 확인
  select emp_seq.currval from dual;
  
  
          ID NAME                                     TITLE                                       DEPT_ID     SALARY
  ---------- ---------------------------------------- ---------------------------------------- ---------- ----------
  		...
         206 William                                  AC_ACCOUNT                                      110       8300
           1 이자바                                   사원                                             30   45000.55
  ```

  



#### Constraint

- 제약조건

  - 중복 X -id 만들때 사용 ==> unique

  - null 값 허용 안됨 ==> not null

  - 중복 X + null x ==> primary key

  - 다른 테이블에 포함된 값 사용 가능 ==> foreign key

  - 사용자 조건  ==> check

    



- 예시

  c_dept

  (`dept_id = 10            10, ` <<- 중복 안되는데???? 어케하쥐???

  `dept_name = 인재개발부 -> 교육부,`

  ` city = 서울` 만들 것이다)

  ```sql
  -- 테이블부터 생성
  create table c_dept(
      dept_id number(5) constraint /*아무 제약조건명, 주로 테이블명_컬럼명_pk로 사용*/c_dept_id_pk primary key,
      dept_name varchar2(20) constraint c_dept_name_uk unique,
      city varchar2(20) constraint c_dept_city_nn not null
      
  );
  
  Table created.
  -------------------------------------------------------------------------------------------
  
  create table c_emp(
  	emp_id number(5) constraint c_emp_id_pk primary key,
  	emp_name varchar2(20) constraint c_emp_name_nn not null,
      title varchar2(10) constraint c_emp_title_ck check (title in ('사원', '대리', '과장', '부장', '임원')), -- 제약조건으로 사원,대리, 과장, 부장, 임원만 가능
      salary number(12,2) constraint c_emp_salary_ck check(salary >= 1000), -- 1000 이상이여야 한다
      dept_id number(5) constraint c_emp_dept_id_fk references c_dept(dept_id) -- c_dept(dept_id)값이 존재한 것만 사용한다는 것으로 제약조건
  );
  
  Table created.
  -------------------------------------------------------------------------------------------
  
  
  insert into c_dept values(10, '인재개발부', '제주');
  commit;
  -------------------------------------------------------------------------------------------
  
  insert into c_dept values(10, '교육부', '서울');
  *
  ERROR at line 1:
  ORA-00001: unique constraint (JDBC.C_DEPT_ID_PK) violated -- 에러 발생! 제약조건인 primary key(중복 불가)에 걸림
  
  -------------------------------------------------------------------------------------------
  insert into c_dept values(20, '교육부', '서울');
  
  insert into c_dept values(20, '교육부', null);
                                             *
  ERROR at line 1:
  ORA-01400: cannot insert NULL into ("JDBC"."C_DEPT"."CITY") -- not null 제약조건
  
  -------------------------------------------------------------------------------------------
  
  insert into c_dept values(20, '교육부', '서울');
  
  insert into c_dept values(30, '전산개발부', '대전');
  
  commit;
  
  -- 확인
  select * from c_dept;
  
     DEPT_ID DEPT_NAME                                CITY
  ---------- ---------------------------------------- ----------------------------------------
          10 인재개발부                               제주
          20 교육부                                   서울
          30 전산개발부                               대전
          
          
  insert into c_emp values(100, '김사원','사원',1000,10);
  insert into c_emp values(200, '박대리','대리',1999,10);
  insert into c_emp values(300, '안대리','대리',1999,20);
  insert into c_emp values(400, '박과장','과장',3000,30);
  insert into c_emp values(500, '박부장','부장',5000,10);
  commit;
  
  SQL> update c_emp set salary = salary+200 where emp_id = 100; -- 100 추가해서 수정
  SQL> commit;
  
  SQL> insert into c_emp values(600, '내가말야','사장',100000,30)
  *
  ERROR at line 1:
  ORA-02290: check constraint (JDBC.C_EMP_TITLE_CK) violated -- '사장'은 사용 불가
  
  SQL> delete c_dept where dept_id = 10;
  *
  ERROR at line 1:
  ORA-02292: integrity constraint (JDBC.C_EMP_DEPT_ID_FK) violated - child record found
  -- 외부에서 참조하는 값이 있으므로 삭제 불가능
  
  SQL> update c_emp set dept_id=20 where dept_id=10; -- 10이엿던 애들으 20으로 옮겼다
  SQL> delete c_Dept where dept_id = 10; -- 이젠 ㅆ가능
  
  
  SQL> drop table c_dept
  drop table c_dept
             *
  ERROR at line 1:
  ORA-02449: unique/primary keys in table referenced by foreign keys
  -- 자식이 있기때문에 부모를 없앨 수가 없다
  
  drop table c_dept casecade constraints; -- 자식까지 포함해서 부모를 삭제
  ```

  

 oraclexe/


 # 21.03.29

 ## jdbc



- 작성 순서
  1. jdbc driver 등록
  2. db 연결
  3. sql 전송
  4. sql 결과 검색
  5. db 연결 해제



1. db 준비

2. db 종류(Oracle db) jdbc driver 설치

3. 이클립스 자바 프로젝트를 기본 jdk 라이브러리 경로 확인

   (c:\kdigital\jre8\lib\ext )
   
4. C:\Kdigital\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 에 있는 `oracle6.jar`를 복사해서 위의 라이브러리 경로로 붙여넣기

   사실, 메뉴에 Project - Properties - Java Build Path - Libraries -  Add External JARs.. 로 추가해주는 것이 좋다.

5. 이클립스 실행 (실행되어 있었으면 껏다 킬 것)

6. jdbc 프로젝트를 만들고, `JRE System Lirbary`에 oracle 6 있는지 확인

    



- dml 

  - Statement st= con.createStatement();

    int 변경행 = st.execiteUpdate("insert | update | delete")

    

    

- dql

  - Statement st = con.createStatetment();

    ResultSet 변경행 = st.executeQuery("select ...")





---

setString 과 setNString

- setString : varchar2

- setNString : nvarchar2

  ( 하지만, 현재로써는 차이가 없다...)