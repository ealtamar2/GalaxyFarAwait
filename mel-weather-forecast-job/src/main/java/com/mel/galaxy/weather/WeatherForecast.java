package com.mel.galaxy.weather;

import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mel.galaxy.model.Planet;
import com.mel.galaxy.model.Triangle;
import com.mel.galaxy.util.CommonUtil;
import com.mel.galaxy.util.Constant;

public class WeatherForecast {

    private List<Planet> arrayPlanet;
    private Map<Integer, Weather> weatherData;

    public WeatherForecast(List<Planet> arrayPlanet) {
        this.arrayPlanet = arrayPlanet;
    }

    public void predictWeather(int fromDay, int toDay) {

        weatherData = IntStream.rangeClosed(fromDay, toDay).boxed()
                .collect(Collectors.toMap(Function.identity(),
                        this::predictWeatherByDay));
    }

    /**
     * Metodo para predecir el Clima por Día
     * 
     * @param day
     * @return
     */
    public Weather predictWeatherByDay(int day) {

        List<Point2D> points = arrayPlanet.stream().map(p -> p.getPoint(day))
                .collect(Collectors.toList());

        Weather w = null;

        if ((w = rain(points)) != null || (w = drougth(points)) != null
                || (w = optimun(points)) != null) {

            // System.out.println(day);
            // DynamoUtil.getIntance().putItem(Constant.COMMON_STRING_DYNAMO_TABLE,
            // DynamoUtil.buildItem(day, w.getType().getValue()));

            return w;
        }

        return new Weather(WeatherType.UNKNONW_WEATHER);
    }

    /**
     * Metodo para validar si el dia Optimo
     * 
     * @param points
     * 
     * @return <code>Weather</code>
     */
    private Weather optimun(List<Point2D> points) {

        double prediction = CommonUtil.calculePointsCorrelation(points);
        if (prediction > Constant.COMMON_DOUBLE_PROFIT_MARGIN_MIN
                && prediction < Constant.COMMON_DOUBLE_PROFIT_MARGIN_MAX) {

            return new Weather(WeatherType.OPTIMAL_CONDITIONS);

        }

        return null;

    }

    /**
     * Metodo para validar si el dia es Seco
     * 
     * @param points
     * 
     * @return <code>Weather</code>
     */
    private Weather drougth(List<Point2D> points) {

        points.add(Constant.COMMON_SUN_POSITION);

        if (CommonUtil.checkStraightLine(points)) {
            return new Weather(WeatherType.DROUGHT_WEATHER);

        }

        return null;

    }

    /**
     * Metodo para validar si el dia es lluvioso
     * 
     * @param points
     * 
     * @return <code>Weather</code>
     */
    private Weather rain(List<Point2D> points) {

        Triangle planetsTriangle = new Triangle(points);

        if (planetsTriangle.isValid()
                && planetsTriangle.contains(Constant.COMMON_SUN_POSITION)) {

            return new Weather(WeatherType.RAIN_WEATHER,
                    planetsTriangle.perimeter());

        }
        return null;
    }

    /**
     * Metodo para obtener el mayor día de LLuvia segun el maximo perimetro
     * 
     * @return
     */
    public int getMaxDayRain() {
        return Collections.max(weatherData.entrySet(),
                new Comparator<Entry<Integer, Weather>>() {
                    @Override
                    public int compare(Entry<Integer, Weather> o1,
                            Entry<Integer, Weather> o2) {
                        return o1.getValue().getPerimeter() > o2.getValue()
                                .getPerimeter() ? 1 : -1;
                    }
                }).getKey();
    }

    /**
     * Metodo para calcular los periodos del Clima
     * 
     * @return
     */
    public Map<String, Integer> getWheatherPeriods() {

        Map<String, Integer> result = new HashMap<>();

        int maxRainDay = getMaxDayRain();
        result.put(WeatherType.MAX_RAIN_WEATHER.getValue(), maxRainDay);

        for (Entry<Integer, Weather> entry : weatherData.entrySet()) {

            String key = entry.getValue().getType().getValue();
            int value = null != result.get(key) ? result.get(key) : 0;
            result.put(key, ++value);

        }

        return result;

    }

    /**
     * Retorna un arreglo con el clima por día
     *
     * @see Map<Integer, Weather>
     */
    public Map<Integer, Weather> getWeatherData() {
        if (weatherData == null) {
            weatherData = new HashMap<>();
        }
        return weatherData;
    }

    /**
     * Retorna el arreglo de los planetas
     *
     * @see List<Planet>
     */
    public List<Planet> getArrayPlanet() {
        return arrayPlanet;
    }

}
