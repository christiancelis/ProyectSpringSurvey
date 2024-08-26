package com.proyectospringsurvey.survey.users.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")

@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "enabled", columnDefinition = "BOOL", nullable = false)
    private double enabled;

    @Column(name = "username", columnDefinition = "VARCHAR(12)", nullable = false)
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
    private String  password;
}


