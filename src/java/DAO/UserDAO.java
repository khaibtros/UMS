/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duy Thai
 */
public class UserDAO extends DBContext {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        public User checkLogin(String email, String password) {
                try {
                        String query = "SELECT * FROM Users WHERE email = ?";
                        conn = new DBContext().getConnection();
                        ps = conn.prepareStatement(query);
                        ps.setString(1, email);
                        rs = ps.executeQuery();

                        if (rs.next()) {
                                String hashedPasswordFromDB = rs.getString("password");
                                String hashedInputPassword = md5Hash(password); // Hash mật khẩu nhập vào

                                if (hashedInputPassword.equalsIgnoreCase(hashedPasswordFromDB)) {
                                        return new User(
                                                rs.getInt("userId"),
                                                rs.getString("email"),
                                                rs.getString("password"),
                                                rs.getInt("roleId"),
                                                rs.getInt("statusId")
                                        );
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }

// Hàm mã hóa MD5
        private String md5Hash(String input) {
                try {
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        byte[] messageDigest = md.digest(input.getBytes());
                        StringBuilder hexString = new StringBuilder();
                        for (byte b : messageDigest) {
                                String hex = Integer.toHexString(0xff & b);
                                if (hex.length() == 1) {
                                        hexString.append('0');
                                }
                                hexString.append(hex);
                        }
                        return hexString.toString();
                } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                }
        }

        public boolean checkEmailExist(String email) {
                try {
                        String querry = "Select * from User where email=?";
                        conn = new DBContext().getConnection();
                        ps = conn.prepareStatement(querry);
                        ps.setString(1, email);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                                return true;
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return false;
        }

        public void changePassword(User u) throws Exception {

                String upd = "Update Users set password=?"
                        + " where email=?";
                try {
                        conn = new DBContext().getConnection();
                        PreparedStatement st = conn.prepareStatement(upd);
                        st.setString(1, u.getPassword());
                        st.setString(2, u.getEmail());
                        st.executeUpdate();
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }

        public void changePasswordWhenForget(String email, String password) throws Exception {

                String upd = "Update Users set password=?"
                        + " where email=?";
                try {
                        conn = new DBContext().getConnection();
                        PreparedStatement st = conn.prepareStatement(upd);
                        st.setString(1, password);
                        st.setString(2, email);
                        st.executeUpdate();
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }

        public boolean checkUserByEmail(String email) {
                try {
                        String query = "Select * from User where email = ?";
                        conn = new DBContext().getConnection();
                        ps = conn.prepareStatement(query);
                        ps.setString(1, email);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                return true;
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return false;
        }
}

