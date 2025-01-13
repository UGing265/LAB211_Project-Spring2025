package sample.views;

import sample.controllers.Menu;
import sample.models.I_Menu;



public class ListMountainHikingManagement {
    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("1. New Registration");
        menu.addItem("2. Update Registration Information");
        menu.addItem("3. Display Registered List");
        menu.addItem("4. Delete Registration Information");
        menu.addItem("5. Search Participants by Name");
        menu.addItem("6. Filter Data by Campus");
        menu.addItem("7. Statistics by Location");
        menu.addItem("8. Save Data to File");
        menu.addItem("9. Exit");
        int choice;
        boolean cont = true;
        I_List list = new ProductList();
//        do {
//            menu.showMenu();
//            choice = menu.getChoice();
//            switch (choice) {
//                case 1:
//                    
//                    list.add();
//                    list.output();
//                    break;
//                case 2:
//                    list.remove();
//                    list.output();
//                    break;
//                case 3:
//                    list.update();
//                    list.output();
//                    break;
//                case 4:
//                    list.sort();
//                    list.output();
//                    break;
//                
//                    
//                case 5:
//                    cont = menu.confirmYesNo("Do you want to quit?(Y/N)"); true
//                    if (cont == true) {
//                        cont = false; 
//                    }
//                    break;
//            }
//        } while (choice >= 0 && choice <= 7 && cont);
    }
}
