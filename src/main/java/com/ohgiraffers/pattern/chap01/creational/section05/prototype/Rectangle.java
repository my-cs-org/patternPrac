package com.ohgiraffers.pattern.chap01.creational.section05.prototype;

/**
 * 설명. 프로토타입 패턴의 구체 클래스
 *  - 사각형 도형 구현
 */
public class Rectangle extends Shape {

    private int width;
    private int height;
    private String color;

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("사각형 그리기: 가로 " + width + ", 세로 " + height + ", 색상 " + color);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
