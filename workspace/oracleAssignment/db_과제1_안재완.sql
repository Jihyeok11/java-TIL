create table Student(
    No number(5) constraint Student_No not null primary key,
    name varchar2(10),
    det varchar2(20),
    addr varchar2(80),
    tel varchar2(20)
);


insert into Student values(1, '홍길동','국문학과','서울','010-1111-1111');
insert into Student values(2, '고길동','수학과','인천','010-2222-2222');

select * from Student;
