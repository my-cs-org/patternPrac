package com.ohgiraffers.pattern.chap02.structural.section04.decorator;

/**
 * 설명. 구체 데코레이터 B - 컴포넌트에 다른 추가 상태를 더함
 */
public class ConcreteDecoratorB extends Decorator{
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    /* 설명. 변형된 기능 */
    @Override
    public String operation() {
        return super.operation() + " + 데코레이터B 기능";
    }

    /* 설명. 추가적인 상태 */
    public String newState() {
        return "데코레이터 B의 새로운 상태";
    }
}
