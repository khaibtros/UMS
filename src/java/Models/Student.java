/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;
import java.util.List;

public class Student {

        private int studentId;
         private int userId;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private Date dob;
        private String gender;
        private int majorId;
        private Date startDate;
        private Date graduatedDate;
        private String guardianName;
        private String guardianPhone;
        private List<Class> classes;

        // Constructors
        public Student() {
        }

        public Student(int studentId, int userId, String firstName, String lastName, String phone, String address, Date dob, String gender, int majorId, Date startDate, Date graduatedDate, String guardianName, String guardianPhone) {
                this.studentId = studentId;
                this.userId = userId;
                this.firstName = firstName;
                this.lastName = lastName;
                this.phone = phone;
                this.address = address;
                this.dob = dob;
                this.gender = gender;
                this.majorId = majorId;
                this.startDate = startDate;
                this.graduatedDate = graduatedDate;
                this.guardianName = guardianName;
                this.guardianPhone = guardianPhone;
        }
        
        public int getStudentId() {
                return studentId;
        }

        public void setStudentId(int studentId) {
                this.studentId = studentId;
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

        public int getMajorId() {
                return majorId;
        }

        public void setMajorId(int majorId) {
                this.majorId = majorId;
        }

        public Date getStartDate() {
                return startDate;
        }

        public void setStartDate(Date startDate) {
                this.startDate = startDate;
        }

        public Date getGraduatedDate() {
                return graduatedDate;
        }

        public void setGraduatedDate(Date graduatedDate) {
                this.graduatedDate = graduatedDate;
        }

        public String getGuardianName() {
                return guardianName;
        }

        public void setGuardianName(String guardianName) {
                this.guardianName = guardianName;
        }

        public String getGuardianPhone() {
                return guardianPhone;
        }

        public void setGuardianPhone(String guardianPhone) {
                this.guardianPhone = guardianPhone;
        }

        public List<Class> getClasses() {
                return classes;
        }

        public void setClasses(List<Class> classes) {
                this.classes = classes;
        }       
}
