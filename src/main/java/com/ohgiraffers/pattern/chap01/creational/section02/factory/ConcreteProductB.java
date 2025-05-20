package com.ohgiraffers.pattern.chap01.creational.section02.factory;

/**
 * 설명. 팩토리 패턴의 구체적인 제품(Concrete Product) 클래스
 *  - Product 인터페이스를 구현하는 또 다른 실제 제품
 */
public class ConcreteProductB implements Product {
    public ConcreteProductB() {
        System.out.println("제품 B가 생성 됨");
    }

    @Override
    public void use() {
        System.out.println("제품 B를 사용합니다.");
    }
}
