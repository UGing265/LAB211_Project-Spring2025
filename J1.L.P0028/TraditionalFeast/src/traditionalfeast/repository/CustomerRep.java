package traditionalfeast.repository;

import java.util.ArrayList;
import java.util.List;
import traditionalfeast.model.Customer;
import traditionalfeast.model.I_List;

public class CustomerRep extends ArrayList<Customer> implements I_List<Customer> {
    
    @Override
    public void addTo(Customer customer) {
        super.add(customer);
    }

    @Override
    public void update(int index, Customer customer) {
        if (index >= 0 && index < this.size()) {
            super.set(index, customer);
        } else {
            System.out.println("Invalid index!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < this.size()) {
            super.remove(index);
        } else {
            System.out.println("Invalid index!");
        }
    }

    @Override
    public Customer findById(String id) {
        for (Customer c : this) {
            if (c.getCustomerId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return this;
    }
}