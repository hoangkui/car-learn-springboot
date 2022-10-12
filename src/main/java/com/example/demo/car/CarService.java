package com.example.demo.car;

import com.example.demo.manufacture.ManufactureEntity;
import com.example.demo.manufacture.ManufactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ManufactureService manufactureService;
    private final CarMapper carMapper;

    public String messageIdNotFound(Long id) {
        return "Id " + id + " not found";
    }

    public CarResponse create(CarRequest req) {
        CarEntity entity = carMapper.toEntity(req);
        ManufactureEntity manuEntity = manufactureService.readToEntity(req.getManu_id());
        entity.setManu(manuEntity);
        carRepository.save(entity);
        return carMapper.toResponse(entity);
    }


    public Page<CarEntity> pageForFilter(String name, Long manu_id, Pageable paging) {
        Optional<ManufactureEntity> manuEntity = manufactureService.readToEntityNotCheck(manu_id);
        return carRepository.findByNameContainingIgnoreCaseAndManu(Optional.ofNullable(name), manuEntity, paging);
    }


    public Map<String, Object> readAll(String name, Long manu_id, Pageable paging) {

        Map<String, Object> response = new HashMap<>();
        Page<CarEntity> pageCars = pageForFilter(name, manu_id, paging);
        response.put("cars", pageCars.getContent().stream().map(entity -> carMapper.toResponse(entity)));
        response.put("currentPage", pageCars.getNumber());
        response.put("totalItems", pageCars.getTotalElements());
        response.put("totalPages", pageCars.getTotalPages());
        return response;
    }

    public CarResponse readOne(Long id) {
        CarEntity entity = carRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, messageIdNotFound(id));
        });
        return carMapper.toResponse(entity);
    }

    public CarResponse edit(Long id, CarRequest req) {
        CarEntity entity = carRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, messageIdNotFound(id));
        });
        String name = req.getName();
        String model = req.getModel();
        Long manu_id = req.getManu_id();
        LocalDateTime buyDate = req.getBuyDate();
        if (name != null) entity.setName(name);
        if (model != null) entity.setModel(model);
        if (manu_id != null) entity.setManu(manufactureService.readToEntity(manu_id));
        if (buyDate != null) entity.setBuyDate(buyDate);
        return carMapper.toResponse(carRepository.save(entity));
    }

    public void delete(Long id) {
        carRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, messageIdNotFound(id));
        });
        carRepository.deleteById(id);
    }
}
