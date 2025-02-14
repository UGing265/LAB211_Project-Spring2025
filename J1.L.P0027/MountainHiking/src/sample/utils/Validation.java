package sample.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sample.models.StudentMountain;

public class Validation {

    public static final int MIN = 0;
    public static final int MAX = 3000;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    public static boolean validStudentID(String id) {
        boolean check = false;
        try {
            if (id.length() == 8) {
                String campusCode = id.substring(0, 2);
                String last6Digits = id.substring(2, 8);
                if (campusCode.equalsIgnoreCase("SE") || campusCode.equalsIgnoreCase("HE") || campusCode.equalsIgnoreCase("DE")
                        || campusCode.equalsIgnoreCase("QE") || campusCode.equalsIgnoreCase("CE")) {
                    Integer.parseInt(last6Digits);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean isIdExists(List<StudentMountain> studentMountains, String id) {
        boolean check = false;
        for (StudentMountain sm : studentMountains) {
            if (sm.getStudent().getId().equalsIgnoreCase(id)) {
                check = true;
            }
        }
        return check;
    }

    public static boolean validName(String name) {
        boolean check = false;
        try {
            if (name.length() > 1 && name.length() < 20) {
                check = true;
            }
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean validPhone(String phone) {
        boolean check = false;
        try {
            if (phone.length() == 10) {
                Integer.parseInt(phone);
                check = true;
            }
        } catch (Exception e) {
        }
        return check;
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean isVaildIdCampus(String id) {
        boolean check = false;
        try {
            String campusCode = id.substring(0, 2);
            if (campusCode.length() == 2 && (campusCode.equalsIgnoreCase("CE") || campusCode.equalsIgnoreCase("DE")
                    || campusCode.equalsIgnoreCase("HE") || campusCode.equalsIgnoreCase("SE") || campusCode.equalsIgnoreCase("QE"))) {
                check = true;
            }
        } catch (Exception e) {
        }

        return check;
    }
}
