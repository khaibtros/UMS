package Models;

import java.util.Date;

public class Announcement {
    private int announcementID;
    private int adminID;
    private String title;
    private String content;
    private Date datePosted;

    public Announcement(int announcementID, int adminID, String title, String content, Date datePosted) {
        this.announcementID = announcementID;
        this.adminID = adminID;
        this.title = title;
        this.content = content;
        this.datePosted = datePosted;
    }

    public int getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementID = announcementID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
}
