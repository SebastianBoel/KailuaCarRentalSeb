import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CarDAO {

    private Connection connection;
    Scanner scanner = new Scanner(System.in);

    public CarDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Car> getCarsByCategory(String category) {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM car";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getDate("Firstregdate"),
                        resultSet.getInt("Odometer"),
                        resultSet.getInt("EngineSize"),
                        resultSet.getBoolean("Automatic"),
                        resultSet.getBoolean("AC"),
                        resultSet.getBoolean("CruiseControl"),
                        resultSet.getBoolean("LeatherSeats"),
                        resultSet.getInt("Seats"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getString("FuelType")
                );

                if (car.carCategory(car).equals(category)) {
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void insertCar(Car car) {
        String query = "INSERT INTO car (RegistrationNumber, Firstregdate, Odometer, EngineSize, Automatic, AC, CruiseControl, LeatherSeats, Seats, Brand, Model, FuelType) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, car.getRegistrationNumber());
            statement.setDate(2, car.getFirstregdate());
            statement.setInt(3, car.getOdometer());
            statement.setInt(4, car.getEngineSize());
            statement.setBoolean(5, car.isAutomatic());
            statement.setBoolean(6, car.hasAC());
            statement.setBoolean(7, car.hasCruiseControl());
            statement.setBoolean(8, car.hasLeatherSeats());
            statement.setInt(9, car.getSeats());
            statement.setString(10, car.getBrand());
            statement.setString(11, car.getModel());
            statement.setString(12, car.getFuelType());

            statement.executeUpdate();
            System.out.println("Car added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car getCarByRegNumber(String regNumber) {
        String query = "SELECT * FROM car WHERE RegistrationNumber = ?";
        Car car = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, regNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                car = new Car(
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getDate("Firstregdate"),
                        resultSet.getInt("Odometer"),
                        resultSet.getInt("EngineSize"),
                        resultSet.getBoolean("Automatic"),
                        resultSet.getBoolean("AC"),
                        resultSet.getBoolean("CruiseControl"),
                        resultSet.getBoolean("LeatherSeats"),
                        resultSet.getInt("Seats"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getString("FuelType")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void deleteCar(String regNumber) {
        String query = "DELETE FROM car WHERE RegistrationNumber = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, regNumber);
            statement.executeUpdate();
            System.out.println("Car deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateOdometer(String regNumber, int newOdometer) {
        String query = "UPDATE car SET Odometer = ? WHERE RegistrationNumber = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, newOdometer);
            statement.setString(2, regNumber);
            statement.executeUpdate();
            System.out.println("Odometer updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCarsByCategory() {
        System.out.println("Available categories: Luxury, Family, Sport");
        System.out.println("Enter category to display:");
        String category = scanner.nextLine();

        String query = "SELECT * FROM car";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            boolean foundCars = false;
            System.out.println("Cars in " + category + " category:");

            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getString("RegistrationNumber"),
                        resultSet.getDate("Firstregdate"),
                        resultSet.getInt("Odometer"),
                        resultSet.getInt("EngineSize"),
                        resultSet.getBoolean("Automatic"),
                        resultSet.getBoolean("AC"),
                        resultSet.getBoolean("CruiseControl"),
                        resultSet.getBoolean("LeatherSeats"),
                        resultSet.getInt("Seats"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getString("FuelType")
                );

                if (car.carCategory(car).equalsIgnoreCase(category)) {
                    System.out.println(car);
                    foundCars = true;
                }
            }

            if (!foundCars) {
                System.out.println("No cars found in " + category + " category.");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving cars: " + e.getMessage());
        }
    }
}


