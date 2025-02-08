package sample.views;

import java.util.List;
import sample.models.I_List;
import sample.models.StatisticsInfo;
import sample.models.StudentMountain;
import sample.utils.Inputs;

public class PrintTable {

    private static I_List list ;
    
public static void setList(I_List sharedList) {
        list = sharedList;
    }

    public static void rowDash(int num){
        for(int i = 0; i < num; i++ ){
            System.out.print("-");
        }
        System.out.println();
    }
    
    public static void printUpdate(){
        list.update(Inputs.getString("Input your Student Code: "));
    }
    
    public static void printStudentInfo(StudentMountain sm){
    System.out.println("--------------------------------------------------------------");
    System.out.println("Student ID: " + sm.getStudent().getId());
    System.out.println("Name: " + sm.getStudent().getName());
    System.out.println("Phone: " + sm.getStudent().getPhone());
    System.out.println("Mountain: " + sm.getMountainCode());
    System.out.println("Fee: " + sm.getFee());
    System.out.println("--------------------------------------------------------------");
}
    
    public static void printDeleteInfo(){
           list.delete(Inputs.getString("Input your Student Code: "));
    }
    
    public static void printDisplayTable(){
        
        
       
        list.display();
        
    }
    
    public static void printSearchTable(){
        int num = 91;
        List<Object> searchList = list.search(Inputs.getString("Input Your Name need to find:"));
        
        if(searchList.isEmpty()){
            return;
        }
        
        // Table header
        rowDash(num);
        System.out.printf("| %-16s | %-18s | %-15s | %-11s | %-15s |\n", "Student ID", "Name", "Phone", "Peak Code", "Fee" );
        rowDash(num);
        
        for(Object obj : searchList){
            if(obj instanceof StudentMountain sm){
                System.out.printf("| %-16s | %-18s | %-15s | %-11s | %-15.2f |\n",sm.getStudent().getId(),sm.getStudent().getName(),sm.getStudent().getPhone(),sm.getMountainCode(),sm.getFee());
            }
        }
        
        // Table Footer
        rowDash(num);
        
    }
    
    public static void printFilterTable(){
        int num = 91;
        String code = Inputs.getCampus("Input Campus Code:");
        List<Object> fil = list.filter(code);
        if(fil.isEmpty()){
            System.out.println("No students have registered under this campus.");
            return;
        }
        
        // Table header
        rowDash(num);
        System.out.printf("| %-16s | %-18s | %-15s | %-11s | %-15s |\n","Student ID","Name","Phone","Mountain","Fee");
        rowDash(num);
        
        // Table rows
        for (Object obj : fil){
            if(obj instanceof StudentMountain sm){
                System.out.printf("| %-16s | %-18s | %-15s | %-11s | %-15.2f |\n",sm.getStudent().getId(), sm.getStudent().getName(),sm.getStudent().getPhone(),sm.getMountainCode(),sm.getFee());
                
            }
        }
        // Table footer
        rowDash(num);
    }
    
    public static void printStatisticsTable() {
        int num = 70;
        List<Object> stats = list.statistics();
        
        if (stats.isEmpty()) {
            System.out.println("No data available to display.");
            return;
        }

        // Table header
        rowDash(num);
        System.out.printf("| %-20s | %-25s | %-15s |\n", "Peak Name", "Number of Participants", "Total Cost");
        rowDash(num);
        // Table rows
        for (Object obj : stats) {
            if (obj instanceof StatisticsInfo stat) {
                System.out.printf("| %-20s | %-25d | $%-14.2f |\n",
                        stat.getPeakName(), stat.getParticipantNum(), stat.getTotalCost());
            }
        }

        // Table footer
        rowDash(num);
    }

    public static void printSaveFile(String fileName) {
        if (list.writeMountainHikingToFile(fileName)) {
            System.out.println("Registration data has been successfully saved to `MountainHiking.bin`.");
        } else{
            System.out.println("Save failed");
        }
    }
}
