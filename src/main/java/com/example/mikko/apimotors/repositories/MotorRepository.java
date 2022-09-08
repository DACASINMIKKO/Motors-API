package com.example.mikko.apimotors.repositories;

import com.example.mikko.apimotors.models.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {
}
