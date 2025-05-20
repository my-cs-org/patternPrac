package com.ohgiraffers.pattern.chap01.creational.section04.builder;

/**
 * 설명. 빌더 패턴 사용 예제
 *  - 복잡한 객체의 생성 과정과 표현 방법을 분리
 *  - 동일한 생성 과정으로 다양한 표현 결과를 만들 수 있음
 *
 * 설명. 빌더 패턴의 장점
 *  1. 가독성이 좋음
 *  2. 필요한 속성만 선택적으로 설정 가능(setter를 사용하지 않고)
 *  3. 매개변수가 많은 생성자들을 쓰지 않아도 됨
 */
public class BuilderPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 빌더 패턴 예제 실행 =====");

        /* 설명. 기본 사양의 컴퓨터 생성 (필수 속성만 설정) */
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB", "256GB SSD").build();

        System.out.println("===== 기본 사양 컴퓨터 =====");
        System.out.println(basicComputer);

        /* 설명. 고급 사양의 컴퓨터 생성 (모든 속성 설정) */
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB", "1TB NVMe SSD")
                .graphicsCard("NVIDIA RTX 3080")
                .monitor("27인치 4K 모니터")
                .keyboard("기계식 게이밍 키보드")
                .mouse("고성능 게이밍 마우스")
                .speaker("7.1 서라운드 스피커")
                .hasBluetooth(true)
                .hasWifi(true)
                .build();

        System.out.println("===== 게이밍 컴퓨터 =====");
        System.out.println(gamingComputer);

        /* 설명. 사무용 컴퓨터 생성 (일부 속성만 설정) */
        Computer officeComputer = new Computer.Builder("Intel i5", "16GB", "512GB SSD")
                .monitor("24인치 모니터")
                .keyboard("일반 키보드")
                .mouse("일반 마우스")
                .hasWifi(true)
                .build();

        System.out.println("===== 사무용 컴퓨터 =====");
        System.out.println(officeComputer);
    }
}
