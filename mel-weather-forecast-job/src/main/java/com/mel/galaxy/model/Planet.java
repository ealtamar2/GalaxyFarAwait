package com.mel.galaxy.model;

import java.awt.geom.Point2D;

import com.mel.galaxy.util.Constant;

public class Planet {

    private String name;
    private boolean isRigth;
    private int diaryDegrees;
    private int sunDistance;

    public Planet(String name, int sunDistance, boolean isRigth,
            int diaryDegrees) {

        this.name = name;
        this.sunDistance = sunDistance;
        this.isRigth = isRigth;
        this.diaryDegrees = diaryDegrees;
    }

    public Point2D getPoint(Integer day) {

        Integer degrees = getDegrees(day);

        double radians = Math.toRadians(degrees);

        double y = this.sunDistance * Math.sin(radians);
        double x = this.sunDistance * Math.cos(radians);

        return new Point2D.Double(x, y);
    }

    public Integer getDegrees(Integer day) {

        Integer currentDegrees = (diaryDegrees * day)
                % Constant.COMMON_INT_ORBIT;

        if (!isRigth && currentDegrees != 0) {
            currentDegrees = Constant.COMMON_INT_ORBIT - currentDegrees;
        }
        return currentDegrees;
    }

    public int getCurrentKilometers() {
        return sunDistance;
    }

    public void setCurrentKilometers(int currentKilometers) {
        this.sunDistance = currentKilometers;
    }

    public int getDiaryDegrees() {
        return diaryDegrees;
    }

    public void setDiaryDegrees(int diaryDegrees) {
        this.diaryDegrees = diaryDegrees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
