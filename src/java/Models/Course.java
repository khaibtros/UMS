package Models;

public class Course {
    private int courseID;
    private String name;
    private String code;
    private String description;
    private int majorID;
    private int semesterID;
    private double feeAmount;

    public Course(int courseID, String name, String code, String description, int majorID, int semesterID, double feeAmount) {
        this.courseID = courseID;
        this.name = name;
        this.code = code;
        this.description = description;
        this.majorID = majorID;
        this.semesterID = semesterID;
        this.feeAmount = feeAmount;
    }

        public int getCourseID() {
                return courseID;
        }

        public void setCourseID(int courseID) {
                this.courseID = courseID;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getMajorID() {
                return majorID;
        }

        public void setMajorID(int majorID) {
                this.majorID = majorID;
        }

        public int getSemesterID() {
                return semesterID;
        }

        public void setSemesterID(int semesterID) {
                this.semesterID = semesterID;
        }

        public double getFeeAmount() {
                return feeAmount;
        }

        public void setFeeAmount(double feeAmount) {
                this.feeAmount = feeAmount;
        }
    
    
    
    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", majorID=" + majorID +
                ", semesterID=" + semesterID +
                ", feeAmount=" + feeAmount +
                '}';
    }
}
