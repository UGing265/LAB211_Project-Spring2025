/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author hoadoan
 */
public class StudentMountain implements Serializable{
    private Student student;
    private String mountainCode;
    private double fee;

    public StudentMountain() {
    }

    @Override
    public boolean equals(Object obj) {
        Student st= (Student)obj;
        return this.getStudent().getId().equals(st.getId());
    }



    public StudentMountain(Student student) {
        this.student = student;
    }

    public StudentMountain(Student student, String mountainCode, double fee) {
        this.student = student;
        this.mountainCode = mountainCode;
        this.fee = fee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    @Override
    public String toString() {
        return "StudentMountain{" + "student=" + student.toString() + ", mountainCode=" + mountainCode + ", fee=" + fee + '}';
    }
    
}
