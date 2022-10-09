package com.example.demo.car;

import com.example.demo.manufacture.ManufactureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String model;
    @OneToOne
//    @JoinColumn(name = "manu",referencedColumnName = "id")
    private ManufactureEntity manu;
    private LocalDate buyDate;
}
