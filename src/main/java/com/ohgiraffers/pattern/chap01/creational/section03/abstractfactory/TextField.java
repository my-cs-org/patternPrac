package com.ohgiraffers.pattern.chap01.creational.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 제품(Product) 인터페이스
 *  - 텍스트 필드 컴포넌트를 위한 인터페이스
 */
public interface TextField {
    void render();
    void getText();
}
