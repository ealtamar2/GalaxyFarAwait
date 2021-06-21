package com.mel.galaxy.handler;

import java.util.Arrays;

import com.mel.galaxy.model.Planet;

public class InputRequest {

    private Integer years;
    private Planet[] planets;

    public InputRequest() {
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Planet[] getPlanets() {
        return planets;

    }

    public void setPlanets(Planet[] planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "InputRequest [years=" + years + ", planets="
                + Arrays.toString(planets) + "]";
    }

}