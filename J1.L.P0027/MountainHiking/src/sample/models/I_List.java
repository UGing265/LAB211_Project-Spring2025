/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.models;

//import java.util.List;

import java.util.List;


/**
 *
 * @author hoadoan
 */
public interface I_List {
    boolean create();
    boolean update(String value);
    void display();
    boolean delete(String value);
    //List<Object> search(String value);
    void search(String value);
    List<Object> filter(String value);//need string value
    List<Object> statistics();
    boolean writeMountainHikingToFile(String path);
}
