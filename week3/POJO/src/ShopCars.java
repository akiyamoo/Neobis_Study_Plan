import Model.Car;
import Model.CarCRUD;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ShopCars {

    private static CarCRUD carCRUD = new CarCRUD(); // Create static object for CarCRUD class (Because we only work with 1 storage)
    private static Scanner input = new Scanner(System.in); // Create static object for work in the entire class

    public static void main(String[] args) throws IOException {
        List<Car> carList = carCRUD.getListCar();
        int n;
        while (true) {
            System.out.println("Are you a buyer (1) or a seller (2) ? To exit, enter -1.");
            n = input.nextInt();
            if (n == 1) {
                toClient(carList);
            }
            else if (n == 2) {
                toShop();
            }
            else break;
        }

    } // main method - start program

    public static void toClient(List<Car> carList) {
        int n;
        do {
            System.out.println("List of cars:");
            for (Car car : carList) {
                System.out.println(car);
            }

            System.out.println("Are you interested in some kind of car? Please enter car's number. If not - please enter 0 and exit.");
            n = input.nextInt();
            ListIterator<Car> iterator = carList.listIterator();
            Car car;

            if (n != 0) {
                while (iterator.hasNext()) {
                    car = iterator.next();
                    if (car.getId() == n) {
                        System.out.println(car);
                        System.out.println("Do you want to buy (1) or not (0)?");
                        n = input.nextInt();
                        if (n == 0) {
                            System.out.println("Ok, you don't buy this car.");
                        }
                        else {
                            System.out.println("Ok, you buy car - Congratulations!)");
                            System.out.println("SerialID = " + car.getSerialID());
                            carCRUD.deleteCar(car.getId());
                        };
                        break;
                    }
                    else if (!iterator.hasNext()) {
                        System.out.println("There is no such car with this number!");
                        break;
                    }
                }
            }
            System.out.println("If you want to continue, enter 1. If not, then -1.");
            n = input.nextInt();
        } while (n == 1);

    }
    // Working with the client

    public static void toShop() {
        int n;
        String nameMark, nameModel, carTrimLevel;
        int serialID, carWarranty, price;
        do {
            System.out.println("Do you want to sell a car(1)? If not 0");
            n = input.nextInt();
            if (n == 1) {
                System.out.print("Enter the brand name: ");
                nameMark = input.next();

                System.out.print("\n Enter the model name:");
                nameModel = input.next();

                System.out.print("\n Enter car's Serial ID:");
                serialID = input.nextInt();
                // don't correct work!

                System.out.print("\n Enter car's price:");
                price = input.nextInt();

                System.out.print("\n Enter car's trim level (not obligatory):");
                carTrimLevel = input.next();
                if (carTrimLevel.equals(""))
                    carTrimLevel = "Standard";

                System.out.print("\n Enter car's warranty (not obligatory):");
                if (!input.hasNextInt())
                    carWarranty = 0;
                else {
                    carWarranty = input.nextInt();
                }
                System.out.println("Ok, you add your car!)");
                carCRUD.addCar(nameMark, nameModel, serialID, price, carTrimLevel, carWarranty);
            }
            System.out.println("If you want to continue, enter 1. If not, then -1.");
            n = input.nextInt();
        } while (n == 1);
    }
    // Working with the seller
}
