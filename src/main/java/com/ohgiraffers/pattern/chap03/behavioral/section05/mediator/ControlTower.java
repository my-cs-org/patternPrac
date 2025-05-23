package com.ohgiraffers.pattern.chap03.behavioral.section05.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 설명. 중재자 패턴의 구체적인 중재자(Concrete Mediator) 클래스
 *  - 항공 교통 관제소 구현
 */
public class ControlTower implements AirTrafficControl {
    private List<Aircraft> registeredAircrafts;
    private int runwayFreeTime;     // 활주로가 비는 시간(초)

    public ControlTower() {
        this.registeredAircrafts = new ArrayList<>();
        this.runwayFreeTime = 0;
    }

    @Override
    public void registerFlight(Aircraft aircraft) {
        registeredAircrafts.add(aircraft);
        aircraft.setAtc(this);
        System.out.println("관제탑: " + aircraft.getFlightNo() + " 등록 완료");
    }

    @Override
    public void sendMessage(String message, Aircraft sender) {
        System.out.println("관제탑: " + sender.getFlightNo() + "로부터 메시지 수신 - " + message);

        /* 설명. 메시지를 보낸 항공기를 제외한 모든 항공기에 메시지 전달 */
        for (Aircraft aircraft : registeredAircrafts) {
            if (aircraft != sender) {
                aircraft.receive(message);
            }
        }
    }

    @Override
    public void requestLanding(Aircraft aircraft) {
        System.out.println("관제탑: " + aircraft.getFlightNo() + "의 착륙 요청 수신");

        if (runwayFreeTime > 0) {
            System.out.println("관제탑: 활주로 사용 중, " + runwayFreeTime + "초 후 착륙 가능");

            /* 설명. 대기 중인 다른 항공기들에게 알림 */
            String waitMessage = "항공편 " + aircraft.getFlightNo() + "의 착륙이 대기 중입니다.";
            for (Aircraft other : registeredAircrafts) {
                if (other != aircraft) {
                    other.receive(waitMessage);
                }
            }
        } else {

            /* 설명. 착륙 허가 */
            System.out.println("관제탑: " + aircraft.getFlightNo() + " 착륙 허가");
            aircraft.receive("착륙 허가. 활주로 3번으로 접근하세요.");
            aircraft.setPosition("착륙 중");

            /* 설명. 활주로 사용 시간 설정 */
            runwayFreeTime = 10;        // 10초 동안 활주로 사용

            /* 설명. 다른 항공기들에게 알림 */
            String landingMessage = "항공편 " + aircraft.getFlightNo() + "가 착륙 중입니다. 주의하세요.";
            for (Aircraft other : registeredAircrafts) {
                if (other != aircraft) {
                    other.receive(landingMessage);
                }
            }

            /* 설명. 착륙 완료 시뮬레이션 */
            new Thread(() -> {
                try {
                    Thread.sleep(5000);     // 5초 후 착륙 완료
                    aircraft.setPosition("착륙 완료");
                    System.out.println("관제탑: " + aircraft.getFlightNo() + " 착륙 완료");

                    // 활주로 사용 시간 감소
                    runwayFreeTime -= 5;

                    if (runwayFreeTime <= 0) {
                        runwayFreeTime = 0;
                        System.out.println("관제탑: 활주로 사용 가능");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
