package com.mavericsystems.digitalinterviewportal.services.dao;


import com.mavericsystems.digitalinterviewportal.models.User;
import com.mavericsystems.digitalinterviewportal.services.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
