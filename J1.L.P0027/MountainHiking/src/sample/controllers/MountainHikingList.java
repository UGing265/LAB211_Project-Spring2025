/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.controllers;

import java.util.ArrayList;
import sample.models.Student;
import sample.models.StudentMountain;
import sample.utils.Utils;
import sample.models.I_List;

public class MountainHikingList extends ArrayList<StudentMountain> implements I_List {

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

            continous = true;
            do {//098: Vettel
                //090 và 091: vina

                int phone = Utils.getInt("input your number phone", 0, 10);
                String phoneStr = String.valueOf(phone);
                String twoNumberFirst = phoneStr.substring(0, 1);
                if (twoNumberFirst.matches("09")) {
                    continous = false;
                }
            } while (continous);

            continous = true;
            do {
                String email = Utils.getString("input your email");
                if (Utils.isVaildEmail(email)) {
                    continous = false;
                }
            } while (continous);

        } catch (Exception e) {
        }
        return check;
    }

}
