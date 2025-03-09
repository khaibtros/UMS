package Models;
 
 import java.util.Date;
 
 public class Semester {
     private int semesterID;
     private int semesterNum;
     private int year;
     private String description;
     private Date startDate;
     private Date endDate;
     private String status;
 
     public Semester(int semesterID, int semesterNum, int year, String description, Date startDate, Date endDate, String status) {
         this.semesterID = semesterID;
         this.semesterNum = semesterNum;
         this.year = year;
         this.description = description;
         this.startDate = startDate;
         this.endDate = endDate;
         this.status = status;
     }
 
     public int getSemesterID() {
         return semesterID;
     }
 
     public void setSemesterID(int semesterID) {
         this.semesterID = semesterID;
     }
 
     public int getSemesterNum() {
         return semesterNum;
     }
 
     public void setSemesterNum(int semesterNum) {
         this.semesterNum = semesterNum;
     }
 
     public int getYear() {
         return year;
     }
 
     public void setYear(int year) {
         this.year = year;
     }
 
     public String getDescription() {
         return description;
     }
 
     public void setDescription(String description) {
         this.description = description;
     }
 
     public Date getStartDate() {
         return startDate;
     }
 
     public void setStartDate(Date startDate) {
         this.startDate = startDate;
     }
 
     public Date getEndDate() {
         return endDate;
     }
 
     public void setEndDate(Date endDate) {
         this.endDate = endDate;
     }
 
     public String getStatus() {
         return status;
     }
 
     public void setStatus(String status) {
         this.status = status;
     }
 }