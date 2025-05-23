package com.ohgiraffers.pattern.chap03.behavioral.section07.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 설명. 구체적인 주제 클래스 - 뉴스 에이전시
 */
public class NewsAgency implements Subject{
    private List<Observer> observers;
    private String news;

    public NewsAgency() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
            System.out.println("새로운 옵저버가 등록되었습니다.");
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.remove(o)) {
            System.out.println("옵저버가 제거되었습니다.");
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(news);
        }
    }

    /* 설명. 뉴스 설정 및 통지 */
    public void setNews(String news) {
        this.news = news;
        System.out.println("새로운 뉴스: " + news);
        notifyObservers();
    }
}
