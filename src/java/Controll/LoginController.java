/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controll;
import DAO.InstructorDAO;
import DAO.StudentDAO;
import DAO.UserDAO;
import Models.Instructor;
import Models.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Models.User;
import jakarta.servlet.http.Cookie;

/**
 *
 * @author ADMIN
 */
//@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
                try {
                        UserDAO ud = new UserDAO();
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");
                        User u = ud.checkLogin(email, password);
                        if (u != null) {
                                HttpSession session = request.getSession();
                                session.setAttribute("users", u);

                                StudentDAO studentDAO = new StudentDAO();
                                Student student = studentDAO.getStudentByUserId(u.getUserId());

                                InstructorDAO instructorDAO = new InstructorDAO();
                                Instructor instructor = instructorDAO.getInstructorByUserId(u.getUserId());

                                if (student != null) {
                                        session.setAttribute("student", student);
                                }
                                if (instructor != null) {
                                        session.setAttribute("instructor", instructor);
                                }
                                response.sendRedirect(request.getContextPath() + "/home.jsp");
                        } else {
                                request.setAttribute("error", "Unable to login. Check your password or email address");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                } catch (Exception e) {
                }
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
