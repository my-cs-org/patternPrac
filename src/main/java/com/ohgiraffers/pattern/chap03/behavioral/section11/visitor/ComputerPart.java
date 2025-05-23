package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/** 
 * 설명. 비지터 패턴의 요소(Element) 인터페이스
 *  - 방문자를 받아들이는 accept 메소드 정의
 */
public interface ComputerPart {
    void accept(Visitor visitor);
}
