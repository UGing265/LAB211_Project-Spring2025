/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.models;

/**
 *
 * @author HP
 */
public class StudentMountain {
    private String studentID;
    private String mountainCode;
    private double fee;
    
    public StudentMountain(){}

    public StudentMountain(String studentID, String mountainCode, double fee) {
        this.studentID = studentID;
        this.mountainCode = mountainCode;
        this.fee = fee;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    
    
}
