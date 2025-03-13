package Models;

import java.util.Date;
import java.sql.Time;

public class Lesson {
        private int lessonID;
        private int courseID;
        private int classID;
        private int instructorID;
        private int roomID;
        private Date date;
        private String dayOfWeek;
        private Time startTime;
        private Time endTime;
        private String content;

        public Lesson(int lessonID, int courseID, int classID, int instructorID, int roomID, Date date, String dayOfWeek, Time startTime, Time endTime, String content) {
                this.lessonID = lessonID;
                this.courseID = courseID;
                this.classID = classID;
                this.instructorID = instructorID;
                this.roomID = roomID;
                this.date = date;
                this.dayOfWeek = dayOfWeek;
                this.startTime = startTime;
                this.endTime = endTime;
                this.content = content;
        }
        
        public int getLessonID() {
                return lessonID;
        }

        public void setLessonID(int lessonID) {
                this.lessonID = lessonID;
        }

        public int getCourseID() {
                return courseID;
        }

        public void setCourseID(int courseID) {
                this.courseID = courseID;
        }

        public int getClassID() {
                return classID;
        }

        public void setClassID(int classID) {
                this.classID = classID;
        }

        public int getInstructorID() {
                return instructorID;
        }

        public void setInstructorID(int instructorID) {
                this.instructorID = instructorID;
        }

        public int getRoomID() {
                return roomID;
        }

        public void setRoomID(int roomID) {
                this.roomID = roomID;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public String getDayOfWeek() {
                return dayOfWeek;
        }

        public void setDayOfWeek(String dayOfWeek) {
                this.dayOfWeek = dayOfWeek;
        }

        public Time getStartTime() {
                return startTime;
        }

        public void setStartTime(Time startTime) {
                this.startTime = startTime;
        }

        public Time getEndTime() {
                return endTime;
        }

        public void setEndTime(Time endTime) {
                this.endTime = endTime;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }
}
