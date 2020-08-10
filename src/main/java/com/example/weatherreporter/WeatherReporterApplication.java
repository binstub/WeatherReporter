package com.example.weatherreporter;

import com.example.weatherreporter.entity.Location;
import com.example.weatherreporter.entity.WeatherData;
import com.example.weatherreporter.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableMongoRepositories
public class WeatherReporterApplication implements CommandLineRunner {
	@Autowired
	private WeatherRepository weatherRepository;

	public static void main(String[] args) {
		SpringApplication.run(WeatherReporterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		weatherRepository.deleteAll();

		System.out.println("Preloading data");

		Location location = new Location(36.1189,-86.6892, "Palo-Alto", "California");
		//Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1985-01-01");
		LocalDate date = LocalDate.parse("1985-01-01");
		double[] temperature = new double[]{36.7, 37, 34.8, 37, 37.1, 36.9, 37.9, 37.7, 38, 38.2, 38.4, 38.9, 39, 39, 40, 40.5, 41, 41.3, 42,40,39,38.3};

		WeatherData data = new WeatherData("1", date, location, temperature);
		System.out.println("saving data");
		weatherRepository.save(data);
		System.out.println("created data");
	}
}
