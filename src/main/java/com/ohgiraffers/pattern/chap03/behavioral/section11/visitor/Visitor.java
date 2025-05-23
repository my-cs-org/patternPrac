package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/**
 * 설명. 비지터 패턴의 방문자(Visitor) 인터페이스
 *  - 방문할 요소들에 대한 visit 메소드 정의
 */
public interface Visitor {
    void visit(Computer computer);
    void visit(Monitor monitor);
    void visit(Keyboard keyboard);
    void visit(Mouse mouse);
}
