package com.example.demo.car;

import com.example.demo.manufacture.ManufactureResponse;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CarResponse {
    private Long id;
    private String name;
    private String model;
    private ManufactureResponse manu;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String buyDate;
}
