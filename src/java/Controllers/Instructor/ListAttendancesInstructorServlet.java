/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Instructor;

import DAO.AttendanceDAO;
import DAO.EnrollmentDAO;
import Models.Attendance;
import Models.Enrollment;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ListAttendancesInstructorServlet extends HttpServlet {
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet ListAttendancesServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet ListAttendancesServlet at " + request.getContextPath() + "</h1>");
                        out.println("</body>");
                        out.println("</html>");
                }
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                String lessonIdStr = request.getParameter("lessonId");

                if (lessonIdStr != null && !lessonIdStr.isEmpty()) {
                        int lessonId = Integer.parseInt(lessonIdStr);
                        AttendanceDAO attendanceDAO = new AttendanceDAO();
                        List<Attendance> listAttendance = attendanceDAO.getAllAttendanceByLessonID(lessonId);

                        request.setAttribute("listAttendance", listAttendance);

                        request.getRequestDispatcher("attendances.jsp").forward(request, response);
                }
        }
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                processRequest(request, response);
        }

        @Override
        public String getServletInfo() {
                return "Short description";
        }// </editor-fold>

}
