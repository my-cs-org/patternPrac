package com.ohgiraffers.pattern.chap01.creational.section02.factory;

/**
 * 설명. 팩토리 패턴의 구체적인 제품(Concrete Product) 클래스
 *  - Product 인터페이스를 구현하는 실제 제품
 */
public class ConcreteProductA implements Product {
    public ConcreteProductA() {
        System.out.println("제품 A가 생성 됨");
    }

    @Override
    public void use() {
        System.out.println("제품 A를 사용합니다.");
    }
}
