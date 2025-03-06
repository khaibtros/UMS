package Models;


import java.util.Date;

public class Instructor {
    private int instructorID; // Primary key
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date dob; // Use java.sql.Date for compatibility with database
    private String gender;
    private double salary; // Decimal(10,2)
    private Date hireDate;
    private Date endDate;
    private String status;

    // Constructor
    public Instructor(int instructorID, String firstName, String lastName, String email, String phone,
                      String address, Date dob, String gender, double salary, Date hireDate, Date endDate, String status) {
        this.instructorID = instructorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.salary = salary;
        this.hireDate = hireDate;
        this.endDate = endDate;
        this.status = status;
    }

    // Default constructor
    public Instructor() {}

    // Getters and Setters
    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID=" + instructorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }
}