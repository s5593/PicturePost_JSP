create table user_info(
   user_id varchar2(10) primary key,	
   pw varchar2(10), 
   name varchar2(10)
);

select * from user_info;

insert into user_info values('jang', '1234', '장희정');
insert into user_info values('lee', '1234', '이가현');