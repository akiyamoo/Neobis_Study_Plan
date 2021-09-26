package com.pojo.Model;

public class Car { // Object Car

    private String nameMark, nameModel, carYear; // attribute of car
    private Integer id, serialId; // attribute of car

    private Car() { // default constructor Lada Vesta serialID = 1 (increment), standard, carWarranty = 2
        nameMark = "Lada";
        nameModel = "Vesta";
        serialId = 0;
        carYear = "";
    } // standard constructor

    private Car(int id, int serialID, String nameMark, String nameModel, String carYear) { // full car information
        this.nameMark = nameMark;
        this.nameModel = nameModel;
        this.serialId = serialID;
        this.id = id;
        this.carYear = carYear;
    } // full constructor

    protected static Car getCar() { // default
        return new Car();
    } // return new object Car (standard object)

    protected static Car getCar(int id, int serialID, String nameMark, String nameModel, String carYear) { // full
        return new Car(id, serialID, nameMark, nameModel, carYear);
    } // return new object Car (full object)

    public Integer getSerialID() {
        return serialId;
    } // getter SerialID

    public String getNameMark(){
        return nameMark;
    } // getter NameMark

    public String getNameModel() {
        return nameModel;
    } // getter NameModel

    public Integer getId() {return id;} // getter Id

    protected void setId(int n) { id = n; } // setter Id

    @Override
    public String toString(){
        return "№" + getId() + ": "+ getNameMark() + " " + getNameModel();
    } // This is for the println method

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }
}


