package com.example.weatherreporter.service;

import com.example.weatherreporter.entity.WeatherData;

import java.util.List;

public interface WeatherService {
    int insertWeatherData(WeatherData weather);
    List<WeatherData> retrieveWeatherData();
    List<WeatherData> retrieveWeatherByDate(String date);
    void deleteAllWeatherData();

}
