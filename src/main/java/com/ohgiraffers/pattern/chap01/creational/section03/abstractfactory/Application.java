package com.ohgiraffers.pattern.chap01.creational.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 클라이언트 클래스
 *  - 구체적인 팩토리 유형을 모른 채 팩토리 인터페이스를 사용
 */
public class Application {
    private Button button;
    private TextField textField;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        textField = factory.createTextField();
    }

    public void renderUI() {
        button.render();
        textField.render();
    }

    public void handleUserInput() {
        button.onClick();
        textField.getText();
    }
}
