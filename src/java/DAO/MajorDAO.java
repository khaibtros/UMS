package DAO;

import Models.Major;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MajorDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Retrieve all majors
    public List<Major> getAllMajors() {
        List<Major> majorList = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM Major";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int majorID = rs.getInt("MajorID");
                String majorCode = rs.getString("MajorCode");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int totalSemester = rs.getInt("TotalSemester");

                Major major = new Major(majorID, majorCode, name, description, totalSemester);
                majorList.add(major);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return majorList;
    }

    // Add a new major
    public void addNewMajor(String majorCode, String name, String description, int totalSemester) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "INSERT INTO Major (MajorCode, Name, Description, TotalSemester) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, majorCode);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setInt(4, totalSemester);

            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Delete a major by ID
    public void deleteMajor(int majorID) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "DELETE FROM Major WHERE MajorID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, majorID);

            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Update major details
    public void updateMajor(int majorID, String majorCode, String name, String description, int totalSemester) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "UPDATE Major SET MajorCode = ?, Name = ?, Description = ?, TotalSemester = ? WHERE MajorID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, majorCode);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setInt(4, totalSemester);
            ps.setInt(5, majorID);

            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
