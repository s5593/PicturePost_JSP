drop table Post;

create table Post(
	post_num varchar2(15) primary key, --��ǰ��ȣ
	post_name varchar2(20) not null,--��ǰ�̸�
	category varchar2(20) not null,--ī�װ�
	picture varchar2(100) not null, --����Ʈ �׸�
	password varchar2(20) not null,--��й�ȣ
	writeday date not null --�ۼ���
);

insert into Post values('A1','**���� ����','human','����1','1111',sysdate);
insert into Post values('A2','�츮�� Ÿ��','animal','����2','1111',sysdate);
insert into Post values('A3','���� �Ѷ��','scenery','����3','1111',sysdate);

select * from Post;	