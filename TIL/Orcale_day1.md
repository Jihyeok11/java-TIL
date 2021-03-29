conn hr/hr
employees


1. 2002년 이후에 입사한 직원들 중에서 급여가 13000 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.

   ```sql
   select first_name, salary, department_id from employees where salary >= 13000 and salary <= 20000 and hire_date > '02/01/01';
   
   FIRST_NAME                                   SALARY DEPARTMENT_ID
   ---------------------------------------- ---------- -------------
   Neena                                         17000            90
   John                                          14000            80
   Karen                                         13500            80
   Michael                                       13000            20
   ```

   


2. 근무한지 10년이 넘은 사원의 이름과 근무년수를 조회하시오.

   ```sql
   select first_name from employees where (select sysdate from dual) - hire_date >= 10/01/01;
   ```

   

3. 직원 중에서 상관이 없는 직원의 이름과 급여를 조회하시오.
  상관의 정보는 manager_id 컬럼에 있습니다.

  ```sql
  select first_name from employees where manager_id is null;
  
  FIRST_NAME
  ----------------------------------------
  Steven
  ```

  

4. 10, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오.

   ```sql
   select first_name, salary, department_id from employees where (department_id = 10 or department_id = 50) and salary>= 13000;
   
   null;
   ```

   

5. 직종이 clerk 직종인 직원의 이름, 급여, 직종코드를 조회하시오.
  (clerk 직종은 job_id에 CLERK을 포함하거나
  CLERK으로 끝난다.)

  ```sql
  select first_name, salary, job_id from employees where job_id like'%CLERK%';
  
  FIRST_NAME                                   SALARY JOB_ID
  ---------------------------------------- ---------- --------------------
  Alexander                                      3100 PU_CLERK
  Shelli                                         2900 PU_CLERK
  Sigal                                          2800 PU_CLERK
  Guy                                            2600 PU_CLERK
  ...
  Douglas                                        2600 SH_CLERK
  
  45 rows selected.
  ```

  

6. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.

   ```sql
   select first_name, salary, hire_date from employees where hire_date like '___12%';
   
   FIRST_NAME                                   SALARY HIRE_DAT
   ---------------------------------------- ---------- --------
   Luis                                           6900 07/12/07
   Den                                           11000 02/12/07
   ...
   Randall                                        2500 07/12/19
   
   7 rows selected.
   ```

   

7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.

   ```sql
   select first_name, salary, hire_date from employees where first_name like '%m';
   
   FIRST_NAME                                   SALARY HIRE_DAT
   ---------------------------------------- ---------- --------
   Adam                                           8200 05/04/10
   Payam                                          7900 03/05/01
   William                                        7400 07/02/23
   William                                        8300 02/06/07
   ```

   

8. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.

   ```sql
   select first_name, salary, hire_date from employees where first_name like '__d%';
   
   no rows selected
   ```

   

9. 커미션을 받는 직원의 이름, 커미션, 총급여를 조회하시오.
  총급여는 커미션*급여로 계산합니다

  ```sql
   select first_name, commission_pct, salary*(commission_pct) as 총급여 from employees where commission_pct is not null;
  
  FIRST_NAME                               COMMISSION_PCT     총급여
  ---------------------------------------- -------------- ----------
  John                                                 .4       5600
  Karen                                                .3       4050
  ...
  Charles                                              .1        620
  
  35 rows selected.
  ```

  



10. 커미션을 받지 않는 직원의 이름, 급여를 조회하시오.

    ```sql
    select first_name, salary from employees where commission_pct is null;
    
    FIRST_NAME                                   SALARY
    ---------------------------------------- ----------
    Steven                                        24000
    Neena                                         17000
    Lex                                           17000
    ...
    William                                        8300
    
    72 rows selected.
    
    ```

    

11. 10월에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
    급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
    단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
    먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.

    ```sql
     select first_name, salary, department_id,hire_date, commission_pct from employees where hire_date like '___10%' and salary >= 5000 and salary <=17000 and commission_pct is not null order by hire_date;
    
    FIRST_NAME                                   SALARY DEPARTMENT_ID HIRE_DAT COMMISSION_PCT
    ---------------------------------------- ---------- ------------- -------- --------------
    John                                          14000            80 04/10/01             .4
    Gerald                                        11000            80 07/10/15             .3
    ```

    

12. jobs 테이블
job_id : 직종코드
job_title : 직종명
max_salary : 해당직종 최대급여
min_salary : 해당직종 최소급여

jobs 테이블에서 회장과 부회장의 직종명, 최소급여,최대급여를 조회하시오.
 job_title은 직종명이고 회장은 president, 부회장은 vise president를 포함합니다.

```sql
select job_title, min_salary, max_salary from jobs where job_title like '%President%' or job_title like '%Vice President%';

JOB_TITLE                                                              MIN_SALARY MAX_SALARY
---------------------------------------------------------------------- ---------- ----------
President                                                                   20080      40000
Administration Vice President                                               15000      30000
```




13. countries 테이블
country_id : 국가코드
country_name : 국가이름

countries 테이블에서 국가이름이 United Kingdom 인 국가의
국가코드를 조회하시오.

```sql
select country_id from countries where country_name = 'United Kingdom';

COUN
----
UK
```



14. locations 테이블
city : 도시이름
country_id : 도시가 위치한 국가코드

13번에서 조회한 결과를 이용하여 United Kingdom에 위치한
도시이름을 조회하시오.

    ```sql
select city from locations where country_id in (select country_id from countries where country_name = 'United Kingdom');

CITY
------------------------------------------------------------
London
Oxford
Stretford
    ```



