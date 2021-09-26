package com.pojo.Model;

public class ShopCar { // For the future tasks

    private String nameSeller;
    private Integer id, price, idCar;

    private ShopCar(){
        nameSeller = "Default";
        id = price = idCar = 0;
    }

    private ShopCar(int id, String nameSeller, int price, int idCar){
        this.nameSeller = nameSeller;
        this.id = id;
        this.price = price;
        this.idCar = idCar;
    }

    public static ShopCar getShopCar(int id, String nameSeller, int price, int idCar){
        return new ShopCar(id, nameSeller, price, idCar);
    }

    public static ShopCar getShopCar(){
        return new ShopCar();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSeller() {
        return nameSeller;
    }

    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }
}
