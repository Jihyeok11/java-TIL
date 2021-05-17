# 중고거래 플랫폼 만들기



## 1. DB 생성

- asg 라는 db 생성

- items 라는 테이블 생성
  - no, item, contents, price, sell_time, buy_time, seller, buyer
- member 라는 테이블 생성
  - id, password, username, create_time





```sql
create table items(
	no number(5) constraint items_no_pk primary key,
	item varchar2(20) constraint items_item_nn not null,
    contents varchar2(300),
    price number(10) not null,
    sell_time date default sysdate,
    seller varchar2(20)
);

insert into items(no,item, contents) values(1,'아이폰','아이폰12 판매 합니다');
```

```sql
create table members(
	id varchar2(20) not null,
    password varchar2(20) not null,
    username varchar2(20) not null,
    create_time date default sysdate,
    primary key(id)
);
```

---





## 로그인

- 아이디 입력 시, 스페이스바만 눌렀거나 아무것도 입력이 안되었을 때 ==> alert으로 아이디 재입력
- 비밀번호 입력 시, 스페이스바만 눌렀거나 아무것도 입력이 안되었을 때 ==> alert으로 비밀번호 재입력
- 로그인 실패시, `아이디 와 비밀번호 재입력`요청
- 로그인 성공시, id가 아닌 username을 alert 하여 main 화면으로 redirect

---

## 회원가입





## Items



```sql
/* 자동 no 증가를 위해 sequence 생성 */
create sequence board_seq; 

/* sequence값 1 증가 */
select board_seq.nextval from items;

/* 데이터 입력 */
insert into items values(board_seq.nextval, '핸드폰','아이폰 판매합니다', 1000000, sysdate, null);

```

###### alter sequence board_seq increment by -10;





---

###### 결과물 산출

bluejeansh@hanmail.net

이메일 주소로 일요일 밤 12시까지 과제물 구현 산출물(프로젝트+sql파일들) 전송하세요.
제목은 kdigital-본인이름 으로 해주세요.

- 기획서(워드파일), 결과보고서(ppt) ----> lc사이트-
- spring 프로젝트(sql까지 포함) 압축하여 ====> 이메일



---

##### 해야하는 작업

- 아이디 중복일 시, 회원가입은 안되게 막았으나, 결과가 출력이 안되고 있음

---

##### 하면서 궁금한점

- DTO(VO).java 파일에서 overloading 하는 이유
- mapping.xml에서 parameterType은 무엇을 말하는건가

