package com.mel.galaxy.util;

import java.awt.geom.Point2D;

import com.mel.galaxy.model.Planet;

public class Constant {

    public static final int COMMON_INT_ORBIT = 360;
    public static final double COMMON_DOUBLE_PRECISION = 0.01D;
    public static final double COMMON_DOUBLE_PROFIT_MARGIN_MIN = 0.8D;
    public static final double COMMON_DOUBLE_PROFIT_MARGIN_MAX = 2.0D;
    public static final String COMMON_STRING_DYNAMO_TABLE = "weather-prediction-mel";
    public static final int COMMON_STRING_DEFAULT_TEN_YEAR = 3365;
    public static final int COMMON_STRING_DEFAULT_YEAR = 365;

    public static final Point2D COMMON_SUN_POSITION = new Point2D.Double(0, 0);

    public static final Planet[] COMMON_ARRAY_PLANETS = {
            new Planet("Ferengi", 500, true, 1),
            new Planet("Betasoide", 2000, true, 3),
            new Planet("Vulcano", 1000, false, 5)

    };

    private Constant() {
        // private constructor
    }
}
