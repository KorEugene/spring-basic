create table if not exists  customers (
id bigserial primary key,
full_name varchar(255) not null unique
);
insert into customers (full_name) values
('Петров Петр Петрович'),
('Иванов Иван Иванович'),
('Сергеев Сергей Сергеевич');