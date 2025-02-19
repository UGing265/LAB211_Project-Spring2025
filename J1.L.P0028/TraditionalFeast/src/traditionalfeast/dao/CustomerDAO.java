
package traditionalfeast.dao;

import java.util.List;
import traditionalfeast.model.Customer;
import traditionalfeast.utils.FileUtils;

public class CustomerDAO {
     private static final String FILE_PATH = "customers.dat";

    public void save(List<Customer> customers) {
        FileUtils.writeToFile(FILE_PATH, customers);
    }

    public List<Customer> load() {
        return FileUtils.readFromFile(FILE_PATH);
    }
}
