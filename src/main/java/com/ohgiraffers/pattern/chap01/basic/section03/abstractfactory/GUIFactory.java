package com.ohgiraffers.pattern.chap01.basic.section03.abstractfactory;


/**
 * 설명. 추상 팩토리 패턴의 추상 팩토리(Abstract Factory) 인터페이스
 *  - 관련된 여러 제품군을 생성하는 인터페이스 정의
 */
public interface GUIFactory {
    Button createButton();
    TextField createTextField();
}
