package com.example.demo.manufacture;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ManufactureService {
    private final ManufactureRepository manufactureRepository;
    private final ManufactureMapper manufactureMapper;

    public ManufactureResponse create(ManufactureRequest request){
        String nameManu=request.getName();
        String address=request.getAddress();
        if(nameManu==null || address==null) throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"Name or address not null");
        ManufactureEntity entity=manufactureMapper.toEntity(request);
        List<ManufactureEntity> found=manufactureRepository.findByName(nameManu);
        if(!found.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"Name manu already existed");
        return manufactureMapper.toResponse(manufactureRepository.save(entity));
    }
    public List<ManufactureResponse> getAll(){
        return  manufactureRepository.findAll().stream().map(manu->manufactureMapper.toResponse(manu)).toList();
    }
    public ManufactureResponse read(Long id){
        ManufactureEntity found=manufactureRepository.findById(id).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"Id not found");
        });
        return manufactureMapper.toResponse(found);
    }
    public ManufactureResponse edit(Long id,ManufactureRequest req){
        String newName=req.getName();
        String newAddress=req.getAddress();
        ManufactureEntity found=manufactureRepository.findById(id).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"Id not found");
        });
        if(newName==null && newAddress==null) throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"name and address not implement");
        if(newName!=null) found.setName(newName);
        if(newAddress!=null) found.setAddress(newAddress);
        return manufactureMapper.toResponse(manufactureRepository.save(found));
    }
    public void delete(Long id){
        ManufactureEntity found=manufactureRepository.findById(id).orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"Id not found");
        });
        manufactureRepository.deleteById(id);
    }

}
