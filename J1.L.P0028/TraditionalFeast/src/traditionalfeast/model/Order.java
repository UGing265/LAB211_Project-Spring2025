package traditionalfeast.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Order {
    private String orderId;
    private String customerId;
    private String MenuId;
    private LocalDate eventDate;
    private int numTables;
    private double totalCost;
    
    // Constructor
    public Order(String orderId, String customerId, String MenuId, String eventDate, int numTables, double pricePerTable) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.MenuId = MenuId;
        this.eventDate = parseDate(eventDate);
        this.numTables = validateNumTables(numTables);
        this.totalCost = calculateTotalCost(pricePerTable);
    }

    // Validate and parse event date
    private LocalDate parseDate(String date) {
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (parsedDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Event date must be in the future.");
        }
        return parsedDate;
    }

    // Validate number of tables
    private int validateNumTables(int numTables) {
        if (numTables <= 0) {
            throw new IllegalArgumentException("Number of tables must be greater than zero.");
        }
        return numTables;
    }

    // Calculate total cost
    private double calculateTotalCost(double pricePerTable) {
        return numTables * pricePerTable;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String MenuId) {
        this.MenuId = MenuId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getNumTables() {
        return numTables;
    }

    public void setNumTables(int numTables) {
        this.numTables = numTables;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", MenuId=" + MenuId + ", eventDate=" + eventDate + ", numTables=" + numTables + ", totalCost=" + totalCost + '}';
    }

   

   
     
    
}

