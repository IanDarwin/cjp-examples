create role javatest login password 'xecret';
create database javatest owner javatest;
\c javatest
create table javatest(id integer primary key, name varchar);
alter table javatest owner to javatest;
insert into javatest(id,name) values(1,'JUnit');
insert into javatest(id,name) values(2,'Spock');
