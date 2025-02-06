package sample.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.models.I_List;
import sample.models.Mountain;
import sample.models.StatisticsInfo;
import sample.models.Student;
import sample.models.StudentMountain;
import sample.utils.Inputs;
import sample.utils.Validation;

public final class MountainHikingList extends ArrayList<StudentMountain> implements I_List {

    public String path = "moutainList.bin";

    // Constructor to initialize the list
    public MountainHikingList() {
        try {
            File file = new File("MountainHiking.bin");
            if (file.exists() && file.length() > 0) { // Ensure the file is not empty
                ArrayList<StudentMountain> studentList = readStudentMountainFromFile("MountainHiking.bin");
                if (studentList != null) {
                    this.addAll(studentList);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

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
                    String name = Inputs.getString("Input Student Name:");
                    if ((name.length() > 2 && name.length() < 20)) {
                        student.setName(name);
                        countinous = false;
                    }
                } while (countinous);
                countinous = true;
                do {
                    phone = Inputs.getString("Input Student Phone:");
                    if (Validation.validPhone(phone)) {
                        student.setPhone(phone);
                        countinous = false;
                    }
                } while (countinous);
                countinous = true;
                do {
                    String email = Inputs.getString("Input Student Email:");
                    if (Validation.isValidEmail(email)) {
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
                mountainCode = Inputs.getString("Mountain code: ");
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
        try {
            if (this != null && !this.isEmpty()) {
                for (StudentMountain sm : this) {
                    System.out.printf("| %-16s | %-18s | %-15s | %-11s | %-15.2f |\n", sm.getStudent().getId(), sm.getStudent().getName(), sm.getStudent().getPhone(), sm.getMountainCode(), sm.getFee());
                }
            } else {
                System.out.println("No data to display.");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public boolean update(String value) {
        boolean checked = false;
        try {
            //boolean continous = false;
            // Find students
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
                    String newName = Inputs.updateString("Enter new name (Leave empty to skip):", studentMountainUpdate.getStudent().getName());
                    if (!newName.trim().isEmpty()) {
                        studentMountainUpdate.getStudent().setName(newName);
                    }

                    String newPhone = Inputs.updateString("Enter new phone (Leave empty to skip):", studentMountainUpdate.getStudent().getPhone());
                    if (!newPhone.trim().isEmpty() && Validation.validPhone(newPhone)) {
                        studentMountainUpdate.getStudent().setPhone(newPhone);
                    }

                    String newEmail = Inputs.updateString("Enter new email (Leave empty to skip):", studentMountainUpdate.getStudent().getEmail());
                    if (!newEmail.trim().isEmpty() && Validation.isValidEmail(newEmail)) {
                        studentMountainUpdate.getStudent().setEmail(newEmail);
                    }

                    // Ask if the user wants to update another detail
//                    String updateMore = Inputs.getString("Do you want to update another field? (Y/N)").toUpperCase();
//                    continueUpdating = updateMore.equals("Y");
                    continueUpdating = Inputs.confirmYesNo("Do you want to update another field? (Y/N): ");

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
      //  try {
            StudentMountain studentToDelete = null;
            for (StudentMountain SM : this) {
                if (SM.getStudent().getId().equalsIgnoreCase(value)) {
                    studentToDelete = SM;
                    break;
                }
            }
            // If the student is found
            if (studentToDelete != null) {
                // Remove the student from the list
                
                System.out.println("--------------------------------------------------------------");
                System.out.println("Student ID: "+studentToDelete.getStudent().getId());
                System.out.println("Name: "+studentToDelete.getStudent().getName());
                System.out.println("Phone: "+studentToDelete.getStudent().getPhone());
                System.out.println("Mountain: "+studentToDelete.getMountainCode());
                System.out.println("Fee: "+studentToDelete.getFee());
                System.out.println("--------------------------------------------------------------");
                boolean isConfirm =  Inputs.confirmYesNo("Are you sure you want to delete this registration? (Y/N): ");
                
                
                
                if(isConfirm){
                    this.remove(studentToDelete);
                    System.out.println("Student with ID " + value + " has been deleted.");
                    checked = true;
                }

                // Save the updated list back to the file
                // writeMountainHikingToFile(path);
                
            } else {
                System.out.println("Student with ID " + value + " not found.");
            }

       // } catch (Exception e) {
      //  }

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
    public List<Object> search(String value) {
        List<Object> searchList = new ArrayList();
        boolean checked = false;
        try {
            String searchValue = value.toLowerCase().trim();
            for (StudentMountain student : this) {

                String[] nameParts = student.getStudent().getName().toLowerCase().split("\\s+");
                boolean matches = false;

                for (String part : nameParts) {
                    if (part.equalsIgnoreCase(searchValue)) {
                        matches = true;
                        break;
                    }
                }
                if (matches) {
                    searchList.add(student);
                    checked = true;
                }
            }
            if (!checked) {
                System.out.println("No one matches the search criteria!");
            }
        } catch (Exception e) {
        }
        return searchList;
    }

    @Override
    public List<Object> filter(String value) {
        List<Object> filteredList = new ArrayList();

        try {
            for (StudentMountain student : this) {
                if (!student.getStudent().getId().isEmpty() && student.getStudent().getId().toUpperCase().startsWith(value.toUpperCase())) {
                    filteredList.add(student);
                }
            }
        } catch (Exception e) {
        }

        return filteredList;

    }

    @Override
    public List<Object> statistics() {
        Map<String, StatisticsInfo> statsMap = new HashMap<>();

        for (StudentMountain student : this) {
            String peak = student.getMountainCode();
            double fee = student.getFee();

            statsMap.putIfAbsent(peak, new StatisticsInfo(peak, 0, 0.0));
            StatisticsInfo currentStats = statsMap.get(peak);

            currentStats.incrementCount();
            currentStats.addFee(fee);

        }
        List<Object> result = new ArrayList<>(statsMap.values());
        return result;

    }

}
