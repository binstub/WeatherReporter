package com.example.weatherreporter.repository;

import com.example.weatherreporter.entity.WeatherData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends MongoRepository<WeatherData,String>{

    List<WeatherData> findAll();
    List<WeatherData> findByDateOrderByIdAsc(LocalDate date);
}
