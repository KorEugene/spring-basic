create table if not exists  customers_products (
customer_id integer references customers (id),
product_id integer references products (id)
);
insert into customers_products (customer_id, product_id) values
(1,2),
(2,3),
(2,4),
(2,5),
(3,3),
(3,5);