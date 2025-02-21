import java.sql.Timestamp;

public class RentalContract {
    private int contractNumber;
    private String registrationNumber;
    private int driverLicenceNumber;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private int odometer;
    private int includedKM;

    public RentalContract(int contractNumber, String registrationNumber,
                          int driverLicenceNumber, Timestamp startDateTime,
                          Timestamp endDateTime, int odometer, int includedKM) {
        this.contractNumber = contractNumber;
        this.registrationNumber = registrationNumber;
        this.driverLicenceNumber = driverLicenceNumber;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.odometer = odometer;
        this.includedKM = includedKM;
    }


    public int getContractNumber() {
        return contractNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public int getOdometer() {
        return odometer;
    }

    public int getIncludedKM() {
        return includedKM;
    }

    @Override
    public String toString() {
        return "Rental Contract #" + contractNumber +
                "\nCar Registration: " + registrationNumber +
                "\nDriver License: " + driverLicenceNumber +
                "\nStart Date/Time: " + startDateTime +
                "\nEnd Date/Time: " + endDateTime +
                "\nOdometer: " + odometer +
                "\nIncluded KM: " + includedKM;
    }
}


