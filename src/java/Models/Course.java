package Models;

import java.math.BigDecimal;

public class Course {
    private int courseId;          // CourseID là kiểu int
    private String name;
    private String code;
    private String description;
    private int semesterId;
    private BigDecimal feeAmount;

    // Constructor
    public Course(int courseId, String name, String code, String description, int semesterId, BigDecimal feeAmount) {
        this.courseId = courseId;
        this.name = name;
        this.code = code;
        this.description = description;
        this.semesterId = semesterId;
        this.feeAmount = feeAmount;
    }

    // Default constructor
    public Course() {
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    // toString method
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", semesterId=" + semesterId +
                ", feeAmount=" + feeAmount +
                '}';
    }
}
