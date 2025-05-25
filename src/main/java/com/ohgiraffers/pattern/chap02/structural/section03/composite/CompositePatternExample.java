package com.ohgiraffers.pattern.chap02.structural.section03.composite;

/**
 * 설명. 컴포지트 패턴 사용 예제
 *  - 객체들을 트리 구조로 구성하여 부분-전체 계층을 표현
 *  - 개별 객체와 복합 객체를 동일하게 다룰 수 있음
 *  
 * 설명. 컴포지트 패턴의 장점
 *  1. 복잡한 트리 구조를 편리하게 사용 가능
 *  2. 단일 객체와 복합 객체를 일관되게 처리 가능
 *  3. 새로운 종류의 구성 요소를 쉽게 추가 가능
 *  4. 클라이언트 코드가 단순해짐
 *  
 * 설명. 컴포지트 패턴의 단점
 *  1. 설계가 지나치게 일반화될 수 있음
 *  2. 특정 컴포넌트에 제약을 두기 어려움
 *  3. 트리 구조 변경 시 전체 구조에 영향을 줄 수 있음
 *  
 * 설명. 적절한 사용처
 *  1. 계층적 트리 구조를 표현해야 할 때
 *  2. 클라이언트가 단일 객체와 복합 객체를 구분하지 않고 동일하게 처리해야 할 때
 *  3. 파일 시스템, 조직도, GUI 컴포넌트 등의 구현
 *  4. 전체-부분 관계를 표현하는 구조가 필요할 때
 */
public class CompositePatternExample {
    public static void main(String[] args) {
        System.out.println("===== 컴포넌트 패턴 예제 실행 =====");
        
        /* 설명. 복합 객체(폴더의 개념) 생성 */
        Composite root = new Composite("루트");
        Composite branch1 = new Composite("브랜치1");
        Composite branch2 = new Composite("브랜치2");
        Composite branch1_1 = new Composite("브랜치1-1");

        /* 설명. 단일 객체(파일의 개념) 생성 */
        Component leaf1 = new Leaf("리프1");
        Component leaf2 = new Leaf("리프2");
        Component leaf3 = new Leaf("리프3");
        Component leaf4 = new Leaf("리프4");
        Component leaf5 = new Leaf("리프5");

        /**
         * 설명. 트리 구조 구성
         *  root
         *  ├── branch1
         *  │   ├── leaf2
         *  │   └── branch1_1
         *  │       └── leaf3
         *  ├── branch2
         *  │   ├── leaf4
         *  │   └── leaf5
         *  └── leaf1
         */
        root.add(branch1);
        root.add(branch2);
        root.add(leaf1);

        branch1.add(leaf2);
        branch1.add(branch1_1);

        branch1_1.add(leaf3);

        branch2.add(leaf4);
        branch2.add(leaf5);

        /* 설명. 전체 구조 출력 */
        System.out.println("===== 전체 트리 구조 동작 =====");
        root.operation();

        /* 설명. 특정 브랜치만 동작 */
        System.out.println("===== 브랜치1 동작 =====");
        branch1.operation();

        /* 설명. 브랜치1-1에서 컴포넌트 삭제 후 동작 */
        System.out.println("===== 리프3 삭제 후 브랜치1-1 동작 =====");
        branch1_1.remove(leaf3);
        branch1_1.operation();

        /* 설명. 브랜치2에서 컴포넌트 추가 후 동작 */
        System.out.println("===== 새 리프 추가 후 브랜치2 동작 =====");
        branch2.add(new Leaf("새 리프"));
        branch2.operation();
    }
}
