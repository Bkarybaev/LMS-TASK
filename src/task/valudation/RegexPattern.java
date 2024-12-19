package task.valudation;

import java.util.regex.Pattern;

public class RegexPattern {

    public static boolean emailPattern(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean passwordPattern(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&!+=]).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

}
