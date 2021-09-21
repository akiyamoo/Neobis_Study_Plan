create table cars (
	Id INT auto_increment unique,
	SerialID INT unique,
	Warranty INT,
	Price INT,
	NameMark VARCHAR(20),
	NameModel VARCHAR(20),
	TrimLevel VARCHAR(30)
);

create table ShopCars (
	Id INT auto_increment unique,
	IdCar INT unique,
	Name_Seller VARCHAR(20),
	Name_Buyer VARCHAR(20),
    SalePrice INT
);