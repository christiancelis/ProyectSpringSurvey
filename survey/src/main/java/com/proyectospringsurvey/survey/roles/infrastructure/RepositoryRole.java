package com.proyectospringsurvey.survey.roles.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectospringsurvey.survey.roles.domain.Roles;

public interface RepositoryRole extends JpaRepository<Roles,Long>{
    Optional<Roles> findByName(String name);
}
