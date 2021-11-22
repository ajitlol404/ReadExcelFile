package com.readexcelfile.entity;


public class Student {

    private int id;
    private String name;
    private String fatherName;
    private String motherName;
    private int mobileNumber;

    public Student() {
    }

    public Student(int id, String name, String fatherName, String motherName, int mobileNumber) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
