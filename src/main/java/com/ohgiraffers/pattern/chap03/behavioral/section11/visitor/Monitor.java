package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/**
 * 설명. 비지터 패턴의 구체적인 요소(Concrete Element) 클래스
 *  - 모니터 부품 구현
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getMonitorInfo() {
        return "27인치 모니터";
    }
}
