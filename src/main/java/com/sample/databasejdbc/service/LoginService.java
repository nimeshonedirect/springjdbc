package com.sample.databasejdbc.service;

import com.sample.databasejdbc.entity.User;
import com.sample.databasejdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;
    public User validateUser(String username, String password) {
        //User user = userRepository.findByUsernameAndAndPassword(username,password);
        User user = userRepository.findByUserName(username);
        if(encoder.matches(password,user.getPassword()))
            return user;
        return null;

    }
}
