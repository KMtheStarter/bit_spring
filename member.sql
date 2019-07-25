create table t_member(
    id varchar2(20) primary key,
    name varchar2(20) not null,
    password varchar2(30) not null,
    email_id varchar2(30),
    email_domain varchar2(20),
    tel1 char(3),
    tel2 char(4),
    tel3 char(4),
    post char(7),
    basic_addr varchar2(200),
    detail_addr varchar2(200),
    type char(1) default 'U',
    reg_date date default sysdate
);

select * from t_member;
delete from t_member where id='aa';
commit;
insert into t_member(id, name, password, type) values
    ('admin', 'admin', 'admin', 'S');
    
insert into t_member(id, password, name, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr)
		values('cc', 'cc', 'cc', 'cc', 'cc', 'cc', 'cc', 'cc', 'cc', 'cc', 'cc');
        rollback;
        
select id, name, email_id || '@' || email_domain as emailId, tel1 || '-' || tel2 || '-' || tel3 as tel1,
		to_char(reg_date, 'yyyy-mm-dd') regDate, type
		from t_member;
        
select id, name, email_id || '@' || email_domain as emailId, tel1 || '-' || tel2 || '-' || tel3 as tel1,
		basic_addr || ' ' || detail_addr || '(' || trim(post) || ')' as detailAddr
		from t_member
		where id='aa';
        
select * from t_board b, t_member m where b.writer = m.name;