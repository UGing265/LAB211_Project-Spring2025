/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.controllers;

import java.util.ArrayList;
import sample.models.I_LIST;
import sample.models.Student;
import sample.models.StudentMountain;
import sample.utils.Utils;

public class MountainHikingList extends ArrayList<StudentMountain> implements I_LIST {

    @Override
    public boolean create() {
        boolean check = false;
        try {
            Student student = new Student();
            boolean continous = true;
            do {
                String id = Utils.getString("Input Student ID");
                if (Utils.valiationStudentID(id)) {
                    student.setId(id);
                    continous = false;
                }
            } while (continous);
            continous = true;

            do {
                String name = Utils.getString("input Student Name:");
                if ((name.length() > 2 && name.length() < 20)) {
                    student.setName(name);
                    continous = false;

                }
            } while (continous);
        } catch (Exception e) {}
        return check;
    }

}
