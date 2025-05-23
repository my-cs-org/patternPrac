package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/**
 * 설명. 비지터 패턴의 구체적인 요소(Concrete Element) 클래스
 *  - 키보드 부품 구현
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getKeyboardInfo() {
        return "기계식 키보드";
    }
}
