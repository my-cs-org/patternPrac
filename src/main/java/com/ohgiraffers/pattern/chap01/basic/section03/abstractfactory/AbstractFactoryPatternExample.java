package com.ohgiraffers.pattern.chap01.basic.section03.abstractfactory;

import java.util.Scanner;

/**
 * 설명. 추상 팩토리 패턴 사용 예제
 *  - 관련된 객체들의 집합을 생성하는 인터페이스 제공
 *  - 구체적인 클래스를 지정하지 않고 관련 객체들의 패밀리 생성
 *  - 연관된 여러 객체를 일관된 방식으로 생성하는 인터페이스를 제공하는 디자인 패턴
 *  - 핵심요소
 *   a. 추상 팩토리: 관련 객체군 생성을 위한 인터페이스 정의
 *   b. 구체적 팩토리: 특정 스타일/테마의 객체들을 실제로 생성
 *   c. 추상 제품: 생성될 객체의 공통 인터페이스
 *   d. 구체적 제품: 실제 구현체
 *  
 * 설명. 추상 팩토리 패턴의 장점
 *  1. 일관된 객체군 생성 보장
 *  2. 구체 클래스와 클라이언트 코드 분리
 *  3. 제품군 교체에 용이
 */
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 추상 팩토리 패턴 예제 실행 =====");

        /* 설명. 운영체제 정보 입력 받음 */
        Scanner sc = new Scanner(System.in);
        System.out.print("OS 종류를 입력하시오(windows or mac): ");
        String inputOS = sc.next();
        GUIFactory factory;

        if (inputOS.equalsIgnoreCase("windows")) {
            factory = new WindowsFactory();
            System.out.println("===== Windows 스타일 UI 생성 =====");
        } else if (inputOS.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
            System.out.println("===== Windows 스타일 UI 생성 =====");
        } else {
            throw new IllegalArgumentException("잘못된 OS 입력");
        }

        /* 설명. 팩토리를 사용하여 애플리케이션 생성 */
        Application app = new Application(factory);

        /* 설명. UI 렌더링 및 사용자 입력 처리 */
        System.out.println("===== UI 컴포넌트 렌더링 =====");
        app.renderUI();

        System.out.println("===== 사용자 입력 처리 =====");
        app.handleUserInput();

        /* 설명. 다른 OS 스타일로 교체된 UI 생성 */
        System.out.println("===== 다른 OS 스타일 UI 생성 =====");
        Application anotherApp = new Application(inputOS.equalsIgnoreCase("windows") ?
                new MacFactory() : new WindowsFactory());
        anotherApp.renderUI();
    }
}
