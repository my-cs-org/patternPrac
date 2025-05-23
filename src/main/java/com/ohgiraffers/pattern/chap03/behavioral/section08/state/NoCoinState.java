package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴의 구체적인 상태 클래스
 *  - 동전이 없는 상태를 나타냄
 */
public class NoCoinState implements State {
    private GumballMachine gumballMachine;
    
    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("동전이 투입되었습니다.");
        gumballMachine.setState(gumballMachine.getHasCoinState());
    }
    
    @Override
    public void ejectCoin() {
        System.out.println("동전을 넣어주세요.");
    }
    
    @Override
    public void turnCrank() {
        System.out.println("동전을 넣어주세요.");
    }
    
    @Override
    public void dispense() {
        System.out.println("동전을 먼저 넣어주세요.");
    }
} 