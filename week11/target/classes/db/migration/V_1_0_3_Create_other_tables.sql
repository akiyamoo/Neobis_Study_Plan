CREATE TABLE IF NOT EXISTS price_list
(
    price_id INT PRIMARY KEY,
    /*product_id INT AUTO_INCREMENT UNIQUE NOT NULL,*/
    price_value INT NOT NULL,
    create_date DATE
);