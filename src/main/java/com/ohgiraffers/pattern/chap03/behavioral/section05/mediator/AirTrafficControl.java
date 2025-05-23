package com.ohgiraffers.pattern.chap03.behavioral.section05.mediator;

/**
 * 설명. 중재자 패턴의 중재자(Mediator) 인터페이스
 *  - 항공기들 간의 통신을 조정하는 인터페이스
 */
public interface AirTrafficControl {
    void registerFlight(Aircraft aircraft);
    void sendMessage(String message, Aircraft sender);
    void requestLanding(Aircraft aircraft);
}
