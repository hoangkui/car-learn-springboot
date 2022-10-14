package com.example.demo.car;

import com.example.demo.manufacture.ManufactureResponse;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
public class CarResponse {
    private Long id;
    private String name;
    private String model;
    private ManufactureResponse manu;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String buyDate;
}
