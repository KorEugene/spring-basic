create table if not exists products (
id bigserial primary key,
title varchar(255) not null unique,
price integer not null
);
insert into products (title, price) values
('orange', 100),
('apple', 200),
('grapes', 300),
('watermelon', 400),
('lemon', 500);