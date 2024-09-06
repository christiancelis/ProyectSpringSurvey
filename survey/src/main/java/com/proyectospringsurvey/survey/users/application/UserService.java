package com.proyectospringsurvey.survey.users.application;



import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.users.domain.Users;

@Service
public interface UserService{
    Users save(Users user);
}
