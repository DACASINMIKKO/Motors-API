package com.example.mikko.apimotors.services;

import com.example.mikko.apimotors.exceptions.ResourceNotFoundException;
import com.example.mikko.apimotors.models.Motor;
import com.example.mikko.apimotors.repositories.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorServiceIMPL implements MotorService{
    private final MotorRepository motorRepository;

    @Autowired
    public MotorServiceIMPL(MotorRepository motorRepository) {
        this.motorRepository = motorRepository;
    }

    @Override
    public List<Motor> getAllMotor() {
        return motorRepository.findAll();
    }

    @Override
    public Motor getMotorById(Long id) {
        Optional<Motor> motor = motorRepository.findById(id);
        if (motor.isPresent()) {
            return motor.get();
        } else {
            throw new ResourceNotFoundException("Motor not found");
        }
    }

    @Override
    public Motor saveMotor(Motor motor) {
        return motorRepository.save(motor);
    }

    @Override
    public Motor updateMotor(Motor motor, Long id) {
        Motor existingMotor = motorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motor not found"));
        existingMotor.setName(motor.getName());
        existingMotor.setTransmission(motor.getTransmission());
        existingMotor.setSumemplang(motor.isSumemplang());
        existingMotor.setPrice(motor.getPrice());
        return motorRepository.save(existingMotor);
    }

    @Override
    public void deleteMotor(Long id) {
        Motor existingMotor = motorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motor not found"));
        motorRepository.delete(existingMotor);
    }
}
