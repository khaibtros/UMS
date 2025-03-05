package Models;

public class Class {
    private int classID;
    private String name;
    private int majorID;
    private int capacity;
    private String status;

    public Class(int classID, String name, int majorID, int capacity, String status) {
        this.classID = classID;
        this.name = name;
        this.majorID = majorID;
        this.capacity = capacity;
        this.status = status;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMajorID() {
        return majorID;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
