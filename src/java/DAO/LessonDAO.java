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

    public void addNewLesson(int courseId, int classId, int instructorId, int roomId, Date date, String dayOfWeek, Time startTime, Time endTime, String content) {
        DBContext db = new DBContext();
        String sql = "INSERT INTO Lesson (CourseID, ClassID, InstructorID, RoomID, Date, DayOfWeek, StartTime, EndTime, Content) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ps.setInt(2, classId);
            ps.setInt(3, instructorId);
            ps.setInt(4, roomId);
            ps.setDate(5, date);
            ps.setString(6, dayOfWeek);
            ps.setTime(7, startTime);
            ps.setTime(8, endTime);
            ps.setString(9, content);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
