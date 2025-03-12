package Models;

public class Request {
    private int id;
    private int senderId;   // ID người gửi yêu cầu
    private int receiverId; // ID người nhận yêu cầu
    private String type;    // Loại yêu cầu (ví dụ: "Retake Course", "Change Class", "Other")
    private String content; // Nội dung yêu cầu
    private String status;  // Trạng thái: "Pending", "Approved", "Rejected"

    public Request() {}

    public Request(int id, int senderId, int receiverId, String type, String content, String status) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.type = type;
        this.content = content;
        setStatus(status); // Đảm bảo giá trị hợp lệ
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equalsIgnoreCase("Pending") || status.equalsIgnoreCase("Approved") || status.equalsIgnoreCase("Rejected")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status must be 'Pending', 'Approved', or 'Rejected'");
        }
    }

    @Override
    public String toString() {
        return "Request{id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + 
               ", type='" + type + "', content='" + content + "', status='" + status + "'}";
    }
}
