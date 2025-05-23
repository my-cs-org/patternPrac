package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/**
 * 설명. 비지터 패턴의 복합 요소(Composite Element) 클래스
 *  - 여러 부품으로 구성된 컴퓨터 구현
 */
public class Computer implements ComputerPart{
    private ComputerPart[] parts;

    public Computer() {
        this.parts = new ComputerPart[] {
                new Keyboard(),
                new Mouse(),
                new Monitor()
        };
    }

    @Override
    public void accept(Visitor visitor) {

        /* 설명. 먼저 각 부품들에 대해 방문자 패턴 적용 */
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }

        /* 설명. 그 다음 컴퓨터 자체에 대해 방문 */
        visitor.visit(this);
    }

    public ComputerPart[] getParts() {
        return parts;
    }

    public String getComputerInfo() {
        return "고성능 데스크탑 컴퓨터";
    }
}
