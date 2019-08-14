create table users(id serial primary key, username text, password text, usertype text);
create table reviews(id serial primary key, rating float, description text, username text, animename text);

insert into users(username, password, usertype)  values('username', 'password', 'user');
insert into users(username, password, usertype) values('Knuckles', 'doyouknowtheway', 'user');
insert into users(username, password, usertype) values('Jim', 'password', 'user');
insert into users(username, password, usertype) values('Overlord','callmesenpai', 'admin');

select * from users;
select * from reviews;

drop table users;
drop table reviews;

drop table users;
drop table reviews;