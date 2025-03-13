/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Instructor;

import DAO.LessonDAO;
import Models.Instructor;
import Models.Lesson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 *
 * @author User
 */
public class ListLessonsInstructorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<title>Servlet ListLessonInSemester</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListLessonInSemester at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();

        // Lấy instructor từ session
        Instructor instructor = (Instructor) session.getAttribute("instructor");

        if (instructor == null) {
            // Nếu không có instructor trong session, chuyển hướng hoặc thông báo lỗi
            response.sendRedirect(request.getContextPath() + "/login"); // Chuyển hướng về trang login nếu cần
            return;
        }

        int instructorId = instructor.getInstructorID(); // Lấy InstructorID

        // Gọi DAO để lấy danh sách lesson giảng viên dạy trong kỳ học này
        LessonDAO lessonDAO = new LessonDAO();
        List<Lesson> listLesson = lessonDAO.getLessonsByInstructorId(instructorId);

        // Lưu danh sách vào request và chuyển đến JSP để hiển thị
        request.setAttribute("listLesson", listLesson);
        request.getRequestDispatcher("lessons.jsp").forward(request, response);
    }
}
