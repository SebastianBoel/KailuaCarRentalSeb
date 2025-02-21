import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class CarHandler {
    private CarDAO carDAO;
    private Scanner scanner;

    public CarHandler(Connection connection) {
        this.carDAO = new CarDAO(connection);
        this.scanner = new Scanner(System.in);
    }

    public void createCar() {
        System.out.println("Enter Registration Number:(XX99999)(Make something you can remember for easy editing)");
        String regNumber = scanner.nextLine();
        System.out.println("Enter First Registration Date (YYYY-MM-DD):");
        Date firstRegDate = Date.valueOf(scanner.nextLine());
        System.out.println("Enter Odometer Reading:");
        int odometer = scanner.nextInt();
        System.out.println("Enter Engine Size:");
        int engineSize = scanner.nextInt();
        System.out.println("Is Automatic (true/false):");
        boolean automatic = scanner.nextBoolean();
        System.out.println("Has AC (true/false):");
        boolean ac = scanner.nextBoolean();
        System.out.println("Has Cruise Control (true/false):");
        boolean cruiseControl = scanner.nextBoolean();
        System.out.println("Has Leather Seats (true/false):");
        boolean leatherSeats = scanner.nextBoolean();
        System.out.println("Enter Number of Seats:");
        int seats = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Brand:");
        String brand = scanner.nextLine();
        System.out.println("Enter Model:");
        String model = scanner.nextLine();
        System.out.println("Enter Fuel Type:");
        String fuelType = scanner.nextLine();

        Car newCar = new Car(regNumber, firstRegDate, odometer, engineSize, automatic, ac, cruiseControl, leatherSeats, seats, brand, model, fuelType);
        carDAO.insertCar(newCar);
    }

    public void getCarByRegNumber() {
        System.out.println("Enter Registration Number:");
        String regNumber = scanner.nextLine();
        Car car = carDAO.getCarByRegNumber(regNumber);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car not found.");
        }
    }

    public void deleteCar() {
        System.out.println("Enter Registration Number of car to delete:");
        String regNumber = scanner.nextLine();
        carDAO.deleteCar(regNumber);
    }


    public void updateOdometer() {
        System.out.println("Enter registration number of the car you wish to update:");
        String regNumber = scanner.nextLine();
        System.out.println("Enter updated odometer:");
        int newOdometer = scanner.nextInt();
        scanner.nextLine();

        carDAO.updateOdometer(regNumber, newOdometer);
        System.out.println("new set value" + newOdometer);

    }
    public void showCarsByCategory() {
        System.out.println("\nAvailable categories: Luxury, Family, Sport");
        System.out.println("Enter category to display:");
        String category = scanner.nextLine();

        List<Car> cars = carDAO.getCarsByCategory(category);

        if (cars.isEmpty()) {
            System.out.println("No cars found in " + category + " category.");
            return;
        }

        System.out.println("\nCars in " + category + " category:");
        for (Car car : cars) {
            System.out.println(car.toString());
            System.out.println("-----------------");
        }
    }
}

