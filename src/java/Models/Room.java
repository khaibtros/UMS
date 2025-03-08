package Models;

public class Room {
    private int roomID;
    private String name;
    private String type;
    private int capacity;
    private String status;

    public Room(int roomID, String name, String type, int capacity, String status) {
        this.roomID = roomID;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.status = status;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
