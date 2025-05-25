package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴 사용 예제
 *  - 객체의 내부 상태가 변경될 때 행동이 변경되도록 함
 *  - 상태 전환 로직을 상태 클래스로 분리
 *
 * 설명. 상태 패턴의 장점
 *  1. 상태에 따른 동작을 개별 클래스로 분리하여 코드 가독성 향상
 *  2. 새로운 상태 추가가 용이함(개방-폐쇄 원칙)
 *  3. 상태 전이 로직을 한 곳에서 관리할 수 있음
 *  4. 조건문(if-else, switch)을 제거하여 코드 복잡도 감소
 *
 * 설명. 상태 패턴의 단점
 *  1. 상태 클래스 수가 많아지면 관리가 복잡해질 수 있음
 *  2. 상태 전환 로직이 여러 클래스에 분산될 수 있음
 *  3. 간단한 상태 관리에는 오버엔지니어링이 될 수 있음
 *  4. 상태 객체 간 의존성이 생길 경우 결합도가 높아질 수 있음
 *
 * 설명. 적절한 사용처
 *  1. 객체의 행동이 상태에 따라 크게 달라지는 경우
 *  2. 상태 전환 규칙이 복잡한 경우
 *  3. 대규모 조건문(if-else, switch)을 대체해야 할 경우
 *  4. 자판기, 워크플로우 시스템, 게임 캐릭터 상태 관리 등
 */
public class StatePatternExample {
    public static void main(String[] args) {
        System.out.println("상태 패턴 예제 실행");
        
        /* 설명. 5개의 껌볼이 있는 껌볼 자판기 생성 */
        GumballMachine gumballMachine = new GumballMachine(5);
        
        /* 설명. 초기 상태 출력 */
        System.out.println(gumballMachine);
        
        /* 설명. 동전 투입 */
        System.out.println("===== 동전 투입 =====");
        gumballMachine.insertCoin();
        System.out.println(gumballMachine);
        
        /* 설명. 손잡이 돌리기 */
        System.out.println("\n=== 손잡이 돌리기 =====");
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        
        /* 설명. 동전 투입 후 반환 */
        System.out.println("\n=== 동전 투입 후 반환 =====");
        gumballMachine.insertCoin();
        gumballMachine.ejectCoin();
        System.out.println(gumballMachine);
        
        /* 설명. 동전 투입 없이 손잡이 돌리기 */
        System.out.println("\n=== 동전 없이 손잡이 돌리기 =====");
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        
        /* 설명. 남은 껌볼 모두 판매 */
        System.out.println("\n=== 남은 껌볼 모두 판매 ===");
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        
        /* 설명. 매진된 상태에서 동전 투입 시도 */
        System.out.println("\n=== 매진 상태에서 동전 투입 ===");
        gumballMachine.insertCoin();
        System.out.println(gumballMachine);
    }
} 