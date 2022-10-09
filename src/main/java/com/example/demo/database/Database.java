package com.example.demo.database;

import com.example.demo.manufacture.ManufactureController;

import com.example.demo.manufacture.ManufactureEntity;
import com.example.demo.manufacture.ManufactureRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase( ManufactureRepository manufactureRepository){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                ManufactureEntity manuA=new ManufactureEntity("Honda","23 Ly Thuong Kiet - P9 - Q10");
//                ManufactureEntity manuB=new ManufactureEntity("Toyota","23 Nguyen Van Cu - Q5");
//                logger.info("Insert data"+manufactureRepository.save(manuA));
//                logger.info("Insert data"+manufactureRepository.save(manuB));
//                Product productA=new Product("mac",2022,2400.0,"");
//                Product productB=new Product("dell",2021,2300.0,"");
//                logger.info("insert data"+productRepository.save(productA));
//                logger.info("insert data"+productRepository.save(productB));
            }
        };
    }
}
