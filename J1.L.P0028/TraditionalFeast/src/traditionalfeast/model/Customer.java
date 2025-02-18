package traditionalfeast.model;


public class Customer {
    private String customerId;
    private String Name;
    private String phoneNumber;
    private String Email;

    public Customer(String customerId, String Name, String phoneNumber, String Email) {
        this.customerId = customerId;
        this.Name = Name;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", Name=" + Name + ", phoneNumber=" + phoneNumber + ", Email=" + Email + '}';
    }
    

}
