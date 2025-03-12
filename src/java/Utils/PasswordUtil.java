package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {

    // Tạo một salt ngẫu nhiên cho mật khẩu
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Băm mật khẩu bằng SHA-256 kết hợp với salt
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedPassword = md.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    // Kiểm tra mật khẩu nhập vào có đúng không
    public static boolean verifyPassword(String inputPassword, String storedHash, String storedSalt) {
        String inputHash = hashPassword(inputPassword, storedSalt);
        return storedHash.equals(inputHash);
    }

    public static void main(String[] args) {
        // Tạo mật khẩu và salt
        String password = "SecurePassword123";
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);

        System.out.println("Salt: " + salt);
        System.out.println("Hashed Password: " + hashedPassword);

        // Kiểm tra mật khẩu
        boolean isMatch = verifyPassword("SecurePassword123", hashedPassword, salt);
        System.out.println("Password Match: " + isMatch);
    }
}
