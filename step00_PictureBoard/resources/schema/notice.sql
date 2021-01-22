drop table Post;

create table Post(
	post_num varchar2(15) primary key, --상품번호
	post_name varchar2(20) not null,--상품이름
	category varchar2(20) not null,--카테고리
	picture varchar2(100) not null, --포스트 그림
	password varchar2(20) not null,--비밀번호
	writeday date not null --작성일
);

insert into Post values('A1','**에서 한컷','human','사진1','1111',sysdate);
insert into Post values('A2','우리집 타래','animal','사진2','1111',sysdate);
insert into Post values('A3','제주 한라산','scenery','사진3','1111',sysdate);

select * from Post;	