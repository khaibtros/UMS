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
                try {
                        conn = db.getConnection();
                        String sql = "DELETE FROM Lesson WHERE LessonID=?";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, lessonId);
                        ps.executeUpdate();
                        conn.close();
                } catch (Exception ex) {
                        Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void addLesson(int lessonId, int courseId, int classId, int instructorId, int roomId, Date date, String dayOfWeek, Time startTime, Time endTime, String content) {
                DBContext db = new DBContext();
                String sql = "INSERT INTO Lesson (LessonID, CourseID, ClassID, InstructorID, RoomID, Date, DayOfWeek, StartTime, EndTime, Content) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setInt(1, lessonId);  // Thêm lessonId
                        ps.setInt(2, courseId);
                        ps.setInt(3, classId);
                        ps.setInt(4, instructorId);
                        ps.setInt(5, roomId);
                        ps.setDate(6, date);
                        ps.setString(7, dayOfWeek);
                        ps.setTime(8, startTime);
                        ps.setTime(9, endTime);
                        ps.setString(10, content);

                        ps.executeUpdate();
                } catch (Exception ex) {
                }
        }

        public void updateLesson(int lessonID, int courseID, int classID, int instructorID, int roomID,
                Date date, String dayOfWeek, Time startTime, Time endTime, String content) {
                DBContext db = new DBContext();
                String sql = "UPDATE Lesson SET CourseID=?, ClassID=?, InstructorID=?, RoomID=?, Date=?, "
                        + "DayOfWeek=?, StartTime=?, EndTime=?, Content=? WHERE LessonID=?";

                try (Connection conn = db.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setInt(1, courseID);
                        stmt.setInt(2, classID);
                        stmt.setInt(3, instructorID);
                        stmt.setInt(4, roomID);
                        stmt.setDate(5, date); // Corrected index
                        stmt.setString(6, dayOfWeek);
                        stmt.setTime(7, startTime);
                        stmt.setTime(8, endTime);
                        stmt.setString(9, content);
                        stmt.setInt(10, lessonID); // Corrected index

                        int rowsUpdated = stmt.executeUpdate();
                        if (rowsUpdated > 0) {
                                System.out.println("Lesson updated successfully.");
                        } else {
                                System.out.println("Lesson update failed. No matching lesson found.");
                        }
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
