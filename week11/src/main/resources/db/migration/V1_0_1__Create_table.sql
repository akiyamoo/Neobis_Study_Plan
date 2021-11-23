CREATE TABLE IF NOT EXISTS orders
(
    order_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    /*user_id INT UNIQUE NOT NULL,
    product_id INT UNIQUE NOT NULL,*/
    order_sum INT NOT NULL,
    order_date DATE
);

CREATE TABLE IF NOT EXISTS products
(
    product_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    brand_id INT UNIQUE NOT NULL,
    category_id INT UNIQUE NOT NULL,
    product_name TEXT NOT NULL,
    product_specification TEXT,
    product_description TEXT
);

CREATE TABLE IF NOT EXISTS brands
(
    brand_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    brand_name TEXT NOT NULL,
    brand_description TEXT
);

CREATE TABLE IF NOT EXISTS categories
(
    category_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    category_name TEXT NOT NULL
);

ALTER TABLE brands
    ADD PRIMARY KEY(brand_id);

ALTER TABLE products
    ADD PRIMARY KEY (product_id);

ALTER TABLE categories
    ADD PRIMARY KEY (category_id);

ALTER TABLE orders
    ADD PRIMARY KEY (order_id);