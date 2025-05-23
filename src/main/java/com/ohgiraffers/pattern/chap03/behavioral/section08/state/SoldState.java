package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴의 구체적인 상태 클래스
 *  - 판매 상태를 나타냄
 */
public class SoldState implements State {
    private GumballMachine gumballMachine;
    
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("잠시만 기다려주세요. 껌볼이 나오고 있습니다.");
    }
    
    @Override
    public void ejectCoin() {
        System.out.println("이미 손잡이를 돌렸습니다.");
    }
    
    @Override
    public void turnCrank() {
        System.out.println("손잡이는 한 번만 돌려주세요.");
    }
    
    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoCoinState());
        } else {
            System.out.println("껌볼이 매진되었습니다.");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
} 