package com.example.dangermap;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepo {

    List<Point> pointList;

    public DataRepo() {
        this.pointList = new ArrayList<>();
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void addPoint(Point newPoint) {
        pointList.add(newPoint);
    }
}
