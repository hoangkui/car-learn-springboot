package com.example.demo.manufacture;

import com.example.demo.models.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/manu")
public class ManufactureController {

    private final ManufactureService manufactureService;


    @GetMapping("")
    ResponseEntity<ResponseObject> getAllManu(Pageable pageable) {
        return ResponseEntity.ok().body(new ResponseObject(true,"Get all manufacture success",manufactureService.getAll(pageable)));
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseObject(true,"Get single manufacture success",manufactureService.read(id)));
    }

    @PostMapping("")
    ResponseEntity<ResponseObject> insertManu(@RequestBody ManufactureRequest newManu) {
        return ResponseEntity.ok().body(new ResponseObject(true, "Create new manu success", manufactureService.create(newManu)));
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> editManu(@PathVariable Long id, @RequestBody ManufactureRequest req) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(true, "Edit success", manufactureService.edit(id,req)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteManu(@PathVariable Long id) {
        manufactureService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(true, "Delete success", null));
    }

}