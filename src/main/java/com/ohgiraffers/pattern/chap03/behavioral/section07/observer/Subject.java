package com.ohgiraffers.pattern.chap03.behavioral.section07.observer;

/** 
 * 설명. 주제 인터페이스 - 옵저버들을 관리하고 상태 변경을 통지하는 인터페이스
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
