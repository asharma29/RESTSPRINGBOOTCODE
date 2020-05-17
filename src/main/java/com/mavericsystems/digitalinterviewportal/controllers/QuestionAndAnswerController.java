package com.mavericsystems.digitalinterviewportal.controllers;

import com.mavericsystems.digitalinterviewportal.models.Q_N_A;
import com.mavericsystems.digitalinterviewportal.services.dao.QuestionAndAnswerRepository;
import com.mavericsystems.digitalinterviewportal.services.exception.CommonException;
import com.mavericsystems.digitalinterviewportal.services.exception.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionAndAnswerController {

    @Autowired
    private QuestionAndAnswerRepository questionAndAnswerRepository;

    @PostMapping("/questionAndAnswers")
    public ResponseEntity<String> storeQuestionAndAnswer(@RequestBody Q_N_A questionWithAnswers) {
        Q_N_A savedQNA = questionAndAnswerRepository.save(questionWithAnswers);
        if (savedQNA == null) {
            throw new CommonException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unknown error");
        } else {
            return new ResponseEntity("Question and answer successfully added", HttpStatus.CREATED);
        }
    }
    @GetMapping("/questionAndAnswers")
    public ResponseEntity<String> retrieveQuestionAndAnswer() {
        List<Q_N_A> retrieveQuestionAndAnswers = questionAndAnswerRepository.findAll();
        if (retrieveQuestionAndAnswers == null) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "List of all questions");
        } else {
            return new ResponseEntity(retrieveQuestionAndAnswers, HttpStatus.OK);
        }
    }
    @GetMapping("/questionAndAnswers/{questionId}")
    public ResponseEntity<String> retrieveQuestionAndAnswer(@PathVariable("questionId") ObjectId questionId) {
        Optional<Q_N_A> retrieveQuestionAndAnswer = questionAndAnswerRepository.findById(questionId);
        if (retrieveQuestionAndAnswer == null) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        } else {
            return new ResponseEntity(retrieveQuestionAndAnswer, HttpStatus.OK);
        }
    }
    @PutMapping("/questionAndAnswers/{questionId}")
    public ResponseEntity<String> storeQuestionAndAnswer(@RequestBody Q_N_A questionAndAnswer,@PathVariable("questionId") ObjectId questionId) {
        Optional<Q_N_A> updatedQNA= questionAndAnswerRepository.findById(questionId);
        if (updatedQNA == null) {
            throw new CommonException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unknown error");
        } else {
            Q_N_A updatedQuestionAndAnswers = questionAndAnswerRepository.save(questionAndAnswer);
            return new ResponseEntity("Question and answer successfully added", HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/questionAndAnswers/{questionId}")
    public ResponseEntity<String> deleteQuestionAndAnswer(@PathVariable("questionId") ObjectId questionId) {
        Optional<Q_N_A> updatedQNA= questionAndAnswerRepository.findById(questionId);
        if (!updatedQNA.isPresent()){
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        }
         else {
            questionAndAnswerRepository.deleteById(questionId);
            return new ResponseEntity("Question successfully deleted", HttpStatus.OK);
        }
    }


}
