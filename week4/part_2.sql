ALTER TABLE categories
    ADD PRIMARY KEY(category_id);

ALTER TABLE brands
    ADD PRIMARY KEY(brand_id);

ALTER TABLE customers
    ADD PRIMARY KEY(customer_id);

ALTER TABLE price_change
    ADD FOREIGN KEY(product_id) REFERENCES products(product_id);

ALTER TABLE products
    ADD PRIMARY KEY(product_id),
    ADD FOREIGN KEY(brand_id) REFERENCES brands(brand_id),
    ADD FOREIGN KEY(category_id) REFERENCES categories(category_id);

ALTER TABLE purchases
    ADD PRIMARY KEY(purchase_id),
    ADD FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
    ADD FOREIGN KEY(product_id) REFERENCES products(product_id);

ALTER TABLE storage_store
    ADD FOREIGN KEY(product_id) REFERENCES products(product_id);