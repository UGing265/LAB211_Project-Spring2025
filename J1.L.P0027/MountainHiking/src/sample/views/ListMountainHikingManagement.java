package sample.views;

import sample.controllers.Menu;
import sample.controllers.MountainHikingList;
import sample.models.I_List;
import sample.models.I_Menu;

public class ListMountainHikingManagement {

    public static void App() {
        int choice;
        boolean cont = true;

        String fileName = "MountainHiking.bin";

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

        I_List list = new MountainHikingList();
        PrintTable.setList(list);
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.create();
                    break;
                case 2:
                    PrintTable.printUpdate();
                    break;
                case 3:
                    PrintTable.printDisplayTable();
                    break;
                case 4:
                    PrintTable.printDeleteInfo();
                    break;
                case 5:
                    PrintTable.printSearchTable();
                    break;
                case 6:
                    PrintTable.printFilterTable();

                    break;
                case 7:
                    PrintTable.printStatisticsTable();
                    break;
                case 8:
                    boolean check = menu.confirmYesNo("Do you want to save the file? (Y/N): ");
                    if (check == true) {
                        PrintTable.printSaveFile(fileName);
                    }
                    break;
                case 9:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N): ");
            }
        } while (choice >= 0 && choice <= 9 && !cont);
    }
}
