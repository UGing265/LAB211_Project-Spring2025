package traditionalfeast.controller;

import traditionalfeast.dao.CustomerDAO;
import traditionalfeast.model.Customer;
import traditionalfeast.repository.CustomerRep;
import traditionalfeast.view.CustomerView;

public class CustomerCon {
    private final CustomerRep customerRep;
    private final CustomerView customerView;
    private final CustomerDAO customerDAO;

    public CustomerCon() {
        this.customerRep = new CustomerRep();
        this.customerView = new CustomerView();
        this.customerDAO = new CustomerDAO();
    }

    public  void registerCustomer() {
        Customer newCustomer = customerView.registerCustomer(); // Get customer input

        // Check if customer already exists
        if (customerRep.findById(newCustomer.getCustomerId()) != null) {
            System.out.println("Error: Customer code already exists!");
            return;
        }

        customerRep.add(newCustomer); // Add to list
        customerDAO.save(customerRep.getAll()); // Save to file
        System.out.println("Customer registered successfully!");
    }
}

