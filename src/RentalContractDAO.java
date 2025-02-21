import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalContractDAO {
    private Connection connection;

    public RentalContractDAO(Connection connection) {
        this.connection = connection;
    }

    public void createContract(RentalContract contract) {
        String query = "INSERT INTO rentalcontracts (contractNumber, RegistrationNumber, " +
                "DriverLicenceNumber, StartDateTime, EndDateTime, Odometer, IncludedKM) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, contract.getContractNumber());
            stmt.setString(2, contract.getRegistrationNumber());
            stmt.setInt(3, contract.getDriverLicenceNumber());
            stmt.setTimestamp(4, contract.getStartDateTime());
            stmt.setTimestamp(5, contract.getEndDateTime());
            stmt.setInt(6, contract.getOdometer());
            stmt.setInt(7, contract.getIncludedKM());

            stmt.executeUpdate();
            System.out.println("Rental contract created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}