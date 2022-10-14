package com.example.demo.car;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository("carRepository")
public interface CarRepository extends JpaRepository<CarEntity,Long>, QuerydslPredicateExecutor<CarEntity> {

    Page<CarEntity> findAll(Predicate predicate, Pageable paging);

}
