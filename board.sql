create table t_board(
    no number(5) primary key,
    title varchar2(200) not null,
    writer varchar2(100) not null,
    content varchar2(2000),
    view_cnt number(5) default 0,
    reg_date date default sysdate
);

create sequence seq_t_board_no nocache;

select * from t_board;

insert into t_board(no, title, content, writer)
    values(4, 'aaaaa', 'bbbbb', 'ccccc');
commit;