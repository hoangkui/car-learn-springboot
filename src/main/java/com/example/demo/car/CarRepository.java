package com.example.demo.car;

import com.example.demo.manufacture.ManufactureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("carRepository")
public interface CarRepository extends JpaRepository<CarEntity,Long>  {
    @Query("select distinct car from CarEntity car where"+"(:name is null or UPPER(car.name) like UPPER(concat('%',:name,'%')))" + " and (:manu is null or car.manu = :manu)")
    Page<CarEntity> findByNameContainingIgnoreCaseAndManu(@Param("name") Optional<String> name ,@Param("manu") Optional<ManufactureEntity> manufacture , Pageable pageable);


}
