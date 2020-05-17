package com.mavericsystems.digitalinterviewportal.services.dao;

import com.mavericsystems.digitalinterviewportal.models.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

}