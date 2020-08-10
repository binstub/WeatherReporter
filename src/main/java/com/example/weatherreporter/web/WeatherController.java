package com.example.weatherreporter.web;

import com.example.weatherreporter.entity.WeatherData;
import com.example.weatherreporter.service.WeatherService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/weather")
    public ResponseEntity addWeather(@RequestBody WeatherData weather) {
        int exists = weatherService.insertWeatherData(weather);
        if(exists == 0) return new ResponseEntity(HttpStatus.CREATED); // Weather record for id already exists
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/weather")
    public ResponseEntity<List<WeatherData>> getAllWeather() {
        List<WeatherData> data = weatherService.retrieveWeatherData();
        return new ResponseEntity<List<WeatherData>>(data, HttpStatus.OK);
    }
    @GetMapping("/weather/date={date}")
    public ResponseEntity<List<WeatherData>> getWeatherByDate(@PathVariable @JsonFormat(pattern="yyyy-MM-dd") String date) {
        List<WeatherData> data = weatherService.retrieveWeatherByDate(date);
        return new ResponseEntity<List<WeatherData>>(data, HttpStatus.OK);
    }
    @DeleteMapping("/erase")
    public void deleteAllWeather() {
        weatherService.deleteAllWeatherData();
    }

}
