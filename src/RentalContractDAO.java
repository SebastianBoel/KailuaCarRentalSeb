import java.sql.*;

public class RentalContractDAO {
    private Connection connection;

    public RentalContractDAO(Connection connection) {
        this.connection = connection;
    }

    public int getNextContractNumber() {
        String query = "SELECT MAX(contractNumber) FROM rentalcontracts";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void createContract(RentalContract contract) {
        int contractNumber = getNextContractNumber();
        String query = "INSERT INTO rentalcontracts (contractNumber, RegistrationNumber, " +
                "DriverLicenceNumber, StartDateTime, EndDateTime, Odometer, IncludedKM) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, contractNumber);
            stmt.setString(2, contract.getRegistrationNumber());
            stmt.setInt(3, contract.getDriverLicenceNumber());
            stmt.setTimestamp(4, contract.getStartDateTime());
            stmt.setTimestamp(5, contract.getEndDateTime());
            stmt.setInt(6, contract.getOdometer());
            stmt.setInt(7, contract.getIncludedKM());

            stmt.executeUpdate();
            System.out.println("Rental contract created successfully! Contract Number: " + contractNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}