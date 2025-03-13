package DAO;

import DAO.DBContext;
import Models.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Retrieve all rooms
        public List<Room> getAllRooms() {
                List<Room> roomList = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Room";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int roomID = rs.getInt("RoomID");
                                String name = rs.getString("Name");
                                String type = rs.getString("Type");
                                int capacity = rs.getInt("Capacity");
                                String status = rs.getString("Status");

                                Room room = new Room(roomID, name, type, capacity, status);
                                roomList.add(room);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return roomList;
        }

        // Add a new room
        public void addNewRoom(String name, String type, int capacity, String status) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "INSERT INTO Room (Name, Type, Capacity, Status) VALUES (?, ?, ?, ?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, name);
                        ps.setString(2, type);
                        ps.setInt(3, capacity);
                        ps.setString(4, status);

                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        // Delete a room by ID
        public void deleteRoom(int roomID) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Room WHERE RoomID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, roomID);

                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        // Update room details
        public void updateRoom(int roomID, String name, String type, int capacity, String status) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "UPDATE Room SET Name = ?, Type = ?, Capacity = ?, Status = ? WHERE RoomID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, name);
                        ps.setString(2, type);
                        ps.setInt(3, capacity);
                        ps.setString(4, status);
                        ps.setInt(5, roomID);

                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public String getRoomNameByRoomId(int roomID) {
                DBContext db = new DBContext();
                String roomName = null;
                try {
                        conn = db.getConnection();
                        String sql = "SELECT Name FROM Room WHERE RoomID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, roomID);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                                roomName = rs.getString("Name");
                        }
                } catch (Exception ex) {
                        Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return roomName;
        }
}
