package com.ohgiraffers.pattern.chap03.behavioral.section07.observer;

/** 
 * 설명. 구체적인 옵저버 클래스 - 뉴스 채널
 */
public class NewsChannel implements Observer {
    private String name;
    private String latestNews;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        this.latestNews = news;
        display();
    }

    public void display() {
        System.out.println(name + "에서 속보를 전합니다: " + latestNews);
    }

}
