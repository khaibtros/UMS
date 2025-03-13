package DAO;

import Models.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

        private DBContext db = new DBContext();

        public List<Attendance> getAllAttendanceByLessonID(int lessonID) {
                List<Attendance> attendanceList = new ArrayList<>();
                String sql = "SELECT * FROM Attendance WHERE LessonID = ?";

                try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                        stmt.setInt(1, lessonID);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                                Attendance attendance = new Attendance(
                                        rs.getInt("AttendanceID"),
                                        rs.getInt("StudentID"),
                                        rs.getInt("LessonID"),
                                        rs.getString("Status")
                                );
                                attendanceList.add(attendance);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return attendanceList;
        }

        public Attendance getStudentAttendanceByLessonID(int lessonId, int studentId) {
                String sql = "SELECT * FROM Attendance WHERE LessonID = ? AND StudentID = ?";

                try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                        stmt.setInt(1, lessonId);
                        stmt.setInt(2, studentId);

                        try (ResultSet rs = stmt.executeQuery()) {
                                if (rs.next()) {
                                        return new Attendance(
                                                rs.getInt("AttendanceID"),
                                                rs.getInt("StudentID"),
                                                rs.getInt("LessonID"),
                                                rs.getString("Status")
                                        );
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null; // Trả về null nếu không tìm thấy
        }

        public void updateAttendanceStatus(int attendanceID, String status) {
                String sql = "UPDATE Attendance SET Status = ? WHERE AttendanceID = ?";
                try (Connection conn = new DBContext().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, status);
                        ps.setInt(2, attendanceID);

                        ps.executeUpdate();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
