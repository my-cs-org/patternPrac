package com.ohgiraffers.pattern.chap02.structural.section04.decorator;

/**
 * 설명. 구체 데코레이터 A - 컴포넌트에 추가 기능을 더함
 */
public class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    /* 설명. 변형된 기능 */
    @Override
    public String operation() {
        return super.operation() + " + 데코레이터A 기능";
    }

    /* 설명. 추가적인 기능 */
    public String additionalOperation() {
        return "데코레이터 A의 추가 기능";
    }
}
