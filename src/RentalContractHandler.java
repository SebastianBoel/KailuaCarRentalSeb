import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Scanner;

public class RentalContractHandler {
    private final RentalContractDAO rentalContractDAO;
    private final CarDAO carDAO;
    private final CustomerDAO customerDAO;
    private final Scanner scanner;

    public RentalContractHandler(Connection connection) {
        this.rentalContractDAO = new RentalContractDAO(connection);
        this.carDAO = new CarDAO(connection);
        this.customerDAO = new CustomerDAO(connection);
        this.scanner = new Scanner(System.in);
    }

    public void createRentalContract() {
        try {

            System.out.println("Enter car registration number:");
            String regNumber = scanner.nextLine();
            Car car = carDAO.getCarByRegNumber(regNumber);
            if (car == null) {
                System.out.println("Car not found!");
                return;
            }

            System.out.println("Enter customer driver license number:");
            int licenseNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter contract number:");
            int contractNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter start date and time (YYYY-MM-DD HH:MM):");
            String startDateStr = scanner.nextLine();
            Timestamp startDateTime = Timestamp.valueOf(startDateStr + ":00");

            System.out.println("Enter end date and time (YYYY-MM-DD HH:MM):");
            String endDateStr = scanner.nextLine();
            Timestamp endDateTime = Timestamp.valueOf(endDateStr + ":00");

            System.out.println("Enter current odometer reading:");
            int odometer = scanner.nextInt();

            System.out.println("Enter included kilometers:");
            int includedKM = scanner.nextInt();

            RentalContract contract = new RentalContract(
                    contractNumber,
                    regNumber,
                    licenseNumber,
                    startDateTime,
                    endDateTime,
                    odometer,
                    includedKM
            );

            rentalContractDAO.createContract(contract);

        } catch (Exception e) {
            System.out.println("Error creating rental contract: " + e.getMessage());
        }
    }
}