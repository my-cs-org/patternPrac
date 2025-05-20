package com.ohgiraffers.pattern.chap01.creational.section02.factory;

/**
 * 설명. 팩토리 패턴의 팩토리(Factory) 클래스
 *  - 제품 객체 생성을 담당하는 클래스
 */
public class ProductFactory {

    /* 설명. 제품 유형에 따라 다른 제품 객체를 생성하는 팩토리 메소드 */
    public static Product createProduct(String type) throws IllegalArgumentException{
        if (type.equalsIgnoreCase("A")) {
            return new ConcreteProductA();
        } else if (type.equalsIgnoreCase("B")) {
            return new ConcreteProductB();
        }

        throw new IllegalArgumentException("지원하지 않는 제품 유형: " + type);
    }
}
