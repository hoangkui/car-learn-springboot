package com.example.demo.car;

import com.example.demo.manufacture.ManufactureService;
import com.example.demo.models.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller()
@AllArgsConstructor
@RequestMapping(path = "/api/v1/car")
public class CarController {
    private final CarService carService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> readFun(@RequestParam(required = false) String name, Pageable paging, @RequestParam(defaultValue = "-1") Long manu_id){
        return ResponseEntity.ok().body(new ResponseObject(true,"Read all car success",carService.readAll(name,manu_id,paging)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> readOne(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(new ResponseObject(true,"Read one success",carService.readOne(id)));
    }
    @PostMapping("")
    public ResponseEntity<ResponseObject> create(@RequestBody CarRequest req){
        return ResponseEntity.ok().body(new ResponseObject(true,"Create success",carService.create(req)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> edit(@PathVariable("id") Long id,@RequestBody CarRequest req){
        return ResponseEntity.ok().body(new ResponseObject(true,"Edit success",carService.edit(id,req)));

    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteManu(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(true, "Delete success", null));
    }
}
