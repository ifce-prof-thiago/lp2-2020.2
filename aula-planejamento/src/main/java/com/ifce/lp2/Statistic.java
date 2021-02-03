package com.ifce.lp2;

import java.util.ArrayList;
import java.util.List;

public class Statistic {

    private double avg;
    private double min;
    private double max;
    private List<Integer> elements = new ArrayList<>();

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setElements(List<Integer> elements) {
        this.elements = elements;
    }

    public double getAvg() {
        return avg;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public List<Integer> getElements() {
        return elements;
    }

}
