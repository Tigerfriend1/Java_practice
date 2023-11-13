package com.bdobe;

public class Rectangle extends Shape {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    float getLength() {
        return (width+height)*2;
    }

    @Override
    void draw() {
        System.out.printf("Rectangle, Area: %.2f, Length: %.2f",getArea(),getLength());
    }

    @Override
    float getArea() {
        return width*height;
    }
}