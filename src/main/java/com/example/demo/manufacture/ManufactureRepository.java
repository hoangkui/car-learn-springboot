package com.example.demo.manufacture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufactureRepository extends JpaRepository<ManufactureEntity,Long> {
    List<ManufactureEntity> findByName(String manuName);
}
