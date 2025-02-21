import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerHandler {
    private CustomerDAO customerDAO;
    private Scanner scanner;

    public CustomerHandler(Connection connection) {
        this.customerDAO = new CustomerDAO(connection);
        this.scanner = new Scanner(System.in);
    }

    public void createCustomer() {
        System.out.println("Enter Driver License Number:");
        int licenseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        System.out.println("Enter Zipcode:");
        int zipcode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Mobile Phone:");
        String mobilePhone = scanner.nextLine();
        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();
        System.out.println("Enter Driver Since Date (YYYY-MM-DD):");
        Date driverSince = Date.valueOf(scanner.nextLine());

        Customer newCustomer = new Customer(licenseNumber, name, address, zipcode, mobilePhone, phone, email, driverSince);
        customerDAO.insertCustomer(newCustomer);
    }

    public void listCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void updateCustomer() {
        System.out.println("Enter Driver License Number of customer to update:");
        int licenseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Name:");
        String name = scanner.nextLine();
        System.out.println("Enter New Address:");
        String address = scanner.nextLine();
        System.out.println("Enter New Zipcode:");
        int zipcode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Mobile Phone:");
        String mobilePhone = scanner.nextLine();
        System.out.println("Enter New Phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter New Email:");
        String email = scanner.nextLine();
        System.out.println("Enter New Driver Since Date (YYYY-MM-DD):");
        Date driverSince = Date.valueOf(scanner.nextLine());

        Customer updatedCustomer = new Customer(licenseNumber, name, address, zipcode, mobilePhone, phone, email, driverSince);
        customerDAO.updateCustomer(updatedCustomer);
    }

    public void deleteCustomer() {
        System.out.println("Enter Driver License Number of customer to delete:");
        int licenseNumber = scanner.nextInt();
        customerDAO.deleteCustomer(licenseNumber);

    }
}