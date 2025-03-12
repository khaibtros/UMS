package Models;

import java.util.Date;
import java.util.List;

public class Instructor {

        private int instructorID; // Primary key
        private int userId;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private Date dob; // Use java.sql.Date for compatibility with database
        private String gender;
        private double salary; // Decimal(10,2)
        private Date hireDate;
        private Date endDate;
        private String status;
        private List<Course> courses;

        public Instructor() {
        }

        public Instructor(int instructorID, int userId, String firstName, String lastName, String phone, String address, Date dob, String gender, double salary, Date hireDate, Date endDate, String status) {
                this.instructorID = instructorID;
                this.userId = userId;
                this.firstName = firstName;
                this.lastName = lastName;
                this.phone = phone;
                this.address = address;
                this.dob = dob;
                this.gender = gender;
                this.salary = salary;
                this.hireDate = hireDate;
                this.endDate = endDate;
                this.status = status;
        }

        public int getInstructorID() {
                return instructorID;
        }

        public void setInstructorID(int instructorID) {
                this.instructorID = instructorID;
        }

        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
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

        public List<Course> getCourses() {
                return courses;
        }

        public void setCourses(List<Course> courses) {
                this.courses = courses;
        }

}
