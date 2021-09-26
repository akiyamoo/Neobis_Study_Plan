alter table cars
add primary key (serial_id);

alter table shop_cars
add primary key (id);

alter table shop_cars
add constraint id_c
foreign key (id_car) references cars(serial_id) on update cascade on delete no action;