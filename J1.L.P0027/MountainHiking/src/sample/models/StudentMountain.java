package sample.models;

import java.io.Serializable;

public class StudentMountain implements Serializable {

    private Student student;
    private String mountainCode;
    private double fee;

    public StudentMountain() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        StudentMountain other = (StudentMountain) obj;

        return this.getStudent().getId().equalsIgnoreCase(other.getStudent().getId()); 
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
