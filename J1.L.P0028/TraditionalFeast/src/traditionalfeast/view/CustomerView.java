/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package traditionalfeast.view;

import traditionalfeast.model.Customer;
import traditionalfeast.utils.InputUtils;


public class CustomerView {
     public Customer registerCustomer() {
        System.out.println("=== REGISTER NEW CUSTOMER ===");
        String code = InputUtils.getString("Enter Customer Code (Cxxxx): ");
        String name = InputUtils.getString("Enter Name: ");
        String phone = InputUtils.getPhoneNumber("Enter Phone Number: ");
        String email = InputUtils.getEmail("Enter Email: ");

        return new Customer(code, name, phone, email);
    }
}
