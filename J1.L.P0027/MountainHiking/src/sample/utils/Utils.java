/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.utils;

import java.util.Scanner;


/**
 *
 * @author HP
 */
public class Utils {
    public static final int MIN=0;
    public static final int MAX=3000;
    // KIem tra ID phải có định dạng sau: 8 ký tự, ký tự đầu là mã vùng (SE, HE, CE, DE, QE), 6 kí tự cuối là số
    public static boolean valiationStudentID(String id){
        boolean check = false;
        try{
            if(id.length() != 8){
                String campusCode = id.substring(0, 2);
                String last6Digit = id.substring(2, 8);
                if(campusCode.equals("SE") || campusCode.equals("HE") || campusCode.equals("CE") 
                                    || campusCode.equals("DE") || campusCode.equals("QE")){
                    int value = Integer.parseInt(last6Digit);
                    check = true;
                }
            }     
        }catch(Exception e){}
        return check;
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

    public static String getString(String welcome, String oldData) {
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

    public static int getInt(String welcome, int min, int max, int oldData) {
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
    
      public static boolean isVaildEmail(String email) {
          String emailRegrex = "[\\w.+%-]+@[\\w.-]+\\.[a-zA-Z]{2,7}$";
          boolean check = false;
          if(email == null || email.isEmpty()){
          }  
          if(email.matches(emailRegrex)){
              check = true;
          }
          return check;
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
