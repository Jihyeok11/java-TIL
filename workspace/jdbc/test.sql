select * from c_emp;


--- board 테이블 - 번호 제목 내용 작성자 작성시간 글 암호 조회수
--- member 테이블 - id, password, name
create table member
(id varchar2(30) constraint member_id_pk primary key,
password number(5),
name varchar2(30));



create table board
(seq number(5) constraint board_seq_pk primary key,
title varchar2(200) constraint board_title_nn not null,
contents varchar2(4000),
writer varchar2(30) constraint board_writer_fk references member(id),
time date default sysdate,
password number(4),
viewcount number(5)
);