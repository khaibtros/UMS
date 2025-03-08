package Models;

public class Attendance {
    private int attendanceID;
    private int studentID;
    private int lessonID;
    private String status;

    public Attendance(int attendanceID, int studentID, int lessonID, String status) {
        this.attendanceID = attendanceID;
        this.studentID = studentID;
        this.lessonID = lessonID;
        this.status = status;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
