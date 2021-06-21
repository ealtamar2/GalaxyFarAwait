package com.mel.galaxy;

import java.util.Arrays;

import com.mel.galaxy.util.Constant;
import com.mel.galaxy.weather.WeatherForecast;

public class Main {

    public static void main(String[] args) {

        WeatherForecast weatherForecast = new WeatherForecast(
                Arrays.asList(Constant.COMMON_ARRAY_PLANETS));

        weatherForecast.predictWeather(1, 3365);

        System.out.println(weatherForecast.getWheatherPeriods());

    }

}
