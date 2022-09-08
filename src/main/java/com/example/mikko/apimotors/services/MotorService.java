package com.example.mikko.apimotors.services;

import com.example.mikko.apimotors.models.Motor;

import java.util.List;

public interface MotorService {
    List<Motor> getAllMotor();

    Motor getMotorById(Long id);

    Motor saveMotor(Motor motor);

    Motor updateMotor(Motor motor, Long id);

    void deleteMotor(Long id);
}
