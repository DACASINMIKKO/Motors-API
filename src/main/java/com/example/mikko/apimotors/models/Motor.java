package com.example.mikko.apimotors.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Motor {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String transmission;
    @Column(name = "is_sumemplang")
    private boolean isSumemplang;
    private double price;
}
