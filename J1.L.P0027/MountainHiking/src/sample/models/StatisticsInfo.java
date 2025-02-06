
package sample.models;

public class StatisticsInfo {
    private String peakName;
    private int participantNum;
    private double totalCost;

    public StatisticsInfo(String peakName, int participantNum, double totalCost) {
        this.peakName = peakName;
        this.participantNum = participantNum;
        this.totalCost = totalCost;
    }

    public String getPeakName() {
        return peakName;
    }

    public void setPeakName(String peakName) {
        this.peakName = peakName;
    }

    public int getParticipantNum() {
        return participantNum;
    }

    public void setParticipantNum(int participantNum) {
        this.participantNum = participantNum;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
       public void incrementCount() {
        this.participantNum++;
    }

    public void addFee(double fee) {
        this.totalCost += fee;
    }
    
    public String toString() {
        return "Peak: " + peakName + ", Participants: " + participantNum + ", Total Cost: $" + totalCost;
    }

}
