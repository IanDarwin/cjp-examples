\c javatest
create table javatest (id integer primary key, name varchar);
alter table javatest owner to javatest;
insert into javatest(id,name) values(1,'spock');
