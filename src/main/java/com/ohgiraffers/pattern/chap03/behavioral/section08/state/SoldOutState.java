package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴의 구체적인 상태 클래스
 *  - 매진 상태를 나타냄
 */
public class SoldOutState implements State {
    private GumballMachine gumballMachine;
    
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("동전을 넣을 수 없습니다. 매진되었습니다.");
    }
    
    @Override
    public void ejectCoin() {
        System.out.println("동전을 반환할 수 없습니다. 동전을 넣지 않았습니다.");
    }
    
    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌릴 수 없습니다. 매진되었습니다.");
    }
    
    @Override
    public void dispense() {
        System.out.println("껌볼을 내보낼 수 없습니다.");
    }
} 