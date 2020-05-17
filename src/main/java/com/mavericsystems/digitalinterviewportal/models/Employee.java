package com.mavericsystems.digitalinterviewportal.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee{

    @Id
    private ObjectId _id;
    private User user;
    private String empId;
    private String designation;

    public Employee(ObjectId _id, User user, String empId, String designation) {
        this._id = _id;
        this.user = user;
        this.empId = empId;
        this.designation = designation;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
