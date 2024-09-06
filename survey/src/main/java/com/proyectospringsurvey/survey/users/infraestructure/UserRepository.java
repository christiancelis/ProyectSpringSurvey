package com.proyectospringsurvey.survey.users.infraestructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.users.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String username);


}
