package com.ohgiraffers.pattern.chap03.behavioral.section05.mediator;

/**
 * 설명. 중재자 패턴의 동료(Collegue) 추상 클래스
 *  - 중재자를 통해 다른 항공기와 통신
 */
public abstract class Aircraft {
    protected AirTrafficControl atc;
    protected String flightNo;
    protected String position;

    public Aircraft(String flightNo) {
        this.flightNo = flightNo;
        this.position = "공중";
    }

    public void setAtc(AirTrafficControl atc) {
        this.atc = atc;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /* 설명. 메시지 전송 */
    public void send(String message) {
        System.out.println(flightNo + ": 메시지 전송 - " + message);
        atc.sendMessage(message, this);
    }

    /* 설명. 메시지 수신 */
    public abstract void receive(String message);

    /* 설명. 착륙 요청 */
    public void requestLanding() {
        System.out.println(flightNo + ": 착륙 요청");
        atc.requestLanding(this);
    }
}
