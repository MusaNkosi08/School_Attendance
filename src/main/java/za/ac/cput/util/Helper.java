package za.ac.cput.util;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidCemisNumber(String cemisNumber) {
        return cemisNumber.matches("^\\d{13}$");
    }
}
