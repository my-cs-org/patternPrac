package com.ohgiraffers.pattern.chap03.behavioral.section11.visitor;

/** 
 * 설명. 비지터 패턴 사용 예제
 *  - 객체 구조를 변경하지 않고 새로운 기능을 추가할 수 있게 함
 *  - 관련 동작을 하나의 클래스에 모아 응집도를 높임
 *
 * 설명. 비지터 패턴의 장점
 *  1. 개방-폐쇄 원칙: 기존 클래스 수정 없이 새로운 기능 추가 가능
 *  2. 단일 책임 원칙: 객체 구조와 알고리즘을 분리하여 각자의 역할에 집중
 *  3. 관련 기능 모음: 특정 기능과 관련된 코드를 한 클래스에 모아 응집도 향상
 *  4. 이중 디스패치: 객체 타입과 방문자 타입에 따라 적절한 메소드 호출
 *
 * 설명. 비지터 패턴의 단점
 *  1. 객체 구조 변경의 어려움: 새로운 요소 클래스 추가 시 모든 방문자 수정 필요
 *  2. 캡슐화 위반: 방문자가 요소의 내부 상태에 접근해야 할 수 있음
 *  3. 복잡성 증가: 이중 디스패치로 인한 코드 복잡도 증가
 *  4. 순환 의존성: 방문자와 요소 클래스 간 의존성 발생 가능
 *
 * 설명. 적절한 사용처
 *  1. 복잡한 객체 구조에 다양한 연산을 적용해야 할 때
 *  2. 객체 구조는 안정적이나 연산이 자주 변경되는 경우
 *  3. 관련 기능을 한 클래스에 모아 응집도를 높이고 싶을 때
 *  4. 컴파일러, 구문 분석기, 파일 시스템 탐색기 등의 구현
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
