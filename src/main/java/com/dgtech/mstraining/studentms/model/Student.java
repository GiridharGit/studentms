package com.dgtech.mstraining.studentms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "ROLLNUMBER", nullable = false)
    private String rollNumber;

    @Column(name = "FULLNAME", nullable = false)
    private String fullname;

    @Column(name = "AGE")
    private int age;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ADDRESS")
    private String address;


    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
