package com.mel.galaxy.model;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Triangle extends Polygon {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private transient List<Point2D> points;

    public Triangle(List<Point2D> points) {
        this.points = points;
        inicialize();

    }

    public void inicialize() {
        points.stream().forEach(p -> addPoint((int) p.getX(), (int) p.getY()));
    }

    /**
     * (X[i], Y[i]) are coordinates of i'th point.
     * 
     * @return
     */
    public double polygonArea() {
        // Initialize area
        double area = 0.0;
        // Calculate value of shoelace formula
        int j = points.size() - 1;
        for (int i = 0; i < points.size(); i++) {
            area += (points.get(j).getX() + points.get(i).getX())
                    * (points.get(j).getY() - points.get(i).getY());
            // j is previous vertex to i
            j = i;
        }
        // Return absolute value
        return Math.abs(area / 2.0);
    }

    public boolean isValid() {
        return polygonArea() != 0.0d;
    }

    public List<Point2D> getPoints() {
        if (points == null) {
            points = new ArrayList<>();
        }
        return points;
    }

    public void setPoints(List<Point2D> points) {
        this.points = points;
    }

    public double perimeter() {
        double distance = 0;
        int len = points.size();
        for (int i = 0; i < len; i++) {
            distance += points.get(i).distance(points.get((i + 1) % len));
        }
        return distance;
    }

}
