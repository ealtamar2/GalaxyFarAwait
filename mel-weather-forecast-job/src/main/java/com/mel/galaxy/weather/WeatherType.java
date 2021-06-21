package com.mel.galaxy.weather;

public enum WeatherType {

    DROUGHT_WEATHER("Tiempo de Sequía"), RAIN_WEATHER(
            "Tiempo LLuvioso"), MAX_RAIN_WEATHER(
                    "Día más LLuvioso"), OPTIMAL_CONDITIONS(
                            "Presión y temperatura óptimas"), UNKNONW_WEATHER(
                                    "Desconocido");

    private final String value;

    private WeatherType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
