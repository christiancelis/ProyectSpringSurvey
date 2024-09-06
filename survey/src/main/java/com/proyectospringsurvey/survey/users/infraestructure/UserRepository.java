package com.proyectospringsurvey.survey.users.infraestructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectospringsurvey.survey.users.domain.Users;


public interface UserRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findByUsername(String username);


}
