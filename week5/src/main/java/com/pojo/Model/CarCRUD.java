package com.pojo.Model;

import java.sql.*;
import java.util.*;

public class CarCRUD { // connect Database and create, read, update, delete Car's object.

    private static List<Car> carList = new ArrayList<>(); // Temporary storage for object
    private static List<ShopCar> shopCarList = new ArrayList<>();
    private static Connection sql;
    private static PreparedStatement requestSELECTCars;
    private static PreparedStatement requestSELECTShopCar;
    private static PreparedStatement requestINSERTCars;
    private static PreparedStatement requestINSERTShopCars;

    static {
        try {
            sql = DriverManager.getConnection(Connecting.URL.getVal(), Connecting.USERNAME.getVal(), Connecting.PASSWORD.getVal());
            requestSELECTCars = sql.prepareCall("SELECT * FROM cars");
            requestSELECTShopCar = sql.prepareCall("SELECT * FROM shop_cars");
            requestINSERTCars = sql.prepareCall("INSERT cars(serial_id, name_mark, name_model, car_year) VALUES(?, ?, ?, ?)");
            requestINSERTShopCars = sql.prepareCall("INSERT shop_cars(id_car, name_seller, price) VALUES(?, ?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CarCRUD() throws SQLException { // initialization connect
        //carList = getCarList();
        //shopCarList = getShopCarList();
    }

    public List<Car> getCarList() throws SQLException{
        ResultSet resultCar = requestSELECTCars.executeQuery();
        carList = new ArrayList<>();
        while (resultCar.next())
        {
                carList.add(Car.getCar(Integer.parseInt(resultCar.getString("id")),
                        Integer.parseInt(resultCar.getString("serial_id")),
                        resultCar.getString("name_mark"),
                        resultCar.getString("name_model"),
                        resultCar.getString("car_year")));
        }
        return carList;
    }

    public List<ShopCar> getShopCarList() throws SQLException{
        ResultSet resultShopCar = requestSELECTShopCar.executeQuery();
        shopCarList = new ArrayList<>();
        while (resultShopCar.next())
        {
            shopCarList.add(
                    ShopCar.getShopCar(
                            resultShopCar.getInt("id"),
                            resultShopCar.getString("name_seller"),
                            resultShopCar.getInt("price"),
                            resultShopCar.getInt("id_car")
                    )
            );
        }
        return shopCarList;
    }

    public void addCar(String nameMark, String nameModel, int serialId, int carYear) throws SQLException{

        requestINSERTCars.setString(2, nameMark);
        requestINSERTCars.setString(3, nameModel);
        requestINSERTCars.setInt(1, serialId);
        requestINSERTCars.setInt(4, carYear);

        requestINSERTCars.executeUpdate();
    }

    public void addShopCar(String nameSeller, int price, int idCar) throws SQLException{
        requestINSERTShopCars.setString(2, nameSeller);
        requestINSERTShopCars.setInt(3, price);
        requestINSERTShopCars.setInt(1, idCar);

        requestINSERTShopCars.executeUpdate();
    }

}

enum Connecting {
    URL("jdbc:mysql://localhost:3306/neobis"), USERNAME("root"), PASSWORD("Eldar2002");
    private String val;
    Connecting(String val) {
        this.val = val;
    }

    String getVal() {
        return val;
    }
}
