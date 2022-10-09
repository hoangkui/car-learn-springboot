package com.example.demo.car;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarRequest {
    private String name;
    private String model;
    private Long manu_id;
    private LocalDate buyDate;
}
