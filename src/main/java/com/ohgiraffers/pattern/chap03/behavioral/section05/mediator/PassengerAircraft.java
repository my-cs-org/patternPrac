package com.ohgiraffers.pattern.chap03.behavioral.section05.mediator;

/**
 * 설명. 중재자 패턴의 구체적인 동료(Concrete Colleague) 클래스
 *  - 여객기 구현
 */
public class PassengerAircraft extends Aircraft {
    private int passengerCount;

    public PassengerAircraft(String flightNo, int passengerCount) {
        super(flightNo);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public void receive(String message) {
        System.out.println(flightNo + "(여객기): 메시지 수신 - " + message);
    }

    /* 설명. 여객기 전용 메소드 */
    public void announceToPassengers(String announcement) {
        System.out.println(flightNo + ": 승객들에게 안내방송 - " + announcement);
    }
}
