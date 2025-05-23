package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴의 구체적인 상태 클래스
 *  - 동전이 투입된 상태를 나타냄
 */
public class HasCoinState implements State {
    private GumballMachine gumballMachine;
    
    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("이미 동전이 있습니다.");
    }
    
    @Override
    public void ejectCoin() {
        System.out.println("동전이 반환됩니다.");
        gumballMachine.setState(gumballMachine.getNoCoinState());
    }
    
    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌렸습니다.");
        gumballMachine.setState(gumballMachine.getSoldState());
    }
    
    @Override
    public void dispense() {
        System.out.println("먼저 손잡이를 돌려주세요.");
    }
} 