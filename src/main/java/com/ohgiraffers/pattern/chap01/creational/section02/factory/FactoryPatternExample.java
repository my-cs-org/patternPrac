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
