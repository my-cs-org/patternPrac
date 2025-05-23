package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/** 
 * 설명. 비지터 패턴 사용 예제
 *  - 객체 구조를 변경하지 않고 새로운 기능을 추가할 수 있게 함
 *  - 관련 동작을 하나의 클래스에 모아 응집도를 높임
 */
public class VisitorPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 비지터 패턴 예제 실행 =====");

        /* 설명. 컴퓨터 객체 생성 */
        ComputerPart computer = new Computer();

        /* 설명. 정보 표시 방문자 사용 */
        System.out.println("===== 컴퓨터 부품 정보 표시 =====");
        computer.accept(new ComputerPartDisplayVisitor());

        /* 설명. 성능 검사 방문자 사용 */
        System.out.println("===== 컴퓨터 부품 성능 검사 =====");
        computer.accept(new ComputerPartPerformanceVisitor());

        /* 설명. 개별 부품에 대한 방문자 패턴 적용 */
        System.out.println("===== 개별 부품에 방문자 패턴 적용 =====");
        ComputerPart keyboard = new Keyboard();
        keyboard.accept(new ComputerPartDisplayVisitor());

        ComputerPart monitor = new Monitor();
        monitor.accept(new ComputerPartPerformanceVisitor());
    }
}
