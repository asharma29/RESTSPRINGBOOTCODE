package com.mavericsystems.digitalinterviewportal.models;

import com.mavericsystems.digitalinterviewportal.services.constants.ModelConstants;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Q_N_A {

    @Id
    private ObjectId _id;
    private String question;
    private Answer[] answers;
    @Enumerated(EnumType.STRING)
    private ModelConstants.QNAStatus status;

    public Q_N_A(ObjectId _id, String question, Answer[] answers, ModelConstants.QNAStatus status) {
        this._id = _id;
        this.question = question;
        this.answers = answers;
        this.status = status;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public ModelConstants.QNAStatus getStatus() {
        return status;
    }

    public void setStatus(ModelConstants.QNAStatus status) {
        this.status = status;
    }
}
