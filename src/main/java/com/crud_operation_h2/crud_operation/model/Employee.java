package com.crud_operation_h2.crud_operation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 30,nullable = false)
    private String first_Name;
    @Column(length = 30,nullable = false)
    private String last_Name;
    @Column(nullable = false, unique = true, length = 50)
    private  String email;
    @Column(length = 10,nullable = false)
    private String gender;

    public Employee() {

    }

    public Employee(long id, String first_Name, String last_Name, String email, String gender) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

