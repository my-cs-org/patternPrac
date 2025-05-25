package com.ohgiraffers.pattern.chap03.behavioral.section07.observer;

/**
 * 설명. 옵저버 패턴 사용 예제
 *  - 객체 간의 일대다 의존관계를 정의하여 한 객체의 상태가 변하면 의존 객체들에게 통지
 *  - 발행-구독(publisher-subscribe) 모델이라고도 함
 *
 * 설명. 옵저버 패턴의 장점
 *  1. 느슨한 결합: 주제와 옵저버는 서로 독립적으로 변경 가능
 *  2. 개방-폐쇄 원칙: 기존 코드 수정 없이 새 옵저버 추가 가능
 *  3. 런타임에 객체 간 관계 변경 가능
 *  4. 상태 변경 시 모든 옵저버에게 자동 통지
 *
 * 설명. 옵저버 패턴의 단점
 *  1. 순서 보장 안됨: 옵저버 호출 순서가 보장되지 않음
 *  2. 메모리 누수: 옵저버 해제를 제대로 하지 않으면 메모리 누수 가능
 *  3. 복잡한 업데이트: 연쇄적 업데이트로 인한 성능 저하 가능성
 *  4. 예상치 못한 부작용: 옵저버 간 의존성이 있을 경우 부작용 발생 가능
 *
 * 설명. 적절한 사용처
 *  1. 이벤트 처리 시스템: GUI 이벤트 처리, 사용자 인터페이스
 *  2. 실시간 데이터 처리: 주식 시세, 날씨 정보 업데이트
 *  3. 분산 시스템: 상태 변경을 여러 구성 요소에 알려야 할 때
 *  4. MVC 아키텍처: 모델의 변경을 뷰에 통지하는 경우
 */
public class ObserverPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 옵저버 패턴 예제 실행 =====");

        /* 설명. 주제(발행자) 생성 */
        NewsAgency newsAgency = new NewsAgency();
        
        /* 설명. 옵저버(구독자) 생성 */
        NewsChannel jtbcNews = new NewsChannel("JTBC News");
        NewsChannel ytnNews = new NewsChannel("YTN News");
        MobileApp userApp = new MobileApp("홍길동");

        /* 설명. 옵저버 등록 */
        System.out.println("===== 옵저버 등록 =====");
        newsAgency.registerObserver(jtbcNews);
        newsAgency.registerObserver(ytnNews);
        newsAgency.registerObserver(userApp);

        /* 설명. 뉴스 발행 및 통지 */
        System.out.println("===== 첫 번째 뉴스 발행 =====");
        newsAgency.setNews("코로나19 백신 개발 성공!");

        /* 설명. 옵저버 제거 */
        System.out.println("===== YTN 옵저버 제거 =====");
        newsAgency.removeObserver(ytnNews);

        /* 설명. 다시 뉴스 발행 */
        System.out.println("===== 두 번째 뉴스 발행 =====");
        newsAgency.setNews("세계 경제 회복 조짐 보여");
    }
}
