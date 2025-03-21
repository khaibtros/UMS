package DAO;

import Models.Course;
import Models.Instructor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstructorDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        public List<Instructor> getAllInstructors() {
                List<Instructor> lstInstructor = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Instructor";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int id = rs.getInt("InstructorID");
                                int userId = rs.getInt("userId");
                                String fn = rs.getString("FirstName");
                                String ln = rs.getString("LastName");
                                String ph = rs.getString("Phone");
                                String addr = rs.getString("Address");
                                Date dob = rs.getDate("DOB");
                                String gen = rs.getString("Gender");
                                double salary = rs.getDouble("Salary");
                                Date hireDate = rs.getDate("HireDate");
                                Date endDate = rs.getDate("EndDate");
                                String status = rs.getString("Status");

                                Instructor x = new Instructor(
                                        id, userId, fn, ln, ph, addr,
                                        dob, gen, salary, hireDate, endDate, status
                                );
                                lstInstructor.add(x);
                        }

                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstInstructor;
        }

        public Instructor getInstructorByUserId(int userId) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Instructor WHERE userId = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, userId);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                                int id = rs.getInt("InstructorID");
                                String fn = rs.getString("FirstName");
                                String ln = rs.getString("LastName");
                                String ph = rs.getString("Phone");
                                String addr = rs.getString("Address");
                                Date dob = rs.getDate("DOB");
                                String gen = rs.getString("Gender");
                                double salary = rs.getDouble("Salary");
                                Date hireDate = rs.getDate("HireDate");
                                Date endDate = rs.getDate("EndDate");
                                String status = rs.getString("Status");

                                return new Instructor(id, userId, fn, ln, ph, addr, dob, gen, salary, hireDate, endDate, status);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
        }

        public List<Course> getAllCoursesByInstructorId(int instructorId) {
                List<Course> lstCourse = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT c.CourseID, c.Name, c.Code, c.Description, c.MajorID, c.SemesterID, c.FeeAmount "
                                + "FROM Course c "
                                + "JOIN CourseInstructor ci ON c.CourseID = ci.CourseID "
                                + "WHERE ci.InstructorID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, instructorId);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int courseID = rs.getInt("CourseID");
                                String name = rs.getString("Name");
                                String code = rs.getString("Code");
                                String description = rs.getString("Description");
                                int majorID = rs.getInt("MajorID");
                                int semesterID = rs.getInt("SemesterID");
                                double feeAmount = rs.getDouble("FeeAmount");

                                Course x = new Course(courseID, name, code, description, majorID, semesterID, feeAmount);
                                lstCourse.add(x);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstCourse;
        }

        public void deleteInstructor(String instructorId) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Instructor WHERE InstructorID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, instructorId);
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void addNewInstructor(String instructorID, String firstName, String lastName, String email, String phone,
                String address, String dob, String gender, String salary, String hireDate,
                String endDate, String status) {
                DBContext db = new DBContext();
                String sql = "INSERT INTO Instructor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, instructorID);
                        ps.setString(2, firstName);
                        ps.setString(3, lastName);
                        ps.setString(4, email);
                        ps.setString(5, phone);
                        ps.setString(6, address);
                        ps.setString(7, dob);
                        ps.setString(8, gender);
                        ps.setDouble(9, Double.parseDouble(salary));
                        ps.setString(10, hireDate);
                        ps.setString(11, endDate);
                        ps.setString(12, status);

                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void updateInstructor(String instructorID, String firstName, String lastName, String email, String phone,
                String address, String dob, String gender, String salary, String hireDate,
                String endDate, String status) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "UPDATE Instructor\n"
                                + "SET FirstName = ?, LastName = ?, Email = ?, Phone = ?, Address = ?, DOB = ?,\n"
                                + "Gender = ?, Salary = ?, HireDate = ?, EndDate = ?, Status = ?\n"
                                + "WHERE InstructorID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, firstName);
                        ps.setString(2, lastName);
                        ps.setString(3, email);
                        ps.setString(4, phone);
                        ps.setString(5, address);
                        ps.setString(6, dob);
                        ps.setString(7, gender);
                        ps.setDouble(8, Double.parseDouble(salary));
                        ps.setString(9, hireDate);
                        ps.setString(10, endDate);
                        ps.setString(11, status);
                        ps.setString(12, instructorID);

                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public int getTotalInstructorNumber() {
                String query = "select count(InstructorID) as Total from Instructor";
                try {
                        int total = 0;
                        conn = new DBContext().getConnection();
                        ps = conn.prepareStatement(query);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                total = rs.getInt("Total");
                                return total;
                        }
                } catch (Exception e) {
                        System.out.println(e);
                }
                return 0;
        }
}
