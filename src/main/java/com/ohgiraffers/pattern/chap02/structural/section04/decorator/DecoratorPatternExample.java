package com.ohgiraffers.pattern.chap02.structural.section04.decorator;

/**
 * 설명. 데코레이터 패턴 사용 예제
 *  - 객체에 동적으로 새로운 책임을 추가
 *  - 상속보다 유연한 대안을 제공
 */
public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 데코레이터 패턴 예제 실행 =====");

        /* 설명. 기본 컴포넌트 생성 */
        Component component = new ConcreteComponent();
        System.out.println("기본 컴포넌트: " + component.operation());

        /* 설명. 데코레이터 A로 장식 */
        Component decoratedA = new ConcreteDecoratorA(component);
        System.out.println("데코레이터 A 적용: " + decoratedA.operation());

        /* 설명. (A 위에) 데코레이터 B로 장식 */
        Component decoratedB = new ConcreteDecoratorB(decoratedA);
        System.out.println("(A 위에) 데코레이터 B 적용: " + decoratedB.operation());

        /* 설명. 데코레이터 B만 장식 */
        Component decoratedBOnly = new ConcreteDecoratorB(new ConcreteComponent());
        System.out.println("데코레이터 B만 적용: " + decoratedBOnly.operation());

        /* 설명. 각 데코레이터 특화 메소드 호출 */
        System.out.println("===== 데코레이터 특화 기능 =====");
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);
        System.out.println("데코레이터 A 특화 기능(additionalOperation): " + decoratorA.additionalOperation());

        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(component);
        System.out.println("데코레이터 B 특화 기능(newState): " + decoratorB.newState());
    }
}
