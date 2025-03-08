package DAO;

import java.math.BigDecimal;
import Models.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        public List<Course> getAllCourses() {
                List<Course> lstCourse = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Course";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int id = rs.getInt("CourseID");
                                String name = rs.getString("Name");
                                String code = rs.getString("Code");
                                String desc = rs.getString("Description");
                                int majorID = rs.getInt("MajorID");
                                int semID = rs.getInt("SemesterID");
                                Double fee = rs.getDouble("FeeAmount");

                                Course cr = new Course(id, name, code, desc, majorID, semID, fee);
                                lstCourse.add(cr);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstCourse;
        }

        // Add a new course
        public void addCourse(String courseId, String courseName, String courseCode, String courseDescription,
                String semesterId, String feeAmount) {
                DBContext db = new DBContext();
                String sql = "INSERT INTO Course (CourseID, Name, Code, Description, SemesterID, FeeAmount)\n"
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, courseId);           // Set CourseID
                        ps.setString(2, courseName);         // Set Name
                        ps.setString(3, courseCode);         // Set Code
                        ps.setString(4, courseDescription);  // Set Description
                        ps.setInt(5, Integer.parseInt(semesterId)); // Parse SemesterID as INT
                        ps.setBigDecimal(6, new java.math.BigDecimal(feeAmount)); // Set FeeAmount
                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        // Delete a course
        public void deleteCourse(String courseId) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Course WHERE CourseID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, courseId);
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        // Update course information
        public void updateCourse(String courseId, String courseName, String courseCode, String courseDescription,
                String semesterId, String feeAmount) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "UPDATE Course\n"
                                + "SET Name = ?, Code = ?, Description = ?, SemesterID = ?, FeeAmount = ?\n"
                                + "WHERE CourseID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, courseName);         // Set Name
                        ps.setString(2, courseCode);         // Set Code
                        ps.setString(3, courseDescription);  // Set Description
                        ps.setInt(4, Integer.parseInt(semesterId)); // Parse SemesterID as INT
                        ps.setBigDecimal(5, new java.math.BigDecimal(feeAmount)); // Set FeeAmount
                        ps.setString(6, courseId);           // Set CourseID
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
}
