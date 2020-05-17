package com.mavericsystems.digitalinterviewportal.services.dao;

import com.mavericsystems.digitalinterviewportal.models.Candidate;
import com.mavericsystems.digitalinterviewportal.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByResetToken(String resetToken);
}
