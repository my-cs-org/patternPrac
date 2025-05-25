package com.ohgiraffers.pattern.chap02.structural.section04.decorator;

/**
 * 설명. 데코레이터 패턴 사용 예제
 *  - 객체에 동적으로 새로운 책임을 추가
 *  - 상속보다 유연한 대안을 제공
 *  
 * 설명. 데코레이터 패턴의 장점
 *  1. 기존 코드를 수정하지 않고 객체의 기능을 동적으로 확장 가능
 *  2. 각 데코레이터가 단일 책임을 가지므로 SRP(단일 책임 원칙) 준수
 *  3. 상속보다 유연한 기능 확장 방법 제공
 *  4. 데코레이터 조합을 통해 다양한 기능 조합 가능
 *  
 * 설명. 데코레이터 패턴의 단점
 *  1. 데코레이터 객체가 많아지면 코드가 복잡해질 수 있음
 *  2. 데코레이터 순서에 따라 결과가 달라질 수 있어 디버깅이 어려울 수 있음
 *  3. 작은 객체들이 많이 생성되어 시스템 복잡도 증가 가능
 *  
 * 설명. 적절한 사용처
 *  1. 객체에 동적으로 책임을 추가하거나 제거해야 할 때
 *  2. 상속으로 서브클래스를 만드는 것이 비효율적일 때
 *  3. 특정 기능을 여러 객체에 적용해야 하지만 일부 객체에는 적용하지 않아야 할 때
 *  4. UI 컴포넌트, 스트림 처리, 로깅, 캐싱 등의 기능 추가 시
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
