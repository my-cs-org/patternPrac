package com.ohgiraffers.pattern.chap03.behavioral.section05.mediator;

/**
 * 설명. 중재자 패턴 사용 예제
 *  - 객체 간의 직접적인 통신을 줄이고 중재자를 통해 결합도를 낮춤
 *
 * 설명. 중재자 패턴의 장점
 *  1. 객체 간 결합도 감소: 항공기는 관제탑만 알고 다른 항공기를 직접 알 필요가 없음
 *  2. 객체 간 통신을 중앙화: 모든 통신이 관제탑을 통해 이루어짐
 *  3. 객체 간 관계를 단순화: N:N 관계를 N:1 관계로 단순화시킴
 *  4. 객체의 재사용성 증가: 다른 관제탑에서도 같은 항공기 객체 재사용 가능
 *
 * 설명. 중재자 패턴의 단점
 *  1. 중재자 객체가 복잡해질 수 있음: 모든 통신을 처리하므로 중재자가 복잡해질 수 있음
 *  2. 중앙 집중화로 인한 병목 현상: 모든 통신이 중재자를 통해 이루어져 성능 저하 가능성
 *  3. 중재자에 대한 의존성 증가: 모든 객체가 중재자에 의존하게 됨
 *  4. 유지보수가 어려워질 수 있음: 중재자 객체가 너무 많은 책임을 가지게 될 수 있음
 *
 * 설명. 적절한 사용처
 *  1. 객체 간 통신이 복잡하고 다수의 객체가 서로 상호작용하는 경우
 *  2. 객체 간 결합도를 낮추고 재사용성을 높이고 싶을 때
 *  3. GUI 컴포넌트 간의 상호작용 관리
 *  4. 항공 교통 관제, 채팅 서버, 온라인 게임 등 다수의 객체가 서로 통신해야 하는 시스템
 */
public class MediatorPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 중재자 패턴 예제 =====");
        
        /* 설명. 중재자(관제탑) 생성 */
        AirTrafficControl controlTower = new ControlTower();
        
        /* 설명. 항공기 생성 */
        Aircraft flight1 = new PassengerAircraft("KE1234", 250);
        Aircraft flight2 = new PassengerAircraft("OZ5678", 180);
        Aircraft flight3 = new CargoAircraft("FX9012", 80.5);

        /* 설명. 관제탑에 항공기 등록 */
        controlTower.registerFlight(flight1);
        controlTower.registerFlight(flight2);
        controlTower.registerFlight(flight3);

        System.out.println("===== 일반 통신 테스트 =====");

        /* 설명. 항공기 간 통신 (중재자를 통해) */
        flight1.send("30,000피트 고도에서 순항 중입니다.");

        System.out.println("===== 화물기 특수 기능 =====");

        /* 설명. 화물기 특수 기능 */
        ((CargoAircraft) flight3).reportCargoStatus();

        System.out.println("===== 착륙 요청 테스트 =====");

        /* 설명. 착륙 요청 */
        flight1.requestLanding();

        /* 설명. 여객기 특수 기능 */
        System.out.println("===== 여객기 특수 기능 =====");
        ((PassengerAircraft) flight2).announceToPassengers("곧 착륙 예정입니다. 안전벨트를 착용해 주세요.");

        /* 설명. 두 번째 착륙 요청 (활주로가 사용 중일 때) */
        System.out.println("===== 두 번째 착륙 요청 =====");
        flight2.requestLanding();
    }
}
