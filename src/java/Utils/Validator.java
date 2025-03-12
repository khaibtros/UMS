package Utils;

import java.util.regex.Pattern;

public class Validator {
    
    // Regex mẫu để kiểm tra email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // Kiểm tra email hợp lệ
    public static boolean isValidEmail(String email) {
        return email != null && Pattern.matches(EMAIL_REGEX, email);
    }

    // Kiểm tra số nguyên hợp lệ (ví dụ: ID, số lượng, v.v.)
    public static boolean isValidInteger(String number) {
        if (number == null) return false;
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Kiểm tra điểm hợp lệ (0 - 100)
    public static boolean isValidGrade(String grade) {
        if (!isValidInteger(grade)) return false;
        int score = Integer.parseInt(grade);
        return score >= 0 && score <= 100;
    }

    // Kiểm tra mật khẩu có đủ mạnh không (tối thiểu 8 ký tự, chứa chữ cái và số)
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8 && password.matches(".*[A-Za-z].*") && password.matches(".*\\d.*");
    }

    // Kiểm tra tên hợp lệ (chỉ chứa chữ cái, dấu cách)
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-zÀ-Ỹà-ỹ\\s]+$");
    }

    // Kiểm tra trạng thái hợp lệ (ví dụ: "Pending", "Approved", "Rejected")
    public static boolean isValidStatus(String status, String[] validStatuses) {
        if (status == null) return false;
        for (String valid : validStatuses) {
            if (status.equalsIgnoreCase(valid)) return true;
        }
        return false;
    }
}
