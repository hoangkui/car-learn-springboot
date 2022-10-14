package com.example.demo.car;

import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;


@Data
@Getter
public class CarRequest {
    private String name;
    private String model;
    private Long manu_id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime buyDate;
}
