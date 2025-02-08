
package sample.models;


import java.util.List;

public interface I_List {
    boolean create();
    boolean update(String value);
    void display();
    boolean delete(String value);
    List<Object> search(String value);
    List<Object> filter(String value);
    List<Object> statistics();
    boolean writeMountainHikingToFile(String path);
}
