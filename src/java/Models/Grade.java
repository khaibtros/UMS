package Models;

public class Grade {

        private int gradeID;
        private int enrollmentID;
        private int studentID;
        private String courseName;
        private double assignment;
        private double midterm;
        private double finalExam;
        private double total;

        public Grade() {
        }

        public Grade(int gradeID, int enrollmentID, int studentID, String courseName, double assignment, double midterm, double finalExam, double total) {
                this.gradeID = gradeID;
                this.enrollmentID = enrollmentID;
                this.studentID = studentID;
                this.courseName = courseName;
                this.assignment = assignment;
                this.midterm = midterm;
                this.finalExam = finalExam;
                this.total = total;
        }

        public int getGradeID() {
                return gradeID;
        }

        public void setGradeID(int gradeID) {
                this.gradeID = gradeID;
        }

        public int getEnrollmentID() {
                return enrollmentID;
        }

        public void setEnrollmentID(int enrollmentID) {
                this.enrollmentID = enrollmentID;
        }

        public int getStudentID() {
                return studentID;
        }

        public void setStudentID(int studentID) {
                this.studentID = studentID;
        }

        public String getCourseName() {
                return courseName;
        }

        public void setCourseName(String courseName) {
                this.courseName = courseName;
        }

        public double getAssignment() {
                return assignment;
        }

        public void setAssignment(double assignment) {
                this.assignment = assignment;
        }

        public double getMidterm() {
                return midterm;
        }

        public void setMidterm(double midterm) {
                this.midterm = midterm;
        }

        public double getFinalExam() {
                return finalExam;
        }

        public void setFinalExam(double finalExam) {
                this.finalExam = finalExam;
        }

        public double getTotal() {
                return total;
        }

        public void setTotal(double total) {
                this.total = total;
        }

}
