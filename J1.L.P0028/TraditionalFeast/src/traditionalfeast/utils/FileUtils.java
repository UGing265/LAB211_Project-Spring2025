package traditionalfeast.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FileUtils {
    public static <T> void writeToFile(String filePath, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static <T> List<T> readFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
    
//    public boolean writeMountainHikingToFile(String path) {
//        boolean result = false;
//        try {
//            FileOutputStream file = new FileOutputStream(path);
//            ObjectOutputStream oos = new ObjectOutputStream(file);
//            try {
//
//                for (StudentMountain sm : this) {
//                    oos.writeObject(sm);
//                }
//                result = true;
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (oos != null) {
//                    oos.close();
//                }
//            }
//            if (file != null) {
//                file.close();
//            }
//        } catch (Exception e) {
//        }
//
//        return result;
//    }
//
//    public ArrayList<Mountain> readMountainFromFile(String path) throws IOException {
//        FileInputStream fis = new FileInputStream(path);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        ArrayList<Mountain> list = new ArrayList();
//        try {
//            Mountain mountain = null;
//            while (fis.available() > 0) {
//                mountain = (Mountain) ois.readObject();
//                list.add(mountain);
//            }
//        } catch (Exception e) {
//        } finally {
//            if (ois != null) {
//                ois.close();
//            }
//            if (fis != null) {
//                fis.close();
//            }
//        }
//        return list;
//    }
//
//    public ArrayList<StudentMountain> readStudentMountainFromFile(String path) throws IOException {
//        FileInputStream fis = new FileInputStream(path);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        ArrayList<StudentMountain> list = new ArrayList();
//        try {
//            StudentMountain sm = null;
//            while (fis.available() > 0) {
//                sm = (StudentMountain) ois.readObject();
//                list.add(sm);
//            }
//        } catch (Exception e) {
//        } finally {
//            if (ois != null) {
//                ois.close();
//            }
//            if (fis != null) {
//                fis.close();
//            }
//        }
//        return list;
//    }
}
