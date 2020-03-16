package com.example.dangermap;

public class Point {

    private String country;
    private double x;
    private double y;
    private String text;

    public Point(double x, double y, String text, String country) {
        this.country = country;
        this.x = x;
        this.y = y;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Point{" +
                "country='" + country + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", text='" + text + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
