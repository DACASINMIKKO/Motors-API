package com.example.mikko.apimotors.controllers;

import com.example.mikko.apimotors.models.Motor;
import com.example.mikko.apimotors.services.MotorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/motors")
public class MotorController {

    private final MotorService motorService;

    @GetMapping
    public ResponseEntity<List<Motor>> getAllMotor() {
        List<Motor> motors = motorService.getAllMotor();
        return ResponseEntity.ok(motors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motor> getMotorById(@PathVariable Long id) {
        Motor motor = motorService.getMotorById(id);
        return ResponseEntity.ok(motor);
    }

    @PostMapping
    public Motor postMotor(@RequestBody Motor motor) {
        return motorService.saveMotor(motor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motor> updateMotor(@RequestBody Motor motor, @PathVariable Long id) {
        return ResponseEntity.ok(motorService.updateMotor(motor, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMotor(@PathVariable Long id) {
        motorService.deleteMotor(id);
        return ResponseEntity.ok("Successfuly Deleted");
    }
}
