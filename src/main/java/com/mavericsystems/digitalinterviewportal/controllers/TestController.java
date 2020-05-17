package com.mavericsystems.digitalinterviewportal.controllers;

import com.mavericsystems.digitalinterviewportal.models.Test;
import com.mavericsystems.digitalinterviewportal.services.dao.TestRepository;
import com.mavericsystems.digitalinterviewportal.services.exception.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @PostMapping("/tests")
    public ResponseEntity<String> createTest(@RequestBody Test test) {
        Test savedTest = testRepository.save(test);
        return new ResponseEntity("Test successfully added", HttpStatus.CREATED);
    }

    @PutMapping("/tests/{testId}")
    public ResponseEntity<String> updateTest(@PathVariable("testId") ObjectId testId, @RequestBody Test test) {
        Optional<Test> savedTest = testRepository.findById(testId);
        if (savedTest == null) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        } else {
            Test updatedTest = testRepository.save(test);
            return new ResponseEntity("Test details successfully updated", HttpStatus.OK);
        }
    }

    /*@GetMapping("/tests/{testId}")
    public ResponseEntity<String> retrieveTestByTestId(@RequestParam("testId") ObjectId testId) {

    }
     */
    /*@GetMapping("/tests")
    public ResponseEntity<String> retrieveAllTest(@RequestParam("testId") ObjectId testId) {

    }
    */
    @DeleteMapping("/tests/{testId}")
    public ResponseEntity<String> deleteTest(@PathVariable("testId") ObjectId testId) {
        Optional<Test> deleteTest = testRepository.findById(testId);
        if (!deleteTest.isPresent()) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        } else {
            testRepository.deleteById(testId);
            return new ResponseEntity("Test successfully deleted", HttpStatus.OK);
        }
    }
}
