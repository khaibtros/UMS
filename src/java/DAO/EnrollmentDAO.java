package DAO;

import Models.Enrollment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnrollmentDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        public List<Enrollment> getAllEnrollments() {
                List<Enrollment> lstEnrollment = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Enrollment";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int id = rs.getInt("EnrollmentID");
                                int stID = rs.getInt("StudentID");
                                int crID = rs.getInt("CourseID");
                                int semID = rs.getInt("SemesterID");
                                String st = rs.getString("Status");

                                Enrollment en = new Enrollment(id, stID, crID, semID, st);
                                lstEnrollment.add(en);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstEnrollment;
        }

        public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
                List<Enrollment> lstEnrollment = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Enrollment WHERE StudentID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, studentId);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int id = rs.getInt("EnrollmentID");
                                int stID = rs.getInt("StudentID");
                                int crID = rs.getInt("CourseID");
                                int semID = rs.getInt("SemesterID");
                                String st = rs.getString("Status");

                                Enrollment en = new Enrollment(id, stID, crID, semID, st);
                                lstEnrollment.add(en);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstEnrollment;
        }

        public void deleteEnrollment(String enID) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Enrollment WHERE EnrollmentID=?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, enID);
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void addNewEnrollment(String enID, String stID, String crID, String semID, String status) {
                DBContext db = new DBContext();
                String sql = "INSERT INTO Enrollment VALUES (?, ?, ?, ?, ?)";
                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, enID);
                        ps.setString(2, stID);
                        ps.setString(3, crID);
                        ps.setString(4, semID);
                        ps.setString(5, status);
                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void updateEnrollment(int enID, String stID) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "UPDATE Enrollment SET Status = ? WHERE EnrollmentID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, stID);
                        ps.setInt(2, enID);
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void updateStatusToNotPassed(int gradeId) {
                DBContext db = new DBContext();
                String sql = "UPDATE Enrollment SET Status = 'Not Passed' WHERE EnrollmentID = (SELECT EnrollmentID FROM Grade WHERE GradeID = ?)";

                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setInt(1, gradeId);
                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, "Error updating enrollment status", ex);
                }
        }
        
         public void updateStatusToPassed(int gradeId) {
                DBContext db = new DBContext();
                String sql = "UPDATE Enrollment SET Status = 'Passed' WHERE EnrollmentID = (SELECT EnrollmentID FROM Grade WHERE GradeID = ?)";

                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setInt(1, gradeId);
                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(EnrollmentDAO.class.getName()).log(Level.SEVERE, "Error updating enrollment status", ex);
                }
        }
}
