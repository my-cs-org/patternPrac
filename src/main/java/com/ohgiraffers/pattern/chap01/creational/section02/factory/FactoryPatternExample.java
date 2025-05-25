package com.ohgiraffers.pattern.chap01.creational.section02.factory;

import java.util.Scanner;

/**
 * 설명. 팩토리 패턴 사용 예제
 *  - 객체 생성 로직을 클라이언트 코드(객체가 필요해서 생성을 요청하는 코드(특정 기능 요청))와 분리
 *  - 조건에 따라 적절한 객체를 생성하는 책임을 팩토리에 위임
 *  
 * 설명. 팩토리 패턴의 장점:
 *  1. 객체 생성 로직을 분리하여 클라이언트 코드를 간결하게 유지
 *  2. 구체적인 클래스가 아닌 인터페이스를 통한 프로그래밍 가능
 *  3. 객체 생성 코드 변경 시 한 곳(팩토리)만 수정하면 됨
 *  4. 컴파일 시점이 아닌 런타임 시점에 타입을 동적으로 정할 수 있음
 *  
 * 설명. 팩토리 패턴의 단점:
 *  1. 팩토리 클래스가 추가되어 코드의 복잡도가 증가할 수 있음
 *  2. 새로운 제품을 추가할 때마다 팩토리 클래스를 수정해야 함
 *  3. 간단한 객체 생성에 적용하면 오버엔지니어링이 될 수 있음
 *  4. 팩토리와 제품 클래스 간의 결합도가 존재함
 *  
 * 설명. 적절한 사용처:
 *  1. 객체 생성 로직이 복잡하거나 자주 변경되는 경우
 *  2. 객체 생성 시점에 어떤 클래스의 인스턴스를 생성할지 결정해야 하는 경우
 *  3. 라이브러리 개발 시 구현 클래스를 노출하지 않고 인터페이스만 제공하고 싶을 때
 *  4. 객체 생성 시 특정 조건에 따라 다른 객체를 생성해야 할 때
 */
public class FactoryPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 팩토리 패턴 예제 실행 =====");

        /* 설명. 팩토리를 사용하여 제품 A 생성 */
        System.out.println("===== 제품 A 생성 =====");
        Product productA = ProductFactory.createProduct("A");
        productA.use();

        /* 설명. 팩토리를 사용하여 제품 B 생성 */
        System.out.println("===== 제품 B 생성 =====");
        Product productB = ProductFactory.createProduct("B");
        productB.use();

        /* 설명. 런타임 시점에 타입 결정 가능 */
        System.out.println("===== 런타임 시 타입 결정 =====");
        Scanner sc = new Scanner(System.in);
        System.out.print("제품 타입을 입력하시오(\"A\" or \"B\"): ");
        String inputType = sc.next();

        Product dynamicProduct = null;
        try {
            dynamicProduct = ProductFactory.createProduct(inputType);
            dynamicProduct.use();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
