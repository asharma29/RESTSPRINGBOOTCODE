package com.mavericsystems.digitalinterviewportal.services.security;

import com.mavericsystems.digitalinterviewportal.services.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        com.mavericsystems.digitalinterviewportal.models.User availableUser = userRepository.findByEmail(emailId);
        if (availableUser == null) {
            throw new UsernameNotFoundException("User not exist with the email id : " + emailId);
        }
        else if (emailId.equals(availableUser.getEmail())) {
            System.out.println("user password: "+availableUser.getPassword());
            return new User(availableUser.getEmail(), availableUser.getPassword(),
                    new ArrayList<>());
        }
        return null;
    }

}
