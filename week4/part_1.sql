create table cars (
	id INT AUTO_INCREMENT unique,
	serial_id INT unique,
    name_mark VARCHAR(20),
    name_model VARCHAR(20),
	car_year YEAR
);

create table shop_cars (
	id INT AUTO_INCREMENT unique,
	id_car INT unique,
	name_seller VARCHAR(20),
    price INT
);