package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverage() {
        Map<String, Double> resultMap = new HashMap<>();
        double sum = 0.0;
        double average = 0.0;
        int measures = 0;

        for (Map.Entry<String, Double> temperature :
        temperatures.getTemperatures().entrySet()) {
            sum = sum + temperature.getValue();
            measures++;
        }

        average = sum/(double)measures;
        return average;
    }

    public double calculateMedian() {
        Map<String, Double> resultMap = new HashMap<>();
        int measures = 0;
        List<Double> tempList = new ArrayList<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            measures++;
            tempList.add(temperature.getValue());
        }

        Collections.sort(tempList);
        double medianResult = 0.0;

        if (measures % 2 == 0){
            measures = measures/2;
            medianResult = (tempList.get(measures - 1) + tempList.get(measures)) / 2;
        } else {
            measures = (measures - 1)/2;
            medianResult = tempList.get(measures);
        }

        return medianResult;
    }
}
