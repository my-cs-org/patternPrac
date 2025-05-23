package com.ohgiraffers.pattern.chap03.behavioral.section07.observer;

/** 
 * 설명. 옵저버 인터페이스 - 주제의 변경사항을 통보받는 객체들의 인터페이스
 */
public interface Observer {
    void update(String message);
}
