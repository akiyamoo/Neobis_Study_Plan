package Model;

import java.util.*;

public class CarCRUD { // connect Database and create, read, update, delete Car's object.

    private static List<Car> carList = new ArrayList<>(); // Temporary storage for object

    public CarCRUD(){ // initialization connect
        carList.add(Car.getCar());
        carList.add(Car.getCar("Toyota", "Camry V70", 4, 1000000, "Sport Edition", 4));
        carList.add(Car.getCar("Toyota", "Corolla", 6, 800000, "Sport Edition", 3));
        carList.add(Car.getCar("Toyota", "Land Cruiser 300", 7, 2300000, "Sport Edition", 6));
        carList.add(Car.getCar());
        carList.add(Car.getCar());
    }

    public List<Car> getListCar() {
        Comparator<Car> carComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        Collections.sort(carList, carComparator);
        return carList;
    }
    // return storage and sort

    public void deleteCar(int id) {
        int n;
        for (int i = 0; i < carList.size(); i++)
        {
            if (carList.get(i).getId() == id) {
                n = id;
                carList.remove(i);
                for (int j = i; j < carList.size(); j++) {
                    setCarId(id++, carList.get(j));
                }
                break;
            }
        }
    }
    // delete object in storage

    public void addCar(String nameMark, String nameModel, int serialID, int price, String carTrimLevel, int carWarranty) {
        carList.add(Car.getCar(nameMark, nameModel, serialID, price, carTrimLevel, carWarranty));
    }
    // add object to storage

    public void addCar(String nameMark, String nameModel, int serialID, int price) {
        carList.add(Car.getCar(nameMark, nameModel, serialID, price));
    }
    // add object to storage (don't have trim level and warranty arguments)

    public void addCar() {
        carList.add(Car.getCar());
    }
    // add default object to storage

    private void setCarId(int n, Car car) { car.setId(n); }
    // Calls the car's setter

/*    public Class<Car> getCarClass() { //Reflex
        return Car.class;
    }*/

}
