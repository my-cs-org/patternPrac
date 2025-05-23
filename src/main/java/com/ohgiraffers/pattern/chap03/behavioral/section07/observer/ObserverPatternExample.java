package com.ohgiraffers.pattern.chap03.behavioral.section07.observer;

/**
 * 설명. 옵저버 패턴 사용 예제
 *  - 객체 간의 일대다 의존관계를 정의하여 한 객체의 상태가 변하면 의존 객체들에게 통지
 *  - 발행-구독(publisher-subscribe) 모델이라고도 함
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
