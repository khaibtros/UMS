package DAO;

import Models.Lesson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LessonDAO {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        public List<Lesson> getAllLessons() {
                List<Lesson> lstLesson = new ArrayList<>();
                DBContext db = new DBContext();
                try {
                        conn = db.getConnection();
                        String sql = "SELECT * FROM Lesson";
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                int id = rs.getInt("LessonID");
                                int courseId = rs.getInt("CourseID");
                                int classId = rs.getInt("ClassID");
                                int instructorId = rs.getInt("InstructorID");
                                int roomId = rs.getInt("RoomID");
                                Date date = rs.getDate("Date");
                                String dayOfWeek = rs.getString("DayOfWeek");
                                Time startTime = rs.getTime("StartTime");
                                Time endTime = rs.getTime("EndTime");
                                String content = rs.getString("Content");

                                Lesson lesson = new Lesson(id, courseId, classId, instructorId, roomId, date, dayOfWeek, startTime, endTime, content);
                                lstLesson.add(lesson);
                        }
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return lstLesson;
        }

        public void deleteLesson(int lessonId) {
                DBContext db = new DBContext();
                String deleteAttendanceSQL = "DELETE FROM Attendance WHERE LessonID=?";
                String deleteLessonSQL = "DELETE FROM Lesson WHERE LessonID=?";

                try (Connection conn = db.getConnection()) {
                        conn.setAutoCommit(false); // Bắt đầu transaction

                        // 1️⃣ Xóa tất cả điểm danh liên quan đến bài học
                        try (PreparedStatement ps = conn.prepareStatement(deleteAttendanceSQL)) {
                                ps.setInt(1, lessonId);
                                ps.executeUpdate();
                        }

                        // 2️⃣ Xóa bài học
                        try (PreparedStatement ps = conn.prepareStatement(deleteLessonSQL)) {
                                ps.setInt(1, lessonId);
                                int rowsDeleted = ps.executeUpdate();
                                if (rowsDeleted > 0) {
                                        System.out.println("Lesson deleted successfully.");
                                } else {
                                        System.out.println("No matching lesson found.");
                                }
                        }

                        conn.commit(); // Lưu thay đổi nếu không có lỗi
                } catch (Exception ex) {
                        Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void addLesson(int lessonId, int courseId, int classId, int instructorId, int roomId, Date date, String dayOfWeek, Time startTime, Time endTime, String content) {
                DBContext db = new DBContext();

                String insertLessonSQL = "INSERT INTO Lesson (LessonID, CourseID, ClassID, InstructorID, RoomID, Date, DayOfWeek, StartTime, EndTime, Content) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                String selectStudentsSQL = "SELECT StudentID FROM StudentClass WHERE ClassID = ?";
                String insertAttendanceSQL = "INSERT INTO Attendance (StudentID, LessonID, Status) VALUES (?, ?, 'Present')";

                try (Connection conn = db.getConnection()) {
                        conn.setAutoCommit(false); // Bắt đầu transaction

                        // 1️⃣ Thêm bài học vào bảng Lesson
                        try (PreparedStatement psLesson = conn.prepareStatement(insertLessonSQL)) {
                                psLesson.setInt(1, lessonId);
                                psLesson.setInt(2, courseId);
                                psLesson.setInt(3, classId);
                                psLesson.setInt(4, instructorId);
                                psLesson.setInt(5, roomId);
                                psLesson.setDate(6, date);
                                psLesson.setString(7, dayOfWeek);
                                psLesson.setTime(8, startTime);
                                psLesson.setTime(9, endTime);
                                psLesson.setString(10, content);
                                psLesson.executeUpdate();
                        }

                        // 2️⃣ Lấy danh sách sinh viên từ StudentClass
                        try (PreparedStatement psStudents = conn.prepareStatement(selectStudentsSQL)) {
                                psStudents.setInt(1, classId);
                                try (ResultSet rs = psStudents.executeQuery()) {

                                        // 3️⃣ Thêm điểm danh cho từng sinh viên
                                        while (rs.next()) {
                                                int studentId = rs.getInt("StudentID");

                                                try (PreparedStatement psAttendance = conn.prepareStatement(insertAttendanceSQL)) {
                                                        psAttendance.setInt(1, studentId);
                                                        psAttendance.setInt(2, lessonId);
                                                        psAttendance.executeUpdate();
                                                }
                                        }
                                }
                        }

                        conn.commit(); // Commit transaction nếu mọi thứ thành công
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        public void updateLesson(int lessonID, int courseID, int classID, int instructorID, int roomID,
                Date date, String dayOfWeek, Time startTime, Time endTime, String content) {
                DBContext db = new DBContext();

                String updateLessonSQL = "UPDATE Lesson SET CourseID=?, ClassID=?, InstructorID=?, RoomID=?, Date=?, "
                        + "DayOfWeek=?, StartTime=?, EndTime=?, Content=? WHERE LessonID=?";
                String deleteAttendanceSQL = "DELETE FROM Attendance WHERE LessonID=?";
                String selectStudentsSQL = "SELECT StudentID FROM StudentClass WHERE ClassID=?";
                String insertAttendanceSQL = "INSERT INTO Attendance (StudentID, LessonID, Status) VALUES (?, ?, 'Present')";

                try (Connection conn = db.getConnection()) {
                        conn.setAutoCommit(false); // Bắt đầu transaction

                        // 1️⃣ Cập nhật thông tin bài học
                        try (PreparedStatement stmt = conn.prepareStatement(updateLessonSQL)) {
                                stmt.setInt(1, courseID);
                                stmt.setInt(2, classID);
                                stmt.setInt(3, instructorID);
                                stmt.setInt(4, roomID);
                                stmt.setDate(5, date);
                                stmt.setString(6, dayOfWeek);
                                stmt.setTime(7, startTime);
                                stmt.setTime(8, endTime);
                                stmt.setString(9, content);
                                stmt.setInt(10, lessonID);
                                stmt.executeUpdate();
                        }

                        // 2️⃣ Xóa danh sách điểm danh cũ của bài học
                        try (PreparedStatement stmt = conn.prepareStatement(deleteAttendanceSQL)) {
                                stmt.setInt(1, lessonID);
                                stmt.executeUpdate();
                        }

                        // 3️⃣ Lấy danh sách sinh viên từ `StudentClass` cho `ClassID` mới
                        try (PreparedStatement stmt = conn.prepareStatement(selectStudentsSQL)) {
                                stmt.setInt(1, classID);
                                try (ResultSet rs = stmt.executeQuery()) {
                                        while (rs.next()) {
                                                int studentId = rs.getInt("StudentID");

                                                // 4️⃣ Thêm mới danh sách điểm danh
                                                try (PreparedStatement insertStmt = conn.prepareStatement(insertAttendanceSQL)) {
                                                        insertStmt.setInt(1, studentId);
                                                        insertStmt.setInt(2, lessonID);
                                                        insertStmt.executeUpdate();
                                                }
                                        }
                                }
                        }

                        conn.commit(); // Lưu thay đổi nếu không có lỗi
                        System.out.println("Lesson and attendance updated successfully.");
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        public int getBottomId() {
                int id = 0;
                String query = "select top 1 id from Lesson\n"
                        + "order by id desc";
                try {
                        conn = new DBContext().getConnection();
                        ps = conn.prepareStatement(query);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                                id = rs.getInt("id");
                        }
                } catch (Exception e) {
                        System.out.println(e);
                }
                return id;
        }
}
