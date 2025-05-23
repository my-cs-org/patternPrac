package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴의 컨텍스트 클래스
 *  - 현재 상태를 유지하고 상태에 따른 행동을 위임
 */
public class GumballMachine {

    /* 설명. 상태 객체들 */
    private State soldOutState;
    private State noCoinState;
    private State hasCoinState;
    private State soldState;
    
    private State state;        // 현재 상태
    private int count = 0;      // 남은 껌볼 개수
    
    public GumballMachine(int numberOfGumballs) {

        /* 설명. 상태 객체 생성 */
        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        
        this.count = numberOfGumballs;

        /* 설명. 초기 상태 설정 */
        if (numberOfGumballs > 0) {
            state = noCoinState;
        } else {
            state = soldOutState;
        }
    }
    
    /* 설명. 동전 투입 */
    public void insertCoin() {
        state.insertCoin();
    }
    
    /* 설명. 동전 반환 */
    public void ejectCoin() {
        state.ejectCoin();
    }
    
    /* 설명. 손잡이 돌리기 */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    
    /* 설명. 변경 메소드 */
    void setState(State state) {
        this.state = state;
    }
    
    /* 설명. 껌볼 배출 */
    void releaseBall() {
        System.out.println("껌볼이 슬롯에서 나옵니다.");
        if (count > 0) {
            count--;
        }
    }
    
    /* 설명. 상태 객체 getter */
    public State getSoldOutState() {
        return soldOutState;
    }
    
    public State getNoCoinState() {
        return noCoinState;
    }
    
    public State getHasCoinState() {
        return hasCoinState;
    }
    
    public State getSoldState() {
        return soldState;
    }
    
    public int getCount() {
        return count;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("===== 껌볼 자판기 상태 ===\n");
        result.append("남은 껌볼: ").append(count).append("개\n");
        
        if (state == soldOutState) {
            result.append("상태: 매진\n");
        } else if (state == noCoinState) {
            result.append("상태: 동전 투입 대기 중\n");
        } else if (state == hasCoinState) {
            result.append("상태: 동전 투입됨, 손잡이를 돌려주세요\n");
        } else if (state == soldState) {
            result.append("상태: 껌볼 배출 중\n");
        }
        
        return result.toString();
    }
} 