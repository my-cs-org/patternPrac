package com.ohgiraffers.pattern.chap03.behavioral.section08.state;

/**
 * 설명. 상태 패턴의 상태 인터페이스
 *  - 모든 구체적인 상태 클래스가 구현해야 하는 인터페이스
 */
public interface State {
    void insertCoin();
    void ejectCoin();
    void turnCrank();
    void dispense();
} 