package Models;
 
 public class Major {
     private int majorID;
     private String majorCode;
     private String name;
     private String description;
     private int totalSemester;
 
     public Major(int majorID, String majorCode, String name, String description, int totalSemester) {
         this.majorID = majorID;
         this.majorCode = majorCode;
         this.name = name;
         this.description = description;
         this.totalSemester = totalSemester;
     }
 
     public int getMajorID() {
         return majorID;
     }
 
     public void setMajorID(int majorID) {
         this.majorID = majorID;
     }
 
     public String getMajorCode() {
         return majorCode;
     }
 
     public void setMajorCode(String majorCode) {
         this.majorCode = majorCode;
     }
 
     public String getName() {
         return name;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     public String getDescription() {
         return description;
     }
 
     public void setDescription(String description) {
         this.description = description;
     }
 
     public int getTotalSemester() {
         return totalSemester;
     }
 
     public void setTotalSemester(int totalSemester) {
         this.totalSemester = totalSemester;
     }
 }