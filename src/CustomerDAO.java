import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertCustomer(Customer customer) {
        String query = "INSERT INTO customer (DriverLicenceNumber, Name, Address, Zipcode, MobilePhone, Phone, Email, DriverSince) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customer.getDriverLicenceNumber());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getAddress());
            statement.setInt(4, customer.getZipcode());
            statement.setString(5, customer.getMobilePhone());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setDate(8, customer.getDriverSince());

            statement.executeUpdate();
            System.out.println("Customer added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customer SET Name=?, Address=?, Zipcode=?, MobilePhone=?, Phone=?, Email=?, DriverSince=? WHERE DriverLicenceNumber=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setInt(3, customer.getZipcode());
            statement.setString(4, customer.getMobilePhone());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.setDate(7, customer.getDriverSince());
            statement.setInt(8, customer.getDriverLicenceNumber());

            statement.executeUpdate();
            System.out.println("Customer updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int driverLicenceNumber) {
        String query = "DELETE FROM customer WHERE DriverLicenceNumber=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, driverLicenceNumber);
            statement.executeUpdate();
            System.out.println("Customer deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getInt("DriverLicenceNumber"),
                        resultSet.getString("Name"),
                        resultSet.getString("Address"),
                        resultSet.getInt("Zipcode"),
                        resultSet.getString("MobilePhone"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getDate("DriverSince")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}