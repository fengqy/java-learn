package com.wallace.observer;

/**
 * @author fengqy
 * @date 2015/12/11.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay currentDisplay=new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(12,13,14);
    }
}
