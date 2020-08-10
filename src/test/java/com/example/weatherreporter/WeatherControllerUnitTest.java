package com.example.weatherreporter;

import com.example.weatherreporter.service.WeatherService;
import com.example.weatherreporter.web.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    WeatherService weatherService;

    @Test
    public void getAllWeather() throws Exception {
        mockMvc.perform(get("/weather/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(weatherService, times(1)).retrieveWeatherData();
    }

    @Test
    public void getWeatherByDate() throws Exception {
        mockMvc.perform(get("/weather/date=1985-01-01"))
                .andExpect(status().isOk());

        verify(weatherService, times(1)).retrieveWeatherByDate("1985-01-01");
    }

}
