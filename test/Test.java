
import DAO.GradeDAO;
import Models.Grade;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class Test {
    public static void main(String[] args) {
        GradeDAO gradeDAO = new GradeDAO();
        List<Grade> grades = gradeDAO.getAllGradesByInstructorId(3);

        // In danh sách điểm ra màn hình
        for (Grade grade : grades) {
            System.out.println(grade);
        }
    }
}
