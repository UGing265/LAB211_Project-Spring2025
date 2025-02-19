package traditionalfeast.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtils {
  private static final Scanner scanner = new Scanner(System.in);
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
        boolean check = true;
        boolean result = false;
        do {
            try {
                String confirm = InputUtils.getString(welcome);
                if ("Y".equalsIgnoreCase(confirm)) {
                    result = true;
                    check = false;
                } else if ("N".equalsIgnoreCase(confirm)) {
                    result = false;
                    check = false;
                }

            } catch (Exception e) {
            }
        } while (check);
        return result;
    }
    
      public static String getPhoneNumber(String prompt) {
        String regex = "^(03|05|07|08|09)\\d{8}$";
        String phone;
        do {
            System.out.print(prompt);
            phone = scanner.nextLine().trim();
            if (!Pattern.matches(regex, phone)) {
                System.out.println("❌ Invalid phone number! Must be 10 digits and start with (03, 05, 07, 08, 09).");
            }
        } while (!Pattern.matches(regex, phone));
        return phone;
    }

    // ✅ Get valid email address (basic format check)
    public static String getEmail(String prompt) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String email;
        do {
            System.out.print(prompt);
            email = scanner.nextLine().trim();
            if (!Pattern.matches(regex, email)) {
                System.out.println("❌ Invalid email format! Example: user@example.com");
            }
        } while (!Pattern.matches(regex, email));
        return email;
    }
}
