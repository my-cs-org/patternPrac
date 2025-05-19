package com.ohgiraffers.pattern.chap01.basic.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 제품(Product) 인터페이스
 *  - 버튼 컴포넌트를 위한 인터페이스
 */
public interface Button {
    void render();
    void onClick();
}
