package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/**
 * 설명. 비지터 패턴의 구체적인 방문자(Concrete Visitor) 클래스
 *  - 컴퓨터 부품 정보를 표시하는 방문자
 */
public class ComputerPartDisplayVisitor implements Visitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("컴퓨터 정보 표시: " + computer.getComputerInfo());
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("모니터 정보 표시: " + monitor.getMonitorInfo());
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("키보드 정보 표시: " + keyboard.getKeyboardInfo());
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("마우스 정보 표시: " + mouse.getMouseInfo());
    }
}
