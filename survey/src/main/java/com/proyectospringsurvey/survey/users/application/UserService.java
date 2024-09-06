package com.proyectospringsurvey.survey.users.application;

import java.util.List;

import com.proyectospringsurvey.survey.users.domain.Users;

public interface UserService{
    List<Users> findAll();
    Users save(Users user);
}
