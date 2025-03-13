/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Student;

import DAO.AttendanceDAO;
import DAO.EnrollmentDAO;
import Models.Attendance;
import Models.Enrollment;
import Models.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ListAttendancesStudentServlet extends HttpServlet {

        /**
         * Processes requests for both HTTP <code>GET</code> and
         * <code>POST</code> methods.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
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

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                String lessonIdStr = request.getParameter("lessonId");

                HttpSession session = request.getSession();

                // Lấy student từ session
                Student student = (Student) session.getAttribute("student");
                if (student == null) {
                        // Nếu không có student trong session, chuyển hướng về trang login
                        response.sendRedirect(request.getContextPath() + "/login");
                        return;
                }

                int studentId = student.getStudentId();

                if (lessonIdStr != null && !lessonIdStr.isEmpty()) {
                        int lessonId = Integer.parseInt(lessonIdStr);
                        AttendanceDAO attendanceDAO = new AttendanceDAO();
                        Attendance attendance = attendanceDAO.getStudentAttendanceByLessonID(lessonId, studentId);

                        request.setAttribute("attendance", attendance);

                        request.getRequestDispatcher("attendances.jsp").forward(request, response);
                }
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
                return "Short description";
        }// </editor-fold>

}
