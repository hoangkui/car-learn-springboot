package com.example.demo.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
}
