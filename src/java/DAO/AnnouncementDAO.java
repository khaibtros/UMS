package DAO;

import Models.Announcement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnnouncementDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Announcement> getAllAnnouncements() {
        List<Announcement> lstAnnouncement = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM Announcement";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("AnnouncementID");
                int adminId = rs.getInt("AdminID");
                String title = rs.getString("Title");
                String content = rs.getString("Content");
                Date datePosted = rs.getDate("DatePosted");

                Announcement announcement = new Announcement(id, adminId, title, content, datePosted);
                lstAnnouncement.add(announcement);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AnnouncementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAnnouncement;
    }

    public void deleteAnnouncement(int announcementId) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "DELETE FROM Announcement WHERE AnnouncementID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, announcementId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AnnouncementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewAnnouncement(int adminId, String title, String content) {
        DBContext db = new DBContext();
        String sql = "INSERT INTO Announcement (AdminID, Title, Content) VALUES (?, ?, ?)";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, adminId);
            ps.setString(2, title);
            ps.setString(3, content);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AnnouncementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
