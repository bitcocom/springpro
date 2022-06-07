create table myboard(
	idx int not null auto_increment,
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);

insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','관리자');

insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','박매일');

insert into myboard(title,content,writer)
values('게시판 연습','게시판 연습','선생님');

select * from myboard order by idx desc;