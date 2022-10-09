package com.example.demo.car;

import com.example.demo.manufacture.ManufactureResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CarResponse {
    private Long id;
    private String name;
    private String model;
    private ManufactureResponse manu;
    private LocalDate buyDate;
}
