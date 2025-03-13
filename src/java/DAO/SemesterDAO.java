/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package DAO;

import Models.Semester;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ManhTD
 */

public class SemesterDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Semester> getAllSemesters() {
        List<Semester> semesters = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM Semester";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int semesterID = rs.getInt("SemesterID");
                int semesterNum = rs.getInt("SemesterNum");
                int year = rs.getInt("Year");
                String description = rs.getString("Description");
                java.util.Date startDate = rs.getDate("StartDate");
                java.util.Date endDate = rs.getDate("EndDate");
                String status = rs.getString("Status");

                Semester semester = new Semester(semesterID, semesterNum, year, description, startDate, endDate, status);
                semesters.add(semester);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return semesters;
    }

    public void deleteSemester(String semesterID) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "DELETE FROM Semester WHERE SemesterID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, semesterID);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewSemester(String semesterID, String semesterNum, String year, String description, String startDate, String endDate, String status) {
        DBContext db = new DBContext();
        String sql = "INSERT INTO Semester VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, semesterID);
            ps.setString(2, semesterNum);
            ps.setString(3, year);
            ps.setString(4, description);
            ps.setString(5, startDate);
            ps.setString(6, endDate);
            ps.setString(7, status);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSemester(String SemesterID, String SemesterNum, String Year, String Description, String StartDate, String EndDate, String Status) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "UPDATE Semester SET SemesterNum = ?, Year = ?, Description = ?, StartDate = ?, EndDate = ?, Status = ? WHERE SemesterID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, SemesterNum);
            ps.setString(2, Year);
            ps.setString(3, Description);
            ps.setString(4, StartDate);
            ps.setString(5, EndDate);
            ps.setString(6, Status);
            ps.setString(7, SemesterID);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
