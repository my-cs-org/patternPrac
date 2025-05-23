package com.ohgiraffers.pattern.chap03.behavioral.section07.observer;

/** 
 * 설명. 구체적인 옵저버 클래스 - 모바일 앱
 */
public class MobileApp implements Observer {
    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String news) {
        System.out.println(userName + "의 모바일 앱에 알림: " + news);
    }
}
