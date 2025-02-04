
package sample.views;

import java.util.List;
import sample.controllers.MountainHikingList;
import sample.models.MountainStatistics;

public class PrintMenu {
     private static MountainHikingList mhl = new MountainHikingList();
    
      public static void printStatisticsTable() {
          List<Object> stats = mhl.statistics();    
        if (stats.isEmpty()) {
            System.out.println("No data available to display.");
            return;
        }

        // Table header
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-30s | %-15s |\n", "Peak Name", "Number of Participants", "Total Cost");
        System.out.println("--------------------------------------------------------------------------");

         // Table rows
        for (Object obj : stats) {
            if (obj instanceof MountainStatistics stat) {
                System.out.printf("| %-20s | %-15d | $%-12.2f |\n", 
                    stat.getPeakName(), stat.getParticipantNum(), stat.getTotalCost());
            }
        }

        // Table footer
        System.out.println("----------------------------------------------------------");
    }
}
