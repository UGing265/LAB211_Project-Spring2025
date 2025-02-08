package sample.utils;

import java.util.Scanner;

public class Inputs {

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

    public static String getCampus(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty() || !Validation.isVaildIdCampus(result)) {
                System.out.println("No students have registered under this campus");
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

    public static String getID() {
        boolean check = true;
        String id = "";
        try {
            do {
                id = Inputs.getString("Input Student ID:");
                if (Validation.validStudentID(id)) {
                    String campus = id.substring(0, 2).toUpperCase();
                    String Num6digits = id.substring(2, 8);
                    id = campus + Num6digits;

                    check = false;
                }
            } while (check);
        } catch (Exception e) {
        }

        return id;
    }

    public static String getName() {
        boolean check = true;
        String name = "";
        try {
            do {
                name = Inputs.getString("Input Student Name:");
                if (Validation.validName(name)) {
                    check = false;
                } else {
                    System.out.println("Invalid ID format");
                }
            } while (check);
        } catch (Exception e) {
        }

        return name;
    }

    public static String getPhone() {
        boolean check = true;
        String phone = "";
        try {
            do {
                phone = Inputs.getString("Input Student Phone");
                if (Validation.validPhone(phone)) {
                    check = false;
                }
            } while (check);
        } catch (Exception e) {
        }

        return phone;
    }

    public static String getEmail() {
        boolean check = true;
        String email = "";
        try {
            do {
                email = Inputs.getEmail();
                if (Validation.isValidEmail(email)) {
                    check = false;
                }
            } while (check);
        } catch (Exception e) {
        }
        return email;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean check = true;
        boolean result = false;
        do {
            try {
                String confirm = Inputs.getString(welcome);
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

}
