package com.example.demo.manufacture;

import com.example.demo.models.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/manu")
public class ManufactureController {

    private final ManufactureService manufactureService;


    @GetMapping("")
    ResponseEntity<ResponseObject> getAllManu() {
        return ResponseEntity.ok().body(new ResponseObject(true,"get all manufacture success",manufactureService.getAll()));
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseObject(true,"get single manufacture success",manufactureService.read(id)));
    }

    @PostMapping("")
    ResponseEntity<ResponseObject> insertManu(@RequestBody ManufactureRequest newManu) {
        return ResponseEntity.ok().body(new ResponseObject(true, "Create new manu success", manufactureService.create(newManu)));
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> editManu(@PathVariable Long id, @RequestBody ManufactureRequest req) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(true, "edit success", manufactureService.edit(id,req)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteManu(@PathVariable Long id) {
        manufactureService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(true, "delete success", null));
    }

}