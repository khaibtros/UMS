package Controllers.Admin;

import DAO.LessonDAO;
import Models.Lesson;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddLessonsServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                // Lấy dữ liệu từ form (Đảm bảo name trong form phải khớp)
                int lessonId = Integer.parseInt(request.getParameter("lessonId"));
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                int classId = Integer.parseInt(request.getParameter("classId"));
                int instructorId = Integer.parseInt(request.getParameter("instructorId"));
                int roomId = Integer.parseInt(request.getParameter("roomId"));
                Date date = Date.valueOf(request.getParameter("date")); 
                String dayOfWeek = request.getParameter("dayOfWeek");
                String startTimeStr = request.getParameter("startTime") + ":00";
                String endTimeStr = request.getParameter("endTime") + ":00";
                Time startTime = Time.valueOf(startTimeStr);
                Time endTime = Time.valueOf(endTimeStr);
                String content = request.getParameter("content");

                // Gọi DAO để thêm bài học
                LessonDAO lessonDAO = new LessonDAO();
                lessonDAO.addLesson(lessonId, courseId, classId, instructorId, roomId, date, dayOfWeek, startTime, endTime, content);

                response.sendRedirect("lessons");
        }
}
