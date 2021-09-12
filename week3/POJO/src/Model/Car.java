package Model;

import java.util.Random;

public class Car { // Object Car

    private String nameMark, nameModel, carTrimLevel; // attribute of car
    private Integer serialID, carWarranty, price, id; // attribute of car
    private static int idDefault = 1; // id
    private boolean sellCar; // check sell car

    private Car() { // default constructor Lada Vesta serialID = 1 (increment), standard, carWarranty = 2
        nameMark = "Lada";
        nameModel = "Vesta";
        carTrimLevel = "Standard";
        price = 700000;
        serialID = new Random().nextInt();
        carWarranty = 2;
        sellCar = false;
        id = idDefault++;
    } // standard constructor

    private Car(String nameMark, String nameModel, int serialID, int price, String carTrimLevel, int carWarranty) { // full car information
        this.nameMark = nameMark;
        this.nameModel = nameModel;
        this.serialID = serialID;
        this.carTrimLevel = carTrimLevel;
        this.carWarranty = carWarranty;
        this.price = price;
        sellCar = false;
        id = idDefault++;
    } // full constructor

    protected static Car getCar() { // default
        return new Car();
    } // return new object Car (standard object)

    protected static Car getCar(String nameMark, String nameModel, int serialID, int price, String carTrimLevel, int carWarranty) { // full
        return new Car(nameMark, nameModel, serialID, price, carTrimLevel, carWarranty);
    } // return new object Car (full object)

    protected static Car getCar(String nameMark, String nameModel, int serialID, int price, String carTrimLevel) { // full
        return new Car(nameMark, nameModel, serialID, price, carTrimLevel, 0); // return new object Car (full, but don't warranty object)
    }

    protected static Car getCar(String nameMark, String nameModel, int serialID, int price) { // default carTrimLevel and carWarranty
        return new Car(nameMark, nameModel, serialID, price, "Standard", 0); // return new object Car (full, but don't warranty and trim level object)
    }

    protected void carToSell() {
        sellCar = true;
    } // This method is check sell car

    public Integer getSerialID() {
        return serialID;
    } // getter SerialID

    public String getNameMark(){
        return nameMark;
    } // getter NameMark

    public String getNameModel() {
        return nameModel;
    } // getter NameModel

    public Integer getId() {return id;} // getter Id

    protected void setId(int n) { id = n; } // setter Id

    public Integer getPrice() { return price;} // getter Price

    @Override
    public String toString(){
        return "№" + getId() + ": "+ getNameMark() + " " + getNameModel() + ". Price = " + getPrice();
    } // This is for the println method

}

