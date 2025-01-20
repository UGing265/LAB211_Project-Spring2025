package sample.views;

import java.io.IOException;
import java.util.ArrayList;
import sample.controllers.Menu;
import sample.controllers.MountainHikingList;
import sample.models.I_List;
import sample.models.I_Menu;
import sample.models.Student;
import sample.models.StudentMountain;
import sample.utils.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class ListMountainHikingManagement {

    public static void App() {
        String fileName = "MountainHiking.bin";
        MountainHikingList mtl=  new MountainHikingList();
     
//            ArrayList<StudentMountain> StudentM = mtl.readStudentMountainFromFile(fileName);
//            for(StudentMountain sm:StudentM){
//                System.out.println(sm);}
             try {
            mtl.readStudentMountainFromFile(fileName); // Read mountain data
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        
//        try {
//            File file= new File(fileName);
//            boolean check= file.exists();
//            if(!check){
//                file.createNewFile();
//            }
//            List<Mountain> lm= mtl.readMountainFromFile(fileName);
//            System.out.println(lm.toString());
//        } catch (Exception e) {
//        }
        I_Menu menu = new Menu();
        menu.addItem("1. New Registration");
        menu.addItem("2. Update Information");
        menu.addItem("3. display all registered students");
        menu.addItem("4. Delete Registration Information");
        menu.addItem("5. Search Participants by Name");
        menu.addItem("6. Filter by Campus");
        menu.addItem("7. Statistics by Location");
        menu.addItem("8: Save data");
        menu.addItem("9: Quit");
        int choice;
        boolean cont = true;
        I_List list = new MountainHikingList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.create();
                    break;
                case 2:
                    list.update(Utils.getString("Input your Student Code: "));
                    break;
                case 3:
                   list.display();
                    break;
                case 4:
                    list.delete(Utils.getString("Input your Student Code: "));
                    break;
                case 5:
                    list.search(Utils.getString("lets go: "));
                    break;
                case 6:
                   //list.writeMountainHikingToFile(fileName);
                    break;
                case 7:
                    //list.writeMountainHikingToFile(fileName);
                    break;
                case 8:
                    list.writeMountainHikingToFile(fileName);
                    break;
                case 9:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    if (cont == true) {
                        cont = false;
                    }
                    break;
            }
        } while (choice >= 0 && choice <= 9 && cont);
    }
}
