package com.mavericsystems.digitalinterviewportal.services.dao;

import com.mavericsystems.digitalinterviewportal.models.Candidate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate, ObjectId> {

}
