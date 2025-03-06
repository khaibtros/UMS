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
                int id = rs.getInt("GradeID");
                int enID = rs.getInt("EnrollmentID");
                double asg = rs.getDouble("Assignment");
                double mid = rs.getDouble("Midterm");
                double fin = rs.getDouble("Final");
                double tot = rs.getDouble("Total");

                Grade gr = new Grade(id, enID, asg, mid, fin, tot);
                lstGrade.add(gr);
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

    public void updateGrade(String grID, String enID, String assignment, String midterm, String finalExam, String total) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "UPDATE Grade SET EnrollmentID = ?, Assignment = ?, Midterm = ?, Final = ?, Total = ? WHERE GradeID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, enID);
            ps.setDouble(2, Double.parseDouble(assignment));
            ps.setDouble(3, Double.parseDouble(midterm));
            ps.setDouble(4, Double.parseDouble(finalExam));
            ps.setDouble(5, Double.parseDouble(total));
            ps.setString(6, grID);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(GradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
