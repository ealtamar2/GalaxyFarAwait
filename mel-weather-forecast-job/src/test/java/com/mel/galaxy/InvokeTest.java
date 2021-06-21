package com.mel.galaxy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Type;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mel.galaxy.handler.Handler;
import com.mel.galaxy.handler.InputRequest;
import com.mel.galaxy.util.Constant;
import com.mel.galaxy.weather.WeatherType;

class InvokeTest {
    private static final Logger logger = LoggerFactory
            .getLogger(InvokeTest.class);

    @Test
    void invokeTest() {

        logger.info("Invoke TEST");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        InputRequest event = new InputRequest();
        event.setYears(1);
        event.setPlanets(Constant.COMMON_ARRAY_PLANETS);

        Context context = new TestContext();
        Handler handler = new Handler();

        String result = handler.handleRequest(gson.toJson(event), context);
        assertTrue(result != null);
        logger.info("Result");
        logger.info("data: " + result);

        Type weatherMapType = new TypeToken<Map<String, Integer>>() {
        }.getType();

        Map<String, Integer> map = gson.fromJson(result, weatherMapType);
        assertTrue(map.get(WeatherType.RAIN_WEATHER.getValue()) > 0);
        assertTrue(map.get(WeatherType.OPTIMAL_CONDITIONS.getValue()) > 0);
        assertTrue(map.get(WeatherType.DROUGHT_WEATHER.getValue()) > 0);
        assertTrue(map.get(WeatherType.MAX_RAIN_WEATHER.getValue()) > 0);

    }

}
