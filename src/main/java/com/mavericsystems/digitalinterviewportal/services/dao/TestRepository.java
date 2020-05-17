package com.mavericsystems.digitalinterviewportal.services.dao;

import com.mavericsystems.digitalinterviewportal.models.Test;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, ObjectId> {
}
