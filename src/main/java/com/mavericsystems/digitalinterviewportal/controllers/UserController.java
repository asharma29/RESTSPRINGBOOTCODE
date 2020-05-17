package com.mavericsystems.digitalinterviewportal.controllers;

import com.mavericsystems.digitalinterviewportal.models.Candidate;
import com.mavericsystems.digitalinterviewportal.models.Employee;
import com.mavericsystems.digitalinterviewportal.models.User;
import com.mavericsystems.digitalinterviewportal.services.dao.CandidateRepository;
import com.mavericsystems.digitalinterviewportal.services.dao.EmployeeRepository;
import com.mavericsystems.digitalinterviewportal.services.dao.UserRepository;
import com.mavericsystems.digitalinterviewportal.services.exception.CommonException;
import com.mavericsystems.digitalinterviewportal.services.exception.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @GetMapping("/")
    public String loginController() {
        return "Hi There Folks";
    }

    @GetMapping("/users")
    public ResponseEntity<String> fetchUserDetails() {
        List<User> savedUser = userRepository.findAll();
        return new ResponseEntity(savedUser, HttpStatus.OK);
    }

    @GetMapping("/candidates")
    public ResponseEntity<String> fetchCandidatesDetails() {
        List<Candidate> savedCandidate = candidateRepository.findAll();
        return new ResponseEntity(savedCandidate, HttpStatus.OK);
    }

    @PutMapping("/candidates/{candidateId}")
    public ResponseEntity<String> updateCandidateDetails(@PathVariable("candidateId") ObjectId candidateId, @RequestBody Candidate candidate) {
        Optional<Candidate> existingCandidate = candidateRepository.findById(candidateId);
        if (existingCandidate == null) {
            throw new CommonException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unknown error");
        } else {
            // Candidate candidateWithPassword = setObjectIdForCandidate(candidate);
            candidate.set_id(candidateId);
            Candidate savedCandidate = candidateRepository.save(candidate);
            return new ResponseEntity("Candidate Record successfully updated", HttpStatus.OK);
        }
    }

    @DeleteMapping("/candidates/{candidateId}")
    public ResponseEntity<String> deleteCandidateDetails(@PathVariable("candidateId") ObjectId candidateId) {
        Optional<Candidate> existingCandidate = candidateRepository.findById(candidateId);
        if (!existingCandidate.isPresent()) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        } else {
            candidateRepository.deleteById(candidateId);
            return new ResponseEntity("Candidate successfully deleted", HttpStatus.OK);
        }
    }

    @GetMapping("/candidates/{candidateId}")
    public ResponseEntity<String> fetchCandidateDetailsById(@PathVariable("candidateId") ObjectId candidateId) {
        Optional<Candidate> existingCandidate = candidateRepository.findById(candidateId);
        if (!existingCandidate.isPresent()) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        } else {
            return new ResponseEntity(existingCandidate, HttpStatus.OK);
        }
    }

    @PostMapping("/candidates")
    public ResponseEntity<String> registerCandidates(@RequestBody Candidate candidate) {
        Candidate candidateWithPassword = setObjectIdForCandidate(candidate);
        User savedUser = userRepository.save(candidate.getUser());
        Candidate savedCandidate = candidateRepository.save(candidateWithPassword);
        return new ResponseEntity("Candidate successfully registered", HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<String> fetchEmployeeDetails() {
        List<Employee> candidateList = employeeRepository.findAll();
        return new ResponseEntity(candidateList, HttpStatus.OK);
    }
    

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<String> fetchEmployeeDetailsById(@PathVariable("employeeId") ObjectId employeeId) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
        if (!existingEmployee.isPresent()) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        } else {
            return new ResponseEntity(existingEmployee, HttpStatus.OK);
        }
    }


@DeleteMapping("/employees/{employeeId}")
public ResponseEntity<String> deleteEmployeeDetails(@PathVariable("employeeId") ObjectId employeeId) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
        if (!existingEmployee.isPresent()) {
        throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "The specified resource was not found");
        } else {
        employeeRepository.deleteById(employeeId);
        return new ResponseEntity("Candidate successfully deleted", HttpStatus.OK);
        }
        }

@PutMapping("/employees/{employeesId}")
public ResponseEntity<String> updateEmployeeDetails(@PathVariable("employeesId") ObjectId employeesId, @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeesId);
        if (existingEmployee == null) {
        throw new CommonException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unknown error");
        } else {
        // Employee employeeWithPassword = setObjectIdForEmployee(employee);
        employee.set_id(employeesId);
        User user = userRepository.save(employee.getUser());
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity("Employees data successfully updates", HttpStatus.CREATED);
        }
        }

@PostMapping("/employees")
public ResponseEntity<String> registerEmployee(@RequestBody Employee employee) {
        Employee employeeWithPassword = setObjectIdForEmployee(employee);
        User user = userRepository.save(employeeWithPassword.getUser());
        Employee savedCandidate = employeeRepository.save(employeeWithPassword);
        return new ResponseEntity("Employees successfully registered", HttpStatus.CREATED);
        }

public Employee setObjectIdForEmployee(Employee employee) {
        ObjectId id = new ObjectId();
        employee.set_id(id);
        employee.getUser().set_id(id);
        System.out.println("Id: " + id);
        employee.getUser().setPassword(bcryptEncoder.encode(employee.getUser().getPassword()));
        System.out.println("employee password: " + employee.getUser().getPassword());
        return employee;
        }

public Candidate setObjectIdForCandidate(Candidate candidate){
        ObjectId id = new ObjectId();
        candidate.set_id(id);
        candidate.getUser().set_id(id);
        candidate.getUser().setPassword(bcryptEncoder.encode(candidate.getUser().getPassword()));
        System.out.println("Id: " + id);
        return candidate;
        }
        }
