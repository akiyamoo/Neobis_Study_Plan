alter table cars
add primary key (SerialID);

alter table shopcars
add primary key (id);

alter table shopcars
add constraint id_car
foreign key (idCar) references cars(SerialID) on delete cascade;