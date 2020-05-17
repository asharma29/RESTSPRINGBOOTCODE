package com.mavericsystems.digitalinterviewportal.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "candidate")
public class Candidate {
    @Id
    private ObjectId _id;
    private User user;
    private String yearsOfExperience;
    private String designation;
    private String skillset;
    private String panNumber;
    private String noticePeriod;

    public Candidate(ObjectId _id, User user, String yearsOfExperience, String designation, String skillset, String panNumber, String noticePeriod) {
        this._id = _id;
        this.user = user;
        this.yearsOfExperience = yearsOfExperience;
        this.designation = designation;
        this.skillset = skillset;
        this.panNumber = panNumber;
        this.noticePeriod = noticePeriod;
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

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSkillset() {
        return skillset;
    }

    public void setSkillset(String skillset) {
        this.skillset = skillset;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }
}