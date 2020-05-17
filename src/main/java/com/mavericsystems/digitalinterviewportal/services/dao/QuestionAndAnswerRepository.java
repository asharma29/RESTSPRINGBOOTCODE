package com.mavericsystems.digitalinterviewportal.services.dao;

import com.mavericsystems.digitalinterviewportal.models.Q_N_A;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionAndAnswerRepository extends MongoRepository<Q_N_A, ObjectId> {
}
