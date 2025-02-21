import java.sql.Date;
import java.sql.*;
import java.util.*;

public class Customer {
    private int driverLicenceNumber;
    private String name;
    private String address;
    private int zipcode;
    private String mobilePhone;
    private String phone;
    private String email;
    private Date driverSince;

    public Customer(int driverLicenceNumber, String name, String address, int zipcode,
                    String mobilePhone, String phone, String email, Date driverSince){
        this.driverLicenceNumber = driverLicenceNumber;
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
        this.driverSince = driverSince;}

    public int getDriverLicenceNumber() {
        return driverLicenceNumber;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public int getZipcode() {
        return zipcode;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public Date getDriverSince() {
        return driverSince;
    }



    public String toString(){
        return "CUSTOMER: "+  driverLicenceNumber + " " + name + " " + address + " " + zipcode +" " +
       mobilePhone + " " + phone + " " +  email + " " + driverSince+ "\n";
    }
}




