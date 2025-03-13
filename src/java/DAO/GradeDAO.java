package DAO;

import Models.Grade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GradeDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        public List<Grade> getAllGrades() {
                List<Grade> lstGrade = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Grade";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int gradeID = rs.getInt("GradeID");
                                int enrollmentID = rs.getInt("EnrollmentID");
                                double assignment = rs.getDouble("Assignment");
                                double midterm = rs.getDouble("Midterm");
                                double finalExam = rs.getDouble("Final");
                                double total = rs.getDouble("Total");
                                int studentID = rs.getInt("StudentID");
                                String courseName = rs.getString("CourseName");

                                Grade gr = new Grade(gradeID, enrollmentID, studentID, courseName, assignment, midterm, finalExam, total);
                                lstGrade.add(gr);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstGrade;
        }

        public List<Grade> getAllGradesByInstructorId(int instructorId) {
                List<Grade> lstGrade = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT g.GradeID, g.EnrollmentID, g.Assignment, g.Midterm, g.Final, g.Total, "
                                + "e.StudentID, c.Name "
                                + "FROM Grade g "
                                + "JOIN Enrollment e ON g.EnrollmentID = e.EnrollmentID "
                                + "JOIN CourseInstructor ci ON e.CourseID = ci.CourseID "
                                + "JOIN Course c ON c.CourseID = ci.CourseID "
                                + "WHERE ci.InstructorID = ?";

                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, instructorId);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int gradeID = rs.getInt("GradeID");
                                int enrollmentID = rs.getInt("EnrollmentID");
                                double assignment = rs.getDouble("Assignment");
                                double midterm = rs.getDouble("Midterm");
                                double finalExam = rs.getDouble("Final");
                                double total = rs.getDouble("Total");
                                int studentID = rs.getInt("StudentID");
                                String courseName = rs.getString("Name");

                                Grade grade = new Grade(gradeID, enrollmentID, studentID, courseName, assignment, midterm, finalExam, total);
                                lstGrade.add(grade);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstGrade;
        }

        public void deleteGrade(String grID) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Grade WHERE GradeID=?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, grID);
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void addNewGrade(String grID, String enID, String assignment, String midterm, String finalExam, String total) {
                DBContext db = new DBContext();
                String sql = "INSERT INTO Grade VALUES (?, ?, ?, ?, ?, ?)";
                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, grID);
                        ps.setString(2, enID);
                        ps.setDouble(3, Double.parseDouble(assignment));
                        ps.setDouble(4, Double.parseDouble(midterm));
                        ps.setDouble(5, Double.parseDouble(finalExam));
                        ps.setDouble(6, Double.parseDouble(total));
                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void updateGrade(int gradeId, double assignment, double midterm, double finalExam) {
                DBContext db = new DBContext();
                String sql = "UPDATE Grade SET Assignment = ?, Midterm = ?, Final = ? WHERE GradeID = ?";

                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

                        ps.setDouble(1, assignment);
                        ps.setDouble(2, midterm);
                        ps.setDouble(3, finalExam);
                        ps.setInt(4, gradeId); // GradeID is an int

                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, "Error updating grade", ex);
                }
        }
}
