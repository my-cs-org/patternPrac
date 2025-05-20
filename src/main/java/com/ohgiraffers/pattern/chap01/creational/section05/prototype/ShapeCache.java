package com.ohgiraffers.pattern.chap01.creational.section05.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명. 프로토타입 패턴의 캐시 클래스
 *  - 기존 객체의 복제본을 저장하고 제공
 */
public class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<>();

    /* 설명. 도형 객체 가져오기 (복제본 반환) */
    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }
    
    /* 설명. 기본 도형들을 로드하고 캐시에 저장 */
    public static void loadCache() {

        /* 설명. 원 객체 생성 및 설정 */
        Circle circle = new Circle();
        circle.setId("1");
        circle.setRadius(10);
        circle.setColor("빨강");
        shapeMap.put(circle.getId(), circle);

        /* 설명. 사각형 객체 생성 및 설정 */
        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        rectangle.setWidth(20);
        rectangle.setHeight(15);
        rectangle.setColor("파랑");
        shapeMap.put(rectangle.getId(), rectangle);

        /* 설명. 다른 원 객체 생성 및 설정 */
        Circle circle2 = new Circle();
        circle2.setId("3");
        circle2.setRadius(5);
        circle2.setColor("초록");
        shapeMap.put(circle2.getId(), circle2);
    }
}
