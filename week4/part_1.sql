DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS brands;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS storage_store;
DROP TABLE IF EXISTS price_change;

CREATE TABLE IF NOT EXISTS categories
(
    category_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    category_name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS brands
(
    brand_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    brand_name TEXT NOT NULL,
    brand_description TEXT
);

CREATE TABLE IF NOT EXISTS customers
(
    customer_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    customer_first_name TEXT NOT NULL,
    customer_last_name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS price_change
(
    product_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    price DECIMAL NOT NULL,
    change_date DATE
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

CREATE TABLE IF NOT EXISTS purchases
(
    purchase_id INT AUTO_INCREMENT UNIQUE NOT NULL,
    customer_id INT UNIQUE NOT NULL,
    product_id INT UNIQUE NOT NULL,
    purchase_count INT NOT NULL,
    purchase_date DATE
);

CREATE TABLE IF NOT EXISTS storage_store
(
    product_id INT UNIQUE NOT NULL,
    storage_count INT NOT NULL
);