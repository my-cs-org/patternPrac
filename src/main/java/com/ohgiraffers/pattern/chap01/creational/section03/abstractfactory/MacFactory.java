package com.ohgiraffers.pattern.chap01.creational.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 구체적인 팩토리(Concrete Factory) 클래스
 *  - Mac 스타일의 UI 컴포넌트를 생성하는 팩토리
 */
public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}
