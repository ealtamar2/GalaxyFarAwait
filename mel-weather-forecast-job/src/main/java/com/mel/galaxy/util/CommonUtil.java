package com.mel.galaxy.util;

import java.awt.geom.Point2D;
import java.util.List;

public class CommonUtil {

    /**
     * Metodo para validar si los puntos estan +- alineados
     * 
     * @param points
     * 
     * @return <code>Weather</code>
     */
    public static double calculePointsCorrelation(List<Point2D> points) {

        double xy = 0;
        double x = 0;
        double y = 0;
        double powX = 0;
        double powY = 0;

        for (Point2D p : points) {

            xy += p.getX() * p.getY();

            x += p.getX();
            y += p.getY();

            powX += Math.pow(x, 2);
            powY += Math.pow(y, 2);

        }

        int positionsCount = points.size();
        double numerator = (positionsCount * xy) - (x * y);

        double denominatorX = Math
                .sqrt((positionsCount * powX) - Math.pow(x, 2));
        double denominatorY = Math
                .sqrt((positionsCount * powY) - Math.pow(y, 2));
        double denominator = denominatorX * denominatorY;

        return Math.abs(Math.pow(numerator / denominator, 2));

    }

    /**
     * Metodo que valida si los puntos conforman una linea recta.
     * 
     * @param point
     * @return
     */
    public static boolean checkStraightLine(List<Point2D> point) {

        double slope = slope(point.get(0), point.get(1));

        for (int i = 2; i < point.size(); i++) {
            if (slope != slope(point.get(0), point.get(i))) {
                return false;
            }
        }
        return true;

    }

    /**
     * Metodo para calcular la pendiente de dos puntos
     * 
     * @param p1
     * @param p2
     * 
     * @return
     */
    public static double slope(Point2D p1, Point2D p2) {

        if ((p1.getX() - p2.getX()) == 0) {
            return 0;
        }

        return ((p1.getY() - p2.getY()) * 1.0)
                / ((p1.getX() - p2.getX()) * 1.0);
    }
}
