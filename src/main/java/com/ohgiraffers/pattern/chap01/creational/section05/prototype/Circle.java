package com.ohgiraffers.pattern.chap01.creational.section05.prototype;

/**
 * 설명. 프로토타입 패턴의 구체 클래스
 *  - 원 도형 구현
 */
public class Circle extends Shape{
    private int radius;
    private String color;

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("원 그리기: 반지름 " + radius + ", 색상 " + color);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
