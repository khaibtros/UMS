package DAO;

import Models.Tuition;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TuitionDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Tuition> getAllTuitionFees() {
        List<Tuition> lstTuitionFee = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM TuitionFee";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("TuitionFeeID");
                int studentId = rs.getInt("StudentID");
                double amount = rs.getDouble("Amount");
                Date dueDate = rs.getDate("DueDate");
                String paymentMethod = rs.getString("PaymentMethod");
                String paymentStatus = rs.getString("PaymentStatus");

                Tuition tuitionFee = new Tuition(id, studentId, amount, dueDate, paymentMethod, paymentStatus);
                lstTuitionFee.add(tuitionFee);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(TuitionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstTuitionFee;
    }

    public void deleteTuitionFee(int tuitionFeeId) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "DELETE FROM TuitionFee WHERE TuitionFeeID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tuitionFeeId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(TuitionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewTuitionFee(int studentId, double amount, Date dueDate, String paymentMethod, String paymentStatus) {
        DBContext db = new DBContext();
        String sql = "INSERT INTO TuitionFee (StudentID, Amount, DueDate, PaymentMethod, PaymentStatus) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setDouble(2, amount);
            ps.setDate(3, dueDate);
            ps.setString(4, paymentMethod);
            ps.setString(5, paymentStatus);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TuitionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
