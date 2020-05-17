package com.mavericsystems.digitalinterviewportal.services.dao;


import com.mavericsystems.digitalinterviewportal.models.User;
public interface UserService {
    User findByEmail(String email);
    User findByResetToken(String resetToken);
    public void save(User user);


}
