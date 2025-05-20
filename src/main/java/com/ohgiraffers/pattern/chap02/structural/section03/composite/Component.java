package com.ohgiraffers.pattern.chap02.structural.section03.composite;

/**
 * 설명. 컴포지트 패턴의 컴포넌트(Component) 인터페이스
 *  - 모든 객체에 대한 공통 인터페이스 정의
 */
public interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
    String getName();
}
