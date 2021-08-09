CREATE TABLE products (
id BIGSERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL UNIQUE,
price INTEGER NOT NULL
);
INSERT INTO products (title, price) VALUES
('orange', 100),
('apple', 200),
('grapes', 300),
('watermelon', 400),
('lemon', 500);