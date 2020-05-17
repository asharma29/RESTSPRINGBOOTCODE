package com.mavericsystems.digitalinterviewportal.models;

import com.mavericsystems.digitalinterviewportal.services.constants.ModelConstants;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Test {
    @Id
    private ObjectId _id;
    private String name;
    private String title;
    @Enumerated(EnumType.STRING)
    private ModelConstants type;
    private String instruction;
    private String testCode;
    private String status;
    private ObjectId subject;
    private ObjectId difficultyLevel;
    private Number noOfQuestions;
    private Number duration;
    private Number cutOffPercentage;
    private Q_N_A q_n_a[];

    public Test(ObjectId _id, String name, String title, ModelConstants type, String instruction, String testCode, String status, ObjectId subject, ObjectId difficultyLevel, Number noOfQuestions, Number duration, Number cutOffPercentage, Q_N_A[] q_n_a) {
        this._id = _id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.instruction = instruction;
        this.testCode = testCode;
        this.status = status;
        this.subject = subject;
        this.difficultyLevel = difficultyLevel;
        this.noOfQuestions = noOfQuestions;
        this.duration = duration;
        this.cutOffPercentage = cutOffPercentage;
        this.q_n_a = q_n_a;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModelConstants getType() {
        return type;
    }

    public void setType(ModelConstants type) {
        this.type = type;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ObjectId getSubject() {
        return subject;
    }

    public void setSubject(ObjectId subject) {
        this.subject = subject;
    }

    public ObjectId getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(ObjectId difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Number getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(Number noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public Number getDuration() {
        return duration;
    }

    public void setDuration(Number duration) {
        this.duration = duration;
    }

    public Number getCutOffPercentage() {
        return cutOffPercentage;
    }

    public void setCutOffPercentage(Number cutOffPercentage) {
        this.cutOffPercentage = cutOffPercentage;
    }

    public Q_N_A[] getQ_n_a() {
        return q_n_a;
    }

    public void setQ_n_a(Q_N_A[] q_n_a) {
        this.q_n_a = q_n_a;
    }
}
