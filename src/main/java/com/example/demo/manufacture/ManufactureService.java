package com.example.demo.manufacture;


import com.example.demo.car.CarEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ManufactureService {
    private final ManufactureRepository manufactureRepository;
    private final ManufactureMapper manufactureMapper;

    public ManufactureResponse create(ManufactureRequest request) {
        String nameManu = request.getName();
        String address = request.getAddress();
        if (nameManu == null || address == null)
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Name or address not null");
        ManufactureEntity entity = manufactureMapper.toEntity(request);
        List<ManufactureEntity> found = manufactureRepository.findByName(nameManu);
        if (!found.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Name manu already existed");
        return manufactureMapper.toResponse(manufactureRepository.save(entity));
    }

    public Map<String, Object>  getAll(Pageable pageable) {
        Map<String, Object> response = new HashMap<>();
        Page<ManufactureEntity> pageManu = manufactureRepository.findAll(pageable);
        response.put("cars", pageManu.getContent());
        response.put("currentPage", pageManu.getNumber());
        response.put("totalItems", pageManu.getTotalElements());
        response.put("totalPages", pageManu.getTotalPages());
        return response;
    }

    public ManufactureResponse read(Long id) {
        ManufactureEntity found = manufactureRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Id "+id+" not found");
        });
        return manufactureMapper.toResponse(found);
    }

    public ManufactureResponse edit(Long id, ManufactureRequest req) {
        String newName = req.getName();
        String newAddress = req.getAddress();
        ManufactureEntity found = manufactureRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Id "+id+" not found");
        });
        if (newName == null && newAddress == null)
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "name and address not in body...");
        if (newName != null) found.setName(newName);
        if (newAddress != null) found.setAddress(newAddress);
        return manufactureMapper.toResponse(manufactureRepository.save(found));
    }

    public void delete(Long id) {
        manufactureRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Id "+id+" not found");
        });
        try {
            manufactureRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    public ManufactureEntity readToEntity(Long id) {
        return manufactureRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Id "+id+" not found");
        });
    }


}
