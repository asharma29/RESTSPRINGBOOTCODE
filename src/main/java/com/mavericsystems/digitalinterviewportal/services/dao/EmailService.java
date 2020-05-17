package com.mavericsystems.digitalinterviewportal.services.dao;

import com.mavericsystems.digitalinterviewportal.models.User;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public interface EmailService {
    public void sendEmail(SimpleMailMessage email);


}
