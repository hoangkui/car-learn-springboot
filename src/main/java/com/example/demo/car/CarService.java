package com.example.demo.car;

import com.example.demo.manufacture.ManufactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ManufactureService manufactureService;
    private final CarMapper carMapper;

    public CarResponse create(CarRequest req){
        CarEntity entity=carMapper.toEntity(req);
        manufactureService.read(req.getManu_id());
        return carMapper.toResponse(carRepository.save(entity));

    }
}
