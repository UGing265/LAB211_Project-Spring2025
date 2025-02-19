package traditionalfeast.view;

import traditionalfeast.controller.CustomerCon;
import traditionalfeast.controller.MenuCon;
import traditionalfeast.model.I_Menu;


public class MenuView {
    I_Menu menu = new MenuCon();
    CustomerCon customerCon = new CustomerCon();
    public void displayMenu() {
        menu.addItem("````````| TRADITIONAL FEAST ORDER MANAGEMENT |```````");
        menu.addItem("1. Register New Customer");
        menu.addItem("2. Update Customer Information");
        menu.addItem("3. Display All Customers");
        menu.addItem("4. Delete Customer");
        menu.addItem("5. Search Customer by Name");
        menu.addItem("6. Place a Feast Order");
        menu.addItem("7. Display All Orders");
        menu.addItem("8: Save Data");
        menu.addItem("9: Quit");
    }
    
    public void runApp(){
        int choice;
        boolean cont = false;
        boolean hasUnsavedChanges = false;
        displayMenu();
        //CustomerRep customerList = new CustomerRep();
        //customerList.addAll(FileUtils.readFromFile(FILE_PATH));
        
        do {
            
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    customerCon.registerCustomer();
                    hasUnsavedChanges = true;
                    break;
                case 2:
                    //customerCon.updateCustomer();
                    hasUnsavedChanges = true;
                    break;
                case 3:
                    //customerCon.displayAllCustomers();
                    break;
                case 4:
                    //customerCon.deleteCustomer();
                    hasUnsavedChanges = true;
                    break;
                case 5:
                    //customerCon.searchCustomerByName();
                    break;
                case 6:
                    //customerCon.placeOrder();
                    hasUnsavedChanges = true;
                    break;
                case 7:
                    //customerCon.displayAllOrders();
                    break;
                case 8:
                    if (menu.confirmYesNo("Do you want to save the file? (Y/N): ")) {
                        //FileUtils.writeToFile(FILE_PATH, customerList.getAll());
                        System.out.println("Data saved successfully!");
                        hasUnsavedChanges = false;
                    }
                    break;
                case 9:
                    if (hasUnsavedChanges) {
                        System.out.println("Warning: You have unsaved changes.");
                    }
                    cont = menu.confirmYesNo("Do you want to quit? (Y/N): ");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice >= 0 && choice <= 9 && !cont);
    } 
}