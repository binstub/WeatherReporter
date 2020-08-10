package com.example.weatherreporter.service;

import com.example.weatherreporter.entity.WeatherData;
import com.example.weatherreporter.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    WeatherRepository weatherRepository;

    @Override
    public List<WeatherData> retrieveWeatherData() {
        return (List<WeatherData>) weatherRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<WeatherData> retrieveWeatherByDate(String dateStr) {
        LocalDate date = null;
        date = LocalDate.parse(dateStr);
        System.out.println("Retrieve by date:"+date);
        return (List<WeatherData>) weatherRepository.findByDateOrderByIdAsc(date);
    }

    @Override
    public void deleteAllWeatherData() {
        weatherRepository.deleteAll();
    }

    @Override
    public int insertWeatherData(WeatherData weather) {
        if(weatherRepository.existsById(weather.getId())) {
            return 1;
        }
        weatherRepository.save(weather);
        return 0;
    }
}
