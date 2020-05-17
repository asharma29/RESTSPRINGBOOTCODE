package com.mavericsystems.digitalinterviewportal.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Answer {

    @Id
    private ObjectId _id;
    private String ans;
    private Boolean isCorrectAnswer;

    public Answer(ObjectId _id, String ans, Boolean isCorrectAnswer) {
        this._id = _id;
        this.ans = ans;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Boolean getCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        isCorrectAnswer = correctAnswer;
    }
}
