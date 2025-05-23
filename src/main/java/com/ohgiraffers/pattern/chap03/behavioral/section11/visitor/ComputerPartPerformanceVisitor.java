package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/**
 * 설명. 비지터 패턴의 구체적인 방문자(Concrete Visitor) 클래스
 *  - 컴퓨터 부품 성능을 검사하는 방문자
 */
public class ComputerPartPerformanceVisitor implements Visitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("컴퓨터 성능 검사: CPU 및 메모리 상태 양호");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("모니터 성능 검사: 화면 밝기 및 색상 조정 필요");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("키보드 성능 검사: 모든 키 정상 작동");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("마우스 성능 검사: 센서 감도 최적화 필요");
    }
}
