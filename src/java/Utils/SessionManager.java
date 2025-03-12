package Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import Models.User;

public class SessionManager {
    
    private static final String USER_SESSION_KEY = "loggedUser";

    // Lưu thông tin user vào session
    public static void createSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_SESSION_KEY, user);
    }

    // Lấy thông tin user từ session
    public static User getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (User) session.getAttribute(USER_SESSION_KEY);
        }
        return null;
    }

    // Kiểm tra xem user đã đăng nhập chưa
    public static boolean isUserLoggedIn(HttpServletRequest request) {
        return getSessionUser(request) != null;
    }

    // Xóa session (logout)
    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
