package traditionalfeast.model;


import java.util.List;

public interface I_List<T> {
    void addTo(T t);
    void update(int i, T t);
    void delete(int i);
    public T findById(String id);
    public List<T> getAll();
    
    

}