/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hd
 */
public class Utils {

    public static final int MIN = 0;
    public static final int MAX = 3000;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
//    kiểm tra id phải có định dạng sau: 8 ký tự, 2 ký tự đầu là mã vùng( SE, HE, DE, QE, CE ), 6 ký tự cuối là số

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

//kiểm tra định dạng email
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String updateString(String welcome, String oldData) {
        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static int updateInt(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = Utils.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }
}
