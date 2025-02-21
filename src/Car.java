import java.sql.Date;

public class Car {
    private String registrationNumber;
    private Date firstRegDate;
    private int odometer;
    private int engineSize;
    private boolean isAutomatic;
    private boolean hasAC;
    private boolean hasCruiseControl;
    private boolean hasLeatherSeats;
    private int seats;
    private String brand;
    private String model;
    private String fuelType;

    public Car(String registrationNumber, Date firstRegDate, int odometer, int engineSize,
               boolean isAutomatic, boolean hasAC, boolean hasCruiseControl, boolean hasLeatherSeats,
               int seats, String brand, String model, String fuelType) {
        this.registrationNumber = registrationNumber;
        this.firstRegDate = firstRegDate;
        this.odometer = odometer;
        this.engineSize = engineSize;
        this.isAutomatic = isAutomatic;
        this.hasAC = hasAC;
        this.hasCruiseControl = hasCruiseControl;
        this.hasLeatherSeats = hasLeatherSeats;
        this.seats = seats;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getFuelType() {
        return fuelType;
    }
    public int getEngineSize(){
        return engineSize;
    }
    public int getSeats(){
        return seats;
    }
    public boolean isAutomatic() {
        return isAutomatic;
    }
    public boolean hasAC() {
        return hasAC;
    }
    public boolean hasCruiseControl(){
        return hasCruiseControl;
    }
    public boolean hasLeatherSeats(){
        return hasLeatherSeats;
    }

    public String carCategory(Car car) {
        if (car.getEngineSize() > 3000 && car.isAutomatic() && car.hasAC() && car.hasCruiseControl() && car.hasLeatherSeats()) {
            return "Luxury";
        } else if (car.getSeats() >= 7 && !car.isAutomatic() && car.hasAC()) {
            return "Family";
        } else if (car.getEngineSize() > 200 && !car.isAutomatic()) {
            return "Sport";
        }
        else{
            return "out of category";
        }
    }

    public Date getFirstregdate() {
        return firstRegDate;
    }

    public int getOdometer() {
        return odometer;
    }

    public String toString() {
        return "Car" + "Registration Number='" + registrationNumber + '\'' +
                ", Brand='" + brand + '\'' +
                ", Model='" + model + '\'' +
                ", Fuel Type='" + fuelType + '\'' +
                ", First Registration Date=" + firstRegDate +"\n" +
                "Odometer=" + odometer + " km" +
                ", Engine Size=" + engineSize + " cc" +
                ", Automatic=" + (isAutomatic ? "Yes" : "No") +
                ", AC=" + (hasAC ? "Yes" : "No") +
                ", Cruise Control=" + (hasCruiseControl ? "Yes" : "No") +
                ", Leather Seats=" + (hasLeatherSeats ? "Yes" : "No") +
                ", Seats=" + seats +"\n";
    }
}