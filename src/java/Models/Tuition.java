package Models;

import java.util.Date;

public class Tuition {
    private int tuitionFeeID;
    private int studentID;
    private double amount;
    private Date dueDate;
    private String paymentMethod;
    private String paymentStatus;

    public Tuition(int tuitionFeeID, int studentID, double amount, Date dueDate, String paymentMethod, String paymentStatus) {
        this.tuitionFeeID = tuitionFeeID;
        this.studentID = studentID;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getTuitionFeeID() {
        return tuitionFeeID;
    }

    public void setTuitionFeeID(int tuitionFeeID) {
        this.tuitionFeeID = tuitionFeeID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
