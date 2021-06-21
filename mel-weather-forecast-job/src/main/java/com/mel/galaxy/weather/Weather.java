package com.mel.galaxy.weather;

public class Weather {

    private int day;
    private WeatherType type;
    private Double perimeter;

    public Weather(WeatherType type, int day, Double perimeter) {
        this.type = type;
        this.day = day;
        this.perimeter = perimeter;

    }

    public Weather(WeatherType type, Double perimeter) {
        this.type = type;
        this.perimeter = perimeter;

    }

    public Weather(WeatherType type) {
        this.type = type;
        this.setPerimeter(0.0D);
    }

    public WeatherType getType() {
        return type;
    }

    public void setType(WeatherType type) {
        this.type = type;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public String toString() {
        return type.getValue();
    }

}
