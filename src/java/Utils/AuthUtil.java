//package Utils;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import Models.User;
//
//public class AuthUtil {
//
//    // Kiểm tra xem người dùng đã đăng nhập hay chưa
//    public static boolean isAuthenticated(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        return session != null && session.getAttribute("user") != null;
//    }
//
//    // Lấy thông tin người dùng hiện tại từ session
//    public static User getCurrentUser(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            return (User) session.getAttribute("user");
//        }
//        return null;
//    }
//
//    // Kiểm tra xem người dùng có vai trò phù hợp không
//    public static boolean hasRole(HttpServletRequest request, String requiredRole) {
//        User user = getCurrentUser(request);
//        return user != null && user.getRole().equalsIgnoreCase(requiredRole);
//    }
//
//    // Đăng nhập người dùng, lưu thông tin vào session
//    public static void loginUser(HttpServletRequest request, User user) {
//        HttpSession session = request.getSession();
//        session.setAttribute("user", user);
//    }
//
//    // Đăng xuất người dùng, xóa session
//    public static void logoutUser(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//    }
//}
