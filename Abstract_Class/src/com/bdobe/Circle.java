package com.bdobe;

public class Circle extends Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    float getLength() {
        return (float) (2*Math.PI*radius);
    }

    @Override
    void draw() {
        System.out.printf("Circle, Area: %.2f, Length: %.2f\n",getArea(),getLength());
    }

    @Override
    float getArea() {
        return (float) (Math.PI*Math.pow(radius,2));
    }
}