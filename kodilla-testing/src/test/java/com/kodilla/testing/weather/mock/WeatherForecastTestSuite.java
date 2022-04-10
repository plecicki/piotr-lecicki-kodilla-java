package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName(
        "Weather Forecast Tests"
)
public class WeatherForecastTestSuite {

    private static int number = 0;

    @BeforeEach
    public void before() {
        number++;
        System.out.println("Test number " + number + ": begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test number " + number + ": end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests end");
    }

    @Mock
    private Temperatures temperaturesMock;

    public static Map<String, Double>  WeatherForecastMock() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        return temperaturesMap;
    }

    @DisplayName(
            "Calculation future weather - Test"
    )
    @Test
    void testCalculateForecastWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(WeatherForecastMock());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName(
            "Calculation of the average temperature - Test"
    )
    @Test
    void testCalculateAverageWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(WeatherForecastMock());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double averageTemp = weatherForecast.calculateAverage();

        //Then
        Assertions.assertEquals(25.56, averageTemp);
    }

    @DisplayName(
            "Calculation of the median value of temperatures - Test"
    )
    @Test
    void testCalculateMedianWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(WeatherForecastMock());
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double medianTemp = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.5, medianTemp);
    }
}
