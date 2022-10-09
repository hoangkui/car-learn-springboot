package com.example.demo.car;

import com.example.demo.manufacture.ManufactureService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/api/v1/car")
public class CarController {
    private final CarService carService;
    @PostMapping("")
    public ResponseEntity<CarResponse> create(CarRequest req){
        return ResponseEntity.ok().body(carService.create(req));
    }
}
