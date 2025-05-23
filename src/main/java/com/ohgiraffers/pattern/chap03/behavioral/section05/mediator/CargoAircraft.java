package com.ohgiraffers.pattern.chap03.behavioral.section05.mediator;

/**
 * 설명. 중재자 패턴의 구체적인 동료(Concrete Colleague) 클래스
 *  - 화물기 구현
 */
public class CargoAircraft extends Aircraft {
    private double cargoWeight;     // 화물 무게(톤)

    public CargoAircraft(String flightNo, double cargoWeight) {
        super(flightNo);
        this.cargoWeight = cargoWeight;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public void receive(String message) {
        System.out.println(flightNo + "(화물기): 메시지 수신 - " + message);
    }

    /* 설명. 화물기 전용 메소드 */
    public void reportCargoStatus() {
        System.out.println(flightNo + ": 화물 상태 보고 - " + cargoWeight + "톤 운송 중");
        send("화물 " + cargoWeight + "톤 정상 운송 중");
    }
}
