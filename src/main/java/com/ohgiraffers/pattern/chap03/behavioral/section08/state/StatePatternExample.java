package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴 사용 예제
 *  - 객체의 내부 상태가 변경될 때 행동이 변경되도록 함
 *  - 상태 전환 로직을 상태 클래스로 분리
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