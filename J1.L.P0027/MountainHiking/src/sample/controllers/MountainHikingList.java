/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sample.models.I_List;
import sample.models.Mountain;
import sample.models.Student;
import sample.models.StudentMountain;
import sample.utils.Utils;

/**
 *
 * @author hoadoan
 */
public class MountainHikingList extends ArrayList<StudentMountain> implements I_List {

    public String path = "moutainList.bin";

    @Override
    public boolean create() {
        boolean check = false;
        boolean checkDuplicateID = true;
        try {
            String phone = "";
            Student student = new Student();
            do {

                // nhập student ID
                boolean countinous = true;

                student.createID();
//             nhập student Name
                //countinous = true;
                do {
                    String name = Utils.getString("Input Student Name:");
                    if ((name.length() > 2 && name.length() < 20)) {
                        student.setName(name);
                        countinous = false;
                    }
                } while (countinous);
                countinous = true;
                do {
                    phone = Utils.getString("Input Student Phone:");
                    if (Utils.validPhone(phone)) {
                        student.setPhone(phone);
                        countinous = false;
                    }
                } while (countinous);
                countinous = true;
                do {
                    String email = Utils.getString("Input Student Email:");
                    if (Utils.isValidEmail(email)) {
                        student.setEmail(email);
                        countinous = false;
                    }
                } while (countinous);
                if (this.size() > 0) {
                    for (int i = 0; i < this.size(); i++) {
                        if (!this.get(i).getStudent().getId().equals(student.getId())) {
                            checkDuplicateID = false;
                        }
                    }
                } else {
                    checkDuplicateID = false;
                }

            } while (checkDuplicateID);
//             load mountain data

            ArrayList listMountain = this.readMountainFromFile(path);
            boolean countinous = true;
            String mountainCode = "";
            do {
                mountainCode = Utils.getString("Mountain code: ");
                if (listMountain.indexOf(new Mountain(mountainCode)) != -1) {
                    countinous = false;

                }
            } while (countinous);
            double fee = 6000000;
            String first3Character = phone.substring(0, 3);
            if (first3Character.equals("097") || first3Character.equals("090") || first3Character.equals("091")) {
                fee = 3950000;
            }
            StudentMountain stm = new StudentMountain();
            stm.setStudent(student);
            stm.setMountainCode(mountainCode);
            stm.setFee(fee);
            this.add(stm);
            check = true;

        } catch (Exception e) {
        }
        return check;
    }

    @Override
    public boolean writeMountainHikingToFile(String path) {
        boolean result = false;
        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            try {

                for (StudentMountain sm : this) {
                    oos.writeObject(sm);
                }
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (oos != null) {
                    oos.close();
                }
            }
            if (file != null) {
                file.close();
            }
        } catch (Exception e) {
        }

        return result;
    }

    public ArrayList<Mountain> readMountainFromFile(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Mountain> list = new ArrayList();
        try {
            Mountain mountain = null;
            while (fis.available() > 0) {
                mountain = (Mountain) ois.readObject();
                list.add(mountain);
            }
        } catch (Exception e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return list;
    }

    public ArrayList<StudentMountain> readStudentMountainFromFile(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<StudentMountain> list = new ArrayList();
        try {
            StudentMountain sm = null;
            while (fis.available() > 0) {
                sm = (StudentMountain) ois.readObject();
                list.add(sm);
            }
        } catch (Exception e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return list;
    }

    @Override
    public void display() {
        for (StudentMountain obj : this) {
            System.out.println(obj.toString());
        }
    }

    @Override
    public boolean update(String value) {
        boolean checked = false;
        try {
            //boolean continous = false;
            StudentMountain studentMountainUpdate = null;
            for (StudentMountain SM : this) {
                if (SM.getStudent().getId().equalsIgnoreCase(value)) {
                    studentMountainUpdate = SM;
                    break;
                }
            }

            // If the student is found
            if (studentMountainUpdate != null) {
                boolean continueUpdating = true;
                while (continueUpdating) {
                    // Prompt user for new student details
                    String newName = Utils.getString("Enter new name (Leave empty to skip):");
                    if (!newName.trim().isEmpty()) {
                        studentMountainUpdate.getStudent().setName(newName);
                    }

                    String newPhone = Utils.getString("Enter new phone (Leave empty to skip):");
                    if (!newPhone.trim().isEmpty() && Utils.validPhone(newPhone)) {
                        studentMountainUpdate.getStudent().setPhone(newPhone);
                    }

                    String newEmail = Utils.getString("Enter new email (Leave empty to skip):");
                    if (!newEmail.trim().isEmpty() && Utils.isValidEmail(newEmail)) {
                        studentMountainUpdate.getStudent().setEmail(newEmail);
                    }

                    // Ask if the user wants to update another detail
                    String updateMore = Utils.getString("Do you want to update another field? (Y/N)").toUpperCase();
                    continueUpdating = updateMore.equals("Y");
                }

                // Save updated list to file
               // writeMountainHikingToFile(path);
                System.out.println("Student information updated successfully!");
                checked = true;
            } else {
                System.out.println("Student with ID " + value + " not found.");
            }

        } catch (Exception e) {
        }
        return checked;
    }

    @Override
    public boolean delete(String value) {
        boolean checked = false;
        try{
            StudentMountain studentToDelete = null;
            for(StudentMountain SM: this){
                if(SM.getStudent().getId().equalsIgnoreCase(value)){
                    studentToDelete = SM;
                    break;
                }
            }
             // If the student is found
            if (studentToDelete != null) {
            // Remove the student from the list
            this.remove(studentToDelete);
            System.out.println("Student with ID " + value + " has been deleted.");

            // Save the updated list back to the file
           // writeMountainHikingToFile(path);
            checked = true;
        } else {
            System.out.println("Student with ID " + value + " not found.");
        }
            
            
        }catch(Exception e){}
        
        
        
        return checked;
    }

    @Override
//    public List<Object> search(String value) {
//        // Implement search logic
//        List<Object> matchingStudents = new ArrayList<>();
//        for (StudentMountain student : this) {
//            if (student.getStudent().getName().toLowerCase().contains(value.toLowerCase())) {
//                matchingStudents.add(student);
//            }
//        }
//        return matchingStudents;
//    }
    public void search(String value) {
        boolean checked = false;

        String searchValue = value.toLowerCase().trim();

        for (StudentMountain student : this) {

            String[] nameParts = student.getStudent().getName().toLowerCase().split("\\s+");

            boolean matches = false;
            for (String part : nameParts) {
                if (part.equals(searchValue)) {
                    matches = true;
                    break;
                }
            }
            if (matches) {
                System.out.println(student);
                checked = true;
            }
        }
        if (!checked) {
            System.out.println("No one matches the search criteria!");
        }
    }

    //@Override
    public Object filter(String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //@Override
    public Object statistics() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
