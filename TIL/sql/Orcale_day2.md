1. 이름이 'adam' 인 직원의 급여와 입사일을 조회하시오.

   ```sql
   select salary, hire_date, first_name from employees where first_name= 'Adam';
   
       SALARY HIRE_DAT FIRST_NAME
   ---------- -------- ----------------------------------------
         8200 05/04/10 Adam
   ```

   


2. 나라 명이 'united states of america' 인 나라의 국가 코드를 조회하시오.

   ```sql
   select region_id from countries where country_name = 'United States of America';
   
    REGION_ID
   ----------
            2
   ```

   


3. 'Adam의 입사일은 05/11/2 이고, 급여는 7,000\ 입니다.' 의 형식으로 직원
    정보를 조회하시오.

  ```sql
select first_name as, hire_date as 입사일, concat(to_char(salary,'999,999'),'\') from employees where first_name ='Adam';

FIRST_NAME                               입사일   CONCAT(TO_CHAR(SAL
---------------------------------------- -------- ------------------
Adam                                     05/04/10    8,200\
  ```

  ```sql
select first_name ||'의 입사일은' || to_char(hire_date,'yy/mm/fmdd') ||'이고, 급여는 '|| to_char(salary,'999,999L') ||' 입니다.'as 직원정보 from employees where first_name = 'Adam';

직원정보
--------------------------------------------------------------------------------
Adam의 입사일은05/04/10이고, 급여는           8,200￦ 입니다.
  ```



직원정보

Adam의 입사일은 05/11/2 이고, 급여는 7,000 입니다. 
......

4. 이름이 5글자 이하인 직원들의 이름, 급여, 입사일을 조회하시오.

   ```sql
    select first_name, salary, hire_date from employees group by first_name,salary,hire_date having length(first_name)<=5;
   
   FIRST_NAME                                   SALARY HIRE_DAT
   ---------------------------------------- ---------- --------
   Lex                                           17000 01/01/13
   Payam                                          7900 03/05/01
   ...
   Susan                                          6500 02/06/07
   
   50 rows selected.
   ```

   

5. 06년도에 입사한 직원의 이름, 입사일을 조회하시오.

   ```sql
   select first_name, hire_date from employees where substr(hire_date,1,2)='06';
   
   FIRST_NAME                               HIRE_DAT
   ---------------------------------------- --------
   Alexander                                06/01/03
   Valli                                    06/02/05
   ...
   Kevin                                    06/05/23
   
   24 rows selected.
   ```



6. 10년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무년차를 조회하시오.

```sql
   select first_name as 이름, hire_date as 입사일,salary as 급여, trunc((sysdate-hire_date)/365) as 근무년차 from employees where trunc((sysdate-hire_date)/365)>=10;
   
   이름                                     입사일         급여   근무년차
   ---------------------------------------- -------- ---------- ----------
   Steven                                   03/06/17      24000         17
   Neena                                    05/09/21      17000         15
   ...
   William                                  02/06/07       8300         18
   
   107 rows selected.
```

   

7. employees 테이블에서 
    직종이(job_id) 'st_clerk'인 사원 중에서 급여가 1500 이상인 사원의
    first_name, job_id, salary 를 조회하시오. 단 이름은 모두 대문자로 출력하시오.

  ```sql
  select upper(first_name), job_id, salary from employees where job_id ='ST_CLERK' and salary>=1500;
  
  UPPER(FIRST_NAME)                        JOB_ID                   SALARY
  ---------------------------------------- -------------------- ----------
  JULIA                                    ST_CLERK                   3200
  IRENE                                    ST_CLERK                   2700
  ...
  PETER                                    ST_CLERK                   2500
  
  20 rows selected.
  ```

  

8.  급여합계가 20000 이상인 직종(job_id)의
    job_id, 급여합계를 조회하시오.
    단, 급여합계는 10자리로 출력하되 공백은 '0'으로 표시하시오

    ```sql
    select job_id, round(nvl(sum(salary),0),-1) as "급여 합계" from employees group by job_id;
    
    JOB_ID                급여 합계
    -------------------- ----------
    IT_PROG                   28800
    AC_MGR                    12010
    ...
    HR_REP                     6500
    
    19 rows selected.
    ```
    
    - AC_MGR의 끝자리가 8이였는데 반올림되어서 10으로 표기됨
    
9. 직원의 이름, 급여, 직원의 관리자 사번 을 조회하시오. 단, 관리자가 없는 직원은
   '<관리자 없음>'이 출력되도록 합니다.
   
   ```sql
   select first_name as 이름, salary as 급여, nvl(to_char(manager_id),'관리자 없음') as "관리자 사번" from employees;
   
   이름                                           급여 관리자 사번
   ---------------------------------------- ---------- --------------------------------------------------------------------------------
   Steven                                        24000 관리자 없음
   Neena                                         17000 100
   ...
   William                                        8300 205
   
   107 rows selected.
   ```
   
   
   
10. 직원의 이름, 급여, 직원의 관리자 이름 을 조회하시오. 단, 관리자가 없는 직원은
    '<관리자 없음>'이 출력되도록 합니다.