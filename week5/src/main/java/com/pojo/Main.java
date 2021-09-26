package com.pojo;

import com.pojo.Model.Car;
import com.pojo.Model.CarCRUD;
import com.pojo.Model.ShopCar;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static CarCRUD crud;
    private static List<Car> carList;
    private static List<ShopCar> shopCarList;

    public static void main(String[] args) throws SQLException {
        crud = new CarCRUD();

        //crud.addCar("Toyota", "Camry V40", 1, 2008);
        //.addCar("Toyota", "Camry V70", 2, 2019); // test
        //crud.addCar("Toyota", "Camry V30", 3, 2004);

        //crud.addShopCar("Jonny", 40000, 1);
        //crud.addShopCar("Jonny", 70000, 2); // test
        //crud.addShopCar("Jonny", 100000, 3);

        carList = crud.getCarList();
        shopCarList = crud.getShopCarList();

        for (Car car : carList){
            System.out.println(car.getId() + " " + car.getSerialID() + " " + car.getNameMark() + " " + car.getNameMark() + " " + car.getCarYear());
        }

        for (ShopCar shopCar : shopCarList){
            System.out.println(shopCar.getId() + " " + shopCar.getIdCar() + " " + shopCar.getPrice() + " " + shopCar.getNameSeller());
        }

    }
}
