package DAO;

import DAO.DBContext;
import Models.Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Retrieve all classes
        public List<Class> getAllClasses() {
                List<Class> classList = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Class";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int classID = rs.getInt("ClassID");
                                String name = rs.getString("Name");
                                int majorID = rs.getInt("MajorID");
                                int semesterID = rs.getInt("SemesterID");
                                int capacity = rs.getInt("Capacity");
                                String status = rs.getString("Status");

                                Class cl = new Class(classID, name, majorID, semesterID, capacity, status);
                                classList.add(cl);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return classList;
        }

        // Add a new class
        public void addNewClass(String name, int majorID, int capacity, String status) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "INSERT INTO Class (Name, MajorID, Capacity, Status) VALUES (?, ?, ?, ?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, name);
                        ps.setInt(2, majorID);
                        ps.setInt(3, capacity);
                        ps.setString(4, status);

                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        // Delete a class by ID
        public void deleteClass(int classID) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Class WHERE ClassID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, classID);

                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        // Update class details
        public void updateClass(int classID, String name, int majorID, int capacity, String status) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "UPDATE Class SET Name = ?, MajorID = ?, Capacity = ?, Status = ? WHERE ClassID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, name);
                        ps.setInt(2, majorID);
                        ps.setInt(3, capacity);
                        ps.setString(4, status);
                        ps.setInt(5, classID);

                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public String getClassNameByClassId(int classID) {
                DBContext db = new DBContext();
                String className = null;
                try {
                        conn = db.getConnection();
                        String sql = "SELECT Name FROM Class WHERE ClassID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, classID);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                                className = rs.getString("Name");
                        }
                } catch (Exception ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return className;
        }
}
