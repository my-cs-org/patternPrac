package com.ohgiraffers.pattern.chap02.structural.section04.decorator;

/**
 * 설명. 데코레이터 추상 클래스 - 모든 구체 데코레이터의 부모 클래스
 */
public class Decorator implements Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        return component.operation();
    }
}
