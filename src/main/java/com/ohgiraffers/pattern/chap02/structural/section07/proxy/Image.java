package com.ohgiraffers.pattern.chap02.structural.section07.proxy;

/**
 * 설명. 프록시 패턴의 주제(Subject) 인터페이스
 *  - 실제 객체와 프록시 객체가 구현하는 공통 인터페이스
 */
public interface Image {
    void display();
    String getFilename();
}
