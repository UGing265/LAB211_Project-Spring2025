package traditionalfeast.model;


import java.util.List;

public interface I_List {
    boolean create();
    boolean update(String value);
    void display();
    boolean delete(String value);
    List<Object> search(String value);

}