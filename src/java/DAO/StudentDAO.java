package DAO;

import Models.Student;
import Models.Class;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        DBContext db = new DBContext();

        public List<Student> getAllStudents() {
                List<Student> lstStudent = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT s.* FROM Student s ";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int id = rs.getInt("StudentID");
                                String fn = rs.getString("FirstName");
                                String ln = rs.getString("LastName");
                                String em = rs.getString("Email");
                                String ph = rs.getString("Phone");
                                String addr = rs.getString("Address");
                                Date dob = rs.getDate("DOB");
                                String gen = rs.getString("Gender");
                                int mjID = rs.getInt("MajorID");
                                Date sd = rs.getDate("StartDate");
                                Date gd = rs.getDate("GraduatedDate");
                                String gn = rs.getString("GuardianName");
                                String gp = rs.getString("GuardianPhone");

                                Student st = new Student(id, fn, ln, em, ph, addr, dob, gen, mjID, sd, gd, gn, gp);
                                lstStudent.add(st);
                        }

                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstStudent;
        }

        public void deleteStudent(String stdId) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Student WHERE StudentID=?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, stdId);
                        ps.executeUpdate();     //Dung executeUpdate() khi chi thay doi du lieu tren csdl           
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void addNewStudent(String stdID, String stdfName, String stdlName, String stdEmail, String stdPhone,
                String stdAddr, String stdDob, String stdGender, String stdMajorID,
                String stdSdate, String stdEdate, String stdGuarName, String stdGuarPhone) {
                DBContext db = new DBContext();
                String sql = "INSERT INTO Student\n"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, stdID);           // Set StudentID
                        ps.setString(2, stdfName);        // Set FirstName
                        ps.setString(3, stdlName);        // Set LastName
                        ps.setString(4, stdEmail);        // Set Email
                        ps.setString(5, stdPhone);        // Set Phone
                        ps.setString(6, stdAddr);         // Set Address
                        ps.setString(7, stdDob);          // Set DOB
                        ps.setString(8, stdGender);       // Set Gender
                        ps.setInt(9, Integer.parseInt(stdMajorID)); // Set MajorID (parsed as INT)
                        ps.setString(10, stdSdate);       // Set StartDate
                        ps.setString(11, stdEdate);       // Set GraduatedDate
                        ps.setString(12, stdGuarName);    // Set GuardianName
                        ps.setString(13, stdGuarPhone);   // Set GuardianPhone

                        ps.executeUpdate();
                } catch (Exception ex) {
                        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void updateStudent(String stdId, String stdfName, String stdlName, String stdEmail, String stdPhone,
                String stdAddr, String stdDob, String stdGender, String stdMajorID,
                String stdSdate, String stdEdate, String stdGuardianName, String stdGuardianPhone) {
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "UPDATE Student\n"
                                + "SET FirstName = ?, LastName = ?, Email = ?, Phone = ?, Address = ?, DOB = ?,\n"
                                + "    Gender = ?, MajorID = ?, StartDate = ?, GraduatedDate = ?,\n"
                                + "    GuardianName = ?, GuardianPhone = ?\n"
                                + "WHERE StudentID = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, stdfName);
                        ps.setString(2, stdlName);
                        ps.setString(3, stdEmail);
                        ps.setString(4, stdPhone);
                        ps.setString(5, stdAddr);
                        ps.setString(6, stdDob);
                        ps.setString(7, stdGender);
                        ps.setInt(8, Integer.parseInt(stdMajorID)); // Parse MajorID as an integer
                        ps.setString(9, stdSdate);
                        ps.setString(10, stdEdate);
                        ps.setString(11, stdGuardianName);
                        ps.setString(12, stdGuardianPhone);
                        ps.setString(13, stdId);
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public int getTotalStudentNumber() {
                String query = "select count(StudentID) as Total from Student";
                try {
                        int total = 0;
                        conn = new DBContext().getConnection();
                        ps = conn.prepareStatement(query);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                total = rs.getInt("Total");
                                return total;
                        }
                } catch (Exception e) {
                        System.out.println(e);
                }
                return 0;
        }
}
