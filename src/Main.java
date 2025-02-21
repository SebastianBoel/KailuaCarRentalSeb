import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();

        if (connection == null) {
            System.out.println("Database connection failed. Exiting...");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        CustomerHandler customerHandler = new CustomerHandler(connection);
        CarHandler carHandler = new CarHandler(connection);
        RentalContractHandler rentalHandler = new RentalContractHandler(connection);


        boolean running = true;
        while (running) {
            System.out.println("\n=== KAILUA CAR RENTAL SYSTEM ===");
            System.out.println("1. Manage Customers");
            System.out.println("2. Manage Cars");
            System.out.println("3. Manage Rentals");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageCustomers(customerHandler, scanner);
                    break;
                case 2:
                    manageCars(carHandler, scanner);
                    break;
                case 3:
                    manageRentals(rentalHandler, scanner);
                    break;

                case 0:
                    running = false;
                    System.out.println("Shutting down");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
        connector.closeConnection();
    }

    private static void manageCustomers(CustomerHandler customerHandler, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- CUSTOMER MANAGEMENT ---");
            System.out.println("1. Create Customer");
            System.out.println("2. List Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customerHandler.createCustomer();
                    break;
                case 2:
                    customerHandler.listCustomers();
                    break;
                case 3:
                    customerHandler.updateCustomer();
                case 4:
                    customerHandler.deleteCustomer();

                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void manageCars(CarHandler carHandler, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- CAR MANAGEMENT ---");
            System.out.println("1. Create Car");
            System.out.println("2. Get Car by Registration Number");
            System.out.println("3. Delete car");
            System.out.println("4. Update odometer");
            System.out.println("5. Show cars by category:");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    carHandler.createCar();
                    break;
                case 2:
                    carHandler.getCarByRegNumber();
                    break;

                case 3:
                    carHandler.deleteCar();

                    break;
                case 4:
                    carHandler.updateOdometer();
                    break;


                case 5:
                    carHandler.showCarsByCategory();
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    private static void manageRentals(RentalContractHandler rentalHandler, Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- RENTAL MANAGEMENT ---");
            System.out.println("1. Create New Rental Contract");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    rentalHandler.createRentalContract();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
 



