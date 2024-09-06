package com.proyectospringsurvey.survey.users.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.users.application.UserService;
import com.proyectospringsurvey.survey.users.domain.Users;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private final UserRepository userRepository;
    
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }
}
   