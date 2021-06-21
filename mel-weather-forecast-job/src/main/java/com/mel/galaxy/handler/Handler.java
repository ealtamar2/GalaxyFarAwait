package com.mel.galaxy.handler;

import java.util.Arrays;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mel.galaxy.util.Constant;
import com.mel.galaxy.weather.WeatherForecast;

// Handler value: com.mel.galaxy.HandlerWeatherData
public class Handler implements RequestHandler<Object, String> {

    private Gson gson = null;

    @Override
    public String handleRequest(Object event, Context context) {

        gson = new GsonBuilder().disableHtmlEscaping().create();

        LambdaLogger logger = context.getLogger();
        // process event
        logger.log("EVENT: " + event.toString());

        InputRequest inputRequest = gson.fromJson(event.toString(),
                InputRequest.class);

        WeatherForecast weatherForecast = new WeatherForecast(
                Arrays.asList(inputRequest.getPlanets()));

        weatherForecast.predictWeather(1,
                inputRequest.getYears() != null
                        ? inputRequest.getYears()
                                * Constant.COMMON_STRING_DEFAULT_YEAR
                        : Constant.COMMON_STRING_DEFAULT_TEN_YEAR);

        logger.log("RESULT: " + weatherForecast.getWheatherPeriods());

        return gson.toJson(weatherForecast.getWheatherPeriods());
    }

}