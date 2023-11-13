package com.bdobe;

//Heron's formula : https://en.wikipedia.org/wiki/Heron%27s_formula
public class Triangle extends Shape {
    int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    float getLength() {
        return a+b+c;
    }

    @Override
    void draw() {
        //Triangle, Area: 43.30, Length: 30.00
        System.out.printf("Triangle, Area: %.2f, Length: %.2f",getArea(),getLength());

    }

    @Override
    float getArea() {
        float p = (float) (0.5*(a+b+c));
        return (float) Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}